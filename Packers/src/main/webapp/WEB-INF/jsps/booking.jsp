<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form method = "post" action="booking">
<pre>
<input type="text" value = "${id}"name= "custId">
Welcome ${name}
Shifting From: <input type="text" name="shiftingFrom">
Shifting To: <input type="text" name="shiftingTo">
Date:<input type="text" name="date">
<button type="submit" >Book</button>
</pre>
</form>

</body>
</html>