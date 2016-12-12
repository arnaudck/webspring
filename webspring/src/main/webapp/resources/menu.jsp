<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="sec"	uri="http://www.springframework.org/security/tags"%>

<head>
<link rel="stylesheet" href='<c:url value="/resources/css/menu.css"/>'>
</head>

<body>
<div id="lang">
	<div style="float: left;">
		<spring:message code="app.language" />:
			&nbsp<a href="?lang=en" title='<spring:message code="app.en" />'><img src='<c:url value="/resources/img/locales/en.png"/>'></a>
			&nbsp<a href="?lang=fr" title='<spring:message code="app.fr" />'><img src='<c:url value="/resources/img/locales/fr.png"/>'></a>
			&nbsp<a href="?lang=es" title='<spring:message code="app.es" />'><img src='<c:url value="/resources/img/locales/es.png"/>'></a>
	</div>
	<div style="float: right;">
		<sec:authorize access="isAuthenticated()">
		<form action='<c:url value="/logout" />' method="POST">
			<input type="submit" value='<spring:message code="app.logout" />'>
		</form>
		</sec:authorize>
	</div>
</div>

<nav id="menu">
	<ul>
		<li><a href='<c:url value="/home" />'><spring:message code="menu.home" /></a></li>
		<li><a href='<c:url value="/getAllDepartments" />'><spring:message code="menu.departments" /></a></li>
		<li></li>
		<li><a href='<c:url value="/hello" />'><spring:message code="menu.hello" /></a></li>
	</ul>
</nav>
</body>
