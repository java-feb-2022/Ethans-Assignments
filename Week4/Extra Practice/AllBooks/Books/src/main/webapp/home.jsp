<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All books</title>
</head>
<body>
	<h1>All Books</h1>
<table>
    <thead>
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Language</th>
            <th>Number of Pages</th>
        </tr>
    </thead>
    <tbody>
    	<c:forEach var="book" items="${allbooks}">
    	<tr>
    		<td>${book.id}</td>
    		<td><a href="/${book.id}">${book.title}</a></td>
    		<td>${book.lang}</td>
			<td>${book.pages}</td>
    	</tr>
    	</c:forEach>
    </tbody>
</table>
<h2><a href = "/new">Create Book!</a></h2>
</body>
</html>