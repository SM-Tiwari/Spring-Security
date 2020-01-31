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

	<title>My Vietnamobile - Gamify</title>
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
</head>

<body>

	<tiles:insertAttribute name="header"/>

<div class="wrapper">

	<div class="landingPage">
		<div class="container">

			<!-- Breadcrumb -->
			<div class="col-sm-11 col-sm-offset-1">
				<ul class="mod-breadcrumb">
					<li><a href="${pageContext.request.contextPath}/secure/dashboard"><spring:message code="label.TopMenu.Home" text="Home"/></a></li>
					<li><spring:message code="label.TopMenu.Gamify" text="Gamify"/></li>
				</ul>
			</div>

			<!-- Page Title -->
			<div class="row">
				<div class="col-sm-4 col-sm-offset-1 landingPage-title">
					<h1>My Gamify Monsters</h1>
				</div>
			</div>

			<!-- Page Content -->
			<div class="row landingPage-content">
				<div class="col-sm-4 col-sm-offset-1 landingPage-image">
					<img src="${pageContext.request.contextPath}/static/assets/image/gamify.png">
				</div>
				<div class="col-sm-6 landingPage-body">
					<p>
						Lorem ipsum dolor sit amet, id est sale sententiae, te quo clita deleniti copiosae. In ius etiam feugiat epicuri. Cu vim delectus patrioque, an fabellas dissentiunt pri. Mea reque doming mollis ut, no pri oportere omittantur.
					</p>
					<p>
						Mucius delectus ne sed, dolor scripta minimum mel an. Ad est dicat accusata disputando. Qui ipsum iudicabit eu. Homero ponderum an quo, no cum meis expetendis theophrastus. His omnium eruditi an, tincidunt conclusionemque ei pri.
					</p>
					<h2 style="font-weight: 600;">Connect, have fun in style</h2>
					<h2>Bring you the coolest way to connect to the world around you.</h2>
				</div>
			</div>

			<!-- Call To Action Button -->
			<div class="row">
				<div class="col-sm-4 col-sm-offset-1">
					<a class="fakeBtn" href="#">
						<div class="landingPage-cta">
							<p>Get It Now</p>
						</div>
					</a>
				</div>
			</div>

			<!-- Native App Download Information -->
			<div class="row landingPage-app">
				<div class="col-sm-6 col-md-4 col-md-offset-1">
					<div class="landingPage-appContent">
						<div class="row">
							<div class="col-sm-2 col-sm-offset-1 appContentIcon">
								<i class="fa fa-apple"></i>
							</div>
							<div class="col-sm-9 appContentBody">
								<h6>App Store</h6>
								<p>iPhones, iPad, and iPod touch with iOS 7.0 or later.</p>
								<a href="#">
									<i class="fa fa-caret-square-o-right"></i>Go to App Store
								</a>
							</div>
						</div>
					</div>
				</div> <!-- App Store -->
				<div class="col-sm-6 col-md-5">
					<div class="landingPage-appContent">
						<div class="row">
							<div class="col-sm-2 col-sm-offset-1 appContentIcon">
								<i class="fa fa-android"></i>
							</div>
							<div class="col-sm-9 appContentBody">
								<h6>Google Play</h6>
								<p>Smartphones with Android 2.3 or later</p>
								<a href="#">
									<i class="fa fa-caret-square-o-right"></i>Go to Play Store
								</a>
							</div>
						</div>
					</div>
				</div> <!-- Play Store -->
			</div>

		</div> <!-- .container -->
	</div> <!-- .landingPage -->



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

</html>