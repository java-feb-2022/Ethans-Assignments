<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>counter</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<div>
		<h1>You have visited <c:out value="${count}"/> times</h1>
		<a href="/">Reload</a>
	</div>
</body>
</html>