<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.example.demo.bean.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%Applications applicationbean = (Applications) session.getAttribute("application"); 
session.setAttribute("applicationbean", applicationbean);
ArrayList<Colleges> collegebean = (ArrayList<Colleges>) session.getAttribute("colleges");
int count=0;
%>
<form action="RegisterAgain" method="post">
<table>
<tr><td>Student Username :</td><td><%=applicationbean.getStudentUsername()%><td></tr>
<tr><td>School Name :</td><td><%=applicationbean.getSchoolName() %></td></tr>
<tr><td>Branch :</td><td><%=applicationbean.getBranch() %></td></tr>
<tr><td>Total Marks :</td><td><%=applicationbean.getTotalMarks() %></td></tr>
<tr><td>Percentage :</td><td><%=applicationbean.getPercentage()%></td></tr>
<tr><td>GPA :</td><td><%=applicationbean.getGpa() %></td></tr>
<tr><td>College Name :</td><td><%=applicationbean.getCollegeName() %></td></tr>
<tr><td>Department Choosed :</td><td><%=applicationbean.getDepartment() %></td></tr>
<tr><h3>The college you have applied to has either rejected you or there are no seats left in the chosen department.
Choose another college to re-register and click register.</h3></tr>

<tr>
					<td>Choose college: </td>
					<td><select name="college">
					
  						  <%for(Colleges college : collegebean) {count++;if(count==1) continue;%>
				       			 <option value="<%=college.getCollegeName()%>"><%=college.getCollegeName()%></option>
				       			 <%} %><td>
				 		  
					</select>
				</tr>
				<tr>
					<td>Choose department*</td>
					<td><select name="dept_choice">
							<option value="CSE">CSE</option>
							<option value="ECE">ECE</option>
							<option value="IT">IT</option>
							<option value="MECH">MECH</option>
					</select></td>
				</tr>
				

<tr><td><input type="submit" value="Register again"></a></td></tr>
</table>
</body>
</html>