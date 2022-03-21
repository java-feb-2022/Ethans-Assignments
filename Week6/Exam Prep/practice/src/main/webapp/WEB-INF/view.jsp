<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Project</title>
</head>
<body>
	<h1>${proj.title}</h1>
	<h3>Description ${proj.description}</h3>
	<h3>Deadline ${proj.deadline}</h3>
	<h3>Created by: ${user.userName}</h3>
	<a href = "/home">Back</a>
</body>
</html>