<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Select Department</title>
</head>
<body>
<%@include file="collegeadmin.jsp"%>

					 
						<form action="/DeptSelected">
						<p>Choose department :</p>
						<input type="radio" name="dept" value="CSE" required>CSE
						<input type="radio" name="dept" value="ECE" required>ECE 
						<input type="radio" name="dept" value="IT" required>IT
						<input type="radio" name="dept" value="MECH" required>MECH 
						<input type="submit" value="View">
						</form> 
</body>
</html>