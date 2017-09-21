<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="stylesheet" href="css/Header.css">
<link rel="stylesheet" href="css/Profile.css">
<link rel="stylesheet" href="css/Tables.css">

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

<script>
	function RegValidator()
	{
		var email1 = document.RecruiterProfile.email.value;
		var name1 = document.RecruiterProfile.name.value;
		
		var address1 = document.RecruiterProfile.address.value;
		var pincode1 = document.RecruiterProfile.pincode.value;
		var phone1 = document.RecruiterProfile.phone.value;
		
		var website1 = document.RecruiterProfile.website.value;
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
		if(name1 == "")
		{
			alert("Enter fname");
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
		
		
		if(website1 == "")
		{
			alert("Enter Website");
			return false;
		}
		return true;
	}
	
	
</script>

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
	session = request.getSession(false);
	Object ob = session.getAttribute("key");
	Object ob2 = session.getAttribute("key2");
	String email = ob.toString();
	//out.println(email);
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
  <button class="tablinks" onclick="openTab(event, 'Jobs Published')">Jobs Published</button>
  <button class="tablinks" onclick="openTab(event, 'Add Job')">Add Job</button>
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
		int app_id = 0;
		int job_id = 0;
		String fname = null;
		String lname = null;
		String name = null;
		String degree = null;
		String stream = null;
		String qualification = null;
		String exp = null;

		try{
			ps = con.prepareStatement("SELECT a.app_id, a.job_id, c.fname, c.lname, c.degree, c.stream, c.exp FROM applist a, candidateProfile c, recruiterProfile r WHERE a.email=c.email and r.email=?;");
			ps.setString(1, email);
			rs = ps.executeQuery(); 
%>

	<table class="table1" align="center" border="none" cellpadding="5" style="min-width: 700px;">
		<br><br><br><br>
		<thead>
			<th class="th1">Application #ID</th>
			<th class="th1">Job #ID</th>
			<th class="th1">Name</th>
			<th class="th1">Qualification</th>
			<th class="th1">Experience</th>
			<th class="th1">Action</th>
		</thead>
				
<% 		
			while(rs.next()){
				app_id = rs.getInt("a.app_id");
				job_id = rs.getInt("a.job_id");
				fname = rs.getString("c.fname");
				lname = rs.getString("c.lname");
				name = fname + " " + lname;
				degree = rs.getString("c.degree");
				stream = rs.getString("c.stream");
				qualification = degree + " in " + stream;
				exp = rs.getString("c.exp"); %>
				
			<tr class="tr1">
				<td class="td1"><%=app_id%></td>
				<td class="td1"><%=job_id%></td>
				<td class="td1"><%=name%></td>
				<td class="td1"><%=qualification%></td>
				<td class="td1"><%=exp%></td>
				<td class="td1">
					<a target="_blank" id="<%=app_id %>" href="ViewProfile.jsp?id=<%=app_id %>" style="text-decoration: none;">View Profile</a>
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
<% } %>
</div>



<div id="Edit Profile" class="tabcontent" align="center">
<%	
	String name = "";
	String address = "";
	String pincode = "";
	String phone = "";
	String website = "";

	if(status!=0){
		try{
			ps = con.prepareStatement("SELECT name, address, pincode, phone, website FROM recruiterProfile WHERE email=?;");
			ps.setString(1, email);
			rs=ps.executeQuery();
			while(rs.next()){
				name = rs.getString("name");
				address = rs.getString("address");
				pincode = Long.toString(rs.getLong("pincode"));
				phone = Long.toString(rs.getLong("phone"));
				website = rs.getString("website");
			}
			rs = ps.executeQuery();
			}
		catch(Exception e){
			e.printStackTrace();
		}
	}
%>
	<form name="RecruiterProfile" action="UpdateRecruiterServlet" method="post" onsubmit="return RegValidator();">
 		 <table width="600" border="0" align="center" cellpadding="5" cellspacing="5">
 		 <br><br><br><br>
			<tbody>
			    <tr>
			      <td>E-mail</td>
			      <td><input type="text" name="email"  value="<%= email %>" readonly></td>
		        </tr>
		        
			    <tr>
			      <td>Name of Organization</td>
			      <td><input type="text" name="name" value="<%= name %>"></td>
		        </tr>
			    
			    <tr>
			      <td>Address</td>
			      <td><input type="text" name="address" value="<%= address %>"></td>
		        </tr>
		        
			    <tr>
			      <td>Pin code</td>
			      <td><input type="text" name="pincode" value="<%= pincode %>"></td>
		        </tr>
			  	
			  	<tr>
					<td>Contact Number</td>
					<td><input type="text" name="phone" value="<%= phone %>"></td>
				</tr>
				
				<tr>
					<td>Website</td>
					<td><input type="text" name="website" value="<%= website %>"></td>
				</tr>
				
				<tr>
					<td>&nbsp;</td>
					<td><input type="submit" name="submit" id="submit" value="Update"></td>
				</tr>
        	</tbody>
	 	 </table> 
	</form>
</div>



<div id="Jobs Published" class="tabcontent" align="center">
<%
	int job_id = 0;
	String post = null;
	String location = null;
	String salary = null;
	String exp = null;
	String description = null;
	
	try{
		ps = con.prepareStatement("SELECT * FROM joblist WHERE email=?;");
		ps.setString(1, email);
		rs = ps.executeQuery();
%>
	<br><br><br><br>
	<table class="table1" align="center" border="none" cellpadding="4" style="min-width:800px;">
		<thead>
			<th class="th1">Job #ID</th>
			<th class="th1">Designation</th>
			<th class="th1">Location</th>
			<th class="th1">Salary</th>
			<th class="th1">Experience</th>
		    <th class="th1">Job Description</th>
		    <th class="th1">Action</th>
		</thead>
		
<% 
		while(rs.next()){
			job_id = rs.getInt("job_id");
			post = rs.getString("post");
			location = rs.getString("location");
			salary = rs.getString("salary");
			exp = rs.getString("exp");
			description = rs.getString("description");
%>
		
        <tr class="tr1">
			<td class="td1"><%=job_id%></td>
			<td class="td1"><%=post%></td>
			<td class="td1"><%=location%></td>
			<td class="td1"><%=salary%></td>
			<td class="td1"><%=exp%></td>
			<td class="td1"><%=description%></td>
			<td class="td1"><a href="" style="text-decoration:none;">Delete</a></td>
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



<div id="Add Job" class="tabcontent" align="center">	
	<form name="addjob" action="AddJobServlet" method="post">
		<table align="center">
			<br><br><br><br>
			<tr>
				<td>Email : </td>
				<td><input type="text" name="email" value="<%=email%>" readonly></td>
			</tr>
			<tr>
				<td>Post : </td>
				<td><input type="text" name="post"></td>
			</tr>
			<tr>
				<td>Location : </td>
				<td><input type="text" name="location"></td>
			</tr>
			<tr>
				<td>Salary : </td>
				<td><input type="text" name="salary"></td>
			</tr>
			<tr>
				<td>Experience : </td>
				<td><input type="text" name="exp"></td>
			</tr>
			<tr>
				<td>Description</td>
				<td><input type="text" name="desc"></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td><input type="submit" value="Add Job"></td>
			</tr>
		</table>
	</form>
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