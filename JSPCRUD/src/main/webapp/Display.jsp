<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
try {
			Class.forName("com.mysql.jdbc.Driver"); // JAR file 
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/crudapp","root", "root");
			Statement stmt= con.createStatement();
			ResultSet rs=stmt.executeQuery("Select * from employee");
			
		
			
			while (rs.next()) {
out.print(rs.getInt(1)+": "+rs.getString(2)+": "+rs.getInt(3)+": "+rs.getInt(4)+": "+rs.getString(5));
		out.print("<br>");		
			}
			
			out.print("<h2> Successfully ...!</h2>");
		}
		catch (Exception e) {
			System.out.println(e);
		}
%>
</body>
</html>