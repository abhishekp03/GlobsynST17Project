<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="javax.servlet.*, java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="stylesheet" href="css/Buttons.css">
<link rel="stylesheet" href="css/Header.css">
<link rel="stylesheet" href="css/Profile.css">
<link rel="stylesheet" href="css/Tables.css">

<script >
function applyForJob(id){
	document.getElementById(id).disabled = true;
	xmlHttp=GetXmlHttpObject()
	var url="ApplyForJob.jsp";
	url=url+"?id="+id;
	xmlHttp.onreadystatechange=stateChanged()
	xmlHttp.open("GET",url,true)
	xmlHttp.send(null)
	location.href="Candidate.jsp"
}

function undo(id){
	var id1 = -(id);
	document.getElementById(id).disabled = true;
	document.getElementById(id1).disabled = false;
	xmlHttp=GetXmlHttpObject()
	var url="UndoApplication.jsp";
	url=url+"?id="+id1;
	xmlHttp.onreadystatechange=stateChanged(id)
	xmlHttp.open("GET",url,true)
	xmlHttp.send(null)
}

function stateChanged(){ 
	if(xmlHttp.readyState==4 || xmlHttp.readyState=="complete"){
		var showdata = xmlHttp.responseText; 
		alert(showdata)
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
		var email1 = document.CandidateProfile.email.value;
		var fname1 = document.CandidateProfile.fname.value;
		var lname1 = document.CandidateProfile.lname.value;
		var sex1 = document.CandidateProfile.sex.value;
		var dob1 = document.CandidateProfile.dob.value;
		var address1 = document.CandidateProfile.address.value;
		var pincode1 = document.CandidateProfile.pincode.value;
		var phone1 = document.CandidateProfile.phone.value;
		var exp1 = document.CandidateProfile.exp.value;
		var degree1 = document.CandidateProfile.degree.value;
		var stream1 = document.CandidateProfile.stream.value;
		var validemail = /[a-zA-Z0-9._-]+[@]{1}[a-z]+[.]{1}[a-zA-Z]{3}$/;
		
		if(email1 == "")
		{
			alert("Enter email");
			return false;
		}
		
		if(!(validemail.test(email1)))
		{
			alert("email not correct");
			return false;
		}
		if(fname1 == "")
		{
			alert("Enter fname");
			return false;
		}
		if(lname1 == "")
		{
			alert("Enter lname");
			return false;
		}
		if(sex1 == "")
		{
			alert("Enter sex");
			return false;
		}
		if(dob1 == "")
		{
			alert("Enter dob");
			return false;
		}
		if(address1 == "")
		{
			alert("Enter address");
			return false;
		}
		if(pincode1 == "")
		{
			alert("Enter pincode");
			return false;
		}
		if(phone1 == "")
		{
			alert("Enter phone");
			return false;
		}
		if(exp1 == "")
		{
			alert("Enter exp");
			return false;
		}
		if(degree1 == "")
		{
			alert("Enter degree");
			return false;
		}
		if(stream1 == "")
		{
			alert("Enter stream");
			return false;
		}
		return true;
	}
	
	
</script>


<style>
	.welcome{
		border: none;
		height: 100px;
		width: auto;
		background-color: inherit;
		float: right;
		text-align: center;
		padding-right: 35px;		
}
</style>

</head>

<body>

<% 	
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	try{
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/GlobsynST17ProjectDB", "abhishekp03", "d!ve!nnow");
	}
	catch(Exception e){
		e.printStackTrace();
	}
	
	int status=-1;
	HttpSession session3 = request.getSession(false);
	Object ob = session3.getAttribute("key");
	Object ob2 = session3.getAttribute("key2");
	String email = ob.toString();
	String foo = ob2.toString();
	status = Integer.parseInt(foo);
%>

<div id="header" >
	<img class="center" src="Images/JobsPikr.png">
	<div class="welcome">
		<p><font color="white"><br>Welcome<br><%=email%></font></p>
	</div>
</div>

<div class="tab">
  <button class="tablinks" onclick="openTab(event, 'Home')" id="default">Home</button>
  <button class="tablinks" onclick="openTab(event, 'Edit Profile')">Edit Profile</button>
  <button class="tablinks" onclick="openTab(event, 'My Applications')">My Applications</button>
  <button class="tablinks" onclick="openTab(event, 'Change Password')">Change Password</button>
  <form action="Logout" method="post">
  	<button class="tablinks">Logout</button>
  </form>
</div>

<div id="Home" class="tabcontent">
<% 
	if(status==0){
%>
	<h3>Welcome</h3>
	<h3>You have been successfully register</h3>
	<p>Create your profile first</p>
	<input type="button" onclick="openTab(event, 'Edit Profile')" value="Create Profile">
<% 
	}
	else{
		int job_id = 0;
		String name = null;
		String post = null;
		String location = null;
		String salary = null;
		String exp = null;
		String description = null;
		
		try{
			ps = con.prepareStatement("SELECT j.job_id, r.name, j.post, j.location, j.salary, j.exp, j.description FROM joblist j, recruiterProfile r WHERE j.email=r.email;");
			rs = ps.executeQuery();

			while(rs.next()){
				job_id = rs.getInt("j.job_id");
				name = rs.getString("r.name");
				post = rs.getString("j.post");
				location = rs.getString("j.location");
				salary = rs.getString("j.salary");
				exp = rs.getString("j.exp");
				description = rs.getString("j.description"); 
%>

		<h3 align="center">Job #ID: <%=job_id%></h3>
		
		<table class="table1" align="center">
				<thead>
					<th class="th1">Particulars</th>
					<th class="th1">Details</th>
				</thead>
				
				<tr class="tr1">
					<td class="td1">Organization</td>
			 		<td class="td1"><%=name%></td>
			 	</tr>
			 	<tr class="tr1">
					<td class="td1">Designation</td>
			 		<td class="td1"><%=post%></td>
			 	</tr>
				<tr class="tr1">
					<td class="td1">Location</td>
			 		<td class="td1"><%=location%></td>
			 	</tr>
				<tr class="tr1">
					<td class="td1">Salary</td>
			 		<td class="td1"><%=salary%></td>
			 	</tr>
			 	<tr class="tr1">
					<td class="td1">Experience</td>
			 		<td class="td1"><%=exp%></td>
				 </tr>
				 <tr class="tr1">
					<td class="td1">Job Description</td>
				 	<td class="td1"><%=description%></td>
				 </tr>
		</table>
		<br>	
		<input type="button" id="<%= job_id %>" class="apply" value="Apply" onclick="applyForJob(this.id);">
		<br><br>				
<% 
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	} 
%>
</div>


<div id="Edit Profile" class="tabcontent" align="center">
	<br><br>
	<div id="picture">
		<img src="Images/NoImage.jpg" /><br><br>
		<form action="UploadPicture" method="post" enctype="multipart/form-data">
			<input name="photo" type="file" />&emsp;
			<input type="submit" value="Change Picture" />
		</form>
	</div><br><br>
	
<%	
	String fname = "";
	String lname = "";
	String sex = "";
	String dob = "";
	String address = "";
	String pincode = "";
	String phone = "";
	String exp = "";
	String degree = "";
	String stream = "";

	if(status!=0){
		try{
			ps = con.prepareStatement("SELECT fname, lname, sex, dob, address, pincode, phone, exp, degree, stream FROM candidateProfile WHERE email=?;");
			ps.setString(1, email);
			rs=ps.executeQuery();
			while(rs.next()){
				fname = rs.getString("fname");
				lname = rs.getString("lname");
				sex = rs.getString("sex");
				dob = rs.getString("dob");
				address = rs.getString("address");
				pincode = Long.toString(rs.getLong("pincode"));
				phone = Long.toString(rs.getLong("phone"));
				exp = rs.getString("exp");
				degree = rs.getString("degree");
				stream = rs.getString("stream");;
			}
			rs = ps.executeQuery();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
%>

<form name="CandidateProfile" action="UpdateCandidateServlet" method="post" onsubmit="return RegValidator();">
	<br><br><br><br>
	<table width="600" border="0" align="center" cellpadding="5" cellspacing="5">
		<tbody>
		    <tr>
		      <td>E-mail</td>
		      <td><input type="text" name="email"  value="<%= email %>" readonly></td>
	        </tr>
	        
		    <tr>
		      <td>First name</td>
		      <td><input type="text" name="fname" value="<%= fname %>"></td>
	        </tr>
		    
		    <tr>
		      <td>Last name</td>
		      <td><input type="text" name="lname" value="<%= lname %>"></td>
	        </tr>
	        
		    <tr>
		      <td>Gender</td>
		      <td><input type="text" name="sex" value="<%= sex %>"></td>
	        </tr>
		  	
		  	<tr>
				<td>Date of Birth</td>
				<td><input type="text" name="dob" value="<%= dob %>"></td>
			</tr>
				
			<tr>
				<td>Address</td>
				<td><input type="text" name="address" value="<%= address %>"></td>
			</tr>
				
			<tr>
				<td>Pincode</td>
				<td><input type="text" name="pincode" value="<%= pincode %>"></td>
			</tr>
				
			<tr>
				<td>Contact Number</td>
				<td><input type="text" name="phone" value="<%= phone %>"></td>
			</tr>
				
			<tr>
				<td>Years of Experience</td>
				<td><input type="text" name="exp" value="<%= exp %>"></td>
			</tr>
				
			<tr>
				<td>Highest Educational Attainment</td>
				<td><input type="text" name="degree" value="<%= degree %>"></td>
			</tr>
				
			<tr>
				<td>Stream</td>
				<td><input type="text" name="stream" value="<%= stream %>"></td>
			</tr>
			
		</tbody>
	</table>
	<br>
	<input type="submit" name="submit" id="submit" value="Update" style="margin: 0 auto;">
	<br><br><br><br>
</form>

<div id="cv">
	<form action="UploadResume" method="post" enctype="multipart/form-data">
		<input name="resume" type="file" />&emsp;
		<input type="submit" value="Add Resume" />
	</form>
	<br><br>
</div>

</div>

<div id="My Applications" align="center" class="tabcontent">
<%
	int job_id=0;
	int app_id = 0;
	String name = null;
	String post = null;
	String location = null;
%>

<%  
	try{
		ps = con.prepareStatement("SELECT a.app_id, a.job_id, r.name, j.post, j.location FROM applist a, joblist j, recruiterProfile r WHERE a.email=? AND a.job_id=j.job_id AND j.email=r.email;");
		ps.setString(1, email);
		rs = ps.executeQuery();
%>
	<br><br><br><br>
	<table class="table1" style="width:800px;" align="center" border="none" cellpadding="4">
		<thead>
			<th class="th1">Application #ID</th>
			<th class="th1">Job #ID</th>
			<th class="th1">Organization</th>
			<th class="th1">Designation</th>
			<th class="th1">Location</th>
			<th class="th1">Action</th>
		</thead>
<%
		while(rs.next()){
			app_id = rs.getInt("a.app_id");
			job_id = rs.getInt("a.job_id");
			name = rs.getString("r.name");
			post = rs.getString("j.post");
			location = rs.getString("j.location");	
%>
		<tr class="tr1">
			<td class="td1"><%=app_id%></td>
			<td class="td1"><%=job_id%></td>
			<td class="td1"><%=name%></td>
			<td class="td1"><%=post%></td>
			<td class="td1"><%=location%></td>
			<td class="td1">
				<input type="button" id="<%= -job_id %>" class="undo" value="Undo" onclick="location.href='Candidate.jsp'; undo(this.id);">
			</td>
		</tr>
<%
		}
	}
	catch(Exception e){
		e.printStackTrace();
	}
%>
	</table>
	
</div>


<div id="Change Password" class="tabcontent">
	<form name="changePassword" action="ChangePassword"><br><br><br><br>
		<table width="600" border="0" align="center" cellpadding="5" cellspacing="5">
			<tbody>		
			<tr>
			<td>Old Password</td>
			<td><input type="password" name="oldPassword" placeholder="Enter Old Password"></td>
			</tr>
			<tr>
			<td>New Password</td>
			<td><input type="password" name="newPassword" placeholder="Enter New Password"></td>
			</tr>
			<tr>
			<td>Confirm Password</td>
			<td><input type="password" name="cnfNewPassword" placeholder="Confirm New Password"></td>
			</tr>
			</tbody>
		</table>
		<input type="submit" value="Update">
	</form>
</div>
  
<script src="JavaScript/TabSwitch.js"></script>

<div id="footer">
	<p><font color="#505050" size="2" face="Georgia">&copy; Copyright 2017. All rights reserved.<br>Best viewed on a resolution of 1920 x 1080 on Google Chrome.</font></p>
</div>

</body>
</html> 