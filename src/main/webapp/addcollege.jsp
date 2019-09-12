<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add College and Admin</title>
</head>
<body>
	<form method=post action="addcollege">
		<table>
			<tr>
				<td>Enter Name of the college:</td>
				<td><input type="text" name="collegeName" required></td>
			</tr>
			<tr>
				<td>Enter College Code:</td>
				<td><input type="text" name="collegeCode" required></td>
			</tr>
			<tr>
				<td>Enter College Admin Username:</td>
				<td><input type="text" name="adminName" required></td>
			</tr>
			<tr>
				<td>Enter College Admin Password:</td>
				<td><input type="text" name="adminPassword" required></td>
			</tr>
			<tr>
				<td><input type="submit" value="Add college" required></td>
			</tr>
			<tr>
				<td><a href="admin.jsp"><input type="button" value="Back"></a></td>
			</tr>
		</table>
</body>
</html>