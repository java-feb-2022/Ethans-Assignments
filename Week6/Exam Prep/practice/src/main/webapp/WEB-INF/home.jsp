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
	<title>Dashboard</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>

	<div>
		<h1>Welcome, <c:out value="${user.userName}"/></h1>
		<a href="/logout">logout</a>
		<a href="/newProject">Create a new Project</a>
		<h3>All projects</h3>
		<table>
			<tr>
				<th>ID</th>
				<th>Title</th>
				<th>Deadline</th>
				<th> actions </th>
			</tr>
			<c:forEach var="proj" items="${projects}">
				<tr>
					<td><c:out value="${proj.id}"/></td>
					<td><a href="Project/${proj.id}"><c:out value="${proj.title}"/></a></td>
					<td><c:out value="${proj.deadline}"/></td>
					<td><a href = "Project/${proj.id}/edit">Edit</a></td>
				</tr>
			</c:forEach>
		</table>
		<h3>My projects</h3>
		~
	</div>

</body>
</html>