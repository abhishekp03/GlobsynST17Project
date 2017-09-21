<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/Header.css">

<title>Message</title>
</head>
<body>

<div id="header">
	<img class="center" src="Images/JobsPikr.png">
</div>

<div id="main1" style="min-height:600px;">
	<br><br><br><br>
    <center>
        <h3><%=request.getAttribute("Message")%></h3>
    </center>
</div>

<div id="footer">
	<p><font color="#505050" size="2" face="Georgia">&copy; Copyright 2017. All rights reserved.<br>Best viewed on a resolution of 1920 x 1080 on Google Chrome.</font></p>
</div>

<% 
	response.setHeader("Refresh", "2; URL=Candidate.jsp"); 
%>

</body>
</html>