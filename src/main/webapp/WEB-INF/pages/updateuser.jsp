<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Find User by Id then edit</title>
</head>
<body>
	Enter the id to find user with the Id, if the user exists it will edit
	<br />
	<form method="post">
		ID: <input type="number" name="id" /> <br />
		Name: <input type="text" name="uname" /> <br /> 
		Password: <input type="password" name="pass" /><br /> 
		Email: <input type="email" name="email" /> <br /> 
		City: <input type="text" name="city" /> <br /> 
		<br />
		<button type="submit">update user</button>
	</form>
</body>
</html>