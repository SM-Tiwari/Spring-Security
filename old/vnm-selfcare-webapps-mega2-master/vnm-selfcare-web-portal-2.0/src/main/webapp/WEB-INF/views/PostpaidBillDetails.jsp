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

	<title>My Vietnamobile - Bill Details</title>
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
				<ul>
					<li><a href="${pageContext.request.contextPath}/secure/dashboard"><spring:message code="label.TopMenu.Home" text="Home"/></a></li>
					<li><a href="${pageContext.request.contextPath}/secure/profile"><spring:message code="label.TopMenu.Profile" text="Profile"/></a></li>
					<li><spring:message code="label.TopMenu.BillDetails" text="Bill Details"/></li>
				</ul>
				<h1><spring:message code="label.TopMenu.BillDetails" text="Bill Details"/></h1>
			</div>
		</div>
	</div>
	<div class="col-sm-12" id="notifContent">
		<div class="col-sm-8 col-sm-offset-2">
			<div class="card notifCard">
				<div class="notif-title">
					<h6><spring:message code="label.TopMenu.BillDetails" text="Bill Details"/></h6>
				</div>
				<div class="notif-body">
					<div class="col-md-7 wowText"><spring:message code="label.Postpaid.BillDetails.PaymentDueDate" text="Payment Due Date"/></div>
					<div class="col-md-5 text-right">${billingDetails.invoiceDueDate}</div>
	
					<div class="col-md-7 wowText"><spring:message code="label.Postpaid.BillDetails.BillPeriod" text="Bill Period"/></div>
					<div class="col-md-5 text-right">${billingDetails.startPeriod} - ${billingDetails.endPeriod}</div>
	
					<div class="col-md-7 wowText"><spring:message code="label.Postpaid.BillDetails.IssueDate" text="Issue Date"/></div>
					<div class="col-md-5 text-right">${billingDetails.invoiceDate}</div>
	
					<div class="col-md-7 wowText"><spring:message code="label.Postpaid.BillDetails.BroughtForwardCharge" text="Brought Forward Charge"/></div>
					<div class="col-md-5 text-right"><fmt:formatNumber value="${billingDetails.balanceBroughtForward}" pattern="#,##0"/></div>
	
					<div class="col-md-7 wowText"><spring:message code="label.Postpaid.BillDetails.ServicesRegFee" text="Services Registration Fee"/></div>
					<div class="col-md-5 text-right">0<br/><br/></div>
					
					<div class="col-md-7">1. <spring:message code="label.Postpaid.BillDetails.MonthlyFee" text="Monthly Fee"/></div>
					<div class="col-md-5 text-right"><fmt:formatNumber value="${billingDetails.monthlyCharge}" pattern="#,##0"/></div>
	
					<div class="col-md-7">2. <spring:message code="label.Postpaid.BillDetails.CallCharges" text="Call Charges"/></div>
					<div class="col-md-5 text-right"></div>

					<div class="col-md-7">2.1. <spring:message code="label.Postpaid.BillDetails.DomesticCallCharges" text="Domestic Call Charges"/></div>
					<div class="col-md-5 text-right"><fmt:formatNumber value="${billingDetails.localCharges}" pattern="#,##0"/></div>
	
					<div class="col-md-7">2.1. <spring:message code="label.Postpaid.BillDetails.IntlCallCharges" text="International Call Charges"/></div>
					<div class="col-md-5 text-right"><fmt:formatNumber value="${billingDetails.iddCharges}" pattern="#,##0"/></div>
	
					<div class="col-md-7">3. <spring:message code="label.Postpaid.BillDetails.IntlRoamingCharges" text="International Roaming Charges"/></div>
					<div class="col-md-5 text-right"></div>
	
					<div class="col-md-7">3.1. <spring:message code="label.Postpaid.BillDetails.VisitedNetworkCharges" text="Visited Network Charges"/></div>
					<div class="col-md-5 text-right">0</div>
	
					<div class="col-md-7">3.2. <spring:message code="label.Postpaid.BillDetails.VietnamobileAdminFee" text="Vietnamobile Administration Fee"/></div>
					<div class="col-md-5 text-right">0</div>
	
					<div class="col-md-7">4. <spring:message code="label.Postpaid.BillDetails.VideoCall3gServicesCharges" text="Video Call and 3G Services Charges"/></div>
					<div class="col-md-5 text-right"><fmt:formatNumber value="${billingDetails.videoCharges}" pattern="#,##0"/></div>
				
					<div class="col-md-7">5. <spring:message code="label.Postpaid.BillDetails.VAS" text="Value Added Services"/></div>
					<div class="col-md-5 text-right">0</div>
	
					<div class="col-md-7">6. <spring:message code="label.Postpaid.BillDetails.ReducedTariff" text="Reduced Tariff"/></div>
					<div class="col-md-5 text-right">0</div>
	
					<div class="col-md-7">7. <spring:message code="label.Postpaid.BillDetails.Promotion" text="Promotion"/></div>
					<div class="col-md-5 text-right">0</div>
	
					<div class="col-md-7">8. <spring:message code="label.Postpaid.BillDetails.Adjustment" text="Adjustment"/></div>
					<div class="col-md-5 text-right"><fmt:formatNumber value="${billingDetails.adjustment}" pattern="#,##0"/></div>
					
					<div class="col-md-7">9. <spring:message code="label.Postpaid.BillDetails.ResidualCommittedAmt" text="Residual Committed Amount"/></div>
					<div class="col-md-5 text-right">0</div>
	
					<div class="col-md-7">10. <spring:message code="label.Postpaid.BillDetails.TotalCurrentBillBeforeTax" text="Total Current Bill Before Tax"/></div>
					<div class="col-md-5 text-right"><fmt:formatNumber value="${billingDetails.totalOutstandingBilling}" pattern="#,##0"/></div>
	
					<div class="col-md-7">11. <spring:message code="label.Postpaid.BillDetails.VAT" text="VAT"/></div>
					<div class="col-md-5 text-right"><fmt:formatNumber value="${billingDetails.vat}" pattern="#,##0"/></div>
	
					<div class="col-md-7">12. <spring:message code="label.Postpaid.BillDetails.TotalCurrentBillAfterTax" text="Total Current Bill After Tax"/></div>
					<div class="col-md-5 text-right"><fmt:formatNumber value="${billingDetails.totalOutstandingBilling + billingDetails.vat}" pattern="#,##0"/><br/><br/></div>
					
					<div class="col-md-7 wowText"><spring:message code="label.Postpaid.BillDetails.TotalAmountDue" text="Total Amount Due"/></div>
					<div class="col-md-5 text-right"><fmt:formatNumber value="${billingDetails.totalDue}" pattern="#,##0"/><br/><br/></div>
					
					<div class="col-md-12 text-center">
						<a class="btn btn-primary btn-round" href="${pageContext.request.contextPath}/secure/billpdf/${billingDetails.invoicenumber}"><spring:message code="label.Download" text="Download"/></a>
					</div>
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

</html>