<%@ page import="java.sql.*"%>

<%@ page import="java.io.*"%>

<% 
Blob image = null;
Connection con = null;
byte[ ] imgData = null ;
PreparedStatement ps = null;
ResultSet rs = null;
String email = request.getParameter("name");

try{
	Class.forName("com.mysql.jdbc.Driver");
	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/GlobsynST17ProjectDB", "abhishekp03", "d!ve!nnow");
	ps = con.prepareStatement("SELECT resume FROM candidateResume WHERE email=?;");
	ps.setString(1, email);
	rs = ps.executeQuery();
	
	if(rs.next()){
		image = rs.getBlob(1);
		imgData = image.getBytes(1,(int)image.length());
	}
	else {	
		out.println("Resume not found for given profile!");
		return;
	}

	response.setContentType("application/pdf");
	OutputStream o = response.getOutputStream();
	o.write(imgData);
	o.flush();
	o.close();
} 
catch(Exception e){
	out.println("Unable To Display Resume");
	out.println("Resume Display Error=" + e.getMessage());
	return;
} 

finally{
	try{
		rs.close();
		ps.close();
		con.close();
	}
	catch(SQLException e){
		e.printStackTrace();
	}
}
%>