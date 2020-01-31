<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">

	<link rel="icon" href="${pageContext.request.contextPath}/static/assets/image/favicon.ico">
	<link rel="apple-touch-icon" href="${pageContext.request.contextPath}/static/assets/image/apple-touch-icon.png">

	<title>My Vietnamobile - Profile</title>
	<meta name="description" content="#">
	<meta name="keywords" content="#">
	<meta name="author" content="Vietnamobile">

	<!-- Stylesheets -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/assets/style/bootstrap.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/assets/style/jquery.smartmenus.bootstrap.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/assets/style/material-kit.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/assets/style/vietnamobile.css?id=1">
 <link rel="stylesheet" href="${pageContext.request.contextPath}/static/assets/style/customize.css">
	<!-- Typefaces -->
	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
	<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
	
	
	<style type="text/css">
	.popup-body label {
    font-weight: 600;
    font-size: 18px;
    letter-spacing: 0.09px;
    color: #ff6e01;
    margin-bottom: 5px; 
    }
	
.form-group .form-control{margin-bottom:0!important;}

.form-group, .form-group .form-control {
    float: none;
    padding: 0;
    border: 0;
    border-radius: 0;
    background-image: linear-gradient(#f58233, #f58233), linear-gradient(#D2D2D2, #D2D2D2);
    background-size: 0 2px, 100% 1px;
    background-repeat: no-repeat;
    background-position: center bottom, center calc(100% - 1px);
    background-color: transparent;
    transition: background 0s ease-out;
    box-shadow: none;
    margin:0 auto;
}

.input-group .input-group-addon {
  padding: 0px 8px 0px;
}

	</style>
</head>

<body>

<tiles:insertAttribute name="header"/>

<div class="wrapper">

<!-- Popup  -->
<div class="col-sm-3 popup switchpopup" style="display: none; background:#ffffff!important;">
        <div class="close">
            <a href="#" title="close" style="color:#757575!important;" id="switchclose" ><i class="fa fa-close"></i></a>
        </div>
 
        <div class="popup-body">
        <label><spring:message code="label.EnterYourPassword" text="Enter Your Password"/></label>
           <div class="form-group col-sm-10">
									
									<br clear="all">
									<div class="input-group">
										<span class="input-group-addon">
											<img src="${pageContext.request.contextPath}/static/assets/image/form-icon-lock.png">
										</span>
										<input class="form-control" type="password" id="passwordmsisdn" name="passwordmsisdn" autocomplete="off" placeholder="<spring:message code="label.Password" text="Password"/>"  style="background-image:none!important;">
										
										
									</div>
									
								<span class="material-input"></span></div>
								<span id="statusResponseNotOk" style="display: none"><spring:message code="label.Notupdatesecurity" text="Not Updated Try Again"/></span>
								<span id="statusResponseMismatch" style="display: none"><spring:message code="label.passwordMismatch" text="Password Mismatch"/></span>
        </div>
 
        <form>
            <button id="historySecurityIdSubmit" type="button" class="btn btn-default proceed" ><spring:message code="label.Submit" text="Submit"/></button>
            
        </form>
    </div>


	<!-- Header -->
	<div class="header-general">
		<div class="container">
			<div class="col-sm-11 col-sm-offset-1">
				<h1 class="no-breadcrumb"><spring:message code="label.TopMenu.Profile" text="Profile"/></h1>
			</div>
		</div>
	</div>
	
	<!-- Section: User Profile -->
	<div class="col-sm-12" id="userProfile">
		<div class="container">
			<img src="${userProfile.avatar}" alt="Avatar" class="img-responsive img-rounded img-raised"> 
			<h2>${userProfile.details.fullName}</h2>
		</div>
	</div>

	<!-- Section: User Options -->
	<div class="col-sm-12" id="userOptions">
		<div class="col-sm-8 col-sm-offset-2">
			<div class="card userOptionsCard">
				<div class="userOptions-icon">
					<i class="material-icons">sim_card</i>
				</div>
				<div class="userOptions-title">
					<h6><spring:message code="label.Profile.MyNumber" text="My Number"/></h6>
				</div>
				<div class="userOptions-body">
					<p>${userProfile.msisdn}</p>
				</div>
			</div>
		</div>
		<div class="col-sm-8 col-sm-offset-2">
			<div class="card userOptionsCard">
				<div class="userOptions-icon">
					<a href="${pageContext.request.contextPath}/secure/information"><i class="material-icons">person</i></a>
				</div>
				<div class="userOptions-title">
					<h6><a href="${pageContext.request.contextPath}/secure/information" style="color: #4A4A4A; text-decoration: none;"><spring:message code="label.CustomerInformation" text="Customer Information"/></a></h6>
				</div>
				<div class="userOptions-body">
					<a href="${pageContext.request.contextPath}/secure/information">
						<i class="material-icons">navigate_next</i>
					</a>
				</div>
			</div>
		</div>
		
		<div class="col-sm-8 col-sm-offset-2">
			<div class="card userOptionsCard">
				<div class="userOptions-icon">
					<i class="material-icons">account_balance_wallet</i>
				</div>
				<div class="userOptions-title">
					<h6><spring:message code="label.Profile.RemainingBalance" text="Remaining Balance"/></h6>
				</div>
				<div class="userOptions-body">
					<p><fmt:formatNumber value="${currentBalance.coreBalance.availableValue}" pattern="#,##0"/>đ</p>
				</div>
			</div>
		</div>
		<!-- ${currentBalance.coreBalance.expiryDate} -->
		<c:if test="${currentBalance.coreBalance.validityPeriod gt 0}">
		<div class="col-sm-8 col-sm-offset-2">
			<div class="card userOptionsCard">
				<div class="userOptions-icon">
					<i class="material-icons">timer_off</i>
				</div>
				<div class="userOptions-title">
					<h6><spring:message code="label.Profile.ExpiredDate" text="Expired Date"/></h6>
				</div>
				<div class="userOptions-body">
					<p><fmt:formatDate value="${currentBalance.coreBalance.expiryDate}" pattern="dd/MM/yyyy"/></p>
				</div>
			</div>
		</div>
		</c:if>
		<div class="col-sm-8 col-sm-offset-2">
			<div class="card userOptionsCard">
				<div class="userOptions-icon">
					<a href="${pageContext.request.contextPath}/secure/mysubscriptions"><i class="material-icons">date_range</i></a>
				</div>
				<div class="userOptions-title">
					<h6><a href="${pageContext.request.contextPath}/secure/mysubscriptions" style="color: #4A4A4A; text-decoration: none;"><spring:message code="label.Profile.Subscriptions" text="Subscriptions"/></a></h6>
				</div>
				<div class="userOptions-body">
					<a href="${pageContext.request.contextPath}/secure/mysubscriptions">
						<p>${subscriptionCount}</p>
						<i class="material-icons">navigate_next</i>
					</a>
				</div>
			</div>
		</div>
		<div class="col-sm-8 col-sm-offset-2">
			<div class="card userOptionsCard">
				<div class="userOptions-icon" >				
					 <a href="${pageContext.request.contextPath}/secure/topuphistory"><i class="material-icons">rss_feed</i></a> 
				</div>
				<div class="userOptions-title" >				
					 <h6><a href="${pageContext.request.contextPath}/secure/topuphistory" style="color: #4A4A4A; text-decoration: none;"><spring:message code="label.Profile.TopupHistory" text="Topup History"/></a></h6>
				</div>
				<div class="userOptions-body">		
				
					 <a href="${pageContext.request.contextPath}/secure/topuphistory">
						<i class="material-icons">navigate_next</i>
					</a>
					
				</div>
			</div>
		</div>
		
		<div class="col-sm-8 col-sm-offset-2">
			<div class="card userOptionsCard">
				<div class="userOptions-icon" id="topuphistoryIcon">
				<i class="material-icons">rss_feed</i>
					<%-- <a href="${pageContext.request.contextPath}/secure/topuphistory"><i class="material-icons">rss_feed</i></a> --%>
				</div>
				<div class="userOptions-title" id="topuphistoryTitle">
				<h6><spring:message code="label.Profile.History" text="History"/></h6> 
					<%-- <h6><a href="${pageContext.request.contextPath}/secure/topuphistory" style="color: #4A4A4A; text-decoration: none;"><spring:message code="label.Profile.TopupHistory" text="Topup History"/></a></h6> --%>
				</div>
				<div class="userOptions-body">
				
				<!-- <input type="checkbox" id="historySecurityId" /> -->
					<%-- <a href="${pageContext.request.contextPath}/secure/topuphistory">
						<i class="material-icons">navigate_next</i>
					</a> --%>
					<div class="togglebutton switchbtn desktop" id="switchopen" style="display: none">
							<label>
								<input type="checkbox" ><span class="toggle">OFF<span>ON</span></span>
							</label>
						</div>
					
					<div class="togglebutton switchbtn desktop" id="switchopenChecked" style="display: none">
							<label>
								<input type="checkbox" checked="checked"><span class="toggle">OFF<span>ON</span></span>
							</label>
						</div>
						
						<input type="hidden" id="currentStatus" name="currentStatus" value="0">
						<input type="hidden" id="popupStatus" name="popupStatus" value="0">
				</div>
			</div>
		</div>
		
		
		
		
		
		<div class="col-sm-8 col-sm-offset-2">
			<div class="card userOptionsCard">
				<div class="userOptions-icon">
					<a href="${pageContext.request.contextPath}/secure/changepwd"><i class="material-icons">vpn_key</i></a>
				</div>
				<div class="userOptions-title">
					<h6><a href="${pageContext.request.contextPath}/secure/changepwd" style="color: #4A4A4A; text-decoration: none;"><spring:message code="label.Profile.ChangePassword" text="Change Password"/></a></h6>
				</div>
				<div class="userOptions-body">
					<a href="${pageContext.request.contextPath}/secure/changepwd">
						<i class="material-icons">navigate_next</i>
					</a>
				</div>
			</div>
		</div>
	</div>
 <div class="col-sm-4 popup" id="popupDisplayalreadyexist" style="display: none;">
	<div class="close"><a href="#" title="close"> <a href="${pageContext.request.contextPath}/secure/profile"> </a></div>
    	
        <div class="popup-body">
        	<h1><spring:message code="label.CustomerInformation" text="CustomerInformation"/></h1>
            <h4><spring:message code="label.CanotUpdated" text="Update Customer Information"/></h4>
        </div>
         
       <a href="${pageContext.request.contextPath}/secure/profile"> <button type="button" class="btn btn-default proceed" ><spring:message code="label.OK" text="OK"/></button>
        <div class="togglebutton switchbtn desktop" id="switchopenChecked1" style="display: none">
							<label>
								<input type="checkbox" id="checkClickevent"><span class="toggle">OFF<span>ON</span></span>
							</label>
						</div>
    </div>
    
    <!-- popup for mic -->
	<!-- Divider -->
	<div class="sectionDivider col-sm-12"></div>

	<!-- Footer -->
	<tiles:insertAttribute name="footer"/>

</div> <!-- .wrapper -->

<!-- Main Content: End -->

</body>

<!--   Core Script Files   -->
<script src="${pageContext.request.contextPath}/static/assets/script/jquery.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/static/assets/script/bootstrap.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/static/assets/script/material.min.js"></script>
<script src="${pageContext.request.contextPath}/static/assets/script/modified-material.js"></script>
<script src="${pageContext.request.contextPath}/static/assets/script/dashboard.js"></script>

<!--  Plugins -->
<script src="${pageContext.request.contextPath}/static/assets/script/jquery.smartmenus.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/static/assets/script/jquery.smartmenus.bootstrap.js" type="text/javascript"></script>

<!--  Control for Material Kit -->
<script src="${pageContext.request.contextPath}/static/assets/script/material-kit.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/static/assets/script/langswitcher.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/static/assets/script/bootstrap-dialog.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/static/assets/script/app.js" type="text/javascript"></script>
<script type="text/javascript">
$(document).ready(function() {

	$('body').on('hidden.bs.modal', '.modal', function () {
		  $(this).removeData('bs.modal');
	});
	  
	  var micstatus = "${mic_statusprofile}";

	 if(micstatus==2)
     { 
		// alert("hello");
    	// document.getElementById('popupDisplay').style.display = "block";
		 $('#popupDisplayalreadyexist').show();
    }  
});
</script>

<script type="text/javascript">


$(document).ready(function() {   
    
	var myVar = "${smsCallHistoryStatus}";
	var currentStatus = $('#currentStatus').val();
	$("#popupStatus").val("0");
	if(myVar =="0")
	{
		$('#switchopenChecked').show();
		$('#switchopen').hide();
		currentStatus="1";
	}
	else
	{
		$('#switchopenChecked').hide();
		$('#switchopen').show();
		currentStatus="0";
	}
    $('#historySecurityIdSubmit').click(function(e) {
    	e.preventDefault();	   	
        
    	    /*
    	    * check which div is visible 
    	    */
    	    if($("#switchopen").is(':visible'))
    	    	{
    	    	  console.log(" switchopen ");
    	    	  if($("#switchopen").find("input").prop("checked"))
    	    		  {
    	    		  currentStatus="0";
    	    		  }
    	    	  else
    	    		  {
    	    		  currentStatus="1";
    	    		  }
    	    	}
    	    if($("#switchopenChecked").is(':visible'))
	    	{
	    	  console.log(" switchopenChecked ");
	    	  if($("#switchopenChecked").find("input").prop("checked"))
	    		  {
	    		  currentStatus="0";
	    		  }
	    	  else
	    		  {
	    		  currentStatus="1";
	    		  }
	    	}
        	var returnVal = document.getElementById("passwordmsisdn").value;
        	
            if(returnVal==null || returnVal=="")
           	{
           	console.log("Cancel");           	
           	}
            else
           	{ 
            $.post('${pageContext.request.contextPath}/secure/getPasswordforHistory?${_csrf.parameterName}=${_csrf.token}',   // url
     			   { myData: returnVal, currentStatus: currentStatus }, // data to be submit
     			   function(data, status, jqXHR) {// success callback
     						console.log("adada" +data)
     						console.log("status  ==" +status)
     						if(data== "OK")
   							{   
     							//window.location.href="${pageContext.request.contextPath}/secure/history";  							
     							//location.reload();
     							$(".switchpopup").hide();
     							var popupStatus = $('#popupStatus').val();
     								if(popupStatus=="0")
     								{
     									location.reload();
     								}
     								else
     								{
     									window.location.href="${pageContext.request.contextPath}/secure/history";
     								}
   							}
     						else if(data== "NOTOK")
   							{
     							$('#statusResponseNotOk').show();
     							$('#statusResponseMismatch').hide();
     							var myVar2 = "${smsCallHistoryStatus}";
     							//alert(myVar);
     							if(myVar2 =="1")
     							{
     								$('#switchopenChecked').show();
     								$('#switchopen').hide();
     							}
     							else
     							{
     								$('#switchopenChecked').hide();
     								$('#switchopen').show();
     							}
     							$(".switchpopup").show();
   							}
     						else{
     							$('#statusResponseNotOk').hide();
     							$('#statusResponseMismatch').show();
     							var myVar1 = "${smsCallHistoryStatus}";
     							//alert(myVar);
     							if(myVar1 =="1")
     							{
     								$('#switchopenChecked').show();
     								$('#switchopen').hide();
     							}
     							else
     							{
     								$('#switchopenChecked').hide();
     								$('#switchopen').show();
     							}
     							$(".switchpopup").show();
     						}
     				});
     			
           	console.log(returnVal);
           	
           	
           	}
        	
           /*  var returnVal = confirm("Are you sure?");
            $(this).prop("checked", returnVal); */
        
                
    });
});
</script>

<script type="text/javascript">

$("#switchopen").click(function(){	
	
	$("#popupStatus").val("0");
	$(".switchpopup").show();	
	
});

$("#switchopenChecked").click(function(){	
	$("#popupStatus").val("0");
	$(".switchpopup").show();
});
$("#topuphistoryIcon").click(function(){	
	
	var smsCallHistoryStatus = "${smsCallHistoryStatus}";	
	if(smsCallHistoryStatus =="0")
	{
		$("#popupStatus").val("1");
		$(".switchpopup").show();
	}
	else
	{
		
		window.location.href="${pageContext.request.contextPath}/secure/history";
	} 
	
	
	
});
$("#topuphistoryTitle").click(function(){	
	
	var smsCallHistoryStatus = "${smsCallHistoryStatus}";	
	if(smsCallHistoryStatus =="0")
	{
		$("#popupStatus").val("1");
		$(".switchpopup").show();
	}
	else
	{		
		window.location.href="${pageContext.request.contextPath}/secure/history";
	} 
});
$("#switchclose").click(function(e){
	//e.preventDefault();	
	location.reload();
	/* var myVar222 = "${smsCallHistoryStatus}";
	alert(myVar222);
	if(myVar222 =="0")
	{
		$('#switchopenChecked').show();
		$('#switchopen').hide();
		alert(" myVar1 "  + myVar222);
	}
	else
	{
		
		$('#switchopenChecked').hide();
		$('#switchopen').show();
		
		alert(" myVar0 "  + myVar222);
	} */
	$(".switchpopup").hide();
});
</script>
</html>