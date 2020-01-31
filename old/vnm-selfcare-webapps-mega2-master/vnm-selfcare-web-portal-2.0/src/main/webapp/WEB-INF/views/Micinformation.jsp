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
	/*  height: 100%; */
	height: auto;
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

.form-control[disabled], fieldset[disabled] .form-control, .form-group .form-control[disabled],
	fieldset[disabled] .form-group .form-control {
	border: 1px solid #D2D2D2 !important;
	background: #ececec !important;
}

.cust_close {
background: white;
    opacity: 0.5;
    padding: 0px 3px;
border: 1px solid #1d1c1c;
    border-radius: 5px;
}


.front_close
{
background: white;
    opacity: 0.5;
    padding: 0px 3px;
border: 1px solid #1d1c1c;
    border-radius: 5px;
}

.back_close
{
background: white;
    opacity: 0.5;
    padding: 0px 3px;
border: 1px solid #1d1c1c;
    border-radius: 5px;
}

.rotate90 {

  -webkit-transform: rotate(90deg);
    -moz-transform: rotate(90deg);
    -o-transform: rotate(90deg);
    -ms-transform: rotate(90deg);
    transform: rotate(90deg);
  width: 126px;
  height: 126px;
  
  
}
.rotate270 {
  transform: rotate(270deg);
  width: 126px;
  height: 126px;
}
.rotate0 {
  
  width: 126px;
  height: 126px;
}
</style>

	<style type="text/css">
	.mask {
    height: 100%;
    width: 100%;
    background: #00000085;
    z-index: 9999;
    position: fixed;
    top: 0;
	display:none;
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
	/*  function getAge(dateString) {
	      //  var today = new Date();
	      //  var birthDate = new Date(dateString);
	      //  var age = today.getFullYear() - birthDate.getFullYear();
	      //  var m = today.getMonth() - birthDate.getMonth();
	      //  if (m < 0 || (m === 0 && today.getDate() < birthDate.getDate())) {
	       
	     //          age--;
	     //   }
	     //   return age;
	     
	   var start= new Date(dateString);
	    var end= new Date();
	    days = (end- start) / (1000 * 60 * 60 * 24);
	  // alert(Math.round(days));
	    return Math.round(days);
	     
	 } */

	function toValidDate(datestring) {
		return datestring.replace(/(\d{2})(\/)(\d{2})/, "$3$2$1");
	}

	function isValidDate(datestring) {

		var regex = /^(((0[1-9]|[12]\d|3[01])\/(0[13578]|1[02])\/((19|[2-9]\d)\d{2}))|((0[1-9]|[12]\d|30)\/(0[13456789]|1[012])\/((19|[2-9]\d)\d{2}))|((0[1-9]|1\d|2[0-8])\/02\/((19|[2-9]\d)\d{2}))|(29\/02\/((1[6-9]|[2-9]\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))))$/g;

		var valid = regex.test(datestring);
		//alert(valid);
		if (valid) {

			var startTime = new Date(toValidDate(datestring));
			var startYear = startTime.getYear();
			if (startYear > 1900) {
				valid = false;
			}
		}

		return valid;

	}

	function getAge(dateString) {

		//var startTime = new Date(toValidDate($("#dob").val()));
		var startTime = new Date(toValidDate(dateString));
		//alert(startTime);
		var currentTime = new Date();

		var startDate = startTime.getDate();
		var startMonth = startTime.getMonth() + 1;
		var startYear = startTime.getYear();

		var currentDate = currentTime.getDate();
		var currentMonth = currentTime.getMonth() + 1;
		var currentYear = currentTime.getYear();

		var age = currentYear - startYear;
		var m = currentMonth - startMonth;
		if (m < 0 || (m === 0 && currentDate < startDate)) {
			age--;
		}
		//alert(age);
		return age;
		/* var today = new Date();
		var birthDate = new Date(dateString);
		var age = today.getFullYear() - birthDate.getFullYear();
		var m = today.getMonth() - birthDate.getMonth();
		if (m < 0 || (m === 0 && today.getDate() < birthDate.getDate())) {
			age--;
		}
		return age; */
	}

	function CheckExp(dateString) {

		var startTime = new Date(toValidDate(dateString));
		
		var startYear = startTime.getYear();

		var currentTime = new Date();

		var currentYear = currentTime.getYear();
		
		
		if(startYear>currentYear)
			{
			return (false);
			}
		
		var diff = new Date(currentTime - startTime);
		
		
		var p = 1000;
		var h = 60;
		var m = 60;
		var td = 24;

		// get days
		//var days1 = diff/1000/60/60/24;
		//alert(days1);
		
		
		var days = ((((diff/p)/h)/m)/td);
		
		
		//alert(days);
		//var days = 100;
		//alert(days);

		if (days < 5479) //5479 = 5475( 365*15) + 3 (leap ys days)
		{
			return (true);
		} else {
			return (false);
		}

	}

	function validate() {

		var validName;
		var validDateofbirth;
		var validdateofissue;
		var valididcard;
		var validadress;
		var validplaceofIssue;
		var validCustomerPortrait;
		var validID_Front;
		var validID_Back;

		var firstname = document.f1.firstname.value.trim();
		var lastname = document.f1.lastname.value.trim();
		var Dateofbirth = document.f1.Dateofbirth.value.trim();
		var dateofissue = document.f1.dateofissue.value.trim();
		var idcard = document.f1.idcard.value.trim();
		var adress = document.f1.adress.value.trim();
		var msisdn = document.f1.msisdn.value.trim();
		var placeofIssuevalue = document.f1.placeofIssueId.value.trim();
		//var FirststsideofIDcard=document.getElementById("Customer_Portrait").src;

		var Customer_Portrait = document.getElementById("Customer_Portrait")
				.getAttribute('src');
		var ID_Front = document.getElementById("ID_Front").getAttribute('src');
		var ID_back = document.getElementById("ID_back").getAttribute('src');

		//var status = false;

		function calcChecked() {
			if (document.getElementById('acceptcondition').checked == true) {
				document.getElementById('convert').style.disply = "block";
			} else {
				document.getElementById('convert').style.disply = "none";
			}
		}

		if (firstname == "") {
			//firstname == "NA";
			document.getElementById("firstnameerror").style.display = 'block';
			//"( * Please Enter your First Name )";  
			validName = false;
		} else {
			document.getElementById("firstnameerror").style.display = 'none';
			//status=true;
			firstname = firstname;
			validName = true;
		}

		if (lastname == "") {
			lastname = "NA";
			document.getElementById("lastname").value=" ";
			//"( * Please Enter your Last Name )";  
			//status=false;
		} else {
			lastname = lastname;
			//document.getElementById("lastnameerror").style.display="none"    
			//status=true;
		}

		

		if (!validateDOB()) {  // (calculatedAge < 14) 
			validDateofbirth = false; 
		} else
			validDateofbirth = true;

		if (!validateIdcard()) {
			valididcard = false;
		} else
			valididcard = true;

		
		if (!validateDOIssue()) { //calculatedAge > 15
			validdateofissue = false;
		} else
			validdateofissue = true;

		

		/* if (idcard == "") {

			document.getElementById("idcarderror").style.display = 'block';

		} else {

			if (idcard.length > 7 && idcard.length < 16) {
				if (/[^a-zA-Z0-9\-\/]/.test(idcard)) {
					//alert('Input is not alphanumeric');
					document.getElementById("idcarderror").style.display = 'block';

				} else {
					document.getElementById("idcarderror").style.display = 'none';
					idcard = idcard;
				}

			} else {

				document.getElementById("idcarderror").style.display = 'block';

			}

			//status=true;
		} */

		if (!validatePlaceIssue()) {
			validplaceofIssue = false;
		} else
			validplaceofIssue = true;

		/* if (placeofIssuevalue == "") {
			placeofIssuevalue = "NA";
		} else {

			if (placeofIssuevalue.length > 4 && placeofIssuevalue.length < 16) {
				document.getElementById("placeofIssueerror").style.display = 'none';
				placeofIssuevalue = placeofIssuevalue;

			} else {
				placeofIssuevalue == "NA";
				document.getElementById("placeofIssueerror").style.display = 'block';

			}

			//status=true;
		}
		 */

		if (!validateAddress()) {
			validadress = false;
		} else
			validadress = true;

		/* if (adress == "") {

			adress = "NA";
		} else {

			if (adress.length > 4 && adress.length < 51) {

				document.getElementById("Addresserror").style.display = 'none';
				placeofIssuevalue = placeofIssuevalue;

			} else {
				adress == "NA";
				document.getElementById("Addresserror").style.display = 'block';

			}

			//status=true;
		} */

		if (msisdn == "") {
			document.getElementById("MSISDNerror").style.display = 'block';

		} else {
			document.getElementById("MSISDNerror").style.display = 'none';

		}

		
		
		
		if (!validateCustPortrait()) {
			validCustomerPortrait = false;
		} else
			validCustomerPortrait = true;
		
		
		
		
	
		
		
		/* if (Customer_Portrait == "") {
			document.getElementById("CustomerPortraitError").style.display = 'block';
			validCustomerPortrait = false;

		} else {
			
			
			
			 var filename = $("#Customer_Portrait").val();
			

			var validext = validateExtension(filename);
			 
			alert(validext);
			
			
			if(validext)
				{
				
				document.getElementById("CustPortraitExtError").style.display = 'none';
			 
			var base64String = Customer_Portrait;

			var stringLength = base64String.length
					- 'data:image/png;base64,'.length;
			//var stringLength = base64String.length - 22;

			var sizeInBytes = 4 * Math.ceil((stringLength / 3)) * 0.5624896334383812;
			var sizeInKb = sizeInBytes / 1024;
			if (sizeInKb <= 2048) {
				document.getElementById("CustomerPortraitError").style.display = 'none';
				document.getElementById("CustomerPortraitsizeError").style.display = 'none';
				validCustomerPortrait = true;

			} else {

				document.getElementById("CustomerPortraitError").style.display = 'none';
				document.getElementById("CustomerPortraitsizeError").style.display = 'block';
				validCustomerPortrait = false;

			}
			//alert(sizeInKb);

			//status=true;
			
			
				}
			else
				{
				validCustomerPortrait = false;
				document.getElementById("CustPortraitExtError").style.display = 'block';
				document.getElementById("CustomerPortraitError").style.display = 'none';
				document.getElementById("CustomerPortraitsizeError").style.display = 'none';
				}
			
		} */

		
		if (!validateIDfront()) {
			validID_Front = false;
		} else
			validID_Front = true;
		
		
		
	
		
		/* 
		if (ID_Front == "") {
			document.getElementById("IDCardFrontError").style.display = 'block';
			validID_Front = false;

		} else {
			var base64String = ID_Front;

			var stringLength = base64String.length
					- 'data:image/png;base64,'.length;

			var sizeInBytes = 4 * Math.ceil((stringLength / 3)) * 0.5624896334383812;
			var sizeInKb = sizeInBytes / 1024;
			if (sizeInKb < 2048) {
				document.getElementById("IDCardFrontError").style.display = 'none';
				document.getElementById("IDCardFrontSizeError").style.display = 'none';
				validID_Front = true;

			} else {

				document.getElementById("IDCardFrontError").style.display = 'none';
				document.getElementById("IDCardFrontSizeError").style.display = 'block';
				validID_Front = false;

			}
			//status=true;
		} */
		
		
		if (!validateIDback()) {
			validID_Back = false;
		} else
			validID_Back = true;
		
		
		/*  if (ID_back == "") {
		       //document.getElementById("IDCardBackError").style.display = 'block';
		       //"( * Please Upload 1st side of ID card )"; 
		        
		       validID_Back = true;
		} else {

		       var base64String = ID_back;

		       var stringLength = base64String.length
		                    - 'data:image/png;base64,'.length;

		       var sizeInBytes = 4 * Math.ceil((stringLength / 3)) * 0.5624896334383812;
		       var sizeInKb = sizeInBytes / 1024;
		       if (sizeInKb < 2048) {
		              document.getElementById("IDCardBackError").style.display = 'none';
		             document.getElementById("IDCardBackSizeError").style.display = 'none';
		             validID_Back = true;
		       } else {
		             ID_back = "";
		             document.getElementById("IDCardBackError").style.display = 'none';
		             document.getElementById("IDCardBackSizeError").style.display = 'block';
		             validID_Back = false;
		       }
		       //document.getElementById("IDCardBackError").style.display= 'none';  
		       //status=true;
		}  */

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

		//document.getElementById("Customer_PortraitImage").value = Customer_Portrait;
		//document.getElementById("ID_FrontImage").value = ID_Front;
		if(ID_back =="")
		{			
		document.getElementById("ID_backImage").value = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAIIAAACCCAMAAAC93eDPAAAAJ1BMVEXd3d3////29vbl5eXp6enh4eHu7u76+vry8vLi4uL19fXr6+v5+fn36SEaAAADZUlEQVR4nO2Z22LbIAyGwSCEgfd/3qEDxE7czXMS72L6LpJWqtEfkBVZdc4wDMMwDMMwDMMwDMMwjP+HEIkA/UeIEcRWE/8kPmL6+p9Oe3By0fibqyyewb5C8J5WjTgM6uuA+hz6/LBj4IuUNyTgstCaQSXUvnQmw+oye8j/LIFsjcN2R1uYNyTQtX2hJBIA/dK3fPW+sJ8cbu7QkMDx6kP3W+hyPbCsVunj0/p1/ZOELjN+TkJfKMtq+elQf5AAAKGQWroyEdeF8Lm2Ry4UjyckaDrWTTqmNyTs74h8TgLdNVkd7+9CG7c4h0l6ECH8TsLioFAmuA+m4wwTZWWStpUA+o70JtcgB/+CBNeo4kAehzvecZjjJoUbv0ZgPichoJy0bMKUUL2Y8XFN1mKiXN6MFwl8yj3HYC9B63aBzTXdsn5AwiHremSFcGg2DOPrBGkEQftBoF5yVYdyvRaeY5E606sORZKaxLUqf6kOHUrAKSFSTcyNTWk2k98uUot0ICKhfz9RvPr8vfV9CT160Jc4jLdKKNgbaJZQRy9ZJTNuk5B7wMgSZiMXNQdvk0BtbRQJ/l9J6A8Jix6E1IB090FwSAq6aqdMd4a7WQL1RPS5C8ccDfO9EqJIAPSbx4Z7JdDn59PPqM86N0p4AaxpNIzvAzJVCGNg+PRr4AHj7hFu42PYByGA25nVcYIkD89VC68OEPDRoSw60Jia/aZ7YRrs5gtzTHm2dqE0oaCVN81GcflBAj3eF/VhztRO5mcJMoE8OYgNVPgpQJGGoHHohb4N1mMJjXwwfU66mZ2E/ZjqT2Tf6vjgkTej8mvUsC8SqInUPZ4S2jsSKKQev9fuAOgVR6f2IoHsZfgwpSRDn70Enr2dTAXeAVmRW7PGx4wyAI1HEkhvHD4hu+N0PCeBQ8YxM4vAa8vvqFmxl1D1oaK4kY6FM/fyLlAydry2R0Va9cJWHsK/SGjDBzMX4tMM+u9y4fFwKE+KjWLBNOYXCev0zbmjZNFVCVQMaFTI/wOQ5QOn5EpWvk2HBJ0pZvVxGBmDyxByM3fsPjg9gqxDemPhKI+xTStPpBtUJeiEeu4Hb/7Mu7Ybg0/zmf+OtLFlUp7TqHNa1rCvvZcQp48q5BidZ7guwTAMwzAMwzAMwzAMwzCM6/wC3ZIVE29Bg6kAAAAASUVORK5CYII=";
		}
		
		
		document.getElementById("provinceName").value = $('#customer :selected')
				.text();
		document.getElementById("districtName").value = $('#district :selected')
				.text();

		/* //alert("Dateofbirth "+ Dateofbirth +"dateofissue "+dateofissue +" idcard  "+ idcard +" adress  "+ adress + "Customer_Portrait "+ Customer_Portrait + "ID_Front  "+ ID_Front)
		if (Dateofbirth == "" || dateofissue == "" || idcard == ""
				|| adress == "" || Customer_Portrait == "" || ID_Front == ""
				|| placeofIssuevalue == ""
				|| document.getElementById('acceptcondition').checked == false)
		//  if(status = false || document.getElementById('acceptcondition').checked == false)
		{
			//status = false;
			//return false;
		} else {

			//status = true;

		} */
		
		var validAccept = document.getElementById('acceptcondition').checked ;
		

		/* alert(validName + ","+ validDateofbirth + ","+ validdateofissue + ","+ valididcard
				+ ","+ validadress + ","+ validplaceofIssue + ","+ validCustomerPortrait
				+ ","+validID_Front + ","+ validID_Back + ","+   validAccept); */
		
		if (validName && validDateofbirth && validdateofissue && valididcard
				&& validadress && validplaceofIssue && validCustomerPortrait
				&& validID_Front && validID_Back &&validAccept) {
					
			showLoader();
			return true;
		} else
			{ //alert('no')
			return false;
			}

		//alert(status)
		//return status;\

	}

	function hidecustImage() {
		$('#Customer_Portrait').attr('src', '').css('display', 'none');
		$('.cust_close').css('display', 'none');
		$("[name = customFile]").val('');
		
		document.getElementById("CustPortraitExtError").style.display = 'none';
		document.getElementById("CustomerPortraitError").style.display = 'none';
		document.getElementById("CustomerPortraitsizeError").style.display = 'none';

	}
	function hideID_Front() {
		$('#ID_Front').attr('src', '').css('display', 'none');
		$('.front_close').css('display', 'none');
		$("[name = imageFront]").val('');
		
		document.getElementById("IDFrontExtError").style.display = 'none';
		document.getElementById("IDCardFrontError").style.display = 'none';
		document.getElementById("IDCardFrontSizeError").style.display = 'none';

	}
	function hideID_back() {
		$('#ID_back').attr('src', '').css('display', 'none');
		$('.back_close').css('display', 'none');
		$("[name = imageBack]").val('');
		
		document.getElementById("IDBackExtError").style.display = 'none';
		document.getElementById("IDCardBackError").style.display = 'none';
		document.getElementById("IDCardBackSizeError").style.display = 'none';

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
<div class="mask"></div>
	<div class="masking" style="display: none">
		<div class="loader">
			<img
				src="${pageContext.request.contextPath}/static/assets/image/loader.gif">
		</div>
	</div>


<div class="col-sm-4 popup" id="popupDisplayalreadyexist"
              style="display: none;">
              <div class="close">
                     <a href="#" title="close"><a href="${pageContext.request.contextPath}/secure/dashboard"></a>
              </div>

              <div class="popup-body">
                     <h1>
                           <spring:message code="label.CustomerInformation"
                                  text="CustomerInformation" />
                     </h1>
                     <h4>
                           <spring:message code="label.CanotUpdatedinfo"
                                  text="Update Customer Information" />
                     </h4>
              </div>

            <a href="${pageContext.request.contextPath}/secure/dashboard">  <button type="button" class="btn btn-default proceed">
                     <spring:message code="label.OK" text="OK" />
              </button></a>

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
			<form name="f1" class="customer_varification" method="Post"
				onsubmit="return validate()"
				action="${pageContext.request.contextPath}/secure/submit?${_csrf.parameterName}=${_csrf.token}">

				<div class="col-md-12 no-padding">
					<div class="form-row">
						<div class="form-group col-md-6">
							<table>
								<tr>
									<td><label><spring:message
												code="label.PhoneNumber" text="Phone Number" /></label></td>
									<td><span id="MSISDNerror"
										style="color: red; padding-left: 10px; font-size: 10px;"></span></td>
								</tr>
							</table>

							<input type="text" id="msisdn" name="msisdn" value="${authUser}"
								class="form-control" disabled="disabled" />
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

							<select class="form-control" id="genderId" name="genderId">
							<option value="0"><spring:message
												code="label.maleText" text="Male" /></option>
							<option value="1"><spring:message
												code="label.femaleText" text="Female" /></option>
							</select>
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
									style="color: red; padding-left: 10px; display: none; font-size: 10px;"><spring:message
										code="label.Firstname" text="Enter your First name" /></td>
							</tr>
						</table>
						<input type="text" id="firstname" name="firstname"
							class="form-control">

					</div>
					<div class="form-group col-md-6">
						<table>
							<tr>
								<td><spring:message code="label.LastnameT" text="Last Name" /></td>
								<td id="lastnameerror"
									style="color: red; padding-left: 10px; display: none; font-size: 10px;"><spring:message
										code="label.Lastname" text="Enter your last name" /></td>
							</tr>
						</table>
						<input type="text" id="lastname" name="lastname"
							class="form-control">

					</div>
				</div>

				<div class="form-row">


					<div class="form-group col-md-6">
						<table>
							<tr>
								<td><spring:message code="label.DateofbirthT"
										text="Date of birth" /></td>
								<td id="Dateofbirtherror"
									style="color: red; padding-left: 10px; display: none; font-size: 10px;"><spring:message
										code="label.DateofBirth" text="Enter date of birth" />
								<td id="Dateofbirtherrormin"
									style="color: red; padding-left: 10px; display: none; font-size: 10px;"><spring:message
										code="label.DateofBirth.belowfourteen"
										text="Enter date of birth" /></td>
								<td id="DOBformaterror"
									style="color: red; padding-left: 10px; display: none; font-size: 10px;"><spring:message
										code="label.DateFormat" text="Enter correct date format" /></td>
							</tr>
						</table>
						<!-- <input type="date" id="dob" name="Dateofbirth" class="form-control"  data-toggle="datepicker" > -->
							<input type="text" id="dob" name="Dateofbirth" class="form-control"  data-toggle="datepicker" maxlength="10" onkeypress='validatedate(event,this)' placeholder="dd/mm/yyyy" >
							<!-- onclick="validateDOB();" -->
							
							
					</div>


					<div class="form-group col-md-6">

						<table>
							<tr>
								<td><spring:message code="label.IDCARDT" text="ID Card" /></td>
								<td id="idcarderror"
									style="color: red; padding-left: 10px; display: none; font-size: 10px;"><spring:message
										code="label.ValidIDcardnumber"
										text="Enter your valid ID card number" /></td>
							</tr>
						</table>

						<input type="text" name="idcard" id="idcard" class="form-control">
					</div>


				</div>

				<div class="form-row">
					<div class="form-group col-md-6">

						<table>
							<tr>
								<td><spring:message code="label.DateofissueT"
										text="Date of issue" /></td>
								<td id="Dateofissueerror"
									style="color: red; padding-left: 10px; display: none; font-size: 10px;"><spring:message
										code="label.DateofIssue" text="Enter date of issue" /></td>

								<td id="Dateofissueerrormin"
									style="color: red; padding-left: 10px; display: none; font-size: 10px;"><spring:message
										code="label.IDcardisexpired" text="The ID card is expired" /></td>
								<td id="DOIformaterror"
									style="color: red; padding-left: 10px; display: none; font-size: 10px;"><spring:message
										code="label.DateFormat" text="Enter correct date format" /></td>

							</tr>
						</table>
						<input type="text" id="dateofissue" name="dateofissue"
							class="form-control" data-toggle="datepicker"  maxlength="10" onkeypress='validatedate(event,this)' placeholder="dd/mm/yyyy"    >
					</div>
				</div>



				<div class="form-row">
					<div class="form-group col-md-6">
						<table>
							<tr>
								<td><spring:message code="label.placeofIssueT"
										text="Place of Issue" /></td>
								<td id="placeofIssueerror"
									style="color: red; padding-left: 10px; display: none; font-size: 10px;"><spring:message
										code="label.placeofIssueerror" text="Enter Place of Issue" /></td>
							</tr>
						</table>

						<input type="text" id="placeofIssueId" name="placeofIssueId"
							class="form-control">
					</div>

				</div>




				<div class="form-row">
					<div class="form-group col-md-12">
						<table>
							<tr>
								<td><spring:message code="label.AddressT" text="Address" /></td>
								<td id="Addresserror"
									style="color: red; padding-left: 10px; display: none; font-size: 10px;"><spring:message
										code="label.ValidAddress" text="Enter Address" /></td>
							</tr>
						</table>

						<input type="text" id="adress" name="adress" class="form-control">
					</div>
					<div class="form-group col-md-6">
						<label><spring:message code="label.ProvinceT"
								text="Province" /></label> <select class="form-control" id="customer">
							<c:forEach items="${provincelist}" var="ListItem">

								<option value="${ListItem.provinceId}">${ListItem.provinceName}</option>
							</c:forEach>

						</select>
					</div>
				</div>

				<div class="form-row">
					<div class="form-group col-md-6">

						<table>
							<tr>
								<td><label><spring:message code="label.DistrictT"
											text="District" /></label></td>
								<td id="Districterror"
									style="color: red; padding-left: 10px; display: none; font-size: 10px;"><spring:message
										code="label.Yourdistrict" text="Select your district" /></td>
							</tr>
						</table>
						<select class="form-control" id="district">
							<%--  <c:forEach items="${provincelist}"  var="ListItem">
            <li>${ListItem.name}</li>
            <option>${ListItem.provinceName}</option>
        </c:forEach> --%>

						</select>
					</div>

				</div>
				<div class="clearfix"></div>
				<div class="form-row uploads">
					<div class="col-lg-12">
						<div class="col-md-2 no-padding profile">
							<div class="customer-portrait">
								<div class="upload-btn-wrapper">
									<a class="uploadbtn">
										<i class="fa fa-upload fa-2x" style="line-height:4em;"></i>
									</a>
									 <input type="file" name="customFile"
										accept="image/x-png,image/jpeg,image/jpg,image/JPG,image/PNG"
										onchange="readURL(this);" /> 
										<!-- <input type="file" name="customFile"   
										accept="image/x-png,image/jpeg,image/jpg,image/JPG,image/PNG"
										onchange="validateCustPortrait();" />
										 -->
								</div>
								<canvas id="canvas" class="profile_id"></canvas>
								<img id="Customer_Portrait" name="Customer_Portrait" src=""
									alt="your image" class="profile_id" />
								<div class="cust_close" onClick="hidecustImage()">
									<a  title="close"><i class="fa fa fa-times-circle"></i></a>
								</div>
							</div>
							<spring:message code="label.CustomerPortraitT"
								text="Customer Portrait" />
							<p id="CustomerPortraitError"
								style="color: red; padding-left: 10px; display: none; font-size: 10px;">
								<spring:message code="label.YourPortrait"
									text="Customer Portrait" />
							</p>
							<p id="CustomerPortraitsizeError"
								style="color: red; padding-left: 10px; display: none; font-size: 10px;">
								<spring:message code="label.AttachmentSize"
									text="Attachment size exceeds the allowable limit 200 KB" />
							</p>
							<p id="CustPortraitExtError"
								style="color: red; padding-left: 10px; display: none; font-size: 10px;">
								<spring:message code="label.ExtentionIssue"
									text="File extension not supported" />
							</p>




						</div>
						<div class="col-md-2 no-padding profile">
							<div class="id-front">
								<div class="upload-btn-wrapper">
									<a class="uploadbtn">
										<i class="fa fa-upload fa-2x" style="line-height:4em;"></i>
									</a>
									<input type="file" name="imageFront" accept="image/x-png,image/jpeg,image/jpg,image/JPG,image/PNG"
									 onchange="readURL(this);" />
									
									
									
									
								</div>
								<canvas id="canvas1" class="profile_id"></canvas>
								<img id="ID_Front" src="" name="ID_Front" alt="your image"
									class="profile_id" accept="image/x-png,image/jpeg,image/jpg" />
								<div class="front_close" onClick="hideID_Front()">
									<a  title="close"><i class="fa fa fa-times-circle"></i></a>
								</div>
							</div>
							<spring:message code="label.IDCardFrontT" text="ID Card Front" />
							<p id="IDCardFrontError"
								style="color: red; padding-left: 10px; display: none; font-size: 10px;">
								<spring:message code="label.YourIDproof" text="ID Card Front" />
							</p>
							<p id="IDCardFrontSizeError"
								style="color: red; padding-left: 10px; display: none; font-size: 10px;">
								<spring:message code="label.AttachmentSize"
									text="Attachment size exceeds the allowable limit 200 KB" />
							</p>
							<p id="IDFrontExtError"
								style="color: red; padding-left: 10px; display: none; font-size: 10px;">
								<spring:message code="label.ExtentionIssue"
									text="File extension not supported" />
							</p>


						</div>
						<div class="col-md-2 no-padding profile">
							<div class="id-back">
								<div class="upload-btn-wrapper">
									<a class="uploadbtn">
										<i class="fa fa-upload fa-2x" style="line-height:4em;"></i>
									</a>
									<input type="file"    name="imageBack" onchange="readURL(this);" />
								</div>
								<canvas id="canvas11" class="profile_id"></canvas>
								<img id="ID_back" src="" name="ID_back" alt="your image"
									accept="image/x-png,image/jpeg,image/jpg,image/JPG,image/PNG"
									class="profile_id" />

								<div class="back_close" onClick="hideID_back()">
									<a  title="close"><i class="fa fa fa-times-circle"></i></a>
								</div>
							</div>
							<spring:message code="label.IDCardBackT" text="ID Card Back" />
							<p id="IDCardBackError"
								style="color: red; padding-left: 10px; display: none; font-size: 10px;">
								<spring:message code="label.YourIDproof" text="ID Card Back" />
							</p>
							<p id="IDCardBackSizeError"
								style="color: red; padding-left: 10px; display: none; font-size: 10px;">
								<spring:message code="label.AttachmentSize"
									text="Attachment size exceeds the allowable limit 200 KB" />
							</p>
							<p id="IDBackExtError"
								style="color: red; padding-left: 10px; display: none; font-size: 10px;">
								<spring:message code="label.ExtentionIssue"
									text="File extension not supported" />
							</p>
							
						
							
						</div>
					</div>
<br clear="all">

					<div class="col-lg-12"
						style="margin-bottom: 30px; margin-top: 30px;">
						<input type="checkbox" id="acceptcondition" onClick="hideSubmit()">
						<span style="color: #000000;"> <spring:message
								code="label.CheckboxforCommit" text="Accept Terms & Conditions" /></span>
						<p id="CheckboxforCommits"
							style="color: red; padding-left: 10px; display: none; font-size: 10px;">
							<spring:message code="label.CheckboxforCommitNotSelected"
								text="Accept Terms & Conditions " />
						</p>
					</div>

					<br clear="all">

					<div class="col-lg-12">
						<input type="hidden" name="provinceName" value=""
							id="provinceName"> <input type="hidden"
							name="districtName" value="" id="districtName"> <input
							type="hidden" name="ID_FrontImage" value="" id="ID_FrontImage">
						<input type="hidden" name="ID_backImage" value=""
							id="ID_backImage"> <input type="hidden"
							name="Customer_PortraitImage" value=""
							id="Customer_PortraitImage">

						<button type="submit" id="convert" class="btn btn-primary submit"
							style="display: none" >
							<spring:message code="label.Submit" text="Submit" />
						</button>
						<%-- <button type="submit" id="convert" class="btn btn-primary submit" onclick="showLoader()"
                                                style="display: none">
                                                <spring:message code="label.Submit" text="Submit" />
                                         </button> --%>
					</div>


					<div class="clearfix"></div>
				</div>
		</div>

		<div class="clearfix"></div>
		<canvas id="cannn" height=400 width=400 style="display:none"/>
		<canvas id="cannn1" height=400 width=400 style="display:none"/>
		<canvas id="cannn2" height=400 width=400 style="display:none"/>
		
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
<script src="${pageContext.request.contextPath}/static/assets/script/ImageTools.js"	type="text/javascript"></script>


<script type="text/javascript">
	$(document).ready(function() {
	
	       $('body').on('hidden.bs.modal', '.modal', function () {
	                $(this).removeData('bs.modal');
	       });
	         
	         var micstatus = "${mic_statusalredyexist}";
	
	     if(micstatus==3)
	     { 
	              // alert("hello");
	       // document.getElementById('popupDisplay').style.display = "block";
	              $('#popupDisplayalreadyexist, .mask').show();
	    }  
	});
	
	 
	</script>
	
	
	<script type="text/javascript">
	
	
	$(document).ready(function() {
		$.ajax({ type : "GET",
					url : "${pageContext.request.contextPath}/secure/district/14",
					success : function(data) {
						//  alert('success');
						$("#district").empty();

						$("#district").append('<option value="" disabled="disabled" selected="selected">Please Select</option>');

						$.each(data,function(i, item) {
											$("#district")
													.append('<option value="'+data[i].districtId+'">'+ data[i].districtName	+ '</option>');
										});
						document.getElementById('district').selectedIndex = 1;

					},
					error : function(e) {
						alert('fail');
					}

				});

	});
	</script>

<script>
	$(function() {
		$('[data-toggle="datepicker"]').datepicker({
			autoHide : true,
			zIndex : 0,
			endDate : '+1d'
		});
	});
	
	
	function validatedate(evt,ele) {
		  var theEvent = evt || window.event;
		  var key = theEvent.keyCode || theEvent.which;
		  key = String.fromCharCode( key );
		  var regex = /[0-9\/]/;
		  
		  if( !regex.test(key) ) {
			  
			  if (evt.keyCode == 8 || evt.keyCode == 46 || evt.keyCode == 37 || evt.keyCode == 39) {
				  return true;
			  }
			  else
				  {
		    theEvent.returnValue = false;
		    if(theEvent.preventDefault) theEvent.preventDefault();
				  }
		  }
		  
		  var chklen = ele.value.length;
		  
		  if(chklen==2 || chklen == 5)
			  {  var eledata = ele.value;
			  ele.value = eledata +'/';
			
			  }
		  
		 /*  if (evt.keyCode == 8 || evt.keyCode == 46 || evt.keyCode == 37 || evt.keyCode == 39) {
				     return true;
			
		  } */
		  
		}
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

	/*   function getAge(dateString) {
	         var today = new Date();
	         var birthDate = new Date(dateString);
	         var age = today.getFullYear() - birthDate.getFullYear();
	         var m = today.getMonth() - birthDate.getMonth();
	         if (m < 0 || (m === 0 && today.getDate() < birthDate.getDate())) {
	                age--;
	         }
	         return age;
	  } */

	$("#dob").change(function() {
		validateDOB()
	});

 	$("#dateofissue").change(function() {
		validateDOIssue()
	}); 
 	$("#dateofissue").focusout(function() {
		validateDOIssue()
	}); 
 	
 	

	$("#placeofIssueId").change(function() {
		validatePlaceIssue();
	});

	$("#adress").change(function() {
		validateAddress();

	});

	$("#idcard").change(function() {
		validateIdcard();
	});
	
	$("#firstname").blur(function(){
		var firstname = $("#firstname").val().trim();
		if (firstname == "") {
			
			document.getElementById("firstnameerror").style.display = 'block';
			
		
		} else {
			document.getElementById("firstnameerror").style.display = 'none';
			
			
		}

	});
	
	
</script>




<script type="text/javascript">
	/* $('#convert').click(function(){
	//Some code
	// $imgsrc=$('.img1 ID_back').attr('src');
	// var youtubeimgsrc = document.getElementById("ID_back").src;
	var canvas = document.getElementById('canvas');
	var dataURL = canvas.toDataURL();
	var canvas1 = document.getElementById('canvas1');
	var dataURL1 = canvas.toDataURL();
	var canvas11 = document.getElementById('canvas11');
	var dataURL11 = canvas.toDataURL();
	var dataURL11 =$('[name=whatever]').val();
	
	var msisdn=$('[name=msisdn]').val();
	var firstname=$('[name=firstname]').val();
	var lastname=$('[name=lastname]').val(); 
	 var adress=$('[name=adress]').val();
	var fullname=$('[name=fullname]').val();
	var dob=$('[name=dob]').val();
	var idcard=$('[name=idcard]').val();
	var dateofissue=$('[name=dateofissue]').val(); 
	 var country=$('[name=country]').val();
	
	alert("Image Source Is for first :"+msisdn+" "+firstname+" "+lastname+" "+adress+" "+fullname+" "+dob+" "+idcard+" "+idcard);
	//alert("Image Source Is for Second :"+dataURL);
	//alert("Image Source Is for third :"+dataURL);
	var j ={"firstname":firstname,"msisdn":msisdn,"lastname":lastname,"adress":adress,"fullname":fullname,"dob":dob,"idcard":idcard,"dateofissue":dateofissue,"country":country};
	$.ajax({
	type: "POST",
	url: "${pageContext.request.contextPath}/secure/submit?${_csrf.parameterName}=${_csrf.token}",
	data: {msisdn:msisdn},
	dataType: "json",
	processData: false, //prevent jQuery from automatically transforming the data into a query string
	contentType: false,
	cache: false,
	timeout: 600000,
	success: function (data) {
	console.log("sucess ");
	},
	error: function (e) {
	console.log("Error uploading file: ", e);
	}
	});
	}); */

	function getFileExtension(filename) {
		return filename.split('.').pop();
	}

	function getOrientation(file, callback) {
		  var reader = new FileReader();

		  reader.onload = function(event) {
		    var view = new DataView(event.target.result);

		    if (view.getUint16(0, false) != 0xFFD8) return callback(-2);

		    var length = view.byteLength,
		        offset = 2;

		    while (offset < length) {
		      var marker = view.getUint16(offset, false);
		      offset += 2;

		      if (marker == 0xFFE1) {
		        if (view.getUint32(offset += 2, false) != 0x45786966) {
		          return callback(-1);
		        }
		        var little = view.getUint16(offset += 6, false) == 0x4949;
		        offset += view.getUint32(offset + 4, little);
		        var tags = view.getUint16(offset, little);
		        offset += 2;

		        for (var i = 0; i < tags; i++)
		          if (view.getUint16(offset + (i * 12), little) == 0x0112)
		            return callback(view.getUint16(offset + (i * 12) + 8, little));
		      }
		      else if ((marker & 0xFF00) != 0xFF00) break;
		      else offset += view.getUint16(offset, false);
		    }
		    return callback(-1);
		  };

		  reader.readAsArrayBuffer(file.slice(0, 64 * 1024));
		};
	
		function drawRotated(degrees){
			//alert("c");
		    var canvas=document.getElementById("canvas");
	        var ctx=canvas.getContext("2d");
		    var image=document.getElementById("Customer_Portrait");		
	        ctx.clearRect(0,0,canvas.width,canvas.height);
	       // alert(canvas.width)
	        ctx.save();
	        ctx.translate(canvas.width/2,canvas.height/2);
	        ctx.rotate(degrees*Math.PI/180);
	        ctx.drawImage(image,-image.width/2,-image.width/2);
	        ctx.restore();
	        //alert("canvas.width")
	    }
		
		function rotateBase64ImageCust(base64data, callback) {
		    var canvas = document.getElementById("cannn");
		    var ctx = canvas.getContext("2d");

		    var image = new Image();
		    image.src = base64data;
		    image.onload = function() {
		    	
		    	ctx.clearRect(0,0,canvas.width,canvas.height);
		        ctx.save();
		        ctx.translate(canvas.width/2,canvas.height/2);
		        ctx.rotate(90*Math.PI/180);
		        ctx.drawImage(image,-image.width/2,-image.width/2);
		        ctx.restore();      
		        
		        
		        window.eval(""+callback+"('"+canvas.toDataURL()+"')");
		    };

		}
		function rotateBase64ImageBack(base64data, callbackBack) {
		    var canvas = document.getElementById("cannn1");
		    var ctx = canvas.getContext("2d");

		    var image = new Image();
		    image.src = base64data;
		    image.onload = function() {
		    	
		    	ctx.clearRect(0,0,canvas.width,canvas.height);
		        ctx.save();
		        ctx.translate(canvas.width/2,canvas.height/2);
		        ctx.rotate(90*Math.PI/180);
		        ctx.drawImage(image,-image.width/2,-image.width/2);
		        ctx.restore();      
		        
		        
		        window.eval(""+callbackBack+"('"+canvas.toDataURL()+"')");
		    };

		}
		
		function rotateBase64ImageFront(base64data, callbackFront) {
		    var canvas = document.getElementById("cannn2");
		    var ctx = canvas.getContext("2d");

		    var image = new Image();
		    image.src = base64data;
		    image.onload = function() {
		    	
		    	ctx.clearRect(0,0,canvas.width,canvas.height);
		        ctx.save();
		        ctx.translate(canvas.width/2,canvas.height/2);
		        ctx.rotate(90*Math.PI/180);
		        ctx.drawImage(image,-image.width/2,-image.width/2);
		        ctx.restore();      
		        
		        
		        window.eval(""+callbackFront+"('"+canvas.toDataURL()+"')");
		    };

		}
		function callback(base64data) {
			document.getElementById("Customer_PortraitImage").value = base64data;
		    console.log("Customer_PortraitImage -- " +base64data);
		}
		
		function callbackBack(base64data) {
			document.getElementById("ID_backImage").value = base64data;
		    console.log("ID_backImage -- " +base64data);
		}
		
		function callbackFront(base64data) {
			document.getElementById("ID_FrontImage").value = base64data;
		    console.log("ID_FrontImage -- "+ base64data);
		}
		
	function readURL(input) {
		if (input.name == "customFile") {
			
			
			//class="profile_id_canvas"
				//canvas
			//$('#Customer_Portrait').attr('src', '');
			if (input.files && input.files[0]) {
				
				var reader = new FileReader();
				reader.onload = function(e) {
					var fileName = input.files[0].name
					var actualSize=input.files[0].size;
					var extb = getFileExtension(fileName);
					
					//alert("orientation");
					
					 if(actualSize<(200*1024) || actualSize >(10*1024*1024))
					  { 						
						if (extb == "png" || extb == "jpg" || extb == "jpeg"
								|| extb == "PNG" || extb == "JPG" || extb == "JPEG") {
							
							
							getOrientation(input.files[0], function(orientation) {
								//alert(orientation);
								if(orientation==6)
								{									
									$('#Customer_Portrait').attr('src', e.target.result).width(126).height(126).css('display', 'block').addClass('rotate90');								
									console.log("e.target.result == "+ e.target.result);
									
									rotateBase64ImageCust(e.target.result, 'callback');
									
								//$(input).toggleClass('rotate');
								}
								else if(orientation==8)
								{
									$('#Customer_Portrait').attr('src', e.target.result).width(126).height(126).css('display', 'block').addClass('rotate270');
									
									console.log("orientation8 ==== "+ orientation);
									rotateBase64ImageCust(e.target.result, 'callback');
								//$(input).toggleClass('rotate');
								}
								else
									{
									$("#Customer_Portrait").removeClass("rotate90");
									$('#Customer_Portrait').attr('src', e.target.result).width(126).height(126).css('display', 'block').addClass('profile-round');
									
									document.getElementById("Customer_PortraitImage").value = e.target.result;
									//rotateBase64ImageCust(base64datas, 'callback');
									console.log("orientation ==== "+ orientation);
									}
								
							  });
							
							
							
							$('.cust_close').css('display', 'block');
							document.getElementById("CustPortraitExtError").style.display = 'none';
							document.getElementById("CustomerPortraitError").style.display = 'none';
							document.getElementById("CustomerPortraitsizeError").style.display = 'none';
						} else {
							//document.getElementById("CustomerPortraitError").style.display = 'block';
							document.getElementById("CustPortraitExtError").style.display = 'block';
							document.getElementById("CustomerPortraitError").style.display = 'none';
							document.getElementById("CustomerPortraitsizeError").style.display = 'none';
							
							$("[name = customFile]").val('');
							
						}
					 }
					else
					{
						 ImageTools.resize(input.files[0], {
						        width: 400, // maximum width
						        height: 400 // maximum height
						    }, function(blob, didItResize) {
						        
						    	if (extb == "png" || extb == "jpg" || extb == "jpeg"
									|| extb == "PNG" || extb == "JPG" || extb == "JPEG") {
						    		
						    	 var reader = new FileReader();
						   		 reader.readAsDataURL(blob); 
						   		 reader.onloadend = function() {
						   			var base64datas = reader.result;  
						   			var img_src = base64datas;
						   			//$('#Customer_Portraitbase64').attr('src', img_src).width(126).height(126);
						   			
						   			getOrientation(input.files[0], function(orientation) {
										//alert(orientation);
										if(orientation==6)
										{									
											$('#Customer_Portrait').attr('src', base64datas).width(126).height(126).css('display', 'block').addClass('rotate90');
											console.log("1orientation6 ==== "+ orientation);
											
											
											
											
											rotateBase64ImageCust(base64datas, 'callback');
											
											
										
										}
										else if(orientation==8)
										{
											$('#Customer_Portrait').attr('src', base64datas).width(126).height(126).css('display', 'block').addClass('rotate270');
											
											console.log("1orientation8 ==== "+ orientation);
											rotateBase64ImageCust(base64datas, 'callback');
										//$(input).toggleClass('rotate');
										}
										else
											{
											$("#Customer_Portrait").removeClass("rotate90");
											$('#Customer_Portrait').attr('src', base64datas).width(126).height(126).css('display', 'block').addClass('profile-round');
											
											document.getElementById("Customer_PortraitImage").value = base64datas;
											//rotateBase64ImageCust(base64datas, 'callback');
											
											}
										
									  });
						   			
						   			
						   			
						   			//console.log(base64datas);
						   			//$('#Customer_Portrait').attr('src', base64datas).width(126).height(126).css('display', 'block').addClass('profile-round');
						   		 }
						    		
						    		
								
								$('.cust_close').css('display', 'block');
								
								document.getElementById("CustPortraitExtError").style.display = 'none';
								document.getElementById("CustomerPortraitError").style.display = 'none';
								document.getElementById("CustomerPortraitsizeError").style.display = 'none';
							} else {
								//document.getElementById("CustomerPortraitError").style.display = 'block';
								document.getElementById("CustPortraitExtError").style.display = 'block';
								document.getElementById("CustomerPortraitError").style.display = 'none';
								document.getElementById("CustomerPortraitsizeError").style.display = 'none';
								
								$("[name = customFile]").val('');
								
							}
						    	
						       // document.getElementById('preview').src = window.URL.createObjectURL(blob);
								
						        
					 });
					} 
					
					

				};

				reader.readAsDataURL(input.files[0]);

			}
			/* document.getElementById("CustomerPortraitError").style.display = 'none';
			document.getElementById("CustomerPortraitsizeError").style.display = 'none'; */
			
		} else if (input.name == "imageFront") {

			if (input.files && input.files[0]) {
				var reader = new FileReader();
				reader.onload = function(e) {
					
					var fileName = input.files[0].name
					var extb = getFileExtension(fileName);
					var actualSize=input.files[0].size;
					
					if(actualSize<(200*1024) || actualSize >(10*1024*1024))
					{
						if (extb == "png" || extb == "jpg" || extb == "jpeg"
							|| extb == "PNG" || extb == "JPG" || extb == "JPEG") {					
					
					
					
					getOrientation(input.files[0], function(orientation) {
						//alert(orientation);
						if(orientation==6)
						{									
							$('#ID_Front').attr('src', e.target.result).width(126).height(126).css('display', 'block').addClass('rotate90');
							//$('#Customer_Portrait').attr('src', e.target.result).width(126).height(126).css('display', 'block').addClass('rotate90');
							console.log("orientation6 ==== "+ orientation);
							rotateBase64ImageFront(e.target.result, 'callbackFront');
						//$(input).toggleClass('rotate');
						}
						else if(orientation==8)
						{
							$('#ID_Front').attr('src', e.target.result).width(126).height(126).css('display', 'block').addClass('rotate270');
							rotateBase64ImageFront(e.target.result, 'callbackFront');
							console.log("orientation8 ==== "+ orientation);
						//$(input).toggleClass('rotate');
						}
						else
							{
							$("#ID_Front").removeClass("rotate90");
							$('#ID_Front').attr('src', e.target.result).width(126).height(126).css('display', 'block').addClass('profile-round');
							
							document.getElementById("ID_FrontImage").value = e.target.result;
							//rotateBase64ImageFront(e.target.result, 'callbackFront');
							console.log("orientation ==== "+ orientation);
							}
						
					  });
					
					
					
					
					
					$('.front_close').css('display', 'block');
					
					document.getElementById("IDFrontExtError").style.display = 'none';
					document.getElementById("IDCardFrontError").style.display = 'none';
					document.getElementById("IDCardFrontSizeError").style.display = 'none';
					}
					else {
						//document.getElementById("CustomerPortraitError").style.display = 'block';
						document.getElementById("IDFrontExtError").style.display = 'block';
						document.getElementById("IDCardFrontError").style.display = 'none';
						document.getElementById("IDCardFrontSizeError").style.display = 'none';
						$("[name = imageFront]").val('');
					}
					}
					else
					{
						 ImageTools.resize(input.files[0], {
						        width: 400, // maximum width
						        height: 400 // maximum height
						    }, function(blob, didItResize) {
						    	
						    	if (extb == "png" || extb == "jpg" || extb == "jpeg"
									|| extb == "PNG" || extb == "JPG" || extb == "JPEG") {
							
						    		 var reader = new FileReader();
							   		 reader.readAsDataURL(blob); 
							   		 reader.onloadend = function() {
							   			var base64datas = reader.result;  
							   			//console.log(base64datas);
							   			
							   			
							   			getOrientation(input.files[0], function(orientation) {
										//alert(orientation);
										if(orientation==6)
										{									
											$('#ID_Front').attr('src', base64datas).width(126).height(126).css('display', 'block').addClass('rotate90');
											
											rotateBase64ImageFront(base64datas, 'callbackFront');
											//console.log("1orientation6 ==== "+ orientation);
											
										//$(input).toggleClass('rotate');
										}
										else if(orientation==8)
										{
											$('#ID_Front').attr('src', base64datas).width(126).height(126).css('display', 'block').addClass('rotate270');
											rotateBase64ImageFront(base64datas, 'callbackFront');
											console.log("1orientation8 ==== "+ orientation);
										//$(input).toggleClass('rotate');
										}
										else
											{
											$("#ID_Front").removeClass("rotate90");
											$('#ID_Front').attr('src', base64datas).width(126).height(126).css('display', 'block').addClass('profile-round');
											document.getElementById("ID_FrontImage").value = document.getElementById("ID_Front").getAttribute('src');
											console.log("1orientation ==== "+ orientation);
											}
										
									  });
							   			
							   			
							   			
							   			
							   			//$('#ID_Front').attr('src', base64datas).width(126).height(126).css('display', 'block').addClass('profile-round');
							   		 }
						    		
						    		
							
							$('.front_close').css('display', 'block');
							document.getElementById("IDFrontExtError").style.display = 'none';
							document.getElementById("IDCardFrontError").style.display = 'none';
							document.getElementById("IDCardFrontSizeError").style.display = 'none';
							}
							else {
								//document.getElementById("CustomerPortraitError").style.display = 'block';
								document.getElementById("IDFrontExtError").style.display = 'block';
								document.getElementById("IDCardFrontError").style.display = 'none';
								document.getElementById("IDCardFrontSizeError").style.display = 'none';
								$("[name = imageFront]").val('');
							}
						    	
					  });
					}
					
					

				};

				reader.readAsDataURL(input.files[0]);
			}
			/* document.getElementById("IDCardFrontError").style.display = 'none';
			document.getElementById("IDCardFrontSizeError").style.display = 'none'; */

		} else {
			if (input.files && input.files[0]) {
				var reader = new FileReader();
				reader.onload = function(e) {

					
					var fileName = input.files[0].name
					var extb = getFileExtension(fileName);
					var actualSize=input.files[0].size;
					
					if(actualSize<(200*1024) || actualSize >(10*1024*1024))
					{
						if (extb == "png" || extb == "jpg" || extb == "jpeg"
							|| extb == "PNG" || extb == "JPG" || extb == "JPEG") {
					
					
					//if(input.files[0])
					
						
						
						getOrientation(input.files[0], function(orientation) {
						//alert(orientation);
						if(orientation==6)
						{									
							$('#ID_back').attr('src', e.target.result).width(126).height(126).css('display', 'block').addClass('rotate90');
							
							rotateBase64ImageBack(e.target.result, 'callback');
							//$('#Customer_Portrait').attr('src', e.target.result).width(126).height(126).css('display', 'block').addClass('rotate90');
							console.log("orientation6 ==== "+ orientation);
							
						//$(input).toggleClass('rotate');
						}
						else if(orientation==8)
						{
							$('#ID_back').attr('src', e.target.result).width(126).height(126).css('display', 'block').addClass('rotate270');
							rotateBase64ImageBack(e.target.result, 'callback');
							console.log("orientation8 ==== "+ orientation);
						//$(input).toggleClass('rotate');
						}
						else
							{
							$("#ID_back").removeClass("rotate90");
							$('#ID_back').attr('src', e.target.result).width(126).height(126).css('display', 'block').addClass('profile-round');
							document.getElementById("ID_backImage").value = document.getElementById("ID_back").getAttribute('src');
							console.log("orientation ==== "+ orientation);
							}
						
					  });
						
						
						//$('#ID_back').attr('src', e.target.result).width(126).height(126).css('display', 'block').addClass('profile-round');
					$('.back_close').css('display', 'block');
					document.getElementById("IDBackExtError").style.display = 'none';
					document.getElementById("IDCardBackError").style.display = 'none';
					document.getElementById("IDCardBackSizeError").style.display = 'none';
					
					}
					else {
						//document.getElementById("CustomerPortraitError").style.display = 'block';
							//
						
						document.getElementById("IDBackExtError").style.display = 'block';
						document.getElementById("IDCardBackError").style.display = 'none';
						document.getElementById("IDCardBackSizeError").style.display = 'none';
						$("[name = imageBack]").val('');
					}
					}
					else
					{
						ImageTools.resize(input.files[0], {
					        width: 400, // maximum width
					        height: 400 // maximum height
					    }, function(blob, didItResize) {
					    	
					    	if (extb == "png" || extb == "jpg" || extb == "jpeg"
								|| extb == "PNG" || extb == "JPG" || extb == "JPEG") {
						
					    		var reader = new FileReader();
						   		 reader.readAsDataURL(blob); 
						   		 reader.onloadend = function() {
						   			var base64datas = reader.result;  
						   			//console.log(base64datas);
						   			
						   			
						   			getOrientation(input.files[0], function(orientation) {
										//alert(orientation);
										if(orientation==6)
										{									
											$('#ID_back').attr('src', base64datas).width(126).height(126).css('display', 'block').addClass('rotate90');
											console.log("1orientation6 ==== "+ orientation);
											rotateBase64ImageBack(base64datas, 'callbackBack');
										//$(input).toggleClass('rotate');
										}
										else if(orientation==8)
										{
											$('#ID_back').attr('src', base64datas).width(126).height(126).css('display', 'block').addClass('rotate270');
											rotateBase64ImageBack(base64datas, 'callbackBack');
											console.log("1orientation8 ==== "+ orientation);
										//$(input).toggleClass('rotate');
										}
										else
											{
											$("#ID_back").removeClass("rotate90");
											$('#ID_back').attr('src', base64datas).width(126).height(126).css('display', 'block').addClass('profile-round');
											document.getElementById("ID_backImage").value = document.getElementById("ID_back").getAttribute('src');
											console.log("1orientation ==== "+ orientation);
											}
										
									  });
						   			
						   			
						   			
						   			//$('#ID_back').attr('src', base64datas).width(126).height(126).css('display', 'block').addClass('profile-round');
						   		 }
						//if(input.files[0])
						
						$('.back_close').css('display', 'block');
						document.getElementById("IDBackExtError").style.display = 'none';
						document.getElementById("IDCardBackError").style.display = 'none';
						document.getElementById("IDCardBackSizeError").style.display = 'none';
						
						}
						else {
							//document.getElementById("CustomerPortraitError").style.display = 'block';
								//
							
							document.getElementById("IDBackExtError").style.display = 'block';
							document.getElementById("IDCardBackError").style.display = 'none';
							document.getElementById("IDCardBackSizeError").style.display = 'none';
							$("[name = imageBack]").val('');
						}
					    });
					
					}
					
					
				};

				reader.readAsDataURL(input.files[0]);

			}
		}
	}

	

	$('#customer')
			.change(
					function(e) {
						e.preventDefault();
						var id = $(this).val().trim();
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
										document.getElementById('district').selectedIndex = 1;

									},
									error : function(e) {
										alert('fail');
									}

								});

					});

	function validateDOB() {
		
		var Dateofbirth = $('#dob').val().trim();
		if (Dateofbirth == "") {

			/* document.getElementById("DOBformaterror").style.display = 'none';
			document.getElementById("Dateofbirtherror").style.display = 'none';
			document.getElementById("Dateofbirtherrormin").style.display = 'none';
			Dateofbirth = "NA";
			return true; */
			
			document.getElementById("Dateofbirtherror").style.display = 'block';
			//"( * Please Enter Date of Issue )";  
			document.getElementById("DOBformaterror").style.display = 'none';
			document.getElementById("Dateofbirtherrormin").style.display = 'none';
			return false;
			
			
			
		} else {

			var isValidFormat = isValidDate(Dateofbirth);

			if (isValidFormat) {
				document.getElementById("DOBformaterror").style.display = 'none';

				var calculatedAge = getAge(Dateofbirth);
				if (calculatedAge < 14) {
					Dateofbirth = "NA";
					document.getElementById("Dateofbirtherrormin").style.display = 'block';
					document.getElementById("Dateofbirtherror").style.display = 'none';
					return false;

				} else {
					Dateofbirth = calculatedAge;
					document.getElementById("Dateofbirtherror").style.display = 'none';
					document.getElementById("Dateofbirtherrormin").style.display = 'none';
					return true;
				}
			} else {
				document.getElementById("DOBformaterror").style.display = 'block';
				document.getElementById("Dateofbirtherror").style.display = 'none';
				document.getElementById("Dateofbirtherrormin").style.display = 'none';
				return false;

			}
		}

	}

	function validateDOIssue() {
		
	
		var dateofissue = $('#dateofissue').val().trim();
		if (dateofissue == "") {

			document.getElementById("Dateofissueerror").style.display = 'block';
			//"( * Please Enter Date of Issue )";  
			document.getElementById("DOIformaterror").style.display = 'none';
			document.getElementById("Dateofissueerrormin").style.display = 'none';
			return false;

		} else {

			var isValidFormat = isValidDate(dateofissue);

			if (isValidFormat) {
				document.getElementById("DOIformaterror").style.display = 'none';
				//var calculatedAge = getAge(dateofissue);
				var isValid = CheckExp(dateofissue);
				//if (calculatedAge < 16) {
				if (isValid) {

					document.getElementById("Dateofissueerrormin").style.display = 'none';
					document.getElementById("Dateofissueerror").style.display = 'none';
					return true;
				} else {

					document.getElementById("Dateofissueerror").style.display = 'none';
					document.getElementById("Dateofissueerrormin").style.display = 'block';
					return false;

				}
				//status=true;
			} else {

				document.getElementById("DOIformaterror").style.display = 'block';
				document.getElementById("Dateofissueerrormin").style.display = 'none';
				document.getElementById("Dateofissueerror").style.display = 'none';
				return false;
			}
		}

	}

	function validateIdcard() {
		var idcard = $("#idcard").val().trim();
		if (idcard == "") {

			document.getElementById("idcarderror").style.display = 'block';

			return false;

		} else {

			if (idcard.length > 7 && idcard.length < 13) {
				
				/* if (/[^a-zA-Z0-9\-\/]/.test(idcard)) {
					//alert('Input is not alphanumeric');
					document.getElementById("idcarderror").style.display = 'block';
					return false;
				} else { */
					
				
					document.getElementById("idcarderror").style.display = 'none';
					return true;
				//}

			} else {
				idcard = "";
				document.getElementById("idcarderror").style.display = 'block';
				return false;
			}

			//status=true;
		}
	}

	function validatePlaceIssue() {
		var placeofIssuevalue = $('#placeofIssueId').val().trim();

		if (placeofIssuevalue == "") {
			document.getElementById("placeofIssueerror").style.display = 'block';
			//"( * Please Enter your Address )";  
			//placeofIssuevalue = "1";
			
			return false;

		}

		else {

			if (placeofIssuevalue.length > 4 && placeofIssuevalue.length < 16) {
				//alert("valid");
				document.getElementById("placeofIssueerror").style.display = 'none';
				return true;

			} else {
				placeofIssuevalue == "";
				document.getElementById("placeofIssueerror").style.display = 'block';
				return false;
				//alert("unvalid");

			}

			//status=true;
		}
	}

	function validateAddress() {
		var adress = $('#adress').val().trim();

		if (adress == "") {
			document.getElementById("Addresserror").style.display = 'block';
			return false;

		} else {

			if (adress.length > 4 && adress.length < 51) {

				document.getElementById("Addresserror").style.display = 'none';
				return true;

			} else {

				document.getElementById("Addresserror").style.display = 'block';
				return false;

			}

			//status=true;
		}
	}
	
	
	function validateExtension(filename) {
		
		 var extension = filename.replace(/^.*\./, '');
		 
		 
		 if (extension == filename) {
	            extension = '';
	            return false;
	        } else {
	           
	            extension = extension.toLowerCase();
	        }

	      
	        
	        if(extension == 'jpg' ||  extension == 'jpeg'|| extension == 'png')
	        {
	        return true;
	        }
			else
				{
		   return false;
				}
	           
	        
		 
	}
	
	
	
	function validateCustPortrait()
	{
	
		var Customer_Portrait = document.getElementById("Customer_Portrait").getAttribute('src');
		if (Customer_Portrait == "") {
			document.getElementById("CustomerPortraitError").style.display = 'block';
			
			document.getElementById("CustPortraitExtError").style.display = 'none';
			document.getElementById("CustomerPortraitsizeError").style.display = 'none';
			return false;

		} else {
			
			
			
			 var filename =  $("[name = customFile]").val();//   $("#Customer_Portrait").val();
			

			var validext = validateExtension(filename);
			 
			//alert(validext);
			
			
			if(validext)
				{
				
				document.getElementById("CustPortraitExtError").style.display = 'none';
			 
			var base64String = Customer_Portrait;

			var stringLength = base64String.length
					- 'data:image/png;base64,'.length;
			//var stringLength = base64String.length - 22;

			var sizeInBytes = 4 * Math.ceil((stringLength / 3)) * 0.5624896334383812;
			var sizeInKb = sizeInBytes / 1024;
			if (sizeInKb <= 2048) {
				document.getElementById("CustomerPortraitError").style.display = 'none';
				document.getElementById("CustomerPortraitsizeError").style.display = 'none';
				return true;

			} else {

				document.getElementById("CustomerPortraitError").style.display = 'none';
				document.getElementById("CustomerPortraitsizeError").style.display = 'block';
				return false;

			}
			//alert(sizeInKb);

			//status=true;
			
			
				}
			else
				{
				
				document.getElementById("CustPortraitExtError").style.display = 'block';
				document.getElementById("CustomerPortraitError").style.display = 'none';
				document.getElementById("CustomerPortraitsizeError").style.display = 'none';
				
				$("[name = customFile]").val('')
				
				return false;
				}
			
		}

	}
	
	
	
	function validateIDfront()
	{
		
		var ID_Front = document.getElementById("ID_Front").getAttribute('src');
	
	
		if (ID_Front == "") {
			document.getElementById("IDCardFrontError").style.display = 'block';
			
			document.getElementById("IDFrontExtError").style.display = 'none';
			
			document.getElementById("IDCardFrontSizeError").style.display = 'none';
			
			return false;

		} else {
			
			 var filename =  $("[name = imageFront]").val();//   $("#ID_Front").val();
				

				var validext = validateExtension(filename);
				 
				if(validext)
				{
				
				document.getElementById("IDFrontExtError").style.display = 'none';
				
			var base64String = ID_Front;

			var stringLength = base64String.length
					- 'data:image/png;base64,'.length;

			var sizeInBytes = 4 * Math.ceil((stringLength / 3)) * 0.5624896334383812;
			var sizeInKb = sizeInBytes / 1024;
			if (sizeInKb <= 2048) {
				document.getElementById("IDCardFrontError").style.display = 'none';
				document.getElementById("IDCardFrontSizeError").style.display = 'none';
				return true;

			} else {

				document.getElementById("IDCardFrontError").style.display = 'none';
				document.getElementById("IDCardFrontSizeError").style.display = 'block';
				return false;

			}
			//status=true;
				}
				else
					{
					
					document.getElementById("IDFrontExtError").style.display = 'block';
					document.getElementById("IDCardFrontError").style.display = 'none';
					document.getElementById("IDCardFrontSizeError").style.display = 'none';
					$("[name = imageFront]").val('')
					return false;
					}
		}

	}
	
	
	
	function validateIDback()
	{
		var ID_back = document.getElementById("ID_back").getAttribute('src');
		if (ID_back == "") {
		       //document.getElementById("IDCardBackError").style.display = 'block';
		       document.getElementById("IDBackExtError").style.display = 'none';
				document.getElementById("IDCardBackError").style.display = 'none';
				document.getElementById("IDCardBackSizeError").style.display = 'none';
		       
		       //"( * Please Upload 1st side of ID card )"; 
		        
		       return true;
		} else {
			
			 var filename = $("[name = imageBack]").val();//   $("#ID_back").val();
				

				var validext = validateExtension(filename);
				 
				if(validext)
				{

					document.getElementById("IDBackExtError").style.display = 'none';
					var base64String = ID_back;

		       var stringLength = base64String.length
		                    - 'data:image/png;base64,'.length;

		       var sizeInBytes = 4 * Math.ceil((stringLength / 3)) * 0.5624896334383812;
		       var sizeInKb = sizeInBytes / 1024;
		       if (sizeInKb <= 2048) {
		              document.getElementById("IDCardBackError").style.display = 'none';
		             document.getElementById("IDCardBackSizeError").style.display = 'none';
		             return true;
		       } else {
		             ID_back = "";
		             document.getElementById("IDCardBackError").style.display = 'none';
		             document.getElementById("IDCardBackSizeError").style.display = 'block';
		             return false;
		       }
		       //document.getElementById("IDCardBackError").style.display= 'none';  
		       //status=true;
				}
				else
				{
				
				document.getElementById("IDBackExtError").style.display = 'block';
				document.getElementById("IDCardBackError").style.display = 'none';
				document.getElementById("IDCardBackSizeError").style.display = 'none';
				$("[name = imageBack]").val('')
				return false;
				}
		} 
	}
	
	
</script>

</html>



