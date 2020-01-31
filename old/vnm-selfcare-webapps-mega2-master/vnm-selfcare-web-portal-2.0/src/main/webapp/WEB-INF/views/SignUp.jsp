<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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

	<title>Vietnamobile - Sign Up</title>
	<meta name="description" content="Vietnamobile Selfcare Web Portal">
	<meta name="keywords" content="vietnamobile,selfcare">
	<meta name="author" content="Vietnamobile">

	<!-- Stylesheets -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/assets/style/bootstrap.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/assets/style/vietnamobile-login.css">

	<!-- Typefaces -->
	<link href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700" rel="stylesheet">
	<link href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" rel="stylesheet">

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/assets/script/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/static/assets/script/modified-material.js"></script>

	<!--  Control for Material Kit -->
	<script src="${pageContext.request.contextPath}/static/assets/script/material-kit.js" type="text/javascript"></script>
	
	<style>
		.has-error{
			color: #ff1a1a; 
			font-size: 12px; 
			margin-left: 10px;
		}
	</style>
</head>

<body style="overflow-x: hidden;">
	<div class="wrapper">
		<div class="main">
			<div class="row">
				<div class="col-xs-12 col-sm-6 bg-signin-left" > 
					<div class="logo col-sm-12">
						<a href="${pageContext.request.contextPath}/"><img src="${pageContext.request.contextPath}/static/assets/image/logo.png" alt="Vietnamobile Logo"></a>
					</div>

					<div class="sign-form col-md-8 col-md-offset-2">
						<p><spring:message code="label.Frontpage.RegisterAccount" text="REGISTER FOR AN ACCOUNT"/></p>
						<form:form id="signup-form" method="POST" modelAttribute="signUpForm" action="">
							<div class="card">
								<div class="form-group col-sm-12">
									<div class="${status.error ? 'has-error' : ''} form-group">
										<label for="phoneNumber"><spring:message code="label.PhoneNumber" text="Phone Number"/></label>
										<div class="input-group">
											<span class="input-group-addon">
												<img src="${pageContext.request.contextPath}/static/assets/image/form-icon-phone.png">
											</span>
											<c:set var="phoneNumberPlaceHolder"><spring:message code='label.PhoneNumber' text='Phone Number'/></c:set>
											<form:input path="phoneNumber" class="form-control" placeholder="${phoneNumberPlaceHolder}"/>
										</div>
									</div>
								</div>
								<form:errors path="phoneNumber" cssClass="has-error"/>
							</div>
							<div class="form-title" style ="padding-left: 20px;">
								<h1 style= "font-size: 10px; color: white; font-style: italic;">*) <spring:message code='label.WillReceiveOTP' text='You will receive an SMS with an OTP'/></h1>
							</div>
							<!-- this div is to show app message -->
							<c:if test="${!empty message}">
								<div id="appMsgContainer" class="alert alert-danger alert-block">
									<button type="button" class="close" data-dismiss="alert" aria-label="Close">
										<i class="fa fa-times" aria-hidden="true"></i>
									</button>
									<span id="appMsg">${message}</span>
								</div> 							
                            </c:if>	
                             <c:if test="${empty is_done or is_done ne 1}">
							<div class="signButton">
								<div class="row">
									<div class="col-sm-6">
										<button id="btnNext" class="btn btn-primary btn-round"><spring:message code="label.Next" text="Next"/></button>
									</div>
									<div class="col-sm-6">
										<button id="btnCancelReg" class="btn btn-secondary btn-round"><spring:message code="label.Cancel" text="Cancel"/></button>
									</div>
								</div>
							</div>
							</c:if>
						</form:form>	
					</div>					
					<input type="hidden" id="currentLang" value="${pageContext.response.locale.language}"/>
					<div class="language col-sm-12">
						<div class="togglebutton langOpt">
							<label>
								<input type="checkbox" class="langSwitch" id="langSwitcher">
							</label>
						</div>
					</div> <!-- .language -->
					<footer class="col-sm-12">
						<ul class="social">
							<li><a href="https://www.facebook.com/VietnamobileVNM" target="_blank"><span class="fa fa-facebook"></span></a></li>
							<li><a href="https://www.youtube.com/user/vietnamobileofficial" target="_blank"><span class="fa fa-youtube-play"></span></a></li>
							<!-- <li><a href="#"><span class="fa fa-instagram"></span></a></li>  -->
						</ul>
						<p>Copyright 2017 Vietnamobile. All right reserved.</p>
					</footer>					
				</div>
				<!-- end of left section -->
				<div class="col-xs-12 col-sm-6 bg-signin-right">  
					<tiles:insertAttribute name="right-content"/>
				</div>
			</div>
		</div>
	</div>
</body>
<script>
	$(document).ready(function() {

		var currentLang = $("#currentLang").val();
		if (currentLang == "en") {
			$("#langSwitcher").prop("checked", true);
		} else {
			$("#langSwitcher").prop("checked", false);
		}

		$(".langSwitch").change(function(e) {
			var ischecked = $(this).is(":checked");
			var lang = "";
			if (ischecked) {
				lang = "en";
			} else {
				lang = "vi";
			}
			$("#signup-form").attr("action", "${pageContext.request.contextPath}/signup/next?lang=" + lang);
			$("#signup-form").submit();
		});
		
		$("input:text").focus(function() { $(this).select(); } );

		$(window).keydown(function(event){
		    if(event.keyCode == 13) {
		      event.preventDefault();
		      return false;
		    }
		});

		$("#btnNext").click(function(e){
			e.preventDefault();
			$("#signup-form").attr("action", "${pageContext.request.contextPath}/signup/next");
			$("#signup-form").submit();
		});

		$("#btnCancelReg").click(function(e){
			e.preventDefault();
			location.replace("${pageContext.request.contextPath}/");
		});

	});
</script>
</html>
					