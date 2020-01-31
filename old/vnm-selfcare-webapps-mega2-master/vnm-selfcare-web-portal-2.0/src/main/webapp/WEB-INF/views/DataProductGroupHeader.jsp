<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

	<div class="header-general">
		<div class="container">
			<div class="col-sm-11 col-sm-offset-1">
				<ul>
					<li><a href="${pageContext.request.contextPath}/shop/voice_n_sms"><spring:message code="label.TopMenu.Shop" text="Shop"/></a></li>
					<li><a href="${pageContext.request.contextPath}/shop/data"><spring:message code="label.TopMenu.Data" text="Data"/></a></li>
				</ul>
				<h1><spring:message code="label.TopMenu.Data" text="Data"/></h1>
			</div>
		</div>
	</div>