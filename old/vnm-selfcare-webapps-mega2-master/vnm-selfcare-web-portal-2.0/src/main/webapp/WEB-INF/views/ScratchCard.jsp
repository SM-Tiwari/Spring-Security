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

	<title>My Vietnamobile - Scratch Card</title>
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
	</style>
</head>

<body>

	<tiles:insertAttribute name="header"/>

<!-- Main Content -->

<div class="wrapper">

	<!-- Header -->
	<div class="header-general">
		<div class="container">
			<div class="col-sm-11 col-sm-offset-1">
				<ul>
					<li><a href="${pageContext.request.contextPath}/secure/dashboard"><spring:message code="label.TopMenu.Home" text="Home"/></a></li>
					<li><a href="${pageContext.request.contextPath}/secure/vtopup"><spring:message code="label.TopMenu.TopUp" text="Top Up"/></a></li>
					<li><a href="${pageContext.request.contextPath}/secure/vtopup"><spring:message code="label.TopMenu.ScratchCard" text="Scratch Card"/></a></li>
				</ul>
				<h1><spring:message code="label.TopMenu.ScratchCard" text="Scratch Card"/></h1>
			</div>
		</div>
	</div>

	<div class="col-sm-12" id="scratchCardSection">
		<div class="col-sm-8 col-sm-offset-2">
			<div class="card">
				<div id="scratchCardContent">
					<form:form id="topupFrm" method="POST" modelAttribute="voucherTopUp">
						<input type="hidden" id="mynumber" value="${userProfile.msisdn}"/>
						<div class="form-group">
							<label><spring:message code="label.TopUp.PinCode" text="Enter PIN Code"/></label>
							<form:input path="code" class="pin-code form-control" id="pincode"/>
						</div>
						<form:errors path="code" cssClass="has-error help-block"/>
						<div class="form-group">
							<label><spring:message code="label.PhoneNumber" text="Phone Number"/></label>
							<form:input path="msisdn" class="form-control" id="msisdn"/>
						</div>
						<form:errors path="msisdn" cssClass="has-error help-block"/>
						<div class="text-center scratchCardBtn">
							<img src="${pageContext.request.contextPath}/captcha.png" alt="" class="captcha" id="captchaImg" style="-moz-border-radius: 5px;-webkit-border-radius: 5px;border-radius: 5px;" />
							<button class="btnCaptcha btn btn-secondary btn-round hidden-xs" style="font-size: 0.9em;"><spring:message code="label.RefreshCaptcha" text="Refresh Captcha"/></button>
							<button class="btnCaptcha btn btn-secondary btn-round visible-xs" style="font-size: 0.6em;"><spring:message code="label.RefreshCaptcha" text="Refresh Captcha"/></button>
						</div>					
						<div class="form-group">
							<label><spring:message code="label.Captcha" text="Captcha"/></label>
							<form:input path="captcha" id="captcha" class="form-control"/>
						</div>
						<form:errors path="captcha" cssClass="has-error help-block"/>
						<c:if test="${!empty message}">
						<div id="appMsgContainer" class="alert alert-danger">
							<button type="button" class="close" data-dismiss="alert" aria-label="Close">
								<i class="fa fa-times" aria-hidden="true"></i>
							</button>${message}
						</div> 							
						</c:if>		
						<div class="scratchCardBtn">
							<button class="btnSubmit btn btn-primary btn-round hidden-xs" style="font-size: 0.9em;"><spring:message code="label.Submit" text="Submit"/></button>
							<button class="btnSubmit btn btn-primary btn-round visible-xs" style="font-size: 0.6em;"><spring:message code="label.Submit" text="Submit"/></button>
						</div>
						<div class="col-sm-offset-1 col-sm-6 col-xs-offset-1 col-xs-6 scratchCardBtn">
						<!--  
							<button class="btnCaptcha btn btn-secondary btn-round hidden-xs" style="font-size: 0.9em;"><spring:message code="label.RefreshCaptcha" text="Refresh Captcha"/></button>
							<button class="btnCaptcha btn btn-secondary btn-round visible-xs" style="font-size: 0.6em;"><spring:message code="label.RefreshCaptcha" text="Refresh Captcha"/></button>
						-->
						</div>
						<input type="hidden" name="doneFlag" id="doneFlag" value="${is_done}"/>
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
<script src="${pageContext.request.contextPath}/static/assets/script/cleave.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/static/assets/script/app.js" type="text/javascript"></script>
<script>
$(document).ready(function() {

	$("input:text").focus(function() { $(this).select(); } );
	
	new Cleave('.pin-code', {
	    numericOnly: true,
	    delimiter: '-',
	    blocks: [4, 4, 4]
	});
		
	$(".btnCaptcha").click(function(e){
		e.preventDefault();
		$("#captchaImg").attr("src", "${pageContext.request.contextPath}/captcha.png?" + Math.random());
	}); 

	$(".btnSubmit").click(function(e){
		e.preventDefault();

		var action = "${pageContext.request.contextPath}/secure/vtopup/validate";
		$("#topupFrm").attr("action", action);
		
		if (validInputs()){
			if ($("#mynumber").val() != $("#msisdn").val()){
				BootstrapDialog.confirm({
			        title: '',
			        message: '<spring:message code="Message.Topup.Confirmation" text="Are you sure you want to topup for"/> ' + $("#msisdn").val() + '?',
			        type: BootstrapDialog.TYPE_WARNING, 
			        closable: true,
			        draggable: true,
			        btnCancelLabel: '<spring:message code="label.Cancel" text="Cancel"/>',
			        btnCancelClass: 'btn btn-secondary btn-round',
			        btnOKLabel: '<spring:message code="label.OK" text="OK"/>',
			        btnOKClass: 'btn btn-primary btn-round',
			        callback: function(result) {
			            if(result) {
			            		$("#topupFrm").submit();
			            }
			        }
			    });	
			} else {
				$("#topupFrm").submit();
			}
		}
	});
	
	var isdone = $("#doneFlag").val();
	if (isdone == 1){
		BootstrapDialog.alert({
			title: '',
			type: BootstrapDialog.TYPE_INFO,
			btnOKLabel: '<spring:message code="label.OK" text="OK"/>',
			message: '${message}',
			callback: function(){
				location.replace("${pageContext.request.contextPath}/secure/dashboard");
			}
		});
	}
});

function validInputs(){

	var phoneNoRegex = /${phone_regex}/g;
	var pinCodeRegex = /${pincode_regex}/g;

	var phoneValidator = new RegExp(phoneNoRegex);
	var pinValidator = new RegExp(pinCodeRegex);

	if ( !phoneValidator.test($("#msisdn").val()) ){
		BootstrapDialog.alert({
			title: '',
			type: BootstrapDialog.TYPE_INFO,
			btnOKLabel: '<spring:message code="label.OK" text="OK"/>',
			message: '<spring:message code="Message.InvalidPhoneNumber" text="Please enter a valid Vietnamobile number."/>'
		});
		return false;
		
	} else if ( !pinValidator.test($("#pincode").val()) ){
		BootstrapDialog.alert({
			title: '',
			type: BootstrapDialog.TYPE_INFO,
			btnOKLabel: '<spring:message code="label.OK" text="OK"/>',
			message: '<spring:message code="Message.Topup.IncompletePinCode" text="The code you entered is incorrect, please try again."/>'
		});
		return false;
	} 
	return true;
}
</script>
</html>