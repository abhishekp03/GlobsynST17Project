<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Undo Application</title>
</head>

<body>

<% 
session = request.getSession(false);
Object ob = session.getAttribute("key");
String email = ob.toString();
out.println(email);
int job_id = Integer.parseInt(request.getParameter("id"));

try{
	Class.forName("com.mysql.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/GlobsynST17ProjectDB", "abhishekp03", "d!ve!nnow");
	PreparedStatement ps = con.prepareStatement("DELETE FROM applist WHERE email=? AND job_id=?;");
	ps.setString(1, email);
	ps.setInt(2, job_id);
	ps.executeUpdate();
	response.sendRedirect("Candidate.jsp");
}
catch(Exception e){
	e.printStackTrace();
}
%>

</body>
</html>