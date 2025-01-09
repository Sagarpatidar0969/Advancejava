<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		int id = Integer.parseInt(request.getParameter("id"));
		String e_name = request.getParameter("name");
		String e_salary = request.getParameter("salary");
		String e_mail = request.getParameter("email");
		String e_dept = request.getParameter("dept");
	%>

<form action="">
	<table border = "10">
		<tr>
			<th>Employee_Id</th>
			<th>Employee_Name</th>
			<th>Salary</th>
			<th>Email</th>
			<th>Department</th>
		</tr>
		<tr>
		
		<td> <%= id %> </td>
		<td> <%= e_name %> </td>
		<td> <%= e_salary  %> </td>
		<td> <%= e_mail %> </td>
		<td> <%=e_dept %> </td>
		<tr>
		
		</tr>
	</table>
</form>

	
</body>
</html>