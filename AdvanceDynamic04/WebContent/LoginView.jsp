<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="Header.jsp"%>




	<form action="UserLoginCtl" method="post">

		<%
		String uri =	(String)request.getAttribute("uri");
			
			String msg = (String) request.getAttribute("msg");
		%>
		<td><input type = "hidden" name = "uri" value = "<%=uri %>"></td>

		<table>
			<tr>
				<%
					if (msg != null) {
				%>
				<%=msg%>
				<%
					}
				%>
				<table>
					<tr>
						<th>Login id</th>
						<td><input type="text" name="loginId"></td>
					</tr>
					<tr>
						<th>Password</th>
						<td><input type="text" name="password"></td>
					</tr>
					<tr>
						<th></th>
						<td><input type="submit" value="submit"></td>
					</tr>
					
					
					<a href="UserRegistrationCtl"><b>SignUp</b></a>


				</table>
				</form>
</body>
<%@ include file="Footer.jsp"%>
</html>