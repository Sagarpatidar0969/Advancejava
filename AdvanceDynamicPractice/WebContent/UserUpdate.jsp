<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	 <form action="UserAllCtl" method="post">
		<table>
		<tr>
				<th> Enter Id</th>
				<th><input type = "number" name = "id"></th>
			</tr>
			<tr>
				<th> Enter Name</th>
				<th><input type = "text" name = "fname"></th>
			</tr>
			<tr>
				<th> Enter Last Name</th>
				<td><input type = "text" name = "lname"></td>
			</tr>
			<tr>
				<th> Login Id</th>
				<td><input type = "text" name = "loginId"></td>
			</tr>
			<tr>
				<th>Password</th>
				<td><input type = "text" name = "password"></td>
			</tr>
			<tr>
				<th> DOB</th>
				<td><input type = "date" name = "dob"></td>
			</tr>
			<tr>
				<th> Address</th>
				<td><input type = "text" name = "address"></td>
			</tr>
			<tr>
				<th></th>
				<td><input type = "radio" name = "r1" value = "Update" > Update</td>
			</tr>
			<tr>
				<th></th>
				<td><input type = "submit" ></td>
			</tr>
			
		</table>


	</form> 
</body>
</html>