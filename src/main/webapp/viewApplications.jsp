<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.example.demo.bean.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border=1>
<th>Student Username</th>
<th>School Name</th>
<th>Branch</th>
<th>Total Marks</th>
<th>Percentage</th>
<th>GPA</th>
<th>Department</th>
<th>College Choosed</th>
<th>Status</th>

<%
ArrayList<Applications> list = (ArrayList<Applications>) request.getAttribute("applications");
for(Applications applications : list)
{
%>
	<tr>
	<%
		%>
			<td><%=applications.getStudentUsername()%></td>
			<td><%=applications.getSchoolName() %></td>	
			<td><%=applications.getBranch()%></td>
			<td><%=applications.getTotalMarks()%></td>
			<td><%=applications.getPercentage()%></td>
			<td><%=applications.getGpa()%></td>
			<td><%=applications.getDepartment()%></td>
			<td><%=applications.getCollegeName()%></td>
				<td><%=applications.getStatus()%></td>
	</tr>		
		<%} %>			
					</table>
</body>
</html>