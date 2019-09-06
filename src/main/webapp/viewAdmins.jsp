<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.example.demo.bean.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admins List</title>
</head>
<body>
<table border=1>
<% ArrayList<Login> loginbean =(ArrayList<Login>) request.getAttribute("admins"); 
int count=0;
for(Login login : loginbean)
{ count++;
%>
	<tr>
	<%if(count==1)
		continue;
	Colleges collegebean = login.getCollegeCode(); %>
			<td><%=login.getAdminusername()%></td>
			<td><%=collegebean.getCollegeName() %></td>
			<td><%=collegebean.getCollegeCode()%></td>
	</tr>		
		<%} %>			
					</table>

</body>
</html>