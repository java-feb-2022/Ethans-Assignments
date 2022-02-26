<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Omikuji</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1 class="head">Here's your Omikuji</h1>
	<div class="space">
	<h1><c:out value="${Omikuji}"/></h1>
	</div>
	<div class="a"><a href="/Omikuji">Go back</a></div>
</body>
</html>