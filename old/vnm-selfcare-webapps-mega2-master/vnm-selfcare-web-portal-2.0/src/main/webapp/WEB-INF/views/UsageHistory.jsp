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

	<title>My Vietnamobile - Dashboard</title>
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
<fmt:setLocale value="en_US" scope="session"/>

<div class="wrapper">

	<!-- Header -->
	<div class="header-general">
		<div class="container">
			<div class="col-sm-11 col-sm-offset-1">
				<ul>
					<sec:authorize access="isAuthenticated()">
					<li><a href="${pageContext.request.contextPath}/secure/dashboard"><spring:message code="label.TopMenu.Home" text="Home"/></a></li>
					</sec:authorize>
					<li><spring:message code="label.TopMenu.History" text="History"/></li>
				</ul>
				<h1><spring:message code="label.TopMenu.History" text="History"/></h1>
			</div>
		</div>
	</div>

	<div class="col-sm-12" id="historyContent">
		<div class="col-sm-8 col-sm-offset-2">
			<h2><spring:message code="label.CallHistory.CallHistory" text="Call History"/></h2>
		</div>
		<div class="col-sm-8 col-sm-offset-2">
			<div class="card">
				<div class="table-responsive">
					<table class="table table-hover historyTable" id="callHistoryTable">

						<thead>
							<tr>
								<th class="text-center"><spring:message code="label.CallHistory.No" text="No"/></th>
								<th class="text-center"><spring:message code="label.CallHistory.Number" text="Number"/></th>
								<th class="text-center"><spring:message code="label.CallHistory.Date" text="Date"/></th>
								<th class="text-center"><spring:message code="label.CallHistory.Duration" text="Duration"/></th>
							</tr>
						</thead>

						<tbody>
							<c:forEach items="${callHistory}" var="history" varStatus="ctr">
							<tr>
								<td class="text-center">${ctr.index+1}</td>
								<td class="text-center phoneNumber"><i class="material-icons">call_made</i>${history.calledNumber}</td>
								<td class="text-center"><fmt:formatDate value="${history.startTime}" pattern="d/M/yy hh:mma"/></td>
								<td class="text-center duration">${utils:milisToString(history.duration * 1000, ':')}</td>
							</tr>
							</c:forEach>
						</tbody>

					</table>
				</div>
			</div>
		</div>
		<div class="col-sm-8 col-sm-offset-2">
			<h2><spring:message code="label.SmsHistory.SmsHistory" text="SMS History"/></h2>
		</div>
		<div class="col-sm-8 col-sm-offset-2">
			<div class="card">
				<div class="table-responsive">
					<table class="table table-hover historyTable" id="smsHistoryTable">

						<thead>
							<tr>
								<th class="text-center"><spring:message code="label.SmsHistory.No" text="No"/></th>
								<th class="text-center"><spring:message code="label.SmsHistory.Number" text="Number"/></th>
								<th class="text-center"><spring:message code="label.SmsHistory.Date" text="Date"/></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${smsHistory}" var="history" varStatus="ctr">
							<tr>
								<td class="text-center">${ctr.index+1}</td>
								<td class="text-center phoneNumber"><i class="material-icons">call_made</i>${history.destinationNumber}</td>
								<td class="text-center"><fmt:formatDate value="${history.timeStamp}" pattern="d/M/yy hh:mma"/></td>
							</tr>
							</c:forEach>
						</tbody>

					</table>
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
		$("#callHistoryTable").DataTable({
			"scrollY" : "200px",
			"scrollCollapse" : true,
			"searching" : false,
			"info" : false,
			"paging" : false,
			"language": {
			    "infoEmpty": '<spring:message code="label.CallHistory.NoDataFound" text="No Call History Available"/>',
			    "emptyTable": '<spring:message code="label.CallHistory.NoDataFound" text="No Call History Available"/>'
			}
		});

		$("#smsHistoryTable").DataTable({
			"scrollY" : "200px",
			"scrollCollapse" : true,
			"searching" : false,
			"info" : false,
			"paging" : false,
			"language": {
			    "infoEmpty": '<spring:message code="label.SmsHistory.NoDataFound" text="No SMS History Available"/>',
			    "emptyTable": '<spring:message code="label.SmsHistory.NoDataFound" text="No Call History Available"/>'
			}
		});
	});
</script>
</html>
