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

	<h1>Add to Your Book Shelf</h1>

	<a href="/home">Back to Shelves</a>

	<div class="container">
		<form:form action="/books" modelAttribute="book" class="form" method="post">
		
			<div>
			 	<form:errors path="title" class="error"/>
				<form:label for="title" path="title">Title:</form:label>
				<form:input type="text" path="title"/>
			</div>
			
			<div>
				<form:errors path="author" class="error"/>
				<form:label for="author" path="author">Author:</form:label>
				<form:input type="text" path="author" />
			</div>
			
			<div>
				<form:errors path="thoughts" class="error"/>
				<form:label for="thoughts" path="thoughts">Thoughts:</form:label>
				<form:textarea path="thoughts" />
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