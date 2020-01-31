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

	<title>My Vietnamobile - Data Sharing</title>
	<meta name="description" content="#">
	<meta name="keywords" content="#">
	<meta name="author" content="Vietnamobile">

	<!-- Stylesheets -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/assets/style/bootstrap.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/assets/style/jquery.smartmenus.bootstrap.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/assets/style/material-kit.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/assets/style/vietnamobile.css">

	<!-- Typefaces -->
	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
	<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
</head>

<body>

<tiles:insertAttribute name="header"/>

<div class="wrapper">

	<!-- Header -->
	<div class="header-general">
		<div class="container">
			<div class="col-sm-11 col-sm-offset-1">
				<ul>
					<li><a href="${pageContext.request.contextPath}/shop/voice_n_sms"><spring:message code="label.TopMenu.Shop" text="Shop"/></a></li>
					<li><a href="${pageContext.request.contextPath}/shop/group_sharing"><spring:message code="label.TopMenu.GroupSharing" text="Group Sharing"/></a></li>
					<li><a href="${pageContext.request.contextPath}/shop/group_sharing/products/${productGroup.id}"><spring:message code="label.TopMenu.DataSharing" text="Data Sharing"/></a></li>
					<li><a href="#">${product.name}</a></li>
				</ul>
				<h1>${product.name}</h1>
			</div>
		</div>
	</div>

	<div class="shopPages">
		<div class="container-fluid">
			<div class="row">
				<div class="col-sm-6 content subpageContent">
					<h2>${product.name}</h2>
					<p>${product.details}</p>
					<!-- 
					<p><span style="font-weight: 600;">How to register:</span></p>
					<ul>
						<li>Click on register</li>
						<li>USSD: *999#</li>
					</ul>
					<p><span style="font-weight: 600;">How to un-register:</span></p>
					<ul>
						<li>USSD: send "Huy ABC" to "Hot number"</li>
					</ul>
					 -->
					<div style="text-align: right;">
						<button id="btnRegister" class="btn btn-primary btn-round" style="width: 150px"><spring:message code="label.Register" text="Register"/></button>
					</div>
				</div>
				<div class="col-sm-6 photo subpagePhoto">
					<img class="img-responsive" src="${product.defaultImage}">
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
		$("#btnRegister").click(function(){
			location.replace("${pageContext.request.contextPath}/secure/datasharing/${product.code}");
		});
	});
</script>
</html>