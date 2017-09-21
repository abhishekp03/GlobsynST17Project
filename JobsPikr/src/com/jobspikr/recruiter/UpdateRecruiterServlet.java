package com.jobspikr.recruiter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateRecruiterServlet")
public class UpdateRecruiterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateRecruiterServlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String email=request.getParameter("email");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		long pincode = Long.parseLong(request.getParameter("pincode"));
		long phone = Long.parseLong(request.getParameter("phone"));
		String website = request.getParameter("website");
		
		RecruiterActions action = new RecruiterActions();
		boolean flag = action.update(email, name, address, pincode, phone, website);
		
		if(flag){
			out.println("Success... Please login again!");
			response.setHeader("Refresh", "2; URL=Homepage.jsp");
		}
		
		else{
			out.println("Failure...");
			response.setHeader("Refresh", "2; URL=Recruiter.jsp");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
