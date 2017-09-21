package com.jobspikr.recruiter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddJobServlet")
public class AddJobServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddJobServlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String email = request.getParameter("email");
		String post = request.getParameter("post");
		String location = request.getParameter("location");
		String salary = request.getParameter("salary");
		String exp = request.getParameter("exp");
		String desc = request.getParameter("desc");
		RecruiterActions action = new RecruiterActions();
		boolean flag = action.addJob(email, post, location, salary, exp, desc);
		if(flag){
			out.println("Job Added");
			response.setHeader("Refresh", "2; URL=Recruiter.jsp");
		}
		else{
			out.println("Job not Added");
			response.setHeader("Refresh", "2; URL=Recruiter.jsp");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
