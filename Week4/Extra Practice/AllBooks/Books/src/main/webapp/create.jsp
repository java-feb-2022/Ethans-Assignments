<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create new Book</title>
</head>
<body>
	<form action="/process" method="post">
		<label for="title">Enter book title:</label>
		<input type="text" name="title">
		<label for="desc">Enter book description:</label>
		<input type="text" name="desc">
		<label for="lang">Enter book language:</label>
		<input type="text" name="lang">
		<label for="pages">Enter book pages:</label>
		<input type="text" name="pages">
		<input type="submit">
	</form>
</body>
</html>