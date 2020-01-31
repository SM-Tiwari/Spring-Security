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

	<title>Vietnamobile - Sign In</title>
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
</head>

<body style="overflow-x: hidden;">
	<div class="wrapper">
		<div class="main">
			<div class="row">
				<div class="col-xs-12 col-sm-6 bg-signin-left" > 
					<div class="logo col-sm-12">
						<a href="${pageContext.request.contextPath}/"><img src="${pageContext.request.contextPath}/static/assets/image/logo.png" alt="Vietnamobile Logo"></a>
					</div>
					<!-- left content here -->
					<div class="sign-form col-md-8 col-md-offset-2">
						<form:form method ="post" name="loginForm" id="loginForm" onsubmit="return ValidationEvent()" action="${pageContext.request.contextPath}/login?auth">
							<p><spring:message code="label.SignInToReviewAccount" text="Sign in to review your account"/></p>
							<div class="card">
								<div class="form-group col-sm-12">
									<label for="phoneNumber"><spring:message code="label.PhoneNumber" text="Phone Number"/></label>
									<div class="input-group">
										<span class="input-group-addon">
											<img src="${pageContext.request.contextPath}/static/assets/image/form-icon-phone.png">
										</span>
										<input class="form-control" type="text" name="username" id="username" placeholder='<spring:message code="label.PhoneNumber" text="Phone Number"/>'>
									</div>
								</div>
								<div class="form-group col-sm-12">
									<label for="password"><spring:message code="label.Password" text="Password"/></label>
									<div class="input-group">
										<span class="input-group-addon">
											<img src="${pageContext.request.contextPath}/static/assets/image/form-icon-lock.png">
										</span>
										<input class="form-control" type="password" id="password" name="password" autocomplete="off" placeholder='<spring:message code="label.Password" text="Password"/>'>
									</div>
								</div>
							</div>
							<c:if test="${param.error eq 'bad_credentials'}">
								<div id="appMsgContainer" class="alert alert-danger">
									<button type="button" class="close" data-dismiss="alert" aria-label="Close">
										<!--<span aria-hidden="true"><i class="material-icons">clear</i></span>-->
										<i class="fa fa-times" aria-hidden="true"></i>
									</button>
									<spring:message code="Message.LoginFailure" text="Login failed, please enter the correct phone number and password." />
								</div>
							</c:if>
							
							<div style="margin-bottm:10px;">
							
							<div class="pull-left">
							<input type="checkbox" name="remember-me-param" id="rememberMe" style="vertical-align:super; margin:0!important;"> <span style="color:#ffffff; font-size:14px; vertical-align:top;"><spring:message code="label.RememberMe" text="Remember Me"/></span>
							</div>
							
							<div class="pull-right">
								<p><a href="${pageContext.request.contextPath}/forgotpwd"><spring:message code="label.ForgotPassword" text="Forgot your password?"/></a></p>
							</div>
							
							</div>
							
							<br clear="all">
							
							
							<div class="signButton">
								<div class="row">
									<div class="col-xs-6">
										<button type="button" id="btnRegister" class="btn btn-secondary btn-round" tabindex="2"><spring:message code="label.Register" text="Register"/></button>
									</div>
									<div class="col-xs-6">
										<button type="submit" id="btnLogin" class="btn btn-primary btn-round" tabindex="1"><spring:message code="label.Login" text="ÄÄng nháº­p"/></button>
									</div>
									<!-- <spring:message code="label.Login" text="ÄÄng nháº­p"/> -->
                                    <div class="clearfix"></div>
                                    <div class="col-xs-offset-3 col-xs-6">
                                        <button type="button" class="btn btn-additional btn-round" id="btnGuestLogin"><spring:message code="label.GuestLogin" text="Guest Login"/></button>
                                    </div>
								</div>
							</div>
						</form:form>
					</div>
					<input type="hidden" id="currentLang" value="${pageContext.response.locale.language}"/>
					<div class="language col-sm-12">
						<div class="togglebutton langOpt">
							<label>
								<input type="checkbox" class="langSwitch" id="langSwitcher1">
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
				<!-- <div class="col-xs-12 col-sm-6 bg-signin-right"> -->
				<div class="col-xs-6 bg-signin-right">  
					<tiles:insertAttribute name="right-content"/>
				</div>
			</div>
		</div>
	</div>
</body>
<script src="${pageContext.request.contextPath}/static/assets/script/langswitcher.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/static/assets/script/conversion.js" type="text/javascript"></script>


<script type="text/javascript">
$("#btnRegister").click(function(e){
	e.preventDefault();
	location.replace("${pageContext.request.contextPath}/signup");
});

$("#btnCancelReg").click(function(e){
	e.preventDefault();
	location.replace("${pageContext.request.contextPath}/");
});

$("#btnGuestLogin").click(function(e){
	e.preventDefault();
	location.replace('${pageContext.request.contextPath}/shop/voice_n_sms');
});
</script>
<script>


	function ValidationEvent(){
		//e.preventDefault();
		//alert("first " );
		if($("#rememberMe").prop('checked') == true){
		    //do something
			 var first = convert.encode($('#username').val());
			  var second = convert.encode($('#password').val());
			  
			  //alert("first " + first +"  second   " + second);
			  document.cookie="first=" + first +"#"+second;
		}
		else {
		    console.log('not checked');
		    document.cookie = "first= ; expires = Thu, 01 Jan 1970 00:00:00 GMT"
		  }
		return true;
	}

	
	
	$(document).ready(function() {
		
		var ca = getCookie("first");
		//alert(" ca  " + ca);
		if(ca !="")
		{
		var username = ca.split("#");
		var userN = username[0];
		var passN = username[1];
		//alert(" username  " + username);
		$('#username').val(convert.decode(userN));
		$('#password').val(convert.decode(passN));
		document.getElementById("rememberMe").checked = true;
		
		}
		
		$("input:text").focus(function() { $(this).select(); } );
		
		$("#password").keydown(function(event){
		    if(event.keyCode == 13) {
		    		$("#loginForm").submit();
		    }			
		});
		
		/* $(window).keydown(function(event){
		    if(event.keyCode == 13) {
		      event.preventDefault();
		      return false;
		    }
		}); */
		
		
		  
		
		
		
		
	});
	
	const checkbox = document.getElementById('rememberMe');

	checkbox.addEventListener('change', (event) => {
	  if (event.target.checked) {		  
		  //alert("Hello");
		  var first = convert.encode($('#username').val());
		  var second = convert.encode($('#password').val());
		  
		  //alert("first " + first +"  second   " + second);
		  document.cookie="first=" + first +"#"+second;
		  
	  } else {
	    //console.log('not checked');
	    document.cookie = "first= ; expires = Thu, 01 Jan 1970 00:00:00 GMT"
	  }
	});  
	
	
	function getCookie(name) {
	  var value = "; " + document.cookie;
	  var parts = value.split(name + "=");
	  if (parts.length == 2) return parts.pop().split(";").shift();
	}
	
	
</script>
</html>
