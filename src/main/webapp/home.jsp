<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Login Page</title>
</head>
<body>
<img src="/home/dhanush/Downloads/download.jpeg">
		<form action="login" method=post>
		<div id="form-wrapper" style="max-width: 500px; margin: auto;">
		<table>
		<tr><td>Admin Username: </td><td><input type="text" name="adminusername" required></td></tr>
		<tr><td>Admin Password: </td><td><input type="text" name="adminpassword" required></td></tr>
		<tr><td><input type="submit" value="Login"></td></tr>
		<tr><td><a href="studentlogin.jsp"><input type="button" value="Student Login"></a></td></tr>
		<tr><td><a href="admissionForm"><input type="button" value="Student Registration"></a></td></tr>
		
		</table>
		</div>
		</form>
</body>
</html>