<%@page import="in.co.rays.bean.UserBean"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
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
	   int pageNo = (int)request.getAttribute("pageNo");
	
	  int index  = ((pageNo - 1) * 5 ) + 1;
	
		List list = (List) request.getAttribute("list");
		Iterator it = list.iterator();
	%>
<%@ include file = "Header.jsp" %>
	<form action="UserListCtl"method="post">
	<table>
	<tr>
		<td><input type="text" name="firstName"></td>
		<td><input type = "submit" name = "operation" value = "search"></td>
				
		</tr>
		</table>
		<table border="1">
		
			<tr>
				
				<th>S. No.</th>
				<th>FirstName</th>
				<th>LastName</th>
				<th>LoginId</th>
				<th>Password</th>
				<th>DOB</th>
				<th>Address</th>
				<th>Edit</th>
			</tr>
			<% while(it.hasNext()){
				
				 UserBean bean  =(UserBean)it.next();
				%>
				<tr>
				<td><%=index++%></td>
				<td><%=bean.getFirst_name() %></td>
				<td><%=bean.getLast_name() %></td>
				<td><%=bean.getLogin_id() %></td>
				<td><%=bean.getPassword() %></td>
				<td><%=bean.getDob() %></td>
				<td><%=bean.getAddress() %></td>
				<td> <a href ="UserCtl?id=<%=bean.getId()%>">edit</td>
				</tr>
			
			<% }%>
			
		
		</table>
		
		<table>
	<tr>
		
		<td><input type = "submit" name = "operation" value = "previous"></td>
		<td><input type = "submit" name = "operation" value = "next"></td>
				
		</tr>
		</table>
		
		<input type = "hidden" name = "pageNo" value ="<%= pageNo %>" >
		
	</form>
	
	
	
</body>
</html>