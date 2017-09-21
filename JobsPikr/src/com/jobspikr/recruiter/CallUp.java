package com.jobspikr.recruiter;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/CallUp")
public class CallUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CallUp() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs =null;
		
		int app_id = Integer.parseInt(request.getParameter("app_id"));
		int job_id = Integer.parseInt(request.getParameter("job_id"));
				
		String date = request.getParameter("date"); 
		System.out.println(date);
		String time = request.getParameter("time");
		String place = request.getParameter("place");	
		
		SimpleDateFormat stf = new SimpleDateFormat("hh:mm");
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-mm-dd");
		
		java.sql.Date dateValue = null;
		java.sql.Time timeValue = null;
		
		try {
			dateValue = new java.sql.Date(sdf.parse(date).getTime());
			System.out.println(dateValue);
			timeValue = new java.sql.Time(stf.parse(time).getTime());
		}
		
		catch(Exception e) {e.printStackTrace();}
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/GlobsynST17ProjectDB", "abhishekp03", "d!ve!nnow");
			ps = con.prepareStatement("INSERT INTO interviewdetails(app_id, job_id, date, time, place) VALUES (?, ?, ?, ? , ?);");
			ps.setInt(1, app_id);
			ps.setInt(2, job_id);
			ps.setDate(3, dateValue);
			ps.setTime(4, timeValue);
			ps.setString(5, place);
			int j = ps.executeUpdate();
			
			if(j>0) {
				System.out.println("Success");ps = con.prepareStatement("Select c.fname, c.lname, c.email FROM candidateProfile c, applist a WHERE a.app_id=? AND a.email=c.email;");
				ps.setInt(1, app_id);
				rs = ps.executeQuery();
				
				String fname = null;
				String lname = null;
				String cname = null;
				String cemail = null;
				
				while(rs.next()){
					fname = rs.getString("c.fname");
					lname = rs.getString("c.lname");
					cname = fname + " " + lname;
					cemail = rs.getString("c.email");
				}

				ps = con.prepareStatement("SELECT r.name, j.post, j.location, r.email, r.phone FROM recruiterProfile r, joblist j WHERE j.job_id=? AND j.email=r.email;");
				ps.setInt(1, job_id);
				rs = ps.executeQuery();
				
				String rname = null;
				String post = null;
				String location = null;
				String remail = null;
				Long rphone = 0L;
				
				while(rs.next()){
					rname = rs.getString("r.name");
					post = rs.getString("j.post");
					location = rs.getString("j.location");
					remail = rs.getString("r.email");
					rphone = rs.getLong("r.phone");
				}
				
				ps = con.prepareStatement("SELECT date, time, place FROM  interviewdetails WHERE app_id=?;");
				ps.setInt(1, app_id);
				rs = ps.executeQuery();
				
				String idate = null;
				String itime = null;
				String iplace = null;
				String message = null;
				
				while(rs.next()){
					idate = rs.getString("date");
					itime = rs.getString("time");
					iplace = rs.getString("place");
				}
				
				message="Dear "+cname+",\n\nAs a result of your application for the position of "+post+" at location "+ location +", we would like to invite you to attend an interview on "+idate+", at "+itime+" at our office in "+iplace+".\n\nThe interview will last about 45 minutes. Please bring a copy of your identification proof to the interview. If the date or time of the interview is inconvenient, please contact us by phone "+rphone+" or email "+remail+" in order to arrange another appointment.\n\nWe look forward to seeing you.\n\nBest regards,\n"+rname;
				Mailer mail = new Mailer();
				mail.send("jobspikr@gmail.com", "jai7827@ho", cemail, "Interview Call Up Letter", message);
				out.println("\nMail sent successfully!");
				response.setHeader("Refresh", "2; URL=Recruiter.jsp");
			}
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
