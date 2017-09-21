<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*, java.io.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/Header.css">
<style>

table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    table-layout: fixed;
    width: auto;
}
	
td, th {
    border: 1px solid black;
    text-align: left;
    padding: 8px;
}
	
th {
	background-color: #C8D6A2;
}
	
tr:nth-child(even) {
    background-color: #dddddd;
}
	
</style>
<title>Profile</title>
</head>

<body>

<div id="header">
	<img class="center" src="Images/JobsPikr.png">
</div>

<div id="main" style="min-height: 650px; text-align:center">

<% 
int app_id = Integer.parseInt(request.getParameter("id"));
String fname = null;
String lname = null;
String name = null;
String degree = null;
String stream = null;
String qualification=null;
String exp = null;
String email = null;
Long phone = 0L;

try{
	Class.forName("com.mysql.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/GlobsynST17ProjectDB", "abhishekp03", "d!ve!nnow");
	PreparedStatement ps = con.prepareStatement("SELECT c.fname, c.lname, c.degree, c.stream, c.exp, c.email, c.phone FROM applist a, candidateProfile c WHERE a.app_id=? and a.email=c.email;");
	ps.setInt(1, app_id);
	ResultSet rs = ps.executeQuery();
	while(rs.next()){
		fname = rs.getString("c.fname");
		lname = rs.getString("c.lname");
		name = fname + " " + lname;
		degree = rs.getString("c.degree");
		stream = rs.getString("c.stream");
		qualification = degree + " in " + stream;
		exp = rs.getString("c.exp");
		email = rs.getString("c.email");
		phone = rs.getLong("c.phone");
%>

<br><br><br><br>

<div id="picture" style="margin:0 auto; text-align:center;">
	<img src="ViewImage.jsp?name=<%=email %>" />
</div><br><br>

<a target="_blank" href="ViewResume.jsp?name=<%=email %>" style="text-decoration: none;">View Resume</a>
<br><br>

<table width="400px" align="center" cellspacing="0px" cellpadding="5px">

<tr>
	<td>Name: </td>
	<td><%=name%></td>
</tr>
<tr>
	<td>Highest Educational Attainment: </td>
	<td><%=qualification%></td>
</tr>
<tr>
	<td>Experience: </td>
	<td><%=exp%></td>
</tr>
<tr>
	<td>Email: </td>
	<td><%=email%></td>
</tr>
<tr>
	<td>Phone: </td>
	<td><%=phone%></td>
</tr>
<tr>
	<td>
		<a id="<%=app_id %>" href="CallUp.jsp?id=<%=app_id%>"style="text-decoration:none;">Call For Interview</a>
	</td>
	<td>
		<a id="<%=app_id %>" href="Recruiter.jsp" style="text-decoration:none;">Ignore Application</a>
	</td>
</tr>

</table>	
<%
	}//end of while
}//end of try
catch(Exception e){
	e.printStackTrace();
}
%>

</div>

<div id="footer">
	<p><font color="#505050" size="2" face="Georgia">&copy; Copyright 2017. All rights reserved.<br>Best viewed on a resolution of 1920 x 1080 on Google Chrome.</font></p>
</div>

</body>
</html>