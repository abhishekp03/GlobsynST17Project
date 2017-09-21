package com.jobspikr.candidate;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/CandidateRegistrationServlet")
public class CandidateRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CandidateRegistrationServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String email=request.getParameter("emailNC");
		String password = request.getParameter("passwordNC");
		CandidateActions action = new CandidateActions();
		boolean flag = action.register(email, password);
		
		if(flag){
			HttpSession session = request.getSession(true);
			session.setAttribute("key", email);
			session.setAttribute("key2", 0);
			RequestDispatcher rd = request.getRequestDispatcher("Candidate.jsp");
			rd.forward(request, response);
		}
		
		else{
			//out.println("Registration Failed.");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
