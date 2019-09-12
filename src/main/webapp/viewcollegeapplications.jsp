<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.comakeit.sas.bean.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>College Applications</title>
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
<th>View </th>

<%

ArrayList<Applications> list = (ArrayList<Applications>) request.getAttribute("collegeApplications");
for(Applications applications : list)
{
%>
	<tr>
			<td><%=applications.getStudentUsername()%></td>
			<td><%=applications.getSchoolName() %></td>	
			<td><%=applications.getBranch()%></td>
			<td><%=applications.getTotalMarks()%></td>
			<td><%=applications.getPercentage()%></td>
			<td><%=applications.getGpa()%></td>
			<td><%=applications.getDepartment()%></td>
			<td><%=applications.getCollegeName()%></td>
			<td><a href="/ViewParticular?varname=<%=applications.getStudentUsername()%>">View</a></td>
	</tr>		
		<%} %>			
					</table>
						<a href="collegeadmin.jsp"><input type="button" value="Back"></a>
					
</body>
</html>