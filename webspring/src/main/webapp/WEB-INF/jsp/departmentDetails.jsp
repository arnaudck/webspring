<%@page session="true" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="sec"	uri="http://www.springframework.org/security/tags"%>
<html>
<head>
<link rel="stylesheet" href='<c:url value="/resources/css/normalize.css"/>'>
<style>
.blue-button {
	background: #25A6E1;
	filter: progid: DXImageTransform.Microsoft.gradient( startColorstr='#25A6E1',
		endColorstr='#188BC0', GradientType=0);
	padding: 3px 5px;
	color: #fff;
	font-family: 'Helvetica Neue', sans-serif;
	font-size: 12px;
	border-radius: 2px;
	-moz-border-radius: 2px;
	-webkit-border-radius: 4px;
	border: 1px solid #1A87B9
}

table {
	font-family: "Helvetica Neue", Helvetica, sans-serif;
	width: 50%;
}

th {
	background: SteelBlue;
	color: white;
}

td, th {
	border: 1px solid gray;
	width: 25%;
	text-align: left;
	padding: 5px 10px;
}
</style>
</head>

<body>

	<%@ include file="/resources/menu.jsp" %>
	
	<form:form method="post" modelAttribute="department" action="${pageContext.request.contextPath}/addDepartment">
		<table>
			<tr>
				<th colspan="2"><spring:message code="department.add" /></th>
			</tr>
			<tr>
				<form:hidden path="id" />
				<td><form:label path="name"><spring:message code="department.name" />:</form:label></td>
				<td><form:input path="name" size="30" maxlength="50"></form:input></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" class="blue-button" value='<spring:message code="department.submit" />' /></td>
			</tr>
		</table>
	</form:form>
	<br>
	<h3><spring:message code="department.list" /></h3>
	<c:if test="${!empty listDepartments}">
		<table class="tg">
			<tr>
				<th width="80">Id</th>
				<th width="120"><spring:message code="department.name" /></th>
				<sec:authorize access="hasAnyRole('ADMIN')">
				<th width="60"><spring:message code="department.edit" /></th>
				<th width="60"><spring:message code="department.delete" /></th>
				</sec:authorize>
			</tr>
			<c:forEach items="${listDepartments}" var="department">
				<tr>
					<td>${department.id}</td>
					<td>${department.name}</td>
					<sec:authorize access="hasAnyRole('ADMIN')">
					<td>
						<a href="<c:url value='/updateDepartment/${department.id}' />"><spring:message code="department.edit" /></a>
					</td>
					<td>
						<a href="<c:url value='/deleteDepartment/${department.id}' />"><spring:message code="department.delete" /></a>
					</td>
					</sec:authorize>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>