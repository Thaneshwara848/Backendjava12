<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="pink">
<marquee><h1>Hi Welcome to JSP page </h1></marquee>
<%! 
	int x=100;
	int y=200;
	int z;
%>
<%
	z=x+y;
%>
The sum of X + Y : <%=z %>
</body>
</html>

