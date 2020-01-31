<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="utils" uri="utils"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">

<link rel="icon"
	href="${pageContext.request.contextPath}/static/assets/image/favicon.ico">
<link rel="apple-touch-icon"
	href="${pageContext.request.contextPath}/static/assets/image/apple-touch-icon.png">

<title>My Vietnamobile - Voice &amp; SMS</title>
<meta name="description" content="#">
<meta name="keywords" content="#">
<meta name="author" content="Vietnamobile">

<!-- Stylesheets -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/assets/style/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/assets/style/jquery.smartmenus.bootstrap.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/assets/style/material-kit.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/assets/style/vietnamobile.css?id=1">

<!-- Typefaces -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
	
	
	
	
</head>

<body>



	<tiles:insertAttribute name="header" />

	<div class="wrapper">

		<!-- Header -->
		<tiles:insertAttribute name="productListHeader" />

		<div class="shopPages">
			<div class="container-fluid">
				<c:forEach items="${productList}" var="product" varStatus="ctr">
					<div class="row">
						<c:choose>
							<c:when test="${ctr.index % 2 eq 0}">
								<div class="col-xs-12 col-sm-6 col-sm-push-6 content">
									<h2>${product.name}</h2>
									<p>${product.details}</p>
									<!-- ${product.description} -->
									<!-- 
								<c:if test="${!empty product.howToRegister}">
									<p><span style="font-weight: 600;">How to register:</span></p>
									<ul>
										<li>${product.howToRegister}</li>
									</ul>
								</c:if>
								<c:if test="${!empty product.howToUnregister}">
									<p><span style="font-weight: 600;">How to un-register:</span></p>
									<ul>
										<li>${product.howToUnregister}</li>
									</ul>
								</c:if>
								 -->
									<c:choose>
										<c:when
											test="${!empty userProfile and product.purchaseEnabled}">
											<button onclick="confirmRegister('${product.code}')"
												class="btn btn-primary btn-round">
												<spring:message code="label.Register" text="Register" />
											</button>
										</c:when>
										<c:otherwise>
											<button onclick="mustLoginAlert();"
												class="btn btn-primary btn-round">
												<spring:message code="label.Register" text="Register" />
											</button>
										</c:otherwise>
									</c:choose>

									    <%-- <a
											href="https://api.instagram.com/oauth/authorize/?client_id=4c546ec1a67a44f29add48103bb6acbf&redirect_uri=${shareLink}&response_type=code"
											target="_blank"> <img
											src="${pageContext.request.contextPath}/static/assets/image/instagram.jpg"
											style="height: 34px; width: 34px;" alt="Instagram" />
										</a> --%>

									<%-- <a href="http://www.facebook.com/sharer.php?u=${shareLink}/shareproduct/${product.id}/${selectLanguage}" target="_blank"> --%>
									
									<%-- <img
											src="${pageContext.request.contextPath}/static/assets/image/instagram.jpg"
											style="height: 34px; width: 34px;" alt="Instagram" onclick="myFunction()"/> --%>
									
									<img
										src="https://simplesharebuttons.com/images/somacro/facebook.png"
										alt="Facebook" style="height: 34px; width: 34px;"
										onclick='fb_share("${shareLink}/shareproduct/${product.id}/${selectLanguage}","${product.name}","${product.name}","${product.mediumImage}","${product.id}")' />
									<!-- </a> -->


									<img src="https://simplesharebuttons.com/images/somacro/twitter.png"
										alt="twitter" style="height: 34px; width: 34px;"
										onclick="tw_share('${shareLink}/shareproduct/${product.id}/${selectLanguage}','${product.name}','${product.name}','${product.mediumImage}','${product.id}')" />

									 <%-- <a
										href="https://twitter.com/intent/tweet?url=${shareLink}/shareproduct/${product.id}/${selectLanguage}&amp;text=${product.name}&amp;hashtags=${product.name}"
										target="_blank"> <img
										src="https://simplesharebuttons.com/images/somacro/twitter.png"
										alt="Twitter" style="height: 34px; width: 34px;" />
									</a> --%>

								</div>
								<div class="col-xs-12 col-sm-6 col-sm-pull-6 photo">
									<img class="img-responsive" src="${product.mediumImage}">
								</div>
							</c:when>
							<c:otherwise>
								<div class="col-sm-6 content">
									<h2>${product.name}</h2>
									<p>${product.details}</p>
									<!-- ${product.description} -->
									<!-- 
								<c:if test="${!empty product.howToRegister}">
									<p><span style="font-weight: 600;">How to register:</span></p>
									<ul>
										<li>${product.howToRegister}</li>
									</ul>
								</c:if>
								<c:if test="${!empty product.howToUnregister}">
									<p><span style="font-weight: 600;">How to un-register:</span></p>
									<ul>
										<li>${product.howToUnregister}</li>
									</ul>
								</c:if>
								 -->
									<div style="text-align: right;">
										<%-- <a
											href="https://api.instagram.com/oauth/authorize/?client_id=4c546ec1a67a44f29add48103bb6acbf&redirect_uri=${shareLink}/shareproduct/${product.id}/${selectLanguage}&response_type=code"
											target="_blank"> <img
											src="${pageContext.request.contextPath}/static/assets/image/instagram.jpg"
											style="height: 34px; width: 34px;" alt="Instagram" />
										</a>  --%>
										
										<img
											src="https://simplesharebuttons.com/images/somacro/facebook.png"
											alt="Facebook" style="height: 34px; width: 34px;"
											onclick='fb_share("${shareLink}/shareproduct/${product.id}/${selectLanguage}","${product.name}","${product.name}","${product.mediumImage}","${product.id}")' />

										<%-- <a href="http://www.facebook.com/sharer.php?u=${shareLink}/shareproduct/${product.id}/${selectLanguage}" target="_blank">
							        <img src="https://simplesharebuttons.com/images/somacro/facebook.png" alt="Facebook" style="height: 34px; width: 34px;" />
							    </a> --%>

										 <%-- <a
											href="https://twitter.com/intent/tweet?url=${shareLink}/shareproduct/${product.id}/${selectLanguage}&amp;text=${product.name}&amp;hashtags=${product.name}"
											target="_blank"> <img
											src="https://simplesharebuttons.com/images/somacro/twitter.png"
											alt="Twitter" style="height: 34px; width: 34px;" />
										</a>  --%>
										
										<img src="https://simplesharebuttons.com/images/somacro/twitter.png"
										alt="twitter" style="height: 34px; width: 34px;"
										onclick="tw_share('${shareLink}/shareproduct/${product.id}/${selectLanguage}','${product.name}','${product.name}','${product.mediumImage}','${product.id}')" />
										
										
										<c:choose>
											<c:when
												test="${!empty userProfile and product.purchaseEnabled}">
												<button onclick="confirmRegister('${product.code}')"
													class="btn btn-primary btn-round">
													<spring:message code="label.Register" text="Register" />
												</button>
											</c:when>
											<c:otherwise>
												<button onclick="mustLoginAlert();"
													class="btn btn-primary btn-round">
													<spring:message code="label.Register" text="Register" />
												</button>
											</c:otherwise>
										</c:choose>

									</div>
								</div>
								<div class="col-sm-6 photo">
									<img class="img-responsive" src="${product.mediumImage}">
								</div>
							</c:otherwise>
						</c:choose>
					</div>
				</c:forEach>
			</div>
			<!-- <div>
				<input type="button" onclick="checkGet()">
				<div id="instafeed" style="display: none;"></div>
			</div> -->
		</div>

		<!-- Divider -->
		<div class="sectionDivider col-sm-12"></div>

		<!-- Footer -->
		<tiles:insertAttribute name="footer" />

	</div>
	<!-- .wrapper -->

	<!-- Main Content: End -->

</body>

<!--   Core Script Files   -->
<script
	src="${pageContext.request.contextPath}/static/assets/script/jquery.min.js"
	type="text/javascript"></script>
<script
	src="${pageContext.request.contextPath}/static/assets/script/bootstrap.min.js"
	type="text/javascript"></script>
<script
	src="${pageContext.request.contextPath}/static/assets/script/material.min.js"></script>
<script
	src="${pageContext.request.contextPath}/static/assets/script/modified-material.js"></script>
<script
	src="${pageContext.request.contextPath}/static/assets/script/dashboard.js"></script>

<!--  Plugins -->
<script
	src="${pageContext.request.contextPath}/static/assets/script/jquery.smartmenus.js"
	type="text/javascript"></script>
<script
	src="${pageContext.request.contextPath}/static/assets/script/jquery.smartmenus.bootstrap.js"
	type="text/javascript"></script>

<!--  Control for Material Kit -->
<script
	src="${pageContext.request.contextPath}/static/assets/script/material-kit.js"
	type="text/javascript"></script>
<script
	src="${pageContext.request.contextPath}/static/assets/script/langswitcher.js"
	type="text/javascript"></script>
<script
	src="${pageContext.request.contextPath}/static/assets/script/bootstrap-dialog.min.js"
	type="text/javascript"></script>
<script
	src="${pageContext.request.contextPath}/static/assets/script/app.js"
	type="text/javascript"></script>
<script src="//connect.facebook.net/en_US/sdk.js"></script>
<script src="${pageContext.request.contextPath}/static/assets/script/conversion.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/static/assets/script/instafeed.js" type="text/javascript"></script>
<script>




	function fb_share(sUrl, sName, sDesc, sPic, sPid) {
		FB.init({
			appId : '181206772812193',
			xfbml : true,
			version : 'v3.2'
		});
		FB.ui({
			method : 'feed',
			name : sName,
			link : sUrl,
			picture : sPic,
			description : sDesc

		}, function(response) {
			/* if ( response !== null && typeof response.post_id !== 'undefined' ) { */
			if (response !== null) {
				//alert(response);
				var pSucess = 1;
				var pFail = 0;
				console.log("first " + response);
				if (response == undefined) {					
					console.log("If");
					pSucess = 0;
					pFail = 1;
				} else {
					
					console.log("else");
					pSucess = 1;
					pFail = 0;
				}

				$.get("${pageContext.request.contextPath}/secure/saveStatus/web/FB/"+ pSucess + "/" + pFail + "/" + sPid + "/"+ sName).done(function(data) {
					console.log("Done: " + data);
				}).fail(function(e) {

					console.log("Error: " + e);

				});
				// ajax call to save response
				/* $.post("${pageContext.request.contextPath}/secure/saveStatus?${_csrf.parameterName}=${_csrf.token}", { 'shareStatus': response }, function( result ) {
				      console.log( result );
				  }, 'json' ); */
			}
		});

	}
    
    
    
    function tw_share(sUrl, sName, sDesc, sPic, sPid) {
    	var openStatus =true;
    	var new_window = window.open("https://twitter.com/share?url="+sUrl+"&text="+sName, '_blank', 'location=yes,height=400,width=520,scrollbars=yes,status=yes');
    	console.log("new_window "+ new_window);
    
    	/*  var timer = setInterval(function() { 
    	    if(new_window.closed) {
    	        clearInterval(timer);
    	        if(openStatus){
    	        alert('closed');
    	        }
    	    }
    	    else
    	    	{
    	    	alert("OPEN");
    	    	openStatus =false;
    	    	//clearInterval(timer);
    	    	}
    	}, 1000); */ 
    	
    	
    	
    	/* $.get("${pageContext.request.contextPath}/secure/saveStatus/web/twitter/1/0/" + sPid + "/"+ sName).done(function(data) {
			console.log("Done: " + data);
		}).fail(function(e) {

			console.log("Error: " + e);

		});	 */
    	
    
    	//alert(sUrl);
    	//var window = open('url','name','height=300,width=300');
    	//window.document.write('<iframe onLoad="window.opener.callback(this.contentWindow.location);" src="https://twitter.com/intent/tweet?url='+sUrl+'&text='+sName+'"/>');

    }
  
</script>


	<!-- <script>
window.twttr = (function (d, s, id) {
    var t, js, fjs = d.getElementsByTagName(s)[0];
    if (d.getElementById(id)) return; js = d.createElement(s); js.id = id;
    js.src = "https://platform.twitter.com/widgets.js"; fjs.parentNode.insertBefore(js, fjs);
    return window.twttr || (t = { _e: [], ready: function (f) { t._e.push(f) } });
}(document, "script", "twitter-wjs"));







twttr.ready(function (twttr) {
        twttr.events.bind('tweet', function (event) {
            // Do something there
            alert("callback");
        });
        twttr.events.bind('follow', function(event) {
            var followed_user_id = event.data.user_id;
            var followed_screen_name = event.data.screen_name;
        });
 
        twttr.events.bind('retweet', function(event) {
            var retweeted_tweet_id = event.data.source_tweet_id;
        });
 
        twttr.events.bind('favorite', function(event) {
            var favorited_tweet_id = event.data.tweet_id;
        });
});
</script> -->


<script>
	function checkGet() {
		alert("${pageContext.request.contextPath}/secure/saveStatus")

		$.get("${pageContext.request.contextPath}/secure/saveStatus/sucess")
				.done(function(data) {
					console.log("Done: ");
				}).fail(function(e) {

					console.log("Error: " + e);

				});

	}
</script>
<script>
	$(document).ready(function() {

		$('body').on('hidden.bs.modal', '.modal', function() {
			$(this).removeData('bs.modal');
		});

	});

	function mustLoginAlert() {
		BootstrapDialog
				.confirm({
					title : '',
					message : '<spring:message code="Message.SigninRequired" text="You need to login to use this feature." />',
					type : BootstrapDialog.TYPE_WARNING,
					closable : true,
					draggable : true,
					btnCancelLabel : '<spring:message code="label.Cancel" text="Cancel"/>',
					btnCancelClass : 'btn btn-secondary btn-round',
					btnOKLabel : '<spring:message code="label.Login" text="Login"/>',
					btnOKClass : 'btn btn-primary btn-round',
					callback : function(result) {
						if (result) {
							location
									.replace("${pageContext.request.contextPath}/login");
						}
					}
				});
	}

	function confirmRegister(productCode) {
		BootstrapDialog
				.show({
					type : BootstrapDialog.TYPE_WARNING,
					title : '',
					message : '<spring:message code="Message.Shop.ConfirmRegisterPackage" text="Are you sure you want to register?"/>',
					buttons : [
							{
								label : '<spring:message code="label.OK" text="OK"/>',
								cssClass : 'btn btn-primary btn-round',
								autospin : true,
								action : function(dialogRef) {
									dialogRef.enableButtons(false);
									dialogRef.setClosable(false);
									dialogRef
											.getModalBody()
											.html(
													'<i class="fa fa-spin fa-spinner"></i> <spring:message code="label.ProcessingRequest" text="Processing your request, please wait..."/>');
									$
											.get(
													"${pageContext.request.contextPath}/secure/regpkg/"
															+ productCode

											)
											.done(
													function(data) {
														//dialogRef.getModalBody().html(data);
														var arr = data
																.split("|");
														var txtmsg = arr[1];
														dialogRef
																.getModalBody()
																.html(txtmsg);
														dialogRef
																.enableButtons(false);

													})
											.fail(
													function(e) {
														dialogRef
																.getModalBody()
																.html(
																		'<spring:message code="Message.Shop.RegisterFail" text="The registration has failed."/>');
														console.log("Error: "
																+ e);

													}).always(function() {
												setTimeout(function() {
													dialogRef.close();
												}, 3000);
											});
								}
							},
							{
								label : '<spring:message code="label.Cancel" text="Cancel"/>',
								cssClass : 'btn btn-secondary btn-round',
								action : function(dialogRef) {
									dialogRef.close();
								}
							} ]
				});
	}
</script>
</html>
