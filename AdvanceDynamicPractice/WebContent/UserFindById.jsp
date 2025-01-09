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
				<th>Enter ID</th>
				<td><input type = "number" name =  "id"> </td>
			</tr>
			<tr>
				<th></th>
				<td><input type = "radio" name =  "r1" value = "FindById"></td>
			</tr>
			<tr>
				<th></th>
				<td><button>Submit</button></td>
			</tr>
		</table>
</form>
</body>
</html>