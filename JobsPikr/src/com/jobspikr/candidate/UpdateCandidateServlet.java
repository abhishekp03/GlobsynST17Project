package com.jobspikr.candidate;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateCandidateServlet")
public class UpdateCandidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateCandidateServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String email=request.getParameter("email");
		out.println(email);
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String sex = request.getParameter("sex");
		String dob = request.getParameter("dob");
		String address = request.getParameter("address");
		long pincode = Long.parseLong(request.getParameter("pincode"));
		long phone = Long.parseLong(request.getParameter("phone"));
		String exp = request.getParameter("exp");
		String degree = request.getParameter("degree");
		String stream = request.getParameter("stream");
		
		CandidateActions action = new CandidateActions();
		boolean flag = action.update(email, fname, lname, sex, dob, address, pincode, phone, exp, degree, stream);
		
		if(flag){
			out.println("Success... Please login again!");
			response.setHeader("Refresh", "2; URL=Homepage.jsp");
		}
		
		else{
			out.println("Failure...");
			response.setHeader("Refresh", "2; URL=Candidate.jsp");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
