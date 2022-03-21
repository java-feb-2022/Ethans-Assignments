<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page isErrorPage="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>create</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
<div class="container">

	<h1>Edit</h1>

	<a href="/home">Dashboard</a>

	<div class="container">
		<form:form action="/Project" modelAttribute="project" class="form" method="post">
			<input type="hidden" name="_method" value="put"/>
			<div>
			 	<form:errors path="title" class="error"/>
				<form:label for="title" path="title">Title:</form:label>
				<form:input type="text" path="title"/>
			</div>
			
			<div>
				<form:errors path="description" class="error"/>
				<form:label for="description" path="description">description:</form:label>
				<form:input type="text" path="description" />
			</div>
			<div>
				<form:errors path="deadline" class="error"/>
				<form:label for="deadline" path="deadline">deadline:</form:label>
				<form:input type="date" path="deadline" />
			</div>
			<div>
				<form:errors path="user" class="error"/>
				<form:input type="hidden" path="user" value="${user.id}"/>
			</div>
			
			<div>
				<input type="submit" value="Submit"/>
			</div>
			
		</form:form>
	</div>
</div>
</body>
</html>