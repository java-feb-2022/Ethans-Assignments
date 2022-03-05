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
	<form:form action="/edit/${expenses.id}/process" method="PUT" modelAttribute="expenses">
	<input type="hidden" name="_method">
    <p>
        <form:label path="name">Name</form:label>
        <form:errors path="name" class="error"/>
        <form:input path="name"/>
    </p>
    <p>
        <form:label path="vendor">vendor</form:label>
        <form:errors path="vendor" class="error"/>
        <form:input path="vendor"/>
    </p>
    <p>
        <form:label path="amount">amount</form:label>
        <form:errors path="amount" class="error"/>
        <form:input type="number" step = "0.01" path="amount"/>
    </p>
    <p>
        <form:label path="description">Description</form:label>
        <form:errors path="description" class="error"/>     
        <form:textarea path="description"/>
    </p>    
    <input type="submit" value="Submit"/>
    </form:form>
    </div>
    <a href="/home">Go back</a>
</body>
</html>