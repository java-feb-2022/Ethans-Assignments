<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Date</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<div class="home">
		<h1 class="green"><c:out value="${date}"/></h1>
	</div>
	<h1>Yeah, they're the same on purpose.</h1>
</body>
</html>