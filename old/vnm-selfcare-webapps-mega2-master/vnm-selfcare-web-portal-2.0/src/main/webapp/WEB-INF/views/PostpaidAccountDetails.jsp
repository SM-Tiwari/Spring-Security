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

	<title>My Vietnamobile - Account Details</title>
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
					<li><spring:message code="label.TopMenu.AccountDetails" text="Account Details"/></li>
				</ul>
				<h1><spring:message code="label.TopMenu.AccountDetails" text="Account Details"/></h1>
			</div>
		</div>
	</div>

	<!-- Section: User Options -->
	<c:set var="today" value="<%=new java.util.Date()%>" />
	<div class="col-sm-12" id="accDetails">
		<div class="col-sm-8 col-sm-offset-2 col-md-10 col-md-offset-1">
			<div class="card">
				<div class="col-md-4 accDetailsSubcard">
					<!-- outstanding balance -->
					<div class="accDetailsOptions">
						<div class="accOption-img">
							<img src="${pageContext.request.contextPath}/static/assets/image/accDetailsIcon-1.png">
						</div>
						<div class="accOption-content">
							<h5><spring:message code="label.Postpaid.OutstandingBalance=" text="Outstanding Balance"/></h5>
							<c:choose>
								<c:when test="${outstandingBalanceSize gt 0}">
									<c:forEach items="${outstandingBalanceList}" var="outstanding" varStatus="ctr">
										<div class="statusDetail"><span class="wowText"><fmt:formatDate value="${outstanding.dueDateAsDate}" pattern="MMMMM yyyy"/></span></div>
										<div class="accContent-left">
											<p><spring:message code="label.Postpaid.Balance" text="Balance"/></p>
											<p><spring:message code="label.Postpaid.Status" text="Status"/></p>
											<p><spring:message code="label.Postpaid.PaymentDueDate" text="Due Date"/></p>
										</div>
										<div class="accContent-right">
											<p><b><fmt:formatNumber value="${outstanding.amount}" pattern="#,##0"/>₫</b></p>
											<p style="font-size: 11px;"><b>${outstanding.status}</b></p>
											<p><b>${outstanding.dueDate}</b></p>
										</div>
										<c:if test="${ctr.index < outstandingBalanceSize - 1}"><div class="divider"></div><br/></c:if>
									</c:forEach>
								</c:when>
								<c:otherwise><p class="promoEmpty"><spring:message code="label.Dashboard.None" text="None"/></p></c:otherwise>
							</c:choose>		
						</div>
					</div>
					<!-- un-billed -->
					<div class="accDetailsOptions">
						<div class="accOption-img">
							<img src="${pageContext.request.contextPath}/static/assets/image/accDetailsIcon-1.png">
						</div>
						<div class="accOption-content">
							<h5><spring:message code="label.Postpaid.UnbilledAmount=" text="Unbilled Amount"/></h5>
							<div class="statusDetail"><span class="wowText"><fmt:formatDate value="${today}" pattern="MMMMM yyyy"/></span></div>
							<div class="accContent-left">
								<p><spring:message code="label.Postpaid.Balance" text="Balance"/></p>
								<p><spring:message code="label.Postpaid.FromDate" text="From Date"/></p>
								<p><spring:message code="label.Postpaid.ToDate" text="To Date"/></p>
							</div>
							<div class="accContent-right">
								<p><b><fmt:formatNumber value="${unbilledBalance.totalAmount}" pattern="#,##0"/>₫</b></p>
								<p><b>${unbilledBalance.startDate}</b></p>
								<p><b>${unbilledBalance.endDate}</b></p>
							</div>
						</div>
					</div>
					
					<!-- promotion -->					
					<div class="accDetailsOptions alt">
						<div class="accOption-img">
							<img src="${pageContext.request.contextPath}/static/assets/image/accDetailsIcon-2.png">
						</div>
						<div class="accOption-content">
							<h5><spring:message code="label.Dashboard.Promotion" text="Promotion"/></h5>
							<c:choose>
								<c:when test="${promoBalanceListSize gt 0}">
									<c:forEach items="${currentBalance.promotionBalance.balanceList}" var="promo" varStatus="ctr">
										<c:choose>
											<c:when test="${pageContext.response.locale.language eq 'en'}"><h6>${promo.displayNameEN}</h6></c:when>
											<c:otherwise><h6>${promo.displayNameVI}</h6></c:otherwise>
										</c:choose>
										<div class="accContent-left">
											<p><spring:message code="label.Dashboard.Remaining" text="Remaining"/></p>
											<p><spring:message code="label.Dashboard.Expired" text="Expired"/></p>
										</div>
										<div class="accContent-right">
											<p><fmt:formatNumber value="${promo.availableValue}" pattern="#,##0"/>đ</p>
											<p><fmt:formatDate value="${promo.expiryDate}" pattern="dd/MM/yyyy"/></p>
										</div>
										<c:if test="${ctr.index < promoBalanceListSize - 1}"><div class="divider"></div></c:if>
									</c:forEach>
								</c:when>
								<c:otherwise><p class="promoEmpty"><spring:message code="label.Dashboard.None" text="None"/></p></c:otherwise>
							</c:choose>
						</div>
					</div>
				</div> 
				<div class="col-md-4 accDetailsSubcard">
					<div class="accDetailsOptions">
						<div class="accOption-img">
							<img src="${pageContext.request.contextPath}/static/assets/image/accDetailsIcon-3.png">
						</div>
						<div class="accOption-content">
							<h5>Data</h5>
							<c:choose>
								<c:when test="${dataBalanceListSize gt 0}">
									<c:forEach items="${currentBalance.dataBalance.balanceList}" var="balance" varStatus="ctr">
										<h6>${balance.name}</h6>
										<div class="accContent-left">
											<!--<p><spring:message code="label.Dashboard.Remaining" text="Remaining"/></p>-->
											<p><c:choose><c:when test="${balance.displayOption eq 'CONSUMED_VALUE'}"><p><spring:message code="label.Dashboard.DataConsumed" text="Consumption"/></p></c:when><c:otherwise><p><spring:message code="label.Dashboard.Remaining" text="Remaining"/></p></c:otherwise></c:choose></p>
											<p><spring:message code="label.Dashboard.Expired" text="Expired"/></p>
										</div>
										<c:set var="quotaInfo">
											<c:choose>
												<c:when test="${balance.serviceName eq 'facebook'}"><spring:message code="label.Free" text="Free"/></c:when>
												<c:otherwise>
													<c:choose><c:when test="${balance.displayOption eq 'CONSUMED_VALUE'}"><b><fmt:formatNumber value="${balance.consumedValue / (1024 * 1024)}" maxFractionDigits="2"/> GB</b></c:when>
													<c:otherwise><b><fmt:formatNumber value="${balance.remainingValue / (1024 * 1024)}" maxFractionDigits="2"/> GB</b></c:otherwise></c:choose>
												</c:otherwise>
											</c:choose>
										</c:set>
										<div class="accContent-right">
											<p><b>${quotaInfo}</b></p>
											<p><b><fmt:formatDate value="${balance.endDate}" pattern="dd/MM/yyyy"/></b></p>
										</div>
										<c:if test="${ctr.index < dataBalanceListSize - 1}"><div class="divider"></div></c:if>
									</c:forEach>
								</c:when>
								<c:otherwise><p class="promoEmpty"><spring:message code="label.Dashboard.None" text="None"/></p></c:otherwise>
							</c:choose>
						</div>
					</div>
				</div>
				<div class="col-md-4 accDetailsSubcard">
					<div class="accDetailsOptions">
						<div class="accOption-img">
							<img src="${pageContext.request.contextPath}/static/assets/image/accDetailsIcon-4.png">
						</div>
						<div class="accOption-content">
							<h5><spring:message code="label.Dashboard.VAS" text="VAS"/></h5>
							<c:choose>
								<c:when test="${vasProductListSize gt 0}">
									<c:forEach items="${vasProductList}" var="vas" varStatus="ctr">
										<h6>${utils:abbreviate(vas.product.name, 35)}</h6>
										<div class="accContent-left">
											<p>Expiry Date</p>
										</div>
										<div class="accContent-right">
											<p><fmt:formatDate value="${vas.endDate}" pattern="dd/MM/yyyy"/></p>
										</div>
										<c:if test="${ctr.index < vasProductListSize - 1}"><div class="divider"></div></c:if>									
									</c:forEach>
								</c:when>
								<c:otherwise><p class="promoEmpty"><spring:message code="label.Dashboard.None" text="None"/></p></c:otherwise>
							</c:choose>
						</div>
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