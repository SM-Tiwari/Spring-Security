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

	<title>My Vietnamobile - Apps Details</title>
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
	<style>
		.thumbnail img{
		    max-width: 100%; /* do not stretch the bootstrap column */
		}
		
		.card-wrapper{
			width: 100%;
			padding-bottom: 120%; /* your aspect ratio here! */
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
		
		.modal-scrollfix.modal-scrollfix {
		    overflow-y: hidden;
		}		
	</style>		
	<script src="${pageContext.request.contextPath}/static/assets/script/jquery.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/static/assets/script/bootstrap.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/static/assets/script/app.js" type="text/javascript"></script>
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
					<li><a href="${pageContext.request.contextPath}/shop/content/apps/more/${categoryId}/0"><spring:message code="label.TopMenu.Apps" text="Applications"/></a></li>
				</ul>
			</div>
		</div>

		<!-- Banner -->
		<div class="col-xs-12 marketPage-banner">
			<img src="${appsDetails.defaultBanner}">
		</div>

		<!-- Content -->
		<div class="container">
			<div class="col-sm-10 col-sm-offset-1">
				<div class="row gameDetails">
					<div class="col-xs-6 col-sm-3">
						<div class="gameDetails-image">
							<img src="${!empty appsDetails.defaultIcon ? appsDetails.defaultIcon : appsDetails.defaultImage}">
						</div>
					</div>
					<div class="col-xs-6 col-sm-4">
						<div class="gameDetails-title">
						    <c:choose>
						      <c:when test="${pageContext.response.locale.language eq 'en'}"><h1>${appsDetails.titleEN}</h1></c:when>
						      <c:otherwise><h1>${appsDetails.titleVI}</h1></c:otherwise>
						    </c:choose>							
							<p>${appsDetails.producers}</p>
						</div>
						<div class="gameDetails-meta">
							<div class="row">
								<div class="col-sm-6 hidden-xs">
									<div class="metaDownload">
										50
										<div class="metaDownload-caption">
											thousands
										</div>
									</div>
									<div class="metaDownload-title">
										Downloads
									</div>
								</div>
								<div class="col-sm-6 hidden-xs">
									<div class="metaRating">
										4.7
										<div class="metaRating-caption">
											<i class="fa fa-star"></i>
											<i class="fa fa-star"></i>
											<i class="fa fa-star"></i>
											<i class="fa fa-star"></i>
										</div>
									</div>
									<div class="metaRating-title">
										Rating
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-xs-12 gameDetails-metaMobile visible-xs">
						<div class="row">
							<div class="col-xs-6 visible-xs">
								<div class="metaDownload">
									50
									<div class="metaDownload-caption">
										thousands
									</div>
								</div>
								<div class="metaDownload-title">
									Downloads
								</div>
							</div>
							<div class="col-xs-6 visible-xs">
								<div class="metaRating">
									4.7
									<div class="metaRating-caption">
										<i class="fa fa-star"></i>
										<i class="fa fa-star"></i>
										<i class="fa fa-star"></i>
										<i class="fa fa-star"></i>
									</div>
								</div>
								<div class="metaRating-title">
									Rating
								</div>
							</div>
						</div>
					</div>
					<div class="col-xs-12 col-sm-5">
						<div class="buyGameCTA">
							<button class="btn btn-primary btn-round" id="btnDownload" onclick="downloadContent('${appsDetails.iosProductURL}', '${appsDetails.androidProductURL}');">
								<span style="font-weight: 600; font-size: 18px;"><spring:message code="label.Download" text="Download"/></span>
								<!-- <p><fmt:formatNumber value="${appsDetails.price}" pattern="#,##"/>₫</p> -->
							</button>
							<table class="table table-condensed movieMeta">
								<tr>
									<th class="col-xs-6"><spring:message code="label.Games.Category" text="Category"/></th>
									<td class="col-xs-6">
									    <c:choose>
									      <c:when test="${pageContext.response.locale.language eq 'en'}">${appsDetails.categoryNameEN}</c:when>
									      <c:otherwise>${appsDetails.categoryNameVI}</c:otherwise>
									    </c:choose>										
									</td>
								</tr>
								<tr>
									<th><spring:message code="label.Games.ReleaseDate" text="Release Date"/></th>
									<td><fmt:formatDate value="${appsDetails.releaseDate}" pattern="dd-MM-yyyy"/></td>
								</tr>
								<tr>
									<th><spring:message code="label.Games.Version" text="Version"/></th>
									<td>${appsDetails.version}</td>
								</tr>
								<tr>
									<th><spring:message code="label.Games.Updated" text="Updated"/></th>
									<td><fmt:formatDate value="${appsDetails.lastUpdatedDate}" pattern="dd-MM-yyyy"/></td>
								</tr>
								<tr>
									<th><spring:message code="label.Games.Size" text="Size"/></th>
									<td><c:if test="${!empty appsDetails.fileSize and appsDetails.fileSize gt 0 }"><fmt:formatNumber value="${appsDetails.fileSize / 1024}" maxFractionDigits="2"/> MB</c:if></td>
								</tr>
							</table>
						</div>
					</div>
				</div>

				<!-- Section: Storyline -->
				<div class="row marketPage-sectionTitle">
					<div class="col-xs-12 sectionTitle-title">
						<h2><spring:message code="label.Games.Description" text="Description"/></h2>
					</div>
					<div class="col-xs-12 sectionTitle-storyline">
					    <c:choose>
					      <c:when test="${pageContext.response.locale.language eq 'en'}"><p>${appsDetails.descriptionEN}</p></c:when>
					      <c:otherwise><p>${appsDetails.descriptionVI}</p></c:otherwise>
					    </c:choose>										
					</div>
				</div>

				<!-- Screenshot : Title -->
				<c:if test="${fn:length(appsDetails.screenShots) gt 0}">
				<div class="row marketPage-sectionTitle">
					<div class="col-xs-6 sectionTitle-title">
						<h2><spring:message code="label.Games.Screenshots" text="Screenshots"/></h2>
					</div>
				</div>
				<!-- Screenshot : List -->
				<div class="row marketPage-sectionGame">
					<c:forEach items="${appsDetails.screenShots}" var="screenshot" varStatus="ctr">
						<c:if test="${ctr.index lt 4}">
						<div class="col-xs-6 col-sm-3">
							<div class="moviePoster">
								<a href="#">
									<img src="${screenshot}">
								</a>
							</div>
						</div>
						</c:if>
					</c:forEach>
				</div> 
				</c:if>
				
				<!-- Related Games : Title -->
				<div class="row marketPage-sectionTitle">
					<c:choose>
						<c:when test="${!empty relatedApps}">
							<div class="col-xs-6 sectionTitle-title">
								<h2><spring:message code="label.Games.RelatedGames" text="Related Games"/></h2>
							</div>
							<div class="col-xs-6 sectionTitle-more">
								<c:if test="${fn:length(relatedApps) gt 4}">
									<a href="${pageContext.request.contextPath}/shop/content/apps/more/${categoryId}/0">
										<spring:message code="label.More" text="More"/> <i class="material-icons">navigate_next</i>
									</a>
								</c:if>
							</div>
						</c:when>
						<c:otherwise>
							<div class="col-xs-6 sectionTitle-title">
								<h2><spring:message code="label.Movie.NoRelatedGames" text="No Related Games"/></h2>
							</div>
							<div class="col-xs-6 sectionTitle-more"></div>
						</c:otherwise>
					</c:choose>
				</div>
				
				<div class="row marketPage-sectionGame">
					<c:forEach items="${relatedApps}" var="relatedApps" varStatus="ctr">
						<c:if test="${ctr.index lt 4}">
						<div class="col-xs-6 col-sm-3">
				            <div class="thumbnail">
				                <div class="card-wrapper">
				                    <a href="${pageContext.request.contextPath}/shop/content/apps/details/${categoryId}/${relatedApps.id}"><img src="${!empty relatedApps.defaultIcon ? relatedApps.defaultIcon : relatedApps.defaultImage}" alt="${relatedApps.titleEN}"></a>
				                </div>
				                <div class="caption text-center gameName">
					                <a href="${pageContext.request.contextPath}/shop/content/apps/details/${categoryId}/${relatedApps.id}">
								    <c:choose>
								      <c:when test="${pageContext.response.locale.language eq 'en'}"><h6>${utils:abbreviate(relatedApps.titleEN, 25)}</h6></c:when>
								      <c:otherwise><h6>${utils:abbreviate(relatedApps.titleVI, 25)}</h6></c:otherwise>
								    </c:choose>										
					                </a>
				                </div>
				            </div>
				        </div>									
						</c:if>
					</c:forEach>
				</div> <!-- .marketPage-sectionGame -->
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
<script>
/*
$(document).ready(function() {
	var os = getOS();
	var flag = true;
	if (os == "iOS" || os == "Mac OS"){
		if ("${appDetails.iosProductURL}" != ""){
			flag = false;
		}
	} else {
		if ("${appDetails.androidProductURL}" != ""){
			flag = false;
		}
	}
	$("#btnDownload").prop("disabled", flag);
});
*/
</script>

</html>