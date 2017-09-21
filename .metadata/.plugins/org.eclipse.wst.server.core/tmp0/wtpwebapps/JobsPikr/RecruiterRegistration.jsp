<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/Header.css">
<link rel="stylesheet" type="text/css" href="css/Common.css">

<title>Recruiter :: Register</title>

<script type="text/javascript">		

	function checkEmail(value){ 
		xmlHttp=GetXmlHttpObject()
		var url="checkAJAX.jsp";
		url=url+"?email="+value;
		xmlHttp.onreadystatechange=stateChanged
		xmlHttp.open("GET",url,true)
		xmlHttp.send(null)
	}
	
	function stateChanged(){ 
		if(xmlHttp.readyState==4 || xmlHttp.readyState=="complete"){ 
			var showdata = xmlHttp.responseText; 
			document.getElementById("mydiv").innerHTML= showdata;
		} 
	}
		
	function GetXmlHttpObject(){
		var xmlHttp=null;
		try{
			xmlHttp=new XMLHttpRequest();
		}
		catch (e) {
			try {
				xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
			}
			catch (e){
				xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
			}
		}
			
		return xmlHttp;
	}
</script>
<script>
	function RegValidator()
	{
		var email = document.recruiterRegistration.emailNR.value;
		var password = document.recruiterRegistration.passwordNR.value;
		var passwordC = document.recruiterRegistration.confirmPasswordNR.value;
		var validemail = /[a-zA-Z0-9._-]+[@]{1}[a-z]+[.]{1}[a-zA-Z]{3}$/;
		
		if(email == "")
		{
			alert("Enter email");
			return false;
		}
		
		if(!(validemail.test(email)))
		{
			alert("email not correct");
			return false;
		}
		if(password == "")
		{
			alert("Enter password");
			return false;
		}
		if(password != passwordC)
		{
			alert("Password not match");
			return false;
		}
		return true;
	}
	
	
</script>

</head>

<body>

	<div id="header">
		<img class="center" src="Images/JobsPikr.png">
	</div>
	
	<div class="wrapper">
		<div class="main" style="text-align:center; min-height:600px">
			<form name="recruiterRegistration" action="RecruiterRegistrationServlet" method="post" onsubmit="return RegValidator();">
				<br><br><br><br>
				<font color="red" size="2"><div id="mydiv"></div></font>
				
				<table align="center" >
				
				<tr>
					<td><h3>Recruiter Registration</h3></td>
				</tr>
				<tr>
					<td><input type="text" name="emailNR" placeholder="Enter your e-mail" onkeyup="checkEmail(this.value);"><k/td>
				</tr>
				<tr>
					<td><input type="password" name="passwordNR" placeholder="Enter password"></td>
				</tr>
				<tr>
					<td><input type="password" name="confirmPasswordNR" placeholder="Confirm password"></td>
				</tr>
				</table>
				<br><br>
				<input type="submit" id="signupNR" value="Sign up">
			</form>
		</div>
	
	<div id="footer">
		<p><font color="#505050" size="2" face="Georgia">&copy; Copyright 2017. All rights reserved.<br>Best viewed on a resolution of 1920 x 1080 on Google Chrome.</font></p>
	</div>
	
	</div>
	
</body>
</html>