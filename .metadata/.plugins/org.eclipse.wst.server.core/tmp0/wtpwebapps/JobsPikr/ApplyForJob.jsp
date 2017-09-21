<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Apply For Job</title>
</head>

<body>

<% 
	session = request.getSession(false);
	Object ob = session.getAttribute("key");
	String email = ob.toString();
	out.println(email);
	int job_id = Integer.parseInt(request.getParameter("id"));
	String data="";	
	
	try{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/GlobsynST17ProjectDB", "abhishekp03", "d!ve!nnow");
		PreparedStatement ps = con.prepareStatement("INSERT INTO applist(email, job_id) VALUES(?, ?);");
		ps.setString(1, email);
		ps.setInt(2, job_id);
		ps.executeUpdate();
		data="You have sucessfully applied for this job!";
	}
	catch(Exception e){
		//e.printStackTrace();
		data="You have already applied for this job!";
	}
	finally{
		out.println(data);
	}
%>

</body>
</html>