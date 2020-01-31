<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="utils" uri="utils" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">

	<link rel="icon" href="${pageContext.request.contextPath}/static/assets/image/favicon.ico">
	<link rel="apple-touch-icon" href="${pageContext.request.contextPath}/static/assets/image/apple-touch-icon.png">

	<title>My Vietnamobile - Change Password</title>
	<meta name="description" content="#">
	<meta name="keywords" content="#">
	<meta name="author" content="Vietnamobile">

	<!-- Stylesheets -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/assets/style/bootstrap.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/assets/style/jquery.smartmenus.bootstrap.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/assets/style/material-kit.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/assets/style/vietnamobile.css?id=1">

	<!-- Typefaces -->
	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
	<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
	
    <style type="text/css">
		.alert-box {
			padding: 15px;
		    margin-bottom: 20px;
		    border: 1px solid transparent;
		    border-radius: 4px;  
		}
		
		.success {
		    color: #3c763d;
		    background-color: #dff0d8;
		    border-color: #d6e9c6;
		    display: none;
		}
		
		.failure {
		    color: #a94442;
		    background-color: #f2dede;
		    border-color: #ebccd1;
		    display: none;
		}
		
		.warning {
		    color: #8a6d3b;
		    background-color: #fcf8e3;
		    border-color: #faebcc;
		    display: none;
		}
</style>	
</head>

<body>

<tiles:insertAttribute name="header"/>

<div class="wrapper">

	<!-- Header -->
	<div class="header-general">
		<div class="container">
			<div class="col-sm-11 col-sm-offset-1">
				<ul>
					<li><a href="${pageContext.request.contextPath}/secure/profile"><spring:message code="label.TopMenu.Profile" text="Profile"/></a></li>
					<li><spring:message code="label.TopMenu.ChangePassword" text="Change Password"/></li>
				</ul>
				<h1><spring:message code="label.TopMenu.ChangePassword" text="Change Password"/></h1>
			</div>
		</div>
	</div>

	<div class="col-sm-12" id="changePass">
		<div class="col-sm-8 col-sm-offset-2">
			<div class="card">
				<div id="changePassHeader">
					<div class="wrapper col-sm-10 col-sm-offset-1">
						<img src="${pageContext.request.contextPath}/static/assets/image/otp.png">
						<h6><spring:message code="label.Profile.YouWillReceiveOTP" text="You will receive a OTP code to change your password"/></h6>
					</div>
				</div>
				<div id="changePassContent">
				<form:form id="signup-form" method="POST" modelAttribute="changePasswordForm" action="${pageContext.request.contextPath}/secure/changepwd/confirm">
					<input type="hidden" id="svrMsg" value="${message}"/>
					<input type="hidden" id="is_done" value="${is_done}">
					<div class="form-group">
						<label><spring:message code="label.PhoneNumber" text="Phone Number"/></label>
						<form:input path="phoneNumber" class="form-control" readonly="true"/>
					</div>
					<form:errors path="phoneNumber" cssClass="has-error help-block"/>
					<div class="form-group">
						<label for="otp"><spring:message code="label.OtpCode" text="OTP Code"/></label>
						<c:set var="otpCodePlaceHolder"><spring:message code='label.OtpCode' text='OTP Code'/></c:set>
						<form:input path="otp" class="form-control" placeholder="${otpCodePlaceHolder}"/>
						<button id="btnOtp" class="btn btn-primary btn-round"><spring:message code="label.GetNewOtp" text="Request OTP Code"/></button>
					</div>
					<form:errors path="otp" cssClass="has-error help-block"/>
					<div class="form-group">
						<div id="alertbox" class="alert-box warning"><span id="appMsg">${message}</span></div>
					</div>
					<div class="form-group">
						<label for="newPassword"><spring:message code="label.NewPassword" text="New Password"/></label>
						<form:password path="password" class="form-control" placeholder="*******"/>
					</div>
					<form:errors path="password" cssClass="has-error help-block"/>
					<div class="form-group">
						<label for="confirmNewPassword"><spring:message code="label.ConfirmNewPassword" text="Confirm New Password"/></label>
						<form:password path="confirmPassword" class="form-control" placeholder="*******"/>
					</div>
					<form:errors path="confirmPassword" cssClass="has-error help-block"/>
					<div class="col-xs-6 scratchCardBtn" style="padding-right: 5px;">
						<button id="btnCancel" class="btn btn-secondary btn-round"><spring:message code="label.Cancel" text="Cancel"/></button>
					</div>
					<div class="col-xs-6 scratchCardBtn" style="padding-left: 5px;">
						<button id="btnSave" type="submit" class="btn btn-primary btn-round"><spring:message code="label.Submit" text="Submit"/></button>
					</div>
				</form:form>
				</div>
			</div>
		</div>
	</div>

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

<script>
	$(document).ready(function() {
		$("input:text").focus(function() { $(this).select(); } );
		
		$zopim(function() {
			$zopim.livechat.bubble.hide();
		});

		if ($("#is_done").val() != "1"){
			if ($("#svrMsg").val() != ""){
				$("#alertbox" ).fadeIn( 300 ).delay( 1000 ).fadeOut( 5000 );
				$("#appMsg").html('${message}');
			}
		} else {
	        BootstrapDialog.alert({
	            title: '',
	            message: '<spring:message code="Message.ChangePasswordSuccess" text="Your password has been changed successfully."/>',
	            type: BootstrapDialog.TYPE_WARNING,
	            buttonLabel: '<spring:message code="label.OK" text="OK"/>',
	            callback: function(result) {
	            		//$("#logoutForm").submit();
            			location.replace("${pageContext.request.contextPath}/secure/dashboard");
	            }
	        });			
		}
		
		$("#btnCancel").click(function(e){
			e.preventDefault();
			location.replace("${pageContext.request.contextPath}/secure/profile");
		});
		
		$("#btnOtp").click(function(e){
			e.preventDefault();
			var msisdn = $("#phoneNumber").val();

			$.ajax({
				method: "GET",
				url: "${pageContext.request.contextPath}/getotp/" + msisdn
				
			}).done(function(){
				$("#alertbox" ).fadeIn( 300 ).delay( 1000 ).fadeOut( 3000 );
				$("#appMsg").html('<spring:message code="Message.NewOtpSuccess" text="New OTP has been sent to your number."/>');
				//alert('<spring:message code="Message.OTPSent" text="Your one-time-password has been sent to your number."/>');
				
			}).fail(function(jqXHR, textStatus){
				console.log(textStatus);
			});
		});	
	});
</script>
</html>