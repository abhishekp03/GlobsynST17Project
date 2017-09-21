<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" type="text/css" href="css/Header.css">
<title>Interview Details</title>
</head>

<body>

<div id="header">
	<img class="center" src="Images/JobsPikr.png">
</div>

<%
	int app_id = Integer.parseInt(request.getParameter("id"));
	String cemail = null;
	int job_id = 0;
	String message = null;
%>
		
<% 
	try{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/GlobsynST17ProjectDB" , "abhishekp03" , "d!ve!nnow");
		PreparedStatement ps = con.prepareStatement("SELECT email, job_id FROM applist WHERE app_id=?;");
		ps.setInt(1, app_id);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			cemail = rs.getString("email");
			job_id = rs.getInt("job_id");
		}
%>
<div style="margin: 0 auto;">
<br><br><br><br>	
	<form action=CallUp method="post">
		<table align="center" style="min-width:600px;">
			<tr>
			<td>Application #ID: </td>
			<td><input name="app_id" type="text" value="<%=app_id%>" readonly></td>
			</tr>
			<tr>
			<td>Job #ID: </td>
			<td><input name="job_id" type="text" value="<%=job_id%>" readonly></td>
			</tr>
			<tr>
			<td>Date: </td>
			<td><input name="date" type="date"></td>
			</tr>
			<tr>
			<td>Time: </td>
			<td><input name="time" type="time"></td>
			</tr>
			<tr>
			<td>Place: </td>
			<td><input name="place" type="text"></td>
			</tr>
		</table>
		<br><br>
		<input type="submit" value="Confirm">
	</form>
</div>			
<% 	
	}
	catch(Exception e){
		e.printStackTrace();
	}
%>


<div id="footer">
	<p><font color="#505050" size="2" face="Georgia">&copy; Copyright 2017. All rights reserved.<br>Best viewed on a resolution of 1920 x 1080 on Google Chrome.</font></p>
</div>

</body>
</html>