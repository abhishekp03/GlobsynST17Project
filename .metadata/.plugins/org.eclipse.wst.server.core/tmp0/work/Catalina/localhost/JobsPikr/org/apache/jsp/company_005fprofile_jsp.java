/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.0.M22
 * Generated at: 2017-07-12 22:59:31 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class company_005fprofile_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
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
      out.write("<body>\r\n");
      out.write("<div class=\"welcome\">\r\n");
      out.write("\tWelcome\r\n");
      out.write("\t<div class=\"username\">\r\n");
      out.write("\tUsername\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div class=\"tab\">\r\n");
      out.write("  <button class=\"tablinks\" onclick=\"openProfile(event, 'Home')\" id=\"defaultOpen\">Home</button>\r\n");
      out.write("  <button class=\"tablinks\" onclick=\"openProfile(event, 'Edit Profile')\">Edit Profile</button>\r\n");
      out.write("  <button class=\"tablinks\" onclick=\"openProfile(event, 'Job List')\">Job List</button>\r\n");
      out.write("  <button class=\"tablinks\" onclick=\"openProfile(event, 'Add Job')\">Add Job</button>\r\n");
      out.write("  <button class=\"tablinks\">Logout</button>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div id=\"Home\" class=\"tabcontent\">\r\n");
      out.write("  <h3>London</h3>\r\n");
      out.write("  <p>London is the capital city of England.</p>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div id=\"Edit Profile\" class=\"tabcontent\" align=\"center\">\r\n");
      out.write("  <table width=\"600\" border=\"0\" align=\"center\" cellpadding=\"5\" cellspacing=\"5\">\r\n");
      out.write("\t<tbody>\r\n");
      out.write("\t\t    <tr>\r\n");
      out.write("\t\t      <td>E-mail</td>\r\n");
      out.write("\t\t      <td><input type=\"text\" name=\"textfield\" id=\"textfield\"></td>\r\n");
      out.write("\t        </tr>\r\n");
      out.write("\t        \r\n");
      out.write("\t\t    <tr>\r\n");
      out.write("\t\t      <td>Name of Organization</td>\r\n");
      out.write("\t\t      <td><input type=\"email\" name=\"email\" id=\"email\"></td>\r\n");
      out.write("\t        </tr>\r\n");
      out.write("\t\t    \r\n");
      out.write("\t\t    <tr>\r\n");
      out.write("\t\t      <td>Address</td>\r\n");
      out.write("\t\t      <td><input type=\"text\" name=\"textfield2\" id=\"textfield2\"></td>\r\n");
      out.write("\t        </tr>\r\n");
      out.write("\t        \r\n");
      out.write("\t\t    <tr>\r\n");
      out.write("\t\t      <td>Pin code</td>\r\n");
      out.write("\t\t      <td><input type=\"text\" name=\"textfield3\" id=\"textfield3\"></td>\r\n");
      out.write("\t        </tr>\r\n");
      out.write("\t\t  \t\r\n");
      out.write("\t\t  \t<tr>\r\n");
      out.write("\t\t\t\t<td>Contact Number</td>\r\n");
      out.write("\t\t\t\t<td><input type=\"text\" name=\"textfield4\" id=\"textfield4\"></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td>Website</td>\r\n");
      out.write("\t\t\t\t<td><input type=\"text\" name=\"textfield5\" id=\"textfield5\"></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td>&nbsp;</td>\r\n");
      out.write("\t\t\t\t<td><input type=\"submit\" name=\"submit\" id=\"submit\" value=\"Update\"></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("        </tbody>\r\n");
      out.write("\t  </table> \r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div id=\"Job List\" class=\"tabcontent\" align=\"center\">\r\n");
      out.write("  <table width=\"900\" border=\"0\" align=\"center\">\r\n");
      out.write("\t\t  <tbody>\r\n");
      out.write("\t\t    <tr>\r\n");
      out.write("\t\t      <td>Search By</td>\r\n");
      out.write("\t\t      <td>Job Title\r\n");
      out.write("\t          <input type=\"text\" name=\"textfield\" id=\"textfield\" placeholder=\"Enter Job Title\"></td>\r\n");
      out.write("\t\t      <td>Date\r\n");
      out.write("\t          <input type=\"date\" name=\"date\" id=\"date\" placeholder=\"Enter Date\"></td>\r\n");
      out.write("\t\t      <td>Location\r\n");
      out.write("\t          <input type=\"text\" name=\"textfield2\" id=\"textfield2\" placeholder=\"Enter Location\"></td>\r\n");
      out.write("\t\t\t  <td><input type=\"submit\" value=\"Search\"></td>\r\n");
      out.write("\t        </tr>\r\n");
      out.write("\t    </tbody>\r\n");
      out.write("\t  </table>\r\n");
      out.write("\t  <p><a href=\"company_addjob.html\">Add New Job Title</a></p>\r\n");
      out.write("\t  <table width=\"900\" border=\"0\" align=\"center\">\r\n");
      out.write("\t    <tbody>\r\n");
      out.write("\t      <tr>\r\n");
      out.write("\t        <td>Job ID</td>\r\n");
      out.write("\t        <td>Job Title</td>\r\n");
      out.write("\t        <td>Date</td>\r\n");
      out.write("\t        <td>Location</td>\r\n");
      out.write("          </tr>\r\n");
      out.write("\t      <tr>\r\n");
      out.write("\t        <td>J11</td>\r\n");
      out.write("\t        <td>JSP Developer</td>\r\n");
      out.write("\t        <td>10/8/2017</td>\r\n");
      out.write("\t        <td>Delhi</td>\r\n");
      out.write("\t\t\t<td><input type=\"submit\" value=\"Modify\"></td>\r\n");
      out.write("\t\t\t<td><input type=\"submit\" value=\"Delete\"></td>\r\n");
      out.write("          </tr>\r\n");
      out.write("        </tbody>\r\n");
      out.write("      </table>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div id=\"Add Job\" class=\"tabcontent\" align=\"center\">\r\n");
      out.write("  <table width=\"700\" border=\"0\" align=\"center\">\r\n");
      out.write("\t\t  <tbody>\r\n");
      out.write("\t\t    <tr>\r\n");
      out.write("\t\t      <td>Job Title</td>\r\n");
      out.write("\t\t      <td><input type=\"text\" name=\"textfield\" id=\"textfield\"></td>\r\n");
      out.write("\t        </tr>\r\n");
      out.write("\t\t    <tr>\r\n");
      out.write("\t\t      <td>Date</td>\r\n");
      out.write("\t\t      <td><input type=\"date\" name=\"date\" id=\"date\"></td>\r\n");
      out.write("\t        </tr>\r\n");
      out.write("\t\t    <tr>\r\n");
      out.write("\t\t      <td>Location</td>\r\n");
      out.write("\t\t      <td><input type=\"text\" name=\"textfield2\" id=\"textfield2\"></td>\r\n");
      out.write("\t        </tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td>Salary</td>\r\n");
      out.write("\t\t\t\t<td><input type=\"text\" name=\"salary\" id=\"salary\"></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t    <tr>\r\n");
      out.write("\t\t      <td>Description</td>\r\n");
      out.write("\t\t      <td><textarea name=\"textarea\" id=\"textarea1\" style=\"height: 300px;width: 500px\"></textarea></td>\r\n");
      out.write("\t        </tr>\r\n");
      out.write("\t\t    <tr>\r\n");
      out.write("\t\t      <td>&nbsp;</td>\r\n");
      out.write("\t\t      <td><input type=\"submit\" name=\"submit\" id=\"submit1\" value=\"Add\"></td>\r\n");
      out.write("\t        </tr>\r\n");
      out.write("        </tbody>\r\n");
      out.write("\t  </table>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("function openProfile(evt, cityName) {\r\n");
      out.write("    var i, tabcontent, tablinks;\r\n");
      out.write("    tabcontent = document.getElementsByClassName(\"tabcontent\");\r\n");
      out.write("    for (i = 0; i < tabcontent.length; i++) {\r\n");
      out.write("        tabcontent[i].style.display = \"none\";\r\n");
      out.write("    }\r\n");
      out.write("    tablinks = document.getElementsByClassName(\"tablinks\");\r\n");
      out.write("    for (i = 0; i < tablinks.length; i++) {\r\n");
      out.write("        tablinks[i].className = tablinks[i].className.replace(\" active\", \"\");\r\n");
      out.write("    }\r\n");
      out.write("    document.getElementById(cityName).style.display = \"block\";\r\n");
      out.write("    evt.currentTarget.className += \" active\";\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("// Get the element with id=\"defaultOpen\" and click on it\r\n");
      out.write("document.getElementById(\"defaultOpen\").click();\r\n");
      out.write("</script>\r\n");
      out.write("     \r\n");
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
