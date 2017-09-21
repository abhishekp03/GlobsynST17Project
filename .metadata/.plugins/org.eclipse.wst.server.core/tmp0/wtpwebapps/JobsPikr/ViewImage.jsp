<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*, java.io.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

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
		ps = con.prepareStatement("SELECT photo FROM candidatePhotos WHERE email=?;");
		ps.setString(1, email);
		rs = ps.executeQuery();
		
		if(rs.next()){
			image = rs.getBlob(1);
			imgData = image.getBytes(1,(int)image.length());
		}
		else {	
			out.println("Image not found for given profile!");
			return;
		}

		response.setContentType("image/jpg");
		OutputStream o = response.getOutputStream();
		o.write(imgData);
		o.flush();
		o.close();
	} 
	catch(Exception e){
		out.println("Unable To Display Image");
		out.println("Image Display Error=" + e.getMessage());
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

</body>
</html>