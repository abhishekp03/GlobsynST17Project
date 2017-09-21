<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/Homepage.css">
<link rel="stylesheet" type="text/css" href="css/Header.css">


<script src="JavaScript/HomepageValidator.js"></script>

<title>JobsPikr :: Home Page</title>

</head>

<body background="Images/HomepageBackground.jpg">

<div id="header">
	<img class="center" src="Images/JobsPikr.png">
</div>

<div id="wrapper">

	<div id="main">

	<!-- The following section has been made in accordance to steps given at https://www.w3schools.com/howto/howto_js_tabs.asp  -->

		<div id="loginPane">

			<div class="tab">
				<button class="tablinks" onclick="openTab(event, 'Candidate')" id="default">Candidate</button>
			 	<button class="tablinks" onclick="openTab(event, 'Recruiter')"><font>Recruiter</font></button>
			</div>
  
			<div id="Candidate" class="tabcontent">
				<form name="candidateLogin" action="CandidateLoginServlet" method="post" onsubmit="return CandidateValidator();">
					<br>
				    <input type="text" name="emailC" placeholder="E-mail">
				    <input type="password" name="passwordC" id="passwordC" placeholder="Password">
				    <input type="checkbox" onchange="document.getElementById('passwordC').type = this.checked ? 'text' : 'password'"> Show password<br>
				    <input type="submit" value="Login" />
				</form><br>
				<p>New to our web site?&emsp;<a href="CandidateRegistration.jsp"style="text-decoration: none;">Register here.</a></p>
			</div>

			<div id="Recruiter" class="tabcontent">
				<form name="recruiterLogin" action="RecruiterLoginServlet" method="post" onsubmit="return RecruiterValidator();">
					<br>
					<input type="text" name="emailR" placeholder="E-mail">
				    <input type="password" name="passwordR" id="passwordR" placeholder="Password">
				    <input type="checkbox" onchange="document.getElementById('passwordR').type = this.checked ? 'text' : 'password'"> Show password<br>
					<input type="submit" value="Login">
				</form><br>
				<p>New to our web site?&emsp;<a href="RecruiterRegistration.jsp" style="text-decoration: none;">Register here.</a></p>
			</div>

		</div> <!-- End of div #loginpane -->

	</div>

	<div id="footer">
	<p><font color="#505050" size="2" face="Georgia">&copy; Copyright 2017. All rights reserved.<br>Best viewed on a resolution of 1920 x 1080 on Google Chrome.</font></p>
	</div>

</div>

<script src="JavaScript/TabSwitch.js"></script>

</body>
</html>