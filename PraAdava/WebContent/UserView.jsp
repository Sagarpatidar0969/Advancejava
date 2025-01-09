<%@page import="in.co.rays.bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file = "Header.jsp" %>
	<%
		UserBean bean = (UserBean) request.getAttribute("bean");
	
	%>
	<form action="UserCtl" method="post">
		<table>
		<tr>
			
				<td> <input type = "hidden" name = "id" value ="<%=(bean != null)?bean.getId() : "" %>"></td>
			</tr>
			<tr>
				<th>First name</th>
				<td> <input type = "text" name = "firstName" value = "<%=(bean != null)?bean.getFirst_name() : "" %>"></td>
			</tr>
			<tr>
				<th>Last name</th>
				<td> <input type = "text" name = "lastName" value = "<%=(bean != null)?bean.getLast_name()  : "" %>"></td>
			</tr>
			<tr>
				<th>Login id</th>
				<td> <input type = "text" name = "loginId" value = "<%=(bean != null)?bean.getLogin_id() : "" %>"></td>
			</tr>
			<tr>
				<th>Password</th>
				<td> <input type = "text" name = "password" value = "<%=(bean != null)?bean.getPassword()  : "" %>"></td>
			</tr>
			<tr>
				<th>dobb</th>
				<td> <input type = "Date" name = "dob" value = "<%=(bean != null)?bean.getDob() : "" %>"></td>
			</tr>
			<tr>
				<th>Address</th>
				<td> <input type = "text" name = "address" value = "<%=(bean != null)?bean.getAddress() : "" %>"></td>
			</tr>
			<tr>
				<th></th>
				<td> <input type = "submit" name = "operation" value = "<%=(bean != null)?"update" : "save" %>"></td>
			</tr>
		</table>
	</form>
</body>
</html>