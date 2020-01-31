<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">

	<link rel="icon" href="${pageContext.request.contextPath}/static/assets/image/favicon.ico">
	<link rel="apple-touch-icon" href="${pageContext.request.contextPath}/static/assets/image/apple-touch-icon.png">

	<title>My Vietnamobile</title>
	<meta name="description" content="#">
	<meta name="keywords" content="#">
	<meta name="author" content="Vietnamobile">

	<!-- Stylesheets -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/assets/style/bootstrap.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/assets/style/material-kit.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/assets/style/vietnamobile.css">

	<!-- Typefaces -->
	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
	<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
	
</head>

<body>

<div class="wrapper" id="patnolpat">
	<div class="header-dashboard">
		<div class="container">
			<div class="col-sm-6 col-sm-offset-3 text-center">
				<img src="${pageContext.request.contextPath}/static/assets/image/logo.png" alt="Vietnamobile Logo">
			</div>
		</div>
	</div>
	<div class="col-sm-6 col-sm-offset-3">
		<div class="card card-raised text-center" id="patnolpatContent">
			<h3><spring:message code="Message.TransactionFailed" text="Your transaction could not be processed. Please try again."/></h3>
		</div>
		<div class="row">
			<div class="col-sm-4 col-sm-offset-4 text-center">
				<button id="btnOK" onclick="window.close();" class="btn btn-primary btn-round">OK</button>
			</div>
		</div>
	</div>
	<footer class="col-sm-12 text-center">
		<ul>
			<li><a href="https://www.facebook.com/VietnamobileVNM" target="_blank"><span class="fa fa-facebook"></span></a></li>
			<li><a href="https://www.youtube.com/user/vietnamobileofficial" target="_blank"><span class="fa fa-youtube-play"></span></a></li>
		</ul>
		<p>Copyright 2017 Vietnamobile. All right reserved.</p>
	</footer>
</div>
</body>
<script>
	setTimeout(function() {
    		window.close();
	}, 5000);
</script>
</html>