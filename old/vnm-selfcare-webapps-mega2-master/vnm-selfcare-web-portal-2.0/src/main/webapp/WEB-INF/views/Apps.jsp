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

	<title>My Vietnamobile - Apps</title>
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
	<link rel="stylesheet" href="https://netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap-glyphicons.css">
	<style>
		.carousel-indicators {
			width: 5%;
			top: 70px;
			left: 77.5%;
			position: absolute;
			white-space: nowrap;
		}

		.carousel-control .glyphicon-chevron-right, .carousel-control .icon-next{
			top: 70px;
		}

		.carousel-control .glyphicon-chevron-left, .carousel-control .icon-prev{
			top: 70px;
		}

		.thumbnail img{
		    max-width: 100%; /* do not stretch the bootstrap column */
		}

		.card-wrapper{
			width: 100%;
			padding-bottom: 100%; /* your aspect ratio here! */
			position: relative;
		}

		.card-wrapper img{
			position: absolute;
			top: 0;
			bottom: 0;
			left: 0;
			right: 0;
			min-height: 100%; /* optional: if you want the smallest images to fill the .thumbnail */
		}
	</style>
</head>

<body>

<tiles:insertAttribute name="header"/>

<div class="wrapper">

	<div class="marketPage">

		<!-- Breadcrumb -->
		<div class="container-fluid">
			<div class="col-sm-11 col-sm-offset-1" style="padding: 0;">
				<ul class="mod-breadcrumb">
					<li><a href="${pageContext.request.contextPath}/shop/voice_n_sms"><spring:message code="label.TopMenu.Shop" text="Shop"/></a></li>
					<li><a href="${pageContext.request.contextPath}/shop/vas"><spring:message code="label.TopMenu.Contents" text="Contents"/></a></li>
					<li><a href="${pageContext.request.contextPath}/shop/content/movie/list"><spring:message code="label.TopMenu.Entertainment" text="Entertainment"/></a></li>
					<li><a href="${pageContext.request.contextPath}/shop/content/apps/list"><spring:message code="label.TopMenu.Apps" text="Applications"/></a></li>
				</ul>
			</div>
		</div>

		<!-- Banner -->
		<div class="col-xs-12 marketPage-banner">
			<div id="appsBanner" class="carousel slide" data-ride="carousel" data-interval="3000">
				<!-- Indicators -->
				<ol class="carousel-indicators">
					<c:forEach items="${appsBanner}" var="banner" varStatus="ctr">
						<li data-target="#appsBanner" data-slide-to="${ctr.index}" <c:if test="${ctr.index eq 0}">class="active"</c:if>></li>
					</c:forEach>
				</ol>

				<!-- Wrapper for slides -->
				<div class="carousel-inner">
					<c:forEach items="${appsBanner}" var="banner" varStatus="ctr">
					<div class="item <c:if test="${ctr.index eq 0}">active</c:if>">
						<img src="${banner.webBanner}" alt="Apps Banner ${ctr.index}" style="width: 100%;"/>
					</div>
					</c:forEach>
				</div>

				<!-- Left and right controls -->
				<a class="left carousel-control" href="#appsBanner"
					data-slide="prev"> <span
					class="glyphicon glyphicon-chevron-left"></span> <span
					class="sr-only">Previous</span>
				</a> <a class="right carousel-control" href="#appsBanner"
					data-slide="next"> <span
					class="glyphicon glyphicon-chevron-right"></span> <span
					class="sr-only">Next</span>
				</a>
			</div>
		</div>
		<!-- Content -->
		<div class="container">
			<div class="col-sm-10 col-sm-offset-1">
				<c:forEach items="${appsCategories}" var="category">
					<c:if test="${category.itemCount gt 0}">
						<!-- Section Title -->
						<div class="row marketPage-sectionTitle">
							<div class="col-xs-6 sectionTitle-title">
						    <c:choose>
						      <c:when test="${pageContext.response.locale.language eq 'en'}"><h2>${category.nameEN}</h2></c:when>
						      <c:otherwise><h2>${category.nameVI}</h2></c:otherwise>
						    </c:choose>
							</div>
							<div class="col-xs-6 sectionTitle-more">
								<c:if test="${fn:length(requestScope[category.code]) gt 4 }">
								<a href="${pageContext.request.contextPath}/shop/content/apps/more/${category.id}/0"><spring:message code="label.More" text="More"/> <i class="material-icons">navigate_next</i></a>
								</c:if>
							</div>
						</div>
	
						<!-- Section Movie List -->
						<div class="row marketPage-sectionGame">
							<c:forEach items="${requestScope[category.code]}" var="apps" varStatus="ctr">
								<c:if test="${ctr.index lt 4}">
								<div class="col-xs-6 col-sm-3">
						            <div class="thumbnail">
						                <div class="card-wrapper">
						                    <a href="${pageContext.request.contextPath}/shop/content/apps/details/${category.id}/${apps.id}"><img src="${!empty apps.defaultIcon ? apps.defaultIcon : apps.defaultImage}" alt="${utils:abbreviate(apps.titleEN, 35)}"></a>
						                </div>
						                <div class="caption text-center gameName">
				                            <a href="${pageContext.request.contextPath}/shop/content/apps/details/${category.id}/${apps.id}">
				                              <c:choose>
				                                <c:when test="${pageContext.response.locale.language eq 'en'}"><h6>${utils:abbreviate(apps.titleEN, 35)}</h6></c:when>
				                                <c:otherwise><h6>${utils:abbreviate(apps.titleVI, 35)}</h6></c:otherwise>
				                              </c:choose>
				                            </a>
				                        </div>
						            </div>
						        </div>
								</c:if>
							</c:forEach>
						</div> <!-- .marketPage-sectionGame -->					
					</c:if>
				</c:forEach>
			</div>
		</div> <!-- .container : Content -->
	</div> <!-- .marketPage -->

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
