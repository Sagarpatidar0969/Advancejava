<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%  int a = Integer.parseInt(request.getParameter("firstNumber"));
    int b = Integer.parseInt(request.getParameter("secondNumber"));
    String ob = request.getParameter("r1");
    if(ob.equals("add")){
    	int add = a + b;
    	out.print("adding :.." + add);	
    }
    else if(ob.equals("sub")){
    	int sub = a - b;
    	out.print("subtraction:.." + sub);
    }
    else if(ob.equals("mul")){
    	int mul = a * b;
    	out.print("multiplay:.." + mul);
    }
    
    else if (ob.equals("divide")){
    	int divide = a/b;
    	out.print("divided:.." + divide);
    }
%>
</body>
</html>