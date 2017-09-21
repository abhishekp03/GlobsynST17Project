package com.jobspikr.candidate;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

@WebServlet("/UploadResume")
@MultipartConfig(maxFileSize = 16177215) //File size should be smaller than 16MB
public class UploadResume extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UploadResume() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Connection con = null; //Connection to the database
	    String message = null; //Message will be sent back to client
	    
	    String email=null;
	    HttpSession session = request.getSession(false);
		Object ob = session.getAttribute("key");
		email = ob.toString();
		System.out.println(email);
	    
	    InputStream inputStream = null; //Input stream of the upload file
        Part filePart = request.getPart("resume"); //Obtains the upload file part in this multipart request
		
        if (filePart != null){
            //Prints out some information for debugging
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());
             
            inputStream = filePart.getInputStream(); //Obtains input stream of the upload file
        }
        
        try{
        	//Connects to the database
        	Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/GlobsynST17ProjectDB", "abhishekp03", "d!ve!nnow");
     
        	//Constructs SQL statement
        	PreparedStatement ps = con.prepareStatement("INSERT INTO candidateResume(email, resume) VALUES(?, ?);");
        	ps.setString(1, email);
        	
        	if(inputStream != null){
        		//Fetches input stream of the upload file for the blob column
        		ps.setBlob(2, inputStream);
        	}
     
        	//Sends the statement to the database server
        	int j = ps.executeUpdate();
        	if(j > 0) {
        		message = "File uploaded and saved into database";
        	}
        }
        catch(Exception e){
        	message = "ERROR: " + e.getMessage();
        	e.printStackTrace();
        }
        finally{
        	if (con != null) {
        		//Closes the database connection
        		try{
        			con.close();
        		}
        		catch(Exception e){
        			e.printStackTrace();
                }
        	}
            
        	//Sets the message in request scope
            request.setAttribute("Message", message);
                 
            //Forwards to the message page
            getServletContext().getRequestDispatcher("/Message.jsp").forward(request, response);
         }

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
