<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%!
	int a;
	int b;
	int c;
%>
<%
     a =Integer.parseInt(request.getParameter("aval"));
	 b =Integer.parseInt(request.getParameter("bval"));
	c = a+b;
%>
Sum of A+B = <%=c %><br>
<%
 out.print("Sum of A+B="+c);
%>

</body>
</html>