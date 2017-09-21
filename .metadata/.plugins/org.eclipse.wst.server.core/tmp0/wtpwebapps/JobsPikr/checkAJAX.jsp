<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*"%>
    
<%
	String email = request.getParameter("email").toString();
	//System.out.println(name);
	String data ="";
	
		/*while(!email.contains("@")){
			out.println("Invalid email");
		}*/
		
		int count=0;
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/GlobsynST17ProjectDB", "abhishekp03", "d!ve!nnow");
		
		Statement st=con.createStatement();
		
		ResultSet rs=st.executeQuery("SELECT * FROM candidateLogin WHERE email='"+email+"';");
		while(rs.next())
			count++;
		
		rs=st.executeQuery("SELECT * FROM recruiterLogin WHERE email='"+email+"';");
		while(rs.next())
			count++;
		
	
		if(count>0){
			data="Email already exists!";
		}
		
		else{
			data="You are good to go!";
		}
	
		out.println(data);
	
%>