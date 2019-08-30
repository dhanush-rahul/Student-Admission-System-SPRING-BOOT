<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.example.demo.bean.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%Applications applicationbean = (Applications) session.getAttribute("application"); 
%>
<table>
<tr><td>Student Username :</td><td><%=applicationbean.getStudentUsername()%><td></tr>
<tr><td>School Name :</td><td><%=applicationbean.getSchoolName() %></td></tr>
<tr><td>Branch :</td><td><%=applicationbean.getBranch() %></td></tr>
<tr><td>Total Marks :</td><td><%=applicationbean.getTotalMarks() %></td></tr>
<tr><td>Percentage :</td><td><%=applicationbean.getPercentage()%></td></tr>
<tr><td>GPA :</td><td><%=applicationbean.getGpa() %></td></tr>
<tr><td>College Name :</td><td><%=applicationbean.getCollegeName() %></td></tr>
<tr><td>Department Choosed :</td><td><%=applicationbean.getDepartment() %></td></tr>
<tr><td>Status: </td><td><%=applicationbean.getStatus() %></td></tr>
</body>
</html>