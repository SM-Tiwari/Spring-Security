<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="utils" uri="utils"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">

<link rel="icon"
	href="${pageContext.request.contextPath}/static/assets/image/favicon.ico">
<link rel="apple-touch-icon"
	href="${pageContext.request.contextPath}/static/assets/image/apple-touch-icon.png">

<title>My Vietnamobile</title>
<meta name="description" content="#">
<meta name="keywords" content="#">
<meta name="author" content="Vietnamobile">

<!-- Stylesheets -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/assets/style/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/assets/style/jquery.smartmenus.bootstrap.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/assets/style/material-kit.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/assets/style/vietnamobile.css?id=1">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/assets/style/customize.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/assets/style/datepicker.css">

<!-- Typefaces -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">

<style type="text/css">
html, body {
	overflow-x: hidden;
	height: 100%;
}

.form-control, .form-group .form-control {
	border: 1px solid #c7c7c7;
	background-image: none !important;
	padding: 12px 12px !important;
}

.form-control {
	height: 45px !important;
}

.form-group .checkbox label, .form-group .radio label, .form-group label
	{
	color: #000000 !important;
}

.form-group {
	margin-top: 5px !important;
}

.loader {
	position: absolute;
	left: 50%;
	top: 50%;
	transform: translate(-50%, -50%);
	z-index: 9999;
}

.loader img {
	width: 150px;
}

.masking {
	background: rgba(255, 255, 255, 0.71);
	position: fixed;
	height: 100%;
	width: 100%;
	z-index: 999;
}

.form-control[disabled], fieldset[disabled] .form-control, .form-group .form-control[disabled], fieldset[disabled] .form-group .form-control{
border:1px solid #D2D2D2!important;
background: #ececec!important;
}
</style>


<script type="text/javascript">
	/* $('#convert').click(function(){
	  $('.loader, .overlay').show();      
	  return false();  
	}) */

	function showLoader() {
		$('.loader, .masking').show();
		return false();
	}
</script>


<script type="text/javascript">
	function getAge(dateString) {
		var today = new Date();
		var birthDate = new Date(dateString);
		var age = today.getFullYear() - birthDate.getFullYear();
		var m = today.getMonth() - birthDate.getMonth();
		if (m < 0 || (m === 0 && today.getDate() < birthDate.getDate())) {
			age--;
		}
		return age;
	}
	function validate() {
		var firstname = document.f1.firstname.value;
		var lastname = document.f1.lastname.value;
		var Dateofbirth = document.f1.Dateofbirth.value;
		var dateofissue = document.f1.dateofissue.value;
		var idcard = document.f1.idcard.value;
		var adress = document.f1.adress.value;
		var msisdn = document.f1.msisdn.value;
		var placeofIssuevalue= document.f1.placeofIssueId.value;
		//var FirststsideofIDcard=document.getElementById("Customer_Portrait").src;

		var Customer_Portrait = document.getElementById("Customer_Portrait")
				.getAttribute('src');
		var ID_Front = document.getElementById("ID_Front").getAttribute('src');
		var ID_back = document.getElementById("ID_back").getAttribute('src');

		var status = false;

		function calcChecked() {
			if (document.getElementById('acceptcondition').checked == true) {
				document.getElementById('convert').style.disply = "block";
			} else {
				document.getElementById('convert').style.disply = "none";
			}
		}
		/* if(firstname==""){  
		document.getElementById("firstnameerror").style.display= 'block';
		//"( * Please Enter your First Name )";  
		status=false;
		}else{  
		document.getElementById("firstnameerror").style.display= 'none';  
		//status=true;
		} 
		
		if(lastname==""){  
		document.getElementById("lastnameerror").style.display="block"  
		//"( * Please Enter your Last Name )";  
		status=false;
		}else{  
		document.getElementById("lastnameerror").style.display="none"    
		//status=true;
		} */

		if (Dateofbirth == "") {
			//document.getElementById("Dateofbirtherror").style.display = 'block';

			//"( * Please Enter your Date of Birth )";  
			Dateofbirth = "1";
		} else {
			var calculatedAge = getAge(Dateofbirth);
			if (calculatedAge < 15) {
				Dateofbirth = "1";
				document.getElementById("Dateofbirtherrormin").style.display = 'block';
				document.getElementById("Dateofbirtherror").style.display = 'none';
				
			} else {
				Dateofbirth = calculatedAge;
				document.getElementById("Dateofbirtherror").style.display = 'none';
				document.getElementById("Dateofbirtherrormin").style.display = 'none';
				

			}
			//alert("Dateofbirth " + calculatedAge);

			//status=true;
		}

		if (dateofissue == "") {
			
			document.getElementById("Dateofissueerror").style.display = 'block';
			//"( * Please Enter Date of Issue )";  
			
		} else {

			var calculatedAge = getAge(dateofissue);

			if (calculatedAge < 16) {
				
				document.getElementById("Dateofissueerrormin").style.display = 'none';
				document.getElementById("Dateofissueerror").style.display = 'none';
				
			} else {
				
				document.getElementById("Dateofissueerror").style.display = 'none';
				document.getElementById("Dateofissueerrormin").style.display = 'block';
				

			}
			//status=true;
		}

		if (idcard == "") {

			document.getElementById("idcarderror").style.display = 'block';

			

		} else {

			if (idcard.length > 7 && idcard.length < 16) {
				if (/[^a-zA-Z0-9\-\/]/.test(idcard)) {
					//alert('Input is not alphanumeric');
					document.getElementById("idcarderror").style.display = 'block';
					
				} else {
					document.getElementById("idcarderror").style.display = 'none';
					
				}

			} else {
				
				document.getElementById("idcarderror").style.display = 'block';
				
			}

			//status=true;
		}

		if (placeofIssuevalue == "") {			
			placeofIssuevalue = "1";
		} else {

			if (placeofIssuevalue.length > 4 && placeofIssuevalue.length < 16) {
				document.getElementById("placeofIssueerror").style.display = 'none';

				} else {
				placeofIssuevalue == "1";
				document.getElementById("placeofIssueerror").style.display = 'block';
				
			}

			//status=true;
		}
		
		if (adress == "") {
			  
			adress = "1";
		} else {

			if (adress.length > 4 && adress.length < 51) {
				
				document.getElementById("Addresserror").style.display = 'none';				

			} else {
				adress == "1";
				document.getElementById("Addresserror").style.display = 'block';
				
			}

			//status=true;
		}

		if (msisdn == "") {
			document.getElementById("MSISDNerror").style.display = 'block';
			 
			
		} else {
			document.getElementById("MSISDNerror").style.display = 'none';
			
		}

		if (Customer_Portrait == "") {
			document.getElementById("CustomerPortraitError").style.display = 'block';
			
		} else {

			var base64String = Customer_Portrait;

			var stringLength = base64String.length
					- 'data:image/png;base64,'.length;
			//var stringLength = base64String.length - 22;

			var sizeInBytes = 4 * Math.ceil((stringLength / 3)) * 0.5624896334383812;
			var sizeInKb = sizeInBytes / 1024;
			if (sizeInKb < 200) {
				document.getElementById("CustomerPortraitError").style.display = 'none';
				document.getElementById("CustomerPortraitsizeError").style.display = 'none';
				
			} else {
				
				document.getElementById("CustomerPortraitError").style.display = 'none';
				document.getElementById("CustomerPortraitsizeError").style.display = 'block';
				
			}
			//alert(sizeInKb);

			//status=true;
		}

		if (ID_Front == "") {
			document.getElementById("IDCardFrontError").style.display = 'block';

			
		} else {
			var base64String = ID_Front;

			var stringLength = base64String.length
					- 'data:image/png;base64,'.length;

			var sizeInBytes = 4 * Math.ceil((stringLength / 3)) * 0.5624896334383812;
			var sizeInKb = sizeInBytes / 1024;
			if (sizeInKb < 200) {
				document.getElementById("IDCardFrontError").style.display = 'none';
				document.getElementById("IDCardFrontSizeError").style.display = 'none';
				
			} else {
				
				document.getElementById("IDCardFrontError").style.display = 'none';
				document.getElementById("IDCardFrontSizeError").style.display = 'block';
				
			}
			//status=true;
		}

		/* if (ID_back == "") {
			//document.getElementById("IDCardBackError").style.display = 'block';
			//"( * Please Upload 1st side of ID card )";  
			status = false;
		} else {

			var base64String = ID_back;

			var stringLength = base64String.length
					- 'data:image/png;base64,'.length;

			var sizeInBytes = 4 * Math.ceil((stringLength / 3)) * 0.5624896334383812;
			var sizeInKb = sizeInBytes / 1024;
			if (sizeInKb < 200) {
				document.getElementById("IDCardBackError").style.display = 'none';
				document.getElementById("IDCardBackSizeError").style.display = 'none';
				status = true;
			} else {
				ID_back = "";
				document.getElementById("IDCardBackError").style.display = 'none';
				document.getElementById("IDCardBackSizeError").style.display = 'none';
				status = false;
			}
			//document.getElementById("IDCardBackError").style.display= 'none';  
			//status=true;
		} */

		if (document.getElementById('acceptcondition').checked == true) {
			//alert("t")         
			document.getElementById("CheckboxforCommits").style.display = 'none';
		} else {

			document.getElementById("CheckboxforCommits").style.display = 'block';
			//CheckboxforCommits
			//alert("F")         
		}

		/* if(idcard=="" || Customer_Portrait=="" || ID_Front=="" || ID_back=="" || document.getElementById('acceptcondition').checked == false)
		{
		status=false;
		}
		else
		{                                  
		
		document.getElementById("Customer_PortraitImage").value = Customer_Portrait;
		document.getElementById("ID_FrontImage").value = ID_Front;
		document.getElementById("ID_backImage").value = ID_back;
		document.getElementById("provinceName").value = $('#customer :selected').text();
		document.getElementById("districtName").value = $('#district :selected').text();
		status=true;
		
		} */

		//alert("Dateofbirth "+ Dateofbirth +"dateofissue "+dateofissue +" idcard  "+ idcard +" adress  "+ adress + "Customer_Portrait "+ Customer_Portrait + "ID_Front  "+ ID_Front)
		if (Dateofbirth == "" || dateofissue == "" || idcard == ""
				|| adress == "" || Customer_Portrait == "" || ID_Front == "" ||placeofIssuevalue == ""
				|| document.getElementById('acceptcondition').checked == false)
		//  if(status = false || document.getElementById('acceptcondition').checked == false)
		{
			status = false;
		} else {

			document.getElementById("Customer_PortraitImage").value = Customer_Portrait;
			document.getElementById("ID_FrontImage").value = ID_Front;
			document.getElementById("ID_backImage").value = ID_back;
			document.getElementById("provinceName").value = $(
					'#customer :selected').text();
			document.getElementById("districtName").value = $(
					'#district :selected').text();
			status = true;

		}
		//alert(status)
		return status;
	}

	function hidecustImage() {
		$('#Customer_Portrait').attr('src', '#').css('display', 'none');
		$('.cust_close').css('display', 'none');
		

	}
	function hideID_Front() {
		$('#ID_Front').attr('src', '').css('display', 'none');
		$('.front_close').css('display', 'none');
		

	}
	function hideID_back() {
		$('#ID_back').attr('src', '').css('display', 'none');
		$('.back_close').css('display', 'none');
		

	}

	function hideSubmit() {
		if (document.getElementById('acceptcondition').checked == false) {
			document.getElementById("convert").style.display = 'none';
		} else {
			document.getElementById("convert").style.display = 'block';
		}

	}
</script>

</head>

<body>

	<div class="masking" style="display:none">
		<div class="loader"><img src="${pageContext.request.contextPath}/static/assets/image/loader.gif"></div>
	</div>

	<tiles:insertAttribute name="header" />

	<div class="wrapper">

		<!-- Header -->
		<div class="header-general">
			<div class="container" style="display: block;">
				<div class="col-sm-11 col-sm-offset-1">
					<ul>
						<li><a
							href="${pageContext.request.contextPath}/secure/profile"><spring:message
									code="label.TopMenu.Profile" text="Profile" /></a></li>
						<li><spring:message code="label.CustomerInformation"
								text="Customer Information" /></li>
					</ul>
					<h1>
						<spring:message code="label.CustomerInformation"
							text="Customer Information" />
					</h1>

				</div>
			</div>
		</div>

		<!-- Section: User Options -->
		<!-- mic information  -->
		<div class="col-sm-8 col-sm-offset-2">
			<form name="f1" class="customer_varification" method="Post" onsubmit="return validate()" action="${pageContext.request.contextPath}/secure/submit?${_csrf.parameterName}=${_csrf.token}">

				<div class="col-md-12 no-padding">
					<div class="form-row">
						<div class="form-group col-md-6">
							<table>
								<tr>
									<td><label><spring:message
												code="label.PhoneNumber" text="Phone Number" /></label></td>
									<td><span id="MSISDNerror"
										style="color: red; padding-left: 10px; font-size:12px;"></span></td>
								</tr>
							</table>

							<input type="text" id="msisdn" name="msisdn" value="${authUser}"
								class="form-control" disabled="disabled"  />
						</div>
						
						<div class="form-group col-md-6">
							<table>
								<tr>
									<td><label><spring:message
												code="label.gender" text="Gender" /></label></td>
									<td><span id="Gendererror"
										style="color: red; padding-left: 10px; font-size: 10px;"></span></td>
								</tr>
							</table>

							<input type="text" id="genderIdMale" name="genderIdMale" value='<spring:message code="label.maleText"
										text="Male" />'class="form-control" disabled="disabled" style="display: none"  />
							<input type="text" id="genderIdFemale" name="genderIdFemale" value='<spring:message code="label.femaleText"
							text="Female" />'class="form-control" disabled="disabled" style="display: none"  />
							<input type="text" id="genderIdNA" name="genderIdFemale" value='<spring:message code="label.notavailable"
							text="N/A" />'class="form-control" disabled="disabled" style="display: none"  />
						</div>

					</div>
				</div>

				<div class="form-row">
					<div class="form-group col-md-6">
						<table>
							<tr>
								<td><spring:message code="label.FirstnameT"
										text="First Name" /></td>
								<td id="firstnameerror"
									style="color: red; padding-left: 10px; display: none; font-size:12px;"><spring:message
										code="label.Firstname" text="Enter your First name" /></td>
							</tr>
						</table>
						<input type="text" id="firstname" name="firstname"
							class="form-control" value="${micinformation.firstNmae}" disabled="disabled" >

					</div>
					<div class="form-group col-md-6">
						<table>
							<tr>
								<td><spring:message code="label.LastnameT" text="Last Name" /></td>
								<td id="lastnameerror"
									style="color: red; padding-left: 10px; display: none; font-size:12px;"><spring:message
										code="label.Lastname" text="Enter your last name" /></td>
							</tr>
						</table>
						<input type="text" id="lastname" name="lastname" disabled="disabled" class="form-control" value="${micinformation.lastName}" >

					</div>
				</div>

				<div class="form-row">


					<div class="form-group col-md-6">
						<table>
							<tr>
								<td><spring:message code="label.DateofbirthT"
										text="Date of birth" /></td>
								<td id="Dateofbirtherror"
									style="color: red; padding-left: 10px; display: none; font-size:12px;"><spring:message
										code="label.DateofBirth" text="Enter date of birth" />
								<td id="Dateofbirtherrormin"
									style="color: red; padding-left: 10px; display: none; font-size:12px;"><spring:message
										code="label.DateofBirth.belowfourteen"
										text="Enter date of birth" /></td>
							</tr>
						</table>
						<input type="text" id="dob" name="Dateofbirth" value="${micinformation.dob}"
							class="form-control" data-toggle="datepicker" disabled="disabled">
					</div>


					<div class="form-group col-md-6">

						<table>
							<tr>
								<td><spring:message code="label.IDCARDT" text="ID Card" /></td>
								<td id="idcarderror"
									style="color: red; padding-left: 10px; display: none; font-size:12px;"><spring:message
										code="label.ValidIDcardnumber"
										text="Enter your valid ID card number" /></td>
							</tr>
						</table>

						<input type="text" name="idcard" id="idcard" class="form-control" value="${micinformation.idCard}" disabled="disabled">
					</div>


				</div>

				<div class="form-row">
					<div class="form-group col-md-6">

						<table>
							<tr>
								<td><spring:message code="label.DateofissueT"
										text="Date of issue" /></td>
								<td id="Dateofissueerror"
									style="color: red; padding-left: 10px; display: none; font-size:12px;"><spring:message
										code="label.DateofIssue" text="Enter date of issue" /></td>

								<td id="Dateofissueerrormin"
									style="color: red; padding-left: 10px; display: none; font-size:12px;"><spring:message
										code="label.IDcardisexpired" text="The ID card is expired" /></td>

							</tr>
						</table>
						<input type="text" id="dateofissue" name="dateofissue" disabled="disabled"
							class="form-control" data-toggle="datepicker" value="${micinformation.date_of_issue}"
							>
					</div>
				</div>

				

				<div class="form-row">
					<div class="form-group col-md-6">
						<table>
							<tr>
								<td><spring:message code="label.placeofIssueT" text="Place of Issue" /></td>
								<td id="placeofIssueerror"
									style="color: red; padding-left: 10px; display: none; font-size:12px;"><spring:message
										code="label.placeofIssueerror" text="Enter Place of Issue" /></td>
							</tr>
						</table>

						<input type="text" id="placeofIssueId" name="placeofIssueId" class="form-control" disabled="disabled" value="${micinformation.placeOfIssue}">
					</div>
					
				</div>
				
				
				
				
				<div class="form-row">
					<div class="form-group col-md-12">
						<table>
							<tr>
								<td><spring:message code="label.AddressT" text="Address" /></td>
								<td id="Addresserror"
									style="color: red; padding-left: 10px; display: none; font-size:12px;"><spring:message
										code="label.ValidAddress" text="Enter Address" /></td>
							</tr>
						</table>

						<input type="text" id="adress" name="adress" class="form-control" value="${micinformation.address}" disabled="disabled">
					</div>
					<div class="form-group col-md-6">
						<label><spring:message code="label.ProvinceT"
								text="Province" /></label> 
								<%-- <select class="form-control" id="customer">
							<c:forEach items="${provincelist}" var="ListItem">

								<option value="${ListItem.provinceId}">${ListItem.provinceName}</option>
							</c:forEach>

						</select> --%>
						<input type="text" id="adress" name="adress" class="form-control" value="${micinformation.province}" disabled="disabled">
					</div>
				</div>

				<div class="form-row">
					<div class="form-group col-md-6">

						<table>
							<tr>
								<td><label><spring:message code="label.DistrictT"
											text="District" /></label></td>
								<td id="Districterror"
									style="color: red; padding-left: 10px; display: none; font-size:12px;"><spring:message
										code="label.Yourdistrict" text="Select your district" /></td>
							</tr>
						</table>
						<!-- <select class="form-control" id="district">
						

						</select> -->
						<input type="text" id="adress" name="adress" class="form-control" value="${micinformation.district}" disabled="disabled">
					</div>

				</div>
			<div class="clearfix"></div>
				<div class="form-row uploads">
					<div class="col-lg-12 no-padding">
						<div class="col-md-2 no-padding profile">
							<div class="customer-portrait">
								<!-- <div class="upload-btn-wrapper">
  				<button class="uploadbtn"><i class="fa fa-upload fa-2x"></i></button>
  				<input type="file" name="customFile"  onchange="readURL(this);"/>
				</div> -->
								<%-- <canvas id="canvas" style="position:absolute; 	top:0;	left:0;	border:0; "></canvas> --%>
								<img id="Customer_Portraits"
									src="${micinformation.customerPortrait}" alt="your image"
									style="position: absolute; right: 1px; height: 126px; width: 126px;" />
								<!-- <div class="cust_close">
                	<a href="#" title="close"><i class="fa fa fa-times-circle"></i></a>
                </div> -->
							</div>
							<spring:message code="label.CustomerPortraitT"
								text="Customer Portrait" />
							<p id="CustomerPortraitError"
								style="color: red; padding-left: 10px; display: none">
								<spring:message code="label.YourPortrait"
									text="Customer Portrait" />
							</p>
							<p id="IDCardFrontSizeError"
								style="color: red; padding-left: 10px; display: none">
								<spring:message code="label.AttachmentSize"
									text="Attachment size exceeds the allowable limit 200 KB" />
							</p>
						</div>
						<div class="col-md-2 no-padding profile">
							<div class="id-front">
								<div class="upload-btn-wrapper" style="height:auto!important; width:auto!important;">
									<button class="uploadbtn">
										<i class="fa fa-upload fa-2x"></i>
									</button>
									<input type="file" name="imageFront" onchange="readURL(this);" />
								</div>
								<canvas id="canvas1" class="profile_id"></canvas>
								<img id="ID_Fronts" src="${micinformation.firstSideIdcard}"
									alt="your image"
									style="position: absolute; right: 1px; height: 126px; width: 126px;" />
								<div class="front_close">
									<a href="#" title="close"><i class="fa fa fa-times-circle"></i></a>
								</div>
							</div>
							<spring:message code="label.IDCardFrontT" text="ID Card Front" />
							<p id="IDCardFrontError"
								style="color: red; padding-left: 10px; display: none">
								<spring:message code="label.YourIDproof" text="ID Card Front" />
							</p>
							<p id="IDCardFrontSizeError"
								style="color: red; padding-left: 10px; display: none">
								<spring:message code="label.AttachmentSize"
									text="Attachment size exceeds the allowable limit 200 KB" />
							</p>
						</div>
						<div class="col-md-2 no-padding profile">
							<div class="id-back">
								<div class="upload-btn-wrapper" style="height:auto!important; width:auto!important;">
									<button class="uploadbtn">
										<i class="fa fa-upload fa-2x"></i>
									</button>
									<input type="file" name="imageBack" onchange="readURL(this);" />
								</div>
								<canvas id="canvas11" class="profile_id"></canvas>
								<img id="ID_backs" src="${micinformation.secondSideIdcard}"
									alt="your image"
									style="position: absolute; right: 1px; height: 126px; width: 126px;" />

								<div class="back_close">
									<a href="#" title="close"><i class="fa fa fa-times-circle"></i></a>
								</div>
							</div>
							<spring:message code="label.IDCardBackT" text="ID Card Back" />
							<p id="IDCardBackError"
								style="color: red; padding-left: 10px; display: none">
								<spring:message code="label.YourIDproof" text="ID Card Back" />
							</p>
							<p id="IDCardBackSizeError"
								style="color: red; padding-left: 10px; display: none">
								<spring:message code="label.AttachmentSize"
									text="Attachment size exceeds the allowable limit 200 KB" />
							</p>
						</div>
					</div>
					<div class="clearfix"></div>
				</div>
		</div>

		<div class="clearfix"></div>



		</form>
	</div>

	<!-- End of  mic information  -->

	<!-- Divider -->
	<div class="sectionDivider col-sm-12"></div>

	<!-- Footer -->
	<tiles:insertAttribute name="footer" />

	</div>
	<!-- .wrapper -->

	<!-- Main Content: End -->

</body>

<!--   Core Script Files   -->
<script
	src="${pageContext.request.contextPath}/static/assets/script/jquery.min.js"
	type="text/javascript"></script>
<script
	src="${pageContext.request.contextPath}/static/assets/script/bootstrap.min.js"
	type="text/javascript"></script>
<script
	src="${pageContext.request.contextPath}/static/assets/script/material.min.js"></script>
<script
	src="${pageContext.request.contextPath}/static/assets/script/modified-material.js"></script>
<script
	src="${pageContext.request.contextPath}/static/assets/script/dashboard.js"></script>

<!--  Plugins -->
<script
	src="${pageContext.request.contextPath}/static/assets/script/jquery.smartmenus.js"
	type="text/javascript"></script>
<script
	src="${pageContext.request.contextPath}/static/assets/script/jquery.smartmenus.bootstrap.js"
	type="text/javascript"></script>

<!--  Control for Material Kit -->
<script
	src="${pageContext.request.contextPath}/static/assets/script/material-kit.js"
	type="text/javascript"></script>
<script
	src="${pageContext.request.contextPath}/static/assets/script/langswitcher.js"
	type="text/javascript"></script>
<script
	src="${pageContext.request.contextPath}/static/assets/script/bootstrap-dialog.min.js"
	type="text/javascript"></script>
<script
	src="${pageContext.request.contextPath}/static/assets/script/app.js"
	type="text/javascript"></script>
<script
	src="${pageContext.request.contextPath}/static/assets/script/datepicker.js"
	type="text/javascript"></script>

<script>
	$(function() {
		$('[data-toggle="datepicker"]').datepicker({
			autoHide : true,
			zIndex : 2048,
		});
	});
</script>



<script type="text/javascript">
	$(document)
			.on(
					'click',
					function(e) {
						$('[data-toggle="popover"],[data-original-title]')
								.each(
										function() {
											if (!$(this).is(e.target)
													&& $(this).has(e.target).length === 0
													&& $('.popover').has(
															e.target).length === 0) {
												(($(this).popover('hide').data(
														'bs.popover') || {}).inState || {}).click = false
											}
										});
					});
	//val mic=${micupdation};
	var myVar = "${micupdation}";
	// alert(""+myVar);
	if (myVar == '1') {
		document.getElementById('.popup').style.display = "block";
		//alert(""+myVar);
	}

	function getAge(dateString) {
		var today = new Date();
		var birthDate = new Date(dateString);
		var age = today.getFullYear() - birthDate.getFullYear();
		var m = today.getMonth() - birthDate.getMonth();
		if (m < 0 || (m === 0 && today.getDate() < birthDate.getDate())) {
			age--;
		}
		return age;
	}

	$("#dob")
			.change(
					function() {
						var Dateofbirth = $('#dob').val();
						if (Dateofbirth == "") {
							//alert("hello");
							//document.getElementById("Dateofbirtherror").style.display = 'block';

						} else {

							var calculatedAge = getAge(Dateofbirth);
							//alert("hello" + calculatedAge);
							if (calculatedAge < 15) {

								document.getElementById("Dateofbirtherrormin").style.display = 'block';
								document.getElementById("Dateofbirtherror").style.display = 'none';
								
							} else {
								document.getElementById("Dateofbirtherror").style.display = 'none';
								document.getElementById("Dateofbirtherrormin").style.display = 'none';
								

							}
							//alert("Dateofbirth " + calculatedAge);

							//status=true;
						}
					});
	
	$("#dateofissue").change(function() {
		//alert("hello");
		var dateofissue = $('#dateofissue').val();
		//alert(dateofissue);
		if(dateofissue==""){  
            document.getElementById("Dateofissueerror").style.display= 'block';
            
            
            }else{                    
                            
			var calculatedAge = getAge(dateofissue);
			
			if(calculatedAge < 16 )
			{
				document.getElementById("Dateofissueerrormin").style.display= 'none';
				document.getElementById("Dateofissueerror").style.display= 'none';
				
			}
			else
			{
							
			document.getElementById("Dateofissueerror").style.display= 'none';
			document.getElementById("Dateofissueerrormin").style.display= 'block';
			
							
			}
            //status=true;
            }
	});
	
	$("#placeofIssueId").change(function () {
		var placeofIssuevalue = $('#placeofIssueId').val();
		if (placeofIssuevalue == "") {
			//document.getElementById("placeofIssueerror").style.display = 'block';
			//"( * Please Enter your Address )";  
			placeofIssuevalue = "1";
			
		} else {

			if (placeofIssuevalue.length > 4 && placeofIssuevalue.length < 16) {
				//alert("valid");
				document.getElementById("placeofIssueerror").style.display = 'none';

				} else {
					placeofIssuevalue == "";
				document.getElementById("placeofIssueerror").style.display = 'block';
				//alert("unvalid");
				
			}

			//status=true;
		}
	});
	
	$("#adress").change(function () {
		var adress = $('#adress').val();
		
		if (adress == "") {
			//document.getElementById("Addresserror").style.display = 'block';
			
		} else {

			if (adress.length > 4 && adress.length < 51) {
				
				document.getElementById("Addresserror").style.display = 'none';				

			} else {
				
				document.getElementById("Addresserror").style.display = 'block';
				
			}

			//status=true;
		}
	});
	
	$("#idcard").change(function () {
		var idcard = $("#idcard").val();
		if (idcard == "") {

			document.getElementById("idcarderror").style.display = 'block';

			status = false;

		} else {

			if (idcard.length > 7 && idcard.length < 16) {
				if (/[^a-zA-Z0-9\-\/]/.test(idcard)) {
					//alert('Input is not alphanumeric');
					document.getElementById("idcarderror").style.display = 'block';
					status = false;
				} else {
					document.getElementById("idcarderror").style.display = 'none';
					status = true;
				}

			} else {
				idcard = "";
				document.getElementById("idcarderror").style.display = 'block';
				status = false;
			}

			//status=true;
		}
	});
	
	
</script>

<script type="text/javascript">
	$(document).ready(function() {
	
	       var customerGender= "${micinformation.gender}";
	       if(customerGender=="0")
    	   {
	    	   $("#genderIdMale").css("display","block");
	    	   $("#genderIdFemale").css("display","none");
	    	   $("#genderIdNA").css("display","none");
    	   }
	       else if(customerGender=="1")
    	   {
	    	   $("#genderIdMale").css("display","none");
	    	   $("#genderIdFemale").css("display","block");
	    	   $("#genderIdNA").css("display","none");
    	   }
	       else{
	    	   $("#genderIdMale").css("display","none");
	    	   $("#genderIdFemale").css("display","none");
	    	   $("#genderIdNA").css("display","block");
	       }
	      // alert(customerGender);
	});
	
	 
	</script>
<script type="text/javascript">
	
	function readURL(input) {
		if (input.name == "customFile") {
			if (input.files && input.files[0]) {
				var reader = new FileReader();
				reader.onload = function(e) {
					$('#Customer_Portrait').attr('src', e.target.result).width(
							126).height(126).css('display', 'block').addClass(
							'profile-round');
					$('.cust_close').css('display', 'block')
				};

				reader.readAsDataURL(input.files[0]);

			}
			document.getElementById("CustomerPortraitError").style.display = 'none';
			document.getElementById("CustomerPortraitsizeError").style.display = 'none';
		} else if (input.name == "imageFront") {

			if (input.files && input.files[0]) {
				var reader = new FileReader();
				reader.onload = function(e) {
					$('#ID_Front').attr('src', e.target.result).width(126)
							.height(126).css('display', 'block').addClass(
									'profile-round');
					$('.front_close').css('display', 'block')

				};

				reader.readAsDataURL(input.files[0]);
			}
			document.getElementById("IDCardFrontError").style.display = 'none';
			document.getElementById("IDCardFrontSizeError").style.display = 'none';
			
			
		} else {
			if (input.files && input.files[0]) {
				var reader = new FileReader();
				reader.onload = function(e) {
					$('#ID_back').attr('src', e.target.result).width(126)
							.height(126).css('display', 'block').addClass(
									'profile-round');
					$('.back_close').css('display', 'block')
				};

				reader.readAsDataURL(input.files[0]);

			}
		}
	}

	$(document)
			.ready(
					function() {

						$
								.ajax({
									type : "GET",
									url : "${pageContext.request.contextPath}/secure/district/14",

									success : function(data) {
										//  alert('success');
										$("#district").empty();

										$("#district")
												.append(
														'<option value="" disabled="disabled" selected="selected">Please Select</option>');

										$
												.each(
														data,
														function(i, item) {
															$("#district")
																	.append(
																			'<option value="'+data[i].districtId+'">'
																					+ data[i].districtName
																					+ '</option>');
														});
										document.getElementById('district').selectedIndex = 1;

									},
									error : function(e) {
										alert('fail');
									}

								});

					});

	$('#customer')
			.change(
					function(e) {
						e.preventDefault();
						var id = $(this).val();
						//alert(id+"sucess");

						$
								.ajax({
									type : "GET",
									url : "${pageContext.request.contextPath}/secure/district/"
											+ id,

									success : function(data) {
										//  alert('success');
										$("#district").empty();

										$("#district")
												.append(
														'<option value="" disabled="disabled" selected="selected">Please Select</option>');

										$
												.each(
														data,
														function(i, item) {
															$("#district")
																	.append(
																			'<option value="'+data[i].districtId+'">'
																					+ data[i].districtName
																					+ '</option>');
														});
										document.getElementById('district').selectedIndex = 3;

									},
									error : function(e) {
										alert('fail');
									}

								});

					});
	
	
</script>




</html>
