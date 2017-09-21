package com.jobspikr.recruiter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/RecruiterRegistrationServlet")
public class RecruiterRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RecruiterRegistrationServlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String email=request.getParameter("emailNR");
		String password = request.getParameter("passwordNR");
		RecruiterActions action = new RecruiterActions();
		boolean flag = action.register(email, password);
		if(flag) {
			HttpSession session = request.getSession(true);
			session.setAttribute("key", email);
			session.setAttribute("key2", 0);
			RequestDispatcher rd = request.getRequestDispatcher("Recruiter.jsp");
			rd.forward(request, response);
		}
		else{
			out.println("Registration Failed.");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}