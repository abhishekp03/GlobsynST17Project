package com.jobspikr.recruiter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RecruiterActions {
	
	static Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	int status=-1;
	
	public static Connection connect(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/GlobsynST17ProjectDB", "abhishekp03", "d!ve!nnow");
		} 
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}
	
	public boolean login(String email, String password) {
		try{
			con=connect();
			PreparedStatement ps = con.prepareStatement("SELECT password, status FROM recruiterLogin WHERE email=?;");
			ps.setString(1,email);
			rs = ps.executeQuery();
			while(rs.next()){
				String retrievedPassword= rs.getString("password");
				status=rs.getInt("status");
				if(retrievedPassword.equals(password)){
					return true;
				}
			}
		}
		
		catch(Exception e){
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean register(String email,String password) {
		int j=0;
		try{
			con = connect();
			ps = con.prepareStatement("INSERT INTO recruiterLogin VALUES(?,?,0);");
			ps.setString(1, email);
			ps.setString(2, password);
			j=ps.executeUpdate();
		}
		catch(Exception e){
			e.printStackTrace();;
		}
		
		if(j>0)
			return true;
		
		return false;
	}
	
public boolean update(String email, String name, String address, long pincode, long phone, String website){
		
		int i=0, j=0;
		
		try{
			con = connect();
			int status=-1;
			ps = con.prepareStatement("select status from recruiterLogin where email=?;");
			ps.setString(1, email);
			rs= ps.executeQuery();
			while(rs.next()) {
				status = rs.getInt("status");
			}
			System.out.println("Status: "+status);
			if(status==0) {
				ps = con.prepareStatement("INSERT INTO recruiterProfile VALUES(?,?,?,?,?,?);");
				ps.setString(1, email);
				ps.setString(2, name);
				ps.setString(3, address);
				ps.setLong(4, pincode);
				ps.setLong(5, phone);
				ps.setString(6, website);
				j=ps.executeUpdate();
				
				ps = con.prepareStatement("UPDATE recruiterLogin SET status=1 WHERE email=?;");
				ps.setString(1, email);
				i=ps.executeUpdate();
			}
			
			if(status==1){
				i=1;
				ps = con.prepareStatement("UPDATE recruiterProfile SET name=?, address=?, pincode=?, phone=?, website=? WHERE email=?;");
				ps.setString(1, name);
				ps.setString(2, address);
				ps.setLong(3, pincode);
				ps.setLong(4, phone);
				ps.setString(5, website);
				ps.setString(6, email);
				j=ps.executeUpdate();
			}		
		}
		
		catch(Exception e){
			System.out.println(e);
		}
		
		if(i>0 && j>0) {
				System.out.println("Success");
				return true;
		}
		
		return false;
	}

	public boolean addJob(String email, String post, String location, String salary, String exp, String description){
		int j=0;
		try{
			con=connect();
			ps=con.prepareStatement("INSERT INTO joblist(email, post, location, salary, exp, description) VALUES(?,?,?,?,?,?);");
			ps.setString(1, email);
			ps.setString(2, post);
			ps.setString(3, location);
			ps.setString(4, salary);
			ps.setString(5, exp);
			ps.setString(6, description);
			j = ps.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		if(j>0)
			return true;
		
		return false;
	}

}
