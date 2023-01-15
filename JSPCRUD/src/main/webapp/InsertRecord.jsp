<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%!
int uid;
String uname;
int uage;
int usalary;
String udesig;
%>
<%
uid = Integer.parseInt(request.getParameter("uid"));
uname= request.getParameter("uname");
uage = Integer.parseInt(request.getParameter("uage"));
usalary = Integer.parseInt(request.getParameter("usalary"));
udesig= request.getParameter("udesig");

try {
	Class.forName("com.mysql.jdbc.Driver"); // JAR file 
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/crudapp","root", "root");
	PreparedStatement pstmt=con.prepareStatement(" insert into employee values(?,?,?,?,?)");
	pstmt.setInt(1, uid);
	pstmt.setString(2, uname);
	pstmt.setInt(3, uage);
	pstmt.setInt(4, usalary);
	pstmt.setString(5, udesig);
	
	pstmt.execute();
	pstmt.close();
	
	out.print("<h2>Hi Data InsertedSuccesssfully...!</h2>");
}
catch (Exception e) {
	System.out.println(e);
}


%>
</body>
</html>