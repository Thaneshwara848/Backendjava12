<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Hi WElcome to JSP Page </h1>
<%!
int a=100;
int b=200;
int c;
%>
<%
   c=a+b;
%>

The sum of A+B = <%=c %>









</body>
</html>