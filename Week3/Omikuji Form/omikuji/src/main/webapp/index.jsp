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
	<h1 class="head">Send an Omikuji!</h1>
	<div class="form">
	<form action='/process' method="POST">
		<label for="number">Enter a number:</label>
		<input type="text" name="number">
		<label for="city">Enter a city:</label>
		<input type="text" name="city">
		<label for="name">Enter a name of somebody not yourself:</label>
		<input type="text" name="name">
		<label for="hobby">Enter a hobby:</label>
		<input type="text" name="hobby">
		<label for="thing">Enter anything that exists:</label>
		<input type="text" name="thing">
		<label for="text">Say something nice to someone:</label>
		<textarea name="text" rows="4" cols="50"></textarea>
		<input type="submit" class="btn">
	</form>
	</div>
</body>
</html>