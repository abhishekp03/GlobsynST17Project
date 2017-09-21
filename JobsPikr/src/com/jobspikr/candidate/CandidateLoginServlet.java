package com.jobspikr.candidate;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/CandidateLoginServlet")
public class CandidateLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CandidateLoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String email=request.getParameter("emailC");
		String password = request.getParameter("passwordC");
		CandidateActions action = new CandidateActions();
		boolean flag = action.login(email,password);
		if(flag){
			HttpSession session3 = request.getSession(true);
			session3.setAttribute("key", email);
			session3.setAttribute("key2", action.status);
			RequestDispatcher rd = request.getRequestDispatcher("Candidate.jsp");
			rd.forward(request, response);
		}
		
		else{
			out.println("Invalid Username/Password");
			response.setHeader("Refresh", "2; URL=Homepage.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
}
