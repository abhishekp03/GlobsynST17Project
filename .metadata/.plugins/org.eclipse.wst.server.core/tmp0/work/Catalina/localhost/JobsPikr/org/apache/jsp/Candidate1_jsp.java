/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.0.M22
 * Generated at: 2017-07-14 16:58:35 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.*;
import java.sql.*;

public final class Candidate1_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("java.sql");
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"css/Profile.css\">\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
 		
		int status=1;
		/*session = request.getSession(false);
		Object ob = session.getAttribute("key");
		Object ob2 = session.getAttribute("key2");
		String email = ob.toString();
		out.println(email);
		String foo = ob2.toString();
		status = Integer.parseInt(foo);*/
		String email="abhishekpandey2203@gmail.com";

      out.write("\r\n");
      out.write("\r\n");
      out.write("<div class=\"welcome\">\r\n");
      out.write("\tWelcome\r\n");
      out.write("\t<div class=\"username\">\r\n");
      out.write("\tUsername\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div class=\"tab\">\r\n");
      out.write("  <button class=\"tablinks\" onclick=\"openTab(event, 'Home')\" id=\"default\">Home</button>\r\n");
      out.write("  <button class=\"tablinks\" onclick=\"openTab(event, 'Edit Profile')\">Edit Profile</button>\r\n");
      out.write("  <button class=\"tablinks\" onclick=\"openTab(event, 'My Applications')\">My Applications</button>\r\n");
      out.write("  <button class=\"tablinks\">Logout</button>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div id=\"Home\" class=\"tabcontent\">\r\n");
 if(status==0){
      out.write("\r\n");
      out.write("\t<h3>Welcome</h3>\r\n");
      out.write("\t<h3>You have been successfully register</h3>\r\n");
      out.write("\t<p>Create your profile first</p>\r\n");
      out.write("\t<input type=\"button\" onclick=\"openTab(event, 'Edit Profile')\" value=\"Create Profile\">\r\n");
 }
	
else{
	out.println("Hello");
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	int job_id = 0;
	String post = null;
	String location = null;
	String salary = null;
	String exp = null;
	String description = null;
	
	Class.forName("com.mysql.jdbc.Driver");
	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/GlobsynST17ProjectDB", "abhishekp03", "d!ve!nnow");
	ps = con.prepareStatement("SELECT * FROM joblist;");
	rs = ps.executeQuery();

      out.write("\r\n");
      out.write("\t\t<table align=\"center\" border=\"4\" cellpadding=\"4\">\r\n");
      out.write("\t\t<thead>\r\n");
      out.write("\t\t\t<th>Job #ID</th>\r\n");
      out.write("\t\t\t<th>Designation</th>\r\n");
      out.write("\t\t\t<th>Location</th>\r\n");
      out.write("\t\t\t<th>Salary</th>\r\n");
      out.write("\t\t\t<th>Experience</th>\r\n");
      out.write("\t\t    <th>Job Description</th>\r\n");
      out.write("\t\t</thead>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t");
 while(rs.next()){
			job_id = rs.getInt("job_id");
			post = rs.getString("post");
			location = rs.getString("location");
			salary = rs.getString("salary");
			exp = rs.getString("exp");
			description = rs.getString("description"); 
      out.write("\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t        <tr>\r\n");
      out.write("\t\t\t\t<td bgcolor=\"white\"><font color=\"blue\">");
      out.print(job_id);
      out.write("</font></td>\r\n");
      out.write("\t\t\t\t<td bgcolor=\"white\"><font color=\"blue\">");
      out.print(post);
      out.write("</font></td>\r\n");
      out.write("\t\t\t\t<td bgcolor=\"white\"><font color=\"blue\">");
      out.print(location);
      out.write("</font></td>\r\n");
      out.write("\t\t\t\t<td bgcolor=\"white\"><font color=\"blue\">");
      out.print(salary);
      out.write("</font></td>\r\n");
      out.write("\t\t\t\t<td bgcolor=\"white\"><font color=\"blue\">");
      out.print(exp);
      out.write("</font></td>\r\n");
      out.write("\t\t\t\t<td bgcolor=\"white\"><font color=\"blue\">");
      out.print(description);
      out.write("</font></td>\r\n");
      out.write("\t\t\t\t<td bgcolor=\"white\"><font color=\"blue\"><a href=\"\">Apply</a></font></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t");
 } 
      out.write("\r\n");
      out.write("\t</table>\r\n");
 } 
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div id=\"Edit Profile\" class=\"tabcontent\" align=\"center\">\r\n");
	
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	String fname = "";
	String lname = "";
	String sex = "";
	String dob = "";
	String address = "";
	String pincode = "";
	String phone = "";
	String exp = "";
	String degree = "";
	String stream = "";

	if(status!=0){
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/GlobsynST17ProjectDB", "abhishekp03", "d!ve!nnow");
		ps = con.prepareStatement("SELECT fname, lname, sex, dob, address, pincode, phone, exp, degree, stream FROM candidateProfile WHERE email=?;");
		ps.setString(1, email);
		rs=ps.executeQuery();
		while(rs.next()){
			fname = rs.getString("fname");
			lname = rs.getString("lname");
			sex = rs.getString("sex");
			dob = rs.getString("dob");
			address = rs.getString("address");
			pincode = Long.toString(rs.getLong("pincode"));
			phone = Long.toString(rs.getLong("phone"));
			exp = rs.getString("exp");
			degree = rs.getString("degree");
			stream = rs.getString("stream");;
		}
		rs = ps.executeQuery();
	}

      out.write("\r\n");
      out.write("<form name=\"CandidateProfile\" action=\"UpdateCandidateServlet\" method=\"post\">\r\n");
      out.write("  <table width=\"600\" border=\"0\" align=\"center\" cellpadding=\"5\" cellspacing=\"5\">\r\n");
      out.write("\t<tbody>\r\n");
      out.write("\t\t    <tr>\r\n");
      out.write("\t\t      <td>E-mail</td>\r\n");
      out.write("\t\t      <td><input type=\"text\" name=\"email\"  value=\"");
      out.print( email );
      out.write("\" readonly></td>\r\n");
      out.write("\t        </tr>\r\n");
      out.write("\t        \r\n");
      out.write("\t\t    <tr>\r\n");
      out.write("\t\t      <td>First name</td>\r\n");
      out.write("\t\t      <td><input type=\"text\" name=\"fname\" value=\"");
      out.print( fname );
      out.write("\"></td>\r\n");
      out.write("\t        </tr>\r\n");
      out.write("\t\t    \r\n");
      out.write("\t\t    <tr>\r\n");
      out.write("\t\t      <td>Last name</td>\r\n");
      out.write("\t\t      <td><input type=\"text\" name=\"lname\" value=\"");
      out.print( lname );
      out.write("\"></td>\r\n");
      out.write("\t        </tr>\r\n");
      out.write("\t        \r\n");
      out.write("\t\t    <tr>\r\n");
      out.write("\t\t      <td>Gender</td>\r\n");
      out.write("\t\t      <td><input type=\"text\" name=\"sex\" value=\"");
      out.print( sex );
      out.write("\"></td>\r\n");
      out.write("\t        </tr>\r\n");
      out.write("\t\t  \t\r\n");
      out.write("\t\t  \t<tr>\r\n");
      out.write("\t\t\t\t<td>Date of Birth</td>\r\n");
      out.write("\t\t\t\t<td><input type=\"text\" name=\"dob\" value=\"");
      out.print( dob );
      out.write("\"></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td>Address</td>\r\n");
      out.write("\t\t\t\t<td><input type=\"text\" name=\"address\" value=\"");
      out.print( address );
      out.write("\"></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td>Pincode</td>\r\n");
      out.write("\t\t\t\t<td><input type=\"text\" name=\"pincode\" value=\"");
      out.print( pincode );
      out.write("\"></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td>Contact Number</td>\r\n");
      out.write("\t\t\t\t<td><input type=\"text\" name=\"phone\" value=\"");
      out.print( phone );
      out.write("\"></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td>Years of Experience</td>\r\n");
      out.write("\t\t\t\t<td><input type=\"text\" name=\"exp\" value=\"");
      out.print( exp );
      out.write("\"></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td>Highest Educational Attainment</td>\r\n");
      out.write("\t\t\t\t<td><input type=\"text\" name=\"degree\" value=\"");
      out.print( degree );
      out.write("\"></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td>Stream</td>\r\n");
      out.write("\t\t\t\t<td><input type=\"text\" name=\"stream\" value=\"");
      out.print( stream );
      out.write("\"></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td>&nbsp;</td>\r\n");
      out.write("\t\t\t\t<td><input type=\"submit\" name=\"submit\" id=\"submit\" value=\"Update\"></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("        </tbody>\r\n");
      out.write("\t  </table>\r\n");
      out.write("\t</form>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div id=\"My Applications\" class=\"tabcontent\" align=\"center\">\r\n");
      out.write("  ");

	int job_id=0;
	int app_id = 0;
	String name = null;
	String post = null;
	String location = null;

      out.write("\r\n");
      out.write("\r\n");
  
	Class.forName("com.mysql.jdbc.Driver");
	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/GlobsynST17ProjectDB", "abhishekp03", "d!ve!nnow");
	ps = con.prepareStatement("SELECT a.app_id, a.job_id, r.name, j.post, j.location FROM applist a, joblist j, recruiterProfile r WHERE a.email=? AND a.job_id=j.job_id AND j.email=r.email;");
	ps.setString(1, email);
	rs = ps.executeQuery();

      out.write("\r\n");
      out.write("\t<table align=\"center\" border=\"4\" cellpadding=\"4\">\r\n");
      out.write("\t\t<thead>\r\n");
      out.write("\t\t\t<th>Application #ID</th>\r\n");
      out.write("\t\t\t<th>Job #ID</th>\r\n");
      out.write("\t\t\t<th>Organization</th>\r\n");
      out.write("\t\t\t<th>Designation</th>\r\n");
      out.write("\t\t\t<th>Location</th>\r\n");
      out.write("\t\t</thead>\r\n");

	while(rs.next()){
		app_id = rs.getInt("a.app_id");
		job_id = rs.getInt("a.job_id");
		name = rs.getString("r.name");
		post = rs.getString("j.post");
		location = rs.getString("j.location");	

      out.write("\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td bgcolor=\"white\"><font color=\"blue\">");
      out.print(app_id);
      out.write("</font></td>\r\n");
      out.write("\t\t\t<td bgcolor=\"white\"><font color=\"blue\">");
      out.print(job_id);
      out.write("</font></td>\r\n");
      out.write("\t\t\t<td bgcolor=\"white\"><font color=\"blue\">");
      out.print(name);
      out.write("</font></td>\r\n");
      out.write("\t\t\t<td bgcolor=\"white\"><font color=\"blue\">");
      out.print(post);
      out.write("</font></td>\r\n");
      out.write("\t\t\t<td bgcolor=\"white\"><font color=\"blue\">");
      out.print(location);
      out.write("</font></td>\r\n");
      out.write("\t\t\t<td bgcolor=\"white\"><font color=\"blue\"><a href=\"\">Undo</a></font></td>\r\n");
      out.write("\t\t</tr>\r\n");
 } 
      out.write("\r\n");
      out.write("\t</table>\r\n");
      out.write("</div>\r\n");
      out.write("  \r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("function openTab(evt, tabName) {\r\n");
      out.write("    var i, tabcontent, tablinks;\r\n");
      out.write("    tabcontent = document.getElementsByClassName(\"tabcontent\");\r\n");
      out.write("    for (i = 0; i < tabcontent.length; i++) {\r\n");
      out.write("        tabcontent[i].style.display = \"none\";\r\n");
      out.write("    }\r\n");
      out.write("    tablinks = document.getElementsByClassName(\"tablinks\");\r\n");
      out.write("    for (i = 0; i < tablinks.length; i++) {\r\n");
      out.write("        tablinks[i].className = tablinks[i].className.replace(\" active\", \"\");\r\n");
      out.write("    }\r\n");
      out.write("    document.getElementById(tabName).style.display = \"block\";\r\n");
      out.write("    evt.currentTarget.className += \" active\";\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("// Get the element with id=\"defaultOpen\" and click on it\r\n");
      out.write("document.getElementById(\"default\").click();\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html> ");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}