<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="style.css">
<title>Coding languages</title>
</head>
<body>
	<div class= table>
	<h1>Coding Languages</h1>
	<table>
		<thead>
			<tr>
				<th>Languages</th>
				<th>creator</th>
				<th>version</th>
				<th>view and edit</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="lang" items="${name}">
			<tr>
				<td>${lang.name}</td>
				<td>${lang.creator}</td>
				<td>${lang.version}</td>
				<td>
					<a href="/edit/${lang.id}"> Edit </a>
					<a href="/view/${lang.id}"> View </a>
					<a href="/delete/${lang.id}"> Delete </a>
				
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	
	</div>
	<div class= "form">
	<h1>Add a Language</h1>
	<form:form action="/new" method="post" modelAttribute="languages">
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
</body>
</html>