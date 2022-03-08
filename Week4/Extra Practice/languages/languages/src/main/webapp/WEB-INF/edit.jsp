<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="style.css">
<title>Edit</title>
</head>
<body>
	<div class="form">
	<form:form action="/edit/${languages.id}/process" method="POST" modelAttribute="languages">
    <p>
        <form:label path="name">Name</form:label>
        <form:errors path="name" class="error"/>
        <form:input path="name"/>
    </p>
    <p>
        <form:label path="creator">creator</form:label>
        <form:errors path="creator" class="error"/>
        <form:input path="creator"/>
    </p>
    <p>
        <form:label path="version">version</form:label>
        <form:errors path="version" class="error"/>
        <form:input path="version"/>
    </p>
    <input type="submit" value="Submit"/>
    </form:form>
    </div>
    <a href="/home">Go back</a>
</body>
</html>