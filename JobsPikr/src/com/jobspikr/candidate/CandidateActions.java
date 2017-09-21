package com.jobspikr.candidate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CandidateActions {
	
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
			PreparedStatement ps = con.prepareStatement("SELECT password, status FROM candidateLogin WHERE email=?;");
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
			ps = con.prepareStatement("INSERT INTO candidateLogin VALUES(?,?,?)");
			ps.setString(1, email);
			ps.setString(2, password);
			ps.setInt(3, 0);
			j=ps.executeUpdate();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		if(j>0)
			return true;
		
		return false;
	}
	
	public boolean update(String email, String fname, String lname, String sex, String dob, String address, long pincode, long phone, String exp, String degree, String stream){
		
		int i=0, j=0;
		
		try{
			con = connect();
			int status=-1;
			ps = con.prepareStatement("select status from candidateLogin where email=?;");
			ps.setString(1, email);
			rs= ps.executeQuery();
			while(rs.next()) {
				status = rs.getInt("status");
			}
			System.out.println("Status: "+status);
			if(status==0) {
				ps = con.prepareStatement("INSERT INTO candidateProfile VALUES(?,?,?,?,?,?,?,?,?,?,?);");
				ps.setString(1, email);
				ps.setString(2, fname);
				ps.setString(3, lname);
				ps.setString(4, sex);
				ps.setString(5, dob);
				ps.setString(6, address);
				ps.setLong(7, pincode);
				ps.setLong(8, phone);
				ps.setString(9, exp);
				ps.setString(10, degree);
				ps.setString(11, stream);
				j=ps.executeUpdate();
				
				ps = con.prepareStatement("UPDATE candidateLogin SET status=1 WHERE email=?;");
				ps.setString(1, email);
				i=ps.executeUpdate();
			}
			
			if(status==1){
				i=1;
				ps = con.prepareStatement("UPDATE candidateProfile SET fname=?, lname=?, sex=?, dob=?, address=?, pincode=?, phone=?, exp=?, degree=?, stream=? WHERE email=?;");
				ps.setString(1, fname);
				ps.setString(2, lname);
				ps.setString(3, sex);
				ps.setString(4, dob);
				ps.setString(5, address);
				ps.setLong(6, pincode);
				ps.setLong(7, phone);
				ps.setString(8, exp);
				ps.setString(9, degree);
				ps.setString(10, stream);
				ps.setString(11, email);
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
}
