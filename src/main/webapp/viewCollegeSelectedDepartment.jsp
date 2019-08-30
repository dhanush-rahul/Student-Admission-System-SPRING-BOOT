<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.example.demo.bean.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
<th>Name</th>
<th>Board</th>
<th>School Name</th>
<th>College Name</th>
<th>Department Choice</th>


<%
			ArrayList<SelectedStudents> list = (ArrayList<SelectedStudents>) request.getAttribute("collegeselectedDepartment");
			
			for(SelectedStudents dept: list){
				%>
				<tr>

					<td><%= dept.getStudentUsername()%></td>
					<td><%= dept.getBranch()%></td>
					<td><%= dept.getSchoolName()%></td>
					<td><%= dept.getCollegeName()%></td>
					<td><%= dept.getDepartment()%></td> 
			
				</tr>
			<%	}
			%>
			</table>
</body>
</html>