<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="registerUser" method ="post">
Name        :<input type="text" name="name">
Email       :<input type="text" name="email">
Phone No 	:<input type="number" name="number">
Password    :<input type="text" name="password">
Confirm Password :<input type="text" name="confirmPassword">
<button type="submit">Register</button>
	</form>
</body>
</html>