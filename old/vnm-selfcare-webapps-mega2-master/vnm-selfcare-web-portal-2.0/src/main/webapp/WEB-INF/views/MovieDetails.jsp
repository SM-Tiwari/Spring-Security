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

	<title>My Vietnamobile - Movie Details</title>
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
			padding-bottom: 150%; /* your aspect ratio here! */
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
						<li><a href="${pageContext.request.contextPath}/shop/content/movie/more/${categoryId}/0"><spring:message code="label.TopMenu.Movie" text="Movies"/></a></li>
					</ul>
				</div>
			</div>

			<!-- Content -->
			<div class="container">
				<div class="col-sm-10 col-sm-offset-1">

					<div class="row movieDetails-details">
						<div class="col-sm-6">
							<div class="detailsPoster">
								<img src="${movieDetails.defaultImage}">
							</div>
						</div>
						<div class="col-sm-6">
							<div class="detailsMovie">
							    <c:choose>
							      <c:when test="${pageContext.response.locale.language eq 'en'}"><h1>${movieDetails.titleEN}</h1></c:when>
							      <c:otherwise><h1>${movieDetails.titleVI}</h1></c:otherwise>
							    </c:choose>
								<!--IMDB Data-->
                                <!--
								<div class="row">
									<div class="col-xs-6 col-sm-4 imdbLogo">
										<img src="${pageContext.request.contextPath}/static/assets/image/imdb.png">
									</div>
									<div class="col-xs-1 col-sm-2 imdbRate">
										<h6>8,6</h6>
										<p>75.275</p>
									</div>
								</div>
                                -->
								<!--Movie Meta-->
								<div class="row">
									<div class="col-xs-12">
										<table class="table movieMeta">
											<tr>
												<th class="col-xs-6"><spring:message code="label.Movie.Director" text="Director"/></th>
												<td class="col-xs-6">${movieDetails.directors}</td>
											</tr>
											<tr>
												<th><spring:message code="label.Movie.Writer" text="Writer"/></th>
												<td>${movieDetails.writers}</td>
											</tr>
											<tr>
												<th><spring:message code="label.Movie.Stars" text="Stars"/></th>
												<td>${movieDetails.actors}</td>
											</tr>
											<tr>
												<th><spring:message code="label.Movie.Duration" text="Duration"/></th>
												<td>${movieDetails.duration} mins</td>
											</tr>
											<tr>
												<th><spring:message code="label.Movie.Genre" text="Genre"/></th>
												<td>
												    <c:choose>
												      <c:when test="${pageContext.response.locale.language eq 'en'}">${movieDetails.categoryNameEN}</c:when>
												      <c:otherwise>${movieDetails.categoryNameVI}</c:otherwise>
												    </c:choose>
												</td>
											</tr>
											<tr>
												<th><spring:message code="label.Movie.Language" text="Language"/></th>
												<td>${movieDetails.language}</td>
											</tr>
										</table>
									</div>
								</div>

								<!--CTA Button-->
								<div class="row detailsCTA">
									<div class="col-xs-6">
										<button id="btnWatchNow" class="btn btn-primary btn-round" <c:if test="${empty movieDetails.sourceURL}">disabled</c:if>><spring:message code="label.Movie.WatchNow" text="Watch Now"/></button>
									</div>
									<div class="col-xs-6">
										<!--
										<a href="#" data-toggle="modal" data-target="#transactionModal">
											<button class="btn btn-primary btn-round">Full Movie</button>
										</a>
										-->
									</div>
								</div>

							</div> <!-- .detailsMovie -->
						</div> <!-- .col-sm-5 -->
					</div>

					<!-- Section: Storyline -->
					<div class="row marketPage-sectionTitle">
						<div class="col-xs-12 sectionTitle-title">
							<h2><spring:message code="label.Movie.StoryLine" text="Store Line"/></h2>
						</div>
						<div class="col-xs-12 sectionTitle-storyline">
						    <c:choose>
						      <c:when test="${pageContext.response.locale.language eq 'en'}"><p>${movieDetails.storyLineEN}</p></c:when>
						      <c:otherwise><p>${movieDetails.storyLineVI}</p></c:otherwise>
						    </c:choose>
						</div>
					</div>

					<!-- Related Movies : Title -->
					<div class="row marketPage-sectionTitle">
						<c:choose>
							<c:when test="${!empty relatedMovies}">
								<div class="col-xs-6 sectionTitle-title">
									<h2><spring:message code="label.Movie.RelatedMovies" text="Related Movies"/></h2>
								</div>
								<div class="col-xs-6 sectionTitle-more">
									<c:if test="${fn:length(relatedMovies) gt 4}">
										<a href="${pageContext.request.contextPath}/shop/content/movie/more/${categoryId}/0">
											<spring:message code="label.More" text="More"/> <i class="material-icons">navigate_next</i>
										</a>
									</c:if>
								</div>
							</c:when>
							<c:otherwise>
								<div class="col-xs-6 sectionTitle-title">
									<h2><spring:message code="label.Movie.NoRelatedMovies" text="No Related Movies"/></h2>
								</div>
								<div class="col-xs-6 sectionTitle-more"></div>
							</c:otherwise>
						</c:choose>
					</div>

					<!-- Related Movies : List -->
					<div class="row marketPage-sectionMovie">
						<c:forEach items="${relatedMovies}" var="relatedMovie" varStatus="ctr">
							<c:if test="${ctr.index lt 4}">
							<div class="col-xs-6 col-sm-3">
					            <div class="thumbnail">
					                <div class="card-wrapper">
					                    <a href="${pageContext.request.contextPath}/shop/content/movie/details/${categoryId}/${relatedMovie.id}">
					                    <img src="${!empty relatedMovie.defaultIcon ? relatedMovie.defaultIcon : relatedMovie.defaultImage}" alt="${relatedMovie.titleEN}"></a>
					                </div>
					                <div class="caption text-center movieName">
					                <a href="${pageContext.request.contextPath}/shop/content/movie/details/${categoryId}/${relatedMovie.id}">
								      <c:choose>
								        <c:when test="${pageContext.response.locale.language eq 'en'}"><h6>${utils:abbreviate(relatedMovie.titleEN, 25)}</h6></c:when>
								        <c:otherwise><h6>${utils:abbreviate(relatedMovie.titleVI, 25)}</h6></c:otherwise>
								      </c:choose>
					                </a>
					                </div>
					            </div>
					        </div>
							</c:if>
						</c:forEach>
					</div> <!-- .marketPage-sectionMovie -->

				</div>
			</div> <!-- .container : Content -->
	</div> <!-- .marketPage -->

	<!-- Divider -->
	<div class="sectionDivider col-sm-12"></div>

	<!-- Footer -->
	<tiles:insertAttribute name="footer"/>

</div> <!-- .wrapper -->

<!-- Main Content: End -->

<!-- Modal: Transaction -->

	<div class="modal fade" id="movieBox" tabindex="-1" role="dialog" aria-labelledby="movieBox" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-body">
				</div> <!-- .modal-body -->
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

<script>

$(document).ready(function() {

	$('body').on('hidden.bs.modal', '.modal', function () {
		  $(this).removeData('bs.modal');
	});

	$("#btnWatchNow").click(function(e){
		e.preventDefault();
		var win = window.open("${movieDetails.sourceURL}", "_blank"); //, "location=no,height=600,width=800,scrollbars=yes,status=yes,toolbar=no");
        win.focus();
	});
});

</script>
</html>
