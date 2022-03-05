<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="style.css">
<title>Expenses</title>
</head>
<body>
	<div class= table>
	<h1>Save Travels</h1>
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Expense</th>
				<th>Vendor</th>
				<th>Amount</th>
				<th>view and edit</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="exp" items="${name}">
			<tr>
				<td>${exp.id}</td>
				<td>${exp.name}</td>
				<td>${exp.vendor}</td>
				<td>${exp.amount}</td>
				<td>
					<a href="/edit/${exp.id}"> Edit </a>
					<a href="/view/${exp.id}"> View </a>
					<a href="/delete/${exp.id}"> Delete </a>
				
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	
	</div>
	<div class= "form">
	<h1>Add an expense</h1>
	<form:form action="/new" method="post" modelAttribute="expenses">
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
</body>
</html>