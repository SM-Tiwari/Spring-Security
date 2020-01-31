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

	<title>My Vietnamobile - Store List</title>
	<meta name="description" content="#">
	<meta name="keywords" content="#">
	<meta name="author" content="Vietnamobile">

	<!-- Stylesheets -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/assets/style/bootstrap.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/assets/style/dataTables.bootstrap.min.css">
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

	<!-- Header -->
	<div class="header-general">
		<div class="container">
			<div class="col-sm-11 col-sm-offset-1">
				<ul>
					<sec:authorize access="isAuthenticated()"><li><a href="${pageContext.request.contextPath}/secure/dashboard">Home</a></li></sec:authorize>
					<li><a href="#"><spring:message code="label.TopMenu.LoyaltyProgram" text="Loyalty Program"/></a></li>
				</ul>
				<h1><spring:message code="label.TopMenu.LoyaltyProgram" text="Loyalty Program"/></h1>
			</div>
		</div>
	</div>

	<div class="col-sm-12" id="notifContent">
		<div class="col-sm-8 col-sm-offset-2">
			<div class="card notifCard">
				<div class="notif-title">
					<h6><spring:message code="label.TopMenu.LoyaltyProgram" text="Loyalty Program"/></h6>
				</div>
				<div class="notif-body">
					<p><spring:message code="pagecontent.loyalty.p1" text="Each customer joining Vietnamobile when qualified condition of usage 100,000d will be automatically added to Orange Club."/></p>
					</br>
					<p><spring:message code="pagecontent.loyalty.p2" text="Orange Club account works like a Vietnamobile Loyalty Card, cash back to customers with attractive rate, easy to withdraw for using. The withdrew money can be used for voice, SMS, data, CRBT…"/></p>
					</br>
					<p><spring:message code="pagecontent.loyalty.p3" text="Cash back regime: Members are refunded in Orange Club after 24 hours from spending:"/>
						<ul><li><spring:message code="pagecontent.loyalty.p3.item1" text="3% core usage + 0.3% promotion usage (From currency accounts)"/></li>
							<li><spring:message code="pagecontent.loyalty.p3.item2" text="Members can withdraw money when Orange Club Balance >= 5,000d"/></li>
							<li><spring:message code="pagecontent.loyalty.p3.item3" text="The withdrew money will be added to Promotion_60 (TKLM2), valid 30 days."/></li>
							<li><spring:message code="pagecontent.loyalty.p3.item4" text="Balance of Orange Club balance will be updated after 1 day."/></li>
							<li><spring:message code="pagecontent.loyalty.p3.item5" text="Check balance and withdrawal:"/>
								<ul>
									<li><spring:message code="pagecontent.loyalty.p3.item5.sub1" text="Checking balance: type KT send 268 or *268#OK"/></li>
									<li><spring:message code="pagecontent.loyalty.p3.item5.sub2" text="Withdraw money: Type RT send 268"/></li>
								</ul>
							</ul>
					</p>
					</br>
					<p><spring:message code="pagecontent.loyalty.p4" text="** The policy can change in different periods"/></p>
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
<script src="${pageContext.request.contextPath}/static/assets/script/jquery.dataTables.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/static/assets/script/dataTables.bootstrap.min" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/static/assets/script/bootstrap-dialog.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/static/assets/script/app.js" type="text/javascript"></script>

</html>