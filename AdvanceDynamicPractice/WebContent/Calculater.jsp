<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
	<form action="multi.jsp">
		<table>
			<tr>
				<th>First Number</th>
				<td><input type = "number" name = "firstNumber"></td>

				
			</tr>
			<tr>
				<th>Second Number</th>
				<td><input type = "number" name = "secondNumber"></td>

				
			</tr>
			<tr>
				<th>
				<td>
				<input type = "radio" name = "r1" value = "add">+
				<input type = "radio" name = "r1" value = "sub">-
				<input type = "radio" name = "r1" value = "mul">*
				<input type = "radio" name = "r1" value = "divide">/
				</td>
                 </th>
				
			</tr>
			<tr>
				<th></th>
				<td><button>Submit</button></td>

				
			</tr>
		</table>


	</form>
</body>
</html>