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
		<!-- outstanding balance -->
		<div class="col-sm-8 col-sm-offset-2">
			<div class="card userOptionsCard">
				<div class="userOptions-icon">
					<i class="material-icons">account_balance_wallet</i>
				</div>
				<div class="userOptions-title">
					<h6><spring:message code="label.Postpaid.OutstandingBalance" text="Outstanding Balance"/></h6>
				</div>
				<div class="userOptions-body">
					<p><fmt:formatNumber value="${outstandingBalance}" pattern="#,##0"/>đ</p>
				</div>
			</div>
		</div>
		<!-- subscriptions -->
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
		<!-- roaming status -->
		<div class="col-sm-8 col-sm-offset-2">
			<div class="card userOptionsCard">
				<div class="userOptions-icon">
					<a href="#"><i class="material-icons">account_balance_wallet</i></a>
				</div>
				<div class="userOptions-title">
					<h6><a href="javascript:;" data-toggle="modal" data-target="#roamingStatusModal" data-backdrop="true" style="color: #4A4A4A; text-decoration: none;"><spring:message code="label.Postpaid.RoamingStatus" text="Roaming Status"/></a></h6>
				</div>
				<div class="userOptions-body">
					<a href="javascript:;" data-toggle="modal" data-target="#roamingStatusModal" data-backdrop="true">
						<i class="material-icons">navigate_next</i>
					</a>
				</div>
			</div>
		</div>
		<!-- bill history -->
		<div class="col-sm-8 col-sm-offset-2">
			<div class="card userOptionsCard">
				<div class="userOptions-icon">
					<i class="material-icons">account_balance_wallet</i>
				</div>
				<div class="userOptions-title">
					<h6><a href="javascript:;" data-toggle="modal" data-target="#billHistoryModal" data-backdrop="true" style="color: #4A4A4A; text-decoration: none;"><spring:message code="label.Postpaid.BillHistory" text="Bill History"/></a></h6>
				</div>
				<div class="userOptions-body">
					<a href="javascript:;" data-toggle="modal" data-target="#billHistoryModal" data-backdrop="true">
						<i class="material-icons">navigate_next</i>
					</a>
				</div>
			</div>
		</div>
		<!-- change password -->
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

	<!-- Divider -->
	<div class="sectionDivider col-sm-12"></div>

	<!-- Footer -->
	<tiles:insertAttribute name="footer"/>

</div> <!-- .wrapper -->

<!-- Main Content: End -->
<!-- ${deltaDepositBalance} -->
<div class="modal fade" id="roamingStatusModal" tabindex="-1" role="dialog" aria-labelledby="roamingStatusModal" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title" id="topupModalLabel"><spring:message code="label.Postpaid.RoamingStatus" text="Roaming Status"/></h4>
			</div>
			<div class="modal-body">
				<div class="col-md-6">
					<p><spring:message code="label.Postpaid.DepositBalance" text="Deposit Balance"/></p>
					<p><spring:message code="label.Postpaid.Status" text="Status"/></p>
				</div>
				<div class="col-md-6 text-right">
					<p><b><fmt:formatNumber value="${depositBalance}" pattern="#,##0"/>₫</b></p>
					<p><span class="wowText"><c:choose><c:when test="${userProfile.roamingEnabled}"><spring:message code="label.Postpaid.RoamingStatusEnabled" text="Enabled"/></c:when><c:otherwise><spring:message code="label.Postpaid.RoamingStatusDisabled" text="Disabled"/></c:otherwise></c:choose></span></p>
					<br/><br/>
				</div>
			</div> <!-- .modal-body -->
			<div class="modal-footer">
			<!-- 
				<div class="text-center">
					<c:choose>
						<c:when test="${deltaDepositBalance gt 0}"><button id="btnPayDeposit" class="btn btn-primary btn-round"><spring:message code="label.Pay" text="Pay"/></button></c:when>
						<c:otherwise>
							<c:choose>
								<c:when test="${!userProfile.roamingEnabled}"><button id="btnEnableRoaming" class="btn btn-primary btn-round"><spring:message code="label.Enable" text="Enable"/></button></c:when>
								<c:otherwise><button id="btnDisableRoaming" class="btn btn-primary btn-round"><spring:message code="label.Disable" text="Disable"/></button></c:otherwise>
							</c:choose>
						</c:otherwise>
					</c:choose>
				</div>
			 -->
			</div>
		</div>
	</div>
</div>

<div class="modal fade" id="billHistoryModal" tabindex="-1" role="dialog" aria-labelledby="billHistoryModal" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title" id="topupModalLabel"><spring:message code="label.Postpaid.BillHistory" text="Bill History"/></h4>
			</div>
			<div class="modal-body">
				<c:forEach items="${billingHistory}" var="bill" varStatus="ctr">
					<div class="card userOptionsCard">
							<div class="userOptions-title">
								<h6><a href="${pageContext.request.contextPath}/secure/billdtl/${bill.id}" style="color: #F57E20; text-decoration: none;"><fmt:formatDate value="${bill.ddate}" pattern="MMMMM yyyy"/></a></h6>
							</div>
							<div class="userOptions-body">
								<a class="btn btn-primary btn-round" href="${pageContext.request.contextPath}/secure/billpdf/${bill.invoiceNumber}"><spring:message code="label.Download" text="Download"/></a>
							</div>
					</div>
					<c:if test="${ctr.index < billingHistorySize - 1}"><div class="divider"></div></c:if>
				</c:forEach>
			</div> <!-- .modal-body -->
			<div class="modal-footer">
				<button id="btnPayBill" class="btn btn-primary btn-round"><spring:message code="label.Pay" text="Pay"/></button>
			</div>
		</div>
	</div>
</div>

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