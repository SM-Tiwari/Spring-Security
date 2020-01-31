<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<script>
	//zophim chat
	window.$zopim || (function(d, s) {
	    var z = $zopim = function(c) {
	            z._.push(c)
		},
        $ = z.s =
        d.createElement(s),
        e = d.getElementsByTagName(s)[0];
    		z.set = function(o) {
        		z.set.
        		_.push(o)
    		};
	    z._ = [];
	    z.set._ = [];
	    $.async = !0;
	    $.setAttribute("charset", "utf-8");
	    $.src = "//v2.zopim.com/?3j76JDHQAwr1yxX7ETQeWdLewWf67dUp";
	    z.t = +new Date;
	    $.type = "text/javascript";
	    e.parentNode.insertBefore($, e)
	})(document, "script");
</script>

<c:if test="${!empty userProfile}">
	<script>
	$zopim(function() {
		$zopim.livechat.setName('${userProfile.msisdn}');
		$zopim.livechat.setEmail('${userProfile.emailAddress}');
		$zopim.livechat.setPhone('${userProfile.msisdn}');
	});	
	</script>
</c:if>
	<input type="hidden" id="chatflg" name="chatflg" value="${param.chat}"/>
<!-- Floating Action Button -->
	<div class="action-button-desktop visible-sm visible-md visible-lg visible-xs">
		<button class="act-btn-desktop" type="button" title="<spring:message code='label.FloatMenu.CallUs' text='Call Us'/>" onclick="javascript: window.location.href='callto:${contactus_phoneno}'">
			<img src="${pageContext.request.contextPath}/static/assets/image/ab-phone.png">
		</button>
		<button class="act-btn-desktop" type="button" title="<spring:message code='label.FloatMenu.ContactUs' text='Chat with Us'/>" onclick="javascript: $zopim.livechat.window.show();">
			<img src="${pageContext.request.contextPath}/static/assets/image/ab-chat.png">
		</button>
		<button class="act-btn-desktop" type="button" title="<spring:message code='label.FloatMenu.EmailUs' text='Email Us'/>" onclick="javascript: window.location.href='mailto:${contactus_email_addr}?subject=${contactus_email_subject} [${userProfile.msisdn}]'">
			<img src="${pageContext.request.contextPath}/static/assets/image/ab-mail.png">
		</button>
	</div>
<!-- Floating Action Button: End -->

<!-- Navigation Bar -->
	<nav class="navbar navbar-default">
        <div class="container">
        		<div class="overlay"></div>
           	<div class="navbar-header">
            		<button type="button" class="navbar-toggle pull-left" data-toggle="collapse" data-target="#navbar-content">
            			<span class="sr-only">Toggle navigation</span>
                		<span class="icon-bar"></span>
                		<span class="icon-bar"></span>
                		<span class="icon-bar"></span>
              	</button>
                <button type="button" class="navbar-toggle pull-right" data-toggle="collapse" data-target="#navbar-content2">
                		<c:set var="avatarImage">
                		<c:choose>
                			<c:when test="${!empty userProfile and !empty userProfile.avatar}">${userProfile.avatar}</c:when>
                			<c:otherwise>${pageContext.request.contextPath}/static/assets/image/default-avatar.png</c:otherwise>
                		</c:choose>
                		</c:set>
                		<img class="img-responsive img-rounded photo-profile" src="${avatarImage}" style="padding-bottom:10px;">
            			<!-- <i class="material-icons">person_outline</i> -->
              	</button>
				<button type="button" class="navbar-toggle pull-right">
            			<i class="material-icons">notifications_none
            				<c:if test="${notificationCount gt 0}">
                        <span class="bubble" style="right: -5px!important;">${unreadMessageCount}</span>
                        </c:if>
                    </i>
              	</button>
                <div class="togglebutton langOpt visible-xs">
					<label>
						<input type="checkbox" id="langSwitcher1" class="langSwitch">
					</label>
				</div>
              	<a class="navbar-brand" style="margin-left: -10px;" href="http://vietnamobile.com.vn" target="_blank">
                    <img src="${pageContext.request.contextPath}/static/assets/image/logo-2.png">
              	</a>
            </div>

            <div class="collapse navbar-collapse" id="navbar-content">
				<input type="hidden" id="currentLang" value="${pageContext.response.locale.language}"/> <!-- ${param.lang} -->

				<ul class="nav navbar-nav navbar-left modLeft">
					<sec:authorize access="isAuthenticated()">
					<li <c:choose><c:when test="${activeTopMenu eq 'HOME'}">class="active text-left"</c:when><c:otherwise>class="text-left"</c:otherwise></c:choose>>
						<a href="${pageContext.request.contextPath}/secure/dashboard"><spring:message code="label.TopMenu.Home" text="Home"/></a>
					</li>
					</sec:authorize>
					<li <c:choose><c:when test="${activeTopMenu eq 'SHOP'}">class="active text-left"</c:when><c:otherwise>class="text-left"</c:otherwise></c:choose>>
						<a href="#" class="getFocus"><spring:message code="label.TopMenu.Shop" text="Shop"/></a>
						<ul class="dropdown-menu first">
							<li><a href="${pageContext.request.contextPath}/shop/voice_n_sms"><spring:message code="label.TopMenu.VoiceAndSms" text="Voice and SMS"/></a></li>
							<li><a href="${pageContext.request.contextPath}/shop/data"><spring:message code="label.TopMenu.Data" text="Data"/></a></li>
							<li><a href="#"><spring:message code="label.TopMenu.Contents" text="Contents"/> <span class="caret"></span></a>
								<ul class="dropdown-menu">
									<li><a href="${pageContext.request.contextPath}/shop/vas"><spring:message code="label.TopMenu.VAS" text="VAS"/></a></li>
									<li><a href="#"><spring:message code="label.TopMenu.Entertainment" text="Entertainment"/> <span class="caret"></span></a>
										<ul class="dropdown-menu">
											<li><a href="${pageContext.request.contextPath}/shop/content/music"><spring:message code="label.TopMenu.Music" text="Music"/></a></li>
											<li><a href="${pageContext.request.contextPath}/shop/content/movie/list"><spring:message code="label.TopMenu.Movie" text="Movies"/></a></li>
											<li><a href="${pageContext.request.contextPath}/shop/content/games/list"><spring:message code="label.TopMenu.Games" text="Games"/></a></li>
											<li><a href="${pageContext.request.contextPath}/shop/content/apps/list"><spring:message code="label.TopMenu.Apps" text="Applications"/></a></li>
										</ul>
									</li>
								</ul>
							</li>
							<c:if test="${!userProfile.disabledAppFeatures.contains('SELF_PACKAGE') }">
							<li><a href="${pageContext.request.contextPath}/secure/selfpkg"><spring:message code="label.TopMenu.SelfPackage" text="Self Packages"/></a></li>
							</c:if>
							<li><a href="${pageContext.request.contextPath}/shop/group_sharing"><spring:message code="label.TopMenu.GroupSharing" text="Group Sharing"/></a></li>
						</ul>
					</li>
					<!-- 
					<li <c:choose><c:when test="${activeTopMenu eq 'GAMIFY'}">class="active text-left"</c:when><c:otherwise>class="text-left"</c:otherwise></c:choose>>
						<a href="${pageContext.request.contextPath}/gamify"><spring:message code="label.TopMenu.Gamify" text="Gamify"/></a>
					</li>
					-->
				</ul>

              	<ul class="nav navbar-nav navbar-right visible-md visible-lg">
					<li>
						<div class="togglebutton langOpt desktop">
							<label>
								<input type="checkbox" id="langSwitcher2" class="langSwitch">
							</label>
						</div>
					</li>
					<sec:authorize access="isAuthenticated()">
                    <li <c:if test="${activeTopMenu eq 'NOTIFICATIONS'}">class="active"</c:if>>
                        <a href="${pageContext.request.contextPath}/secure/notifications">
                            	<i class="material-icons">notifications_none<c:if test="${notificationCount gt 0}"><span class="bubble">${notificationCount}</span></c:if></i>
							<p><spring:message code="label.TopMenu.Notifications" text="Notifications"/></p>
						</a>
                    </li>
					</sec:authorize>
                    <li <c:if test="${activeTopMenu eq 'ACCOUNT'}">class="active"</c:if>>
                    		<span class='pull-right' style="padding-top:20px;"> &#x26AC; &#x26AC;</span>
                        <a href="#" class="getFocus">
                        		<img class="img-responsive img-rounded photo-profile" src="${avatarImage}" style="padding-bottom:10px;">  
                        		<!-- 
							<i class="material-icons">person_outline</i>
							<p><spring:message code="label.TopMenu.Account" text="Account"/></p>
                        		 -->
                        </a>
                        <ul class="dropdown-menu">
                        		<sec:authorize access="isAuthenticated()">
							<li class="navUserData" style="width:280px;">
								<h6>${userProfile.details.fullName}</h6>
								<p>${userProfile.msisdn}</p>
								<div class="userDataLabel hidden-xs">
									<span class="label userDataLabelDataType">${userProfile.classOfServiceName}</span>
									<!--
									<span class="label userDataLabelStatus">${userProfile.classOfServiceName}</span>
									<span class="label userDataLabelDataType">${dataBalance.name}</span>
									-->
								</div>
							</li>
                            	<li><a href="${pageContext.request.contextPath}/secure/profile"><span class="material-icons">create</span> <spring:message code="label.TopMenu.Profile" text="Profile"/></a></li>
                            	</sec:authorize>
							<sec:authorize access="isAnonymous()">
							<li class="navUserData" style="width:280px;">
								<h6><spring:message code="label.Guest" text="Guest"/></h6>
							</li>
							</sec:authorize>
                            <li><a href="${pageContext.request.contextPath}/store/all"><span class="material-icons">map</span> <spring:message code="label.TopMenu.StoreList" text="Store List"/></a></li>
                            <li><a href="${pageContext.request.contextPath}/secure/invite/init"><span class="material-icons">face</span> <spring:message code="label.InviteFriends.Title" text="Invite Friends"/></a></li>
                            <li><a href="${pageContext.request.contextPath}/lp/intro"><span class="material-icons">loyalty</span> <spring:message code="label.TopMenu.LoyaltyProgram" text="Loyalty Program"/></a></li>
                            <li><a href="#" onclick="logout('<spring:message code="Message.ConfirmLogout" text="Are you sure to logout?"/>', '<spring:message code="label.Logout" text="Sign Out"/>', '<spring:message code="label.Cancel" text="Cancel"/>');"><span class="material-icons">lock_outline</span> <spring:message code="label.Logout" text="Sign Out"/></a></li>
                        </ul>
                    </li>
               </ul>
                <form:form method="POST" id="logoutForm" action="${pageContext.request.contextPath}/logout"></form:form>
            </div><!-- /.navbar-collapse -->

            <div class="collapse navbar-collapse" id="navbar-content2">
                <ul class="nav navbar-nav navbar-right visible-xs">
					<li>
					<sec:authorize access="isAuthenticated()">
					<li><a href="${pageContext.request.contextPath}/secure/profile"><span class="material-icons">create</span> <spring:message code="label.TopMenu.Profile" text="Profile"/></a></li>	
					</sec:authorize>
					<sec:authorize access="isAnonymous()">
					<li class="navUserData">
						<h6><spring:message code="label.Guest" text="Guest"/></h6>
					</li>
					</sec:authorize>
					<li><a href="${pageContext.request.contextPath}/store/all"><span class="material-icons">map</span> <spring:message code="label.TopMenu.StoreList" text="Store List"/></a></li>
					<li><a href="${pageContext.request.contextPath}/secure/invite/init"><span class="material-icons">face</span> <spring:message code="label.InviteFriends.Title" text="Invite Friends"/></a></li>
					<li><a href="${pageContext.request.contextPath}/lp/intro"><span class="material-icons">loyalty</span> <spring:message code="label.TopMenu.LoyaltyProgram" text="Loyalty Program"/></a></li>
					<li><a href="#" onclick="logout('<spring:message code="Message.ConfirmLogout" text="Are you sure to logout?"/>', '<spring:message code="label.Logout" text="Sign Out"/>', '<spring:message code="label.Cancel" text="Cancel"/>');"><span class="material-icons">lock_outline</span> <spring:message code="label.Logout" text="Sign Out"/></a></li>
               </ul>
            </div>			

    	</div><!-- /.container -->
	</nav>
<!-- Navigation Bar: End -->

