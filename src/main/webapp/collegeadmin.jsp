<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.comakeit.sas.bean.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>College Admin Functionalities</title>
</head>
<body>
<%Colleges college =(Colleges) session.getAttribute("college"); 
out.println(college.getCollegeName()); out.println(college.getCollegeCode());
%>
<form action="collegeAdminFunc" method=post>

<input type="radio" name="adminfunc" value="1" required>View Applications<br>
<input type="radio" name="adminfunc" value="2" required>View Selected Students<br>
<input type="radio" name="adminfunc" value="3" required>View Selected Students department wise<br>

<input type="submit" value="submit">
<a href = "login.jsp"><input type="button" value="Logout"></a>
</form>
</body>
</html>