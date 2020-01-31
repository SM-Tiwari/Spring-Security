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

	<title>My Vietnamobile - Top Up History</title>
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
					<sec:authorize access="isAuthenticated()">
					<li><a href="${pageContext.request.contextPath}/secure/profile"><spring:message code="label.Profile" text="Profile"/></a></li>
					</sec:authorize>
					<li><spring:message code="label.Profile.TopupHistory" text="Topup History"/></li>
				</ul>
				<h1><spring:message code="label.Profile.TopupHistory" text="Topup History"/></h1>
			</div>
		</div>
	</div>

	<div class="col-sm-12" id="topupHistoryContent">
		<div class="col-sm-8 col-sm-offset-2">
			<div class="card">
				<div class="table-responsive">
					<table class="table table-hover historyTable" id="topupHistoryTable">

						<thead>
							<tr>
								<th class="text-center"><spring:message code="label.TopupHistory.Date" text="Date"/></th>
								<th class="text-center"><spring:message code="label.TopupHistory.Method" text="Method"/></th>
								<th class="text-center"><spring:message code="label.TopupHistory.Amount" text="Amount"/></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${topupHistory}" var="history" varStatus="ctr">
							<c:choose>
								<c:when test="${pageContext.response.locale.language eq 'en'}"><c:set var="typeName" value="${history.typeNameEN}"/></c:when>
								<c:otherwise><c:set var="typeName" value="${history.typeNameVN}"/></c:otherwise>
							</c:choose>								
							<tr>
								<td class="text-center"><fmt:formatDate value="${history.timeStamp}" pattern="d/M/yy ha"/></td>
								<td class="text-center">${typeName}</td>
								<td class="text-center"><fmt:formatNumber value="${history.amount}" pattern="#,##0"/>đ</td>
							</tr>
							</c:forEach>
						</tbody>

					</table>
				</div> <!-- .table-responsive -->
			</div> <!-- .card -->
			<div class="row">
				<div class="col-xs-4 col-xs-offset-8">
					<p class="amount">Total: <span style="text-decoration: underline;"><fmt:formatNumber value="${totalAmount}" pattern="#,##0"/> VND</span></p>
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
<script src="${pageContext.request.contextPath}/static/assets/script/jquery.dataTables.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/static/assets/script/langswitcher.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/static/assets/script/bootstrap-dialog.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/static/assets/script/app.js" type="text/javascript"></script>

<script type="text/javascript" class="init">
	$(document).ready(function() {
		var history = $("#topupHistoryTable").DataTable({
			"scrollY" : "300px",
			"scrollCollapse" : true,
			"searching" : false,
			"info" : false,
			"paging" : false,
			"stateSave" : false,
			"aaSorting": [],
			"language": {
			    "infoEmpty": '<spring:message code="label.TopupHistory.NoDataFound" text="No Topup History Available"/>',
			    "emptyTable": '<spring:message code="label.TopupHistory.NoDataFound" text="No Topup History Available"/>'
			}
		});

		/*
		setInterval( function () {
			history.ajax.reload( null, false );
		}, 30000 );
		*/
	});
	
</script>
</html>