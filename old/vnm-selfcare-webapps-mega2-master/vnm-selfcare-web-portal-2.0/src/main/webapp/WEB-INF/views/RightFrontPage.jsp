<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
					<aside class="features">
						<div class="features-title col-sm-12">
							<h1>
								<!--<spring:message code="label.Frontpage.WhyUse" text="Why" /><br>-->
								<span class="brand"><spring:message code="label.Frontpage.MyVietnamobile" text="MyVietnamobile" /></span>
							</h1>
						</div> <!-- .features-title -->
						<div class="features-body col-sm-12">
							<div class="row">
								<div class="col-sm-6">
									<article class="features-article">
										<img class="icon" src="${pageContext.request.contextPath}/static/assets/image/features-icon-1.png">
										<p><spring:message code="label.Frontpage.Why1" text="Simplified, convenience &amp; secure access to your account" /></p>
									</article>
								</div>
								<div class="col-sm-6">
									<article class="features-article">
										<img class="icon" src="${pageContext.request.contextPath}/static/assets/image/features-icon-2.png">
										<p><spring:message code="label.Frontpage.Why2" text="See your balance, usage, validity, &amp; other status" /></p>
									</article>
								</div>
							</div>
							<div class="row">
								<div class="col-sm-6">
									<article class="features-article">
										<img class="icon" src="${pageContext.request.contextPath}/static/assets/image/features-icon-3.png">
										<p><spring:message code="label.Frontpage.Why3" text="Topup, buy packages, data" /></p>
									</article>
								</div>
								<div class="col-sm-6">
									<article class="features-article">
										<img class="icon" src="${pageContext.request.contextPath}/static/assets/image/features-icon-4.png">
										<p><spring:message code="label.Frontpage.Why4" text="See your loyalty status &amp; redeem rewards" /></p>
									</article>
								</div>
							</div>
							<div class="row">
								<div class="col-sm-6">
									<article class="features-article">
										<img class="icon" src="${pageContext.request.contextPath}/static/assets/image/features-icon-5.png">
										<p><spring:message code="label.Frontpage.Why5" text="Easy &amp; fast contact with our customer care by one click" /></p>
									</article>
								</div>
								<div class="col-sm-6">
									<article class="features-article">
										<img class="icon" src="${pageContext.request.contextPath}/static/assets/image/features-icon-6.png">
										<p><spring:message code="label.Frontpage.Why6" text="Entertainment &amp; Relax" /></p>
									</article>
								</div>
							</div>
						</div> <!-- .features-body -->
						<!--
						<div class="native-app col-sm-12">
							<p><spring:message code="label.Frontpage.Download" text="Download" /> <span class="brand"><spring:message code="label.Frontpage.MyVietnamobile" text="MyVietnamobile" /></span></p>
							<ul>
								<li><a href="http://apple.co/2wAmv7E"><img src="${pageContext.request.contextPath}/static/assets/image/app-store.png" alt="App Store"></a></li>
								<li><a href="http://bit.ly/2w6jybv"><img src="${pageContext.request.contextPath}/static/assets/image/g-play.png" alt="Google Play"></a></li>
							</ul>
						</div>
						 -->
						<div class="native-app col-sm-12">
							<p><spring:message code="label.Frontpage.Download" text="Download"/> <span class="brand"><spring:message code="label.Frontpage.MyVietnamobile" text="MyVietnamobile"/></span></p>
							<div class="row">
								<div class="col-sm-6">
									<h6><spring:message code="label.Frontpage.AppStore" text="App Store"/></h6>
									<p><spring:message code="label.Frontpage.AppStore.Remarks" text="iPhones &amp; iPad with iOS 8.0 or later."/></p>
									<ul>
										<li><a href="http://apple.co/2wAmv7E" target="_blank"><img src="${pageContext.request.contextPath}/static/assets/image/app-store.png" alt="App Store"></a></li>
									</ul>
								</div>
								<div class="col-sm-6">
									<h6><spring:message code="label.Frontpage.GooglePlay" text="Google Play"/></h6>
									<p><spring:message code="label.Frontpage.GooglePlay.Remarks" text="Smartphones with Android 5.0 or later"/></p>
									<ul>
										<li><a href="http://bit.ly/2w6jybv" target="_blank"><img src="${pageContext.request.contextPath}/static/assets/image/g-play.png" alt="Google Play"></a></li>
									</ul>
								</div>
							</div>
						</div>
						<!-- .native-app -->
					</aside> <!-- .features -->
