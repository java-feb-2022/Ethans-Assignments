<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<title>New Ninja</title>
</head>
<body>
	<div class="container bg-dark text-light">
		<h1>New Ninja</h1>
		<form:form action="/ninja/create" method="post" modelAttribute="ninja" class="form-group">
			<form:label path="dojo">Dojo:</form:label>
			<form:select path="dojo" class="form-control">
				<c:forEach var="dojo" items="${allDojos}">
					<form:option value="${dojo.id}" path="dojo">${dojo.name}</form:option>
				</c:forEach>
			</form:select>
			<form:label path="first_name">First Name:</form:label>
			<form:errors path="first_name" class="text-danger"/>
			<form:input path="first_name" class="form-control"/>
			<form:label path="last_name">Last Name:</form:label>
			<form:errors path="last_name" class="text-danger"/>
			<form:input path="last_name" class="form-control"/>
			<form:label path="age">Age:</form:label>
			<form:errors path="age" class="text-danger"/>
			<form:input path="age" class="form-control"/>
			<input type="submit" value="Create Ninja" class="btn btn-success my-2">
		</form:form>
	</div>
</body>
</html>