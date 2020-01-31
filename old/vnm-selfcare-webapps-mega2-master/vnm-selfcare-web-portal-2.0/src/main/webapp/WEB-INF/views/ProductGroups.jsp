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

	<title>My Vietnamobile - Voice &amp; SMS</title>
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
	<tiles:insertAttribute name="productGroupHeader"/>
	<div class="shopPages">
		<div class="container-fluid">
			<c:forEach items="${productGroupList}" var="productGroup" varStatus="ctr" >
				<div class="row">
				<c:choose>
					<c:when test="${ctr.index % 2 eq 0}">
						<div class="col-xs-12 col-sm-6 col-sm-push-6 content">
							<h2>${productGroup.name}</h2> <!-- <h2 style="text-align: right;"> -->
							<p>${productGroup.description}</p>
							<button onclick="viewProductList('${productGroup.id}');" class="btn btn-secondary btn-round"><spring:message code="label.SeeMoreDetails" text="See more details"/></button>
						</div>
						<div class="col-xs-12 col-sm-6 col-sm-pull-6 photo ">
							<img class="img-responsive" src="${productGroup.defaultImage}">
						</div>
					</c:when>
					<c:otherwise>
						<div class="col-sm-6 content">
							<h2>${productGroup.name}</h2>
							<p>${productGroup.description}</p>
							<button onclick="viewProductList('${productGroup.id}');" class="btn btn-secondary btn-round"><spring:message code="label.SeeMoreDetails" text="See more details"/></button>
							<div style="text-align: right;"><!-- button was here --></div>
						</div>
						<div class="col-sm-6 photo">
							<img class="img-responsive" src="${productGroup.defaultImage}">
						</div>
					</c:otherwise>
				</c:choose>
				</div>
			</c:forEach>
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

<script>
	$(document).ready(function() {
		$zopim(function() {
			$zopim.livechat.bubble.hide();
		});
		
		if (document.getElementById("chatflg").value == "1"){
			$zopim(function() {
			    window.setTimeout(function() {
			        $zopim.livechat.window.show();
			    }, 2000); // delay time in milliseconds
			});
		} else {
			$zopim(function() {
				$zopim.livechat.window.hide();
			});
		}	
	});

	function viewProductList(id){
		location.replace("${pageContext.request.contextPath}/shop/products/" + id);
	}
</script>

</html>