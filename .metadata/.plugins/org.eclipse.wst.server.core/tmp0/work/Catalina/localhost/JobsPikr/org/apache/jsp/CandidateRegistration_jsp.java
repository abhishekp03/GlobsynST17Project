/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.0.M22
 * Generated at: 2017-07-20 07:15:27 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class CandidateRegistration_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/Header.css\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/Common.css\">\r\n");
      out.write("\r\n");
      out.write("<title>Candidate :: Register</title>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t\t\r\n");
      out.write("\tfunction checkEmail(value){ \r\n");
      out.write("\t\txmlHttp=GetXmlHttpObject()\r\n");
      out.write("\t\tvar url=\"checkAJAX.jsp\";\r\n");
      out.write("\t\turl=url+\"?email=\"+value;\r\n");
      out.write("\t\txmlHttp.onreadystatechange=stateChanged\r\n");
      out.write("\t\txmlHttp.open(\"GET\",url,true)\r\n");
      out.write("\t\txmlHttp.send(null)\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\tfunction stateChanged(){ \r\n");
      out.write("\t\tif(xmlHttp.readyState==4 || xmlHttp.readyState==\"complete\"){ \r\n");
      out.write("\t\t\tvar showdata = xmlHttp.responseText; \r\n");
      out.write("\t\t\tdocument.getElementById(\"mydiv\").innerHTML= showdata;\r\n");
      out.write("\t\t} \r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tfunction GetXmlHttpObject(){\r\n");
      out.write("\t\tvar xmlHttp=null;\r\n");
      out.write("\t\ttry{\r\n");
      out.write("\t\t\txmlHttp=new XMLHttpRequest();\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tcatch (e) {\r\n");
      out.write("\t\t\ttry {\r\n");
      out.write("\t\t\t\txmlHttp=new ActiveXObject(\"Msxml2.XMLHTTP\");\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tcatch (e){\r\n");
      out.write("\t\t\txmlHttp=new ActiveXObject(\"Microsoft.XMLHTTP\");\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\treturn xmlHttp;\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("<script>\r\n");
      out.write("\tfunction RegValidator()\r\n");
      out.write("\t{\r\n");
      out.write("\t\tvar email = document.candidateRegistration.emailNC.value;\r\n");
      out.write("\t\tvar password = document.candidateRegistration.passwordNC.value;\r\n");
      out.write("\t\tvar passwordC = document.candidateRegistration.confirmPasswordNC.value;\r\n");
      out.write("\t\tvar validemail = /[a-zA-Z0-9._-]+[@]{1}[a-z]+[.]{1}[a-zA-Z]{3}$/;\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tif(email == \"\")\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\t\talert(\"Enter email\");\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tif(!(validemail.test(email)))\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\t\talert(\"email not correct\");\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif(password == \"\")\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\t\talert(\"Enter password\");\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif(password != passwordC)\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\t\talert(\"Password not match\");\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\treturn true;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\t\r\n");
      out.write("\t<div id=\"header\">\r\n");
      out.write("\t\t<img class=\"center\" src=\"Images/JobsPikr.png\">\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t<div class=\"wrapper\">\r\n");
      out.write("\t\t<div class=\"main\" style=\"text-align:center; min-height:600px\">\r\n");
      out.write("\t\t\t<form name=\"candidateRegistration\" action=\"CandidateRegistrationServlet\" method=\"post\" onsubmit=\"return RegValidator();\">\r\n");
      out.write("\t\t\t\t<br><br><br><br>\r\n");
      out.write("\t\t\t\t<font color=\"red\" size=\"2\"><div id=\"mydiv\"></div></font>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<table align=\"center\">\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td><h3>Candidate Registration</h3></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td><input type=\"text\" name=\"emailNC\" placeholder=\"Enter your e-mail\" onkeyup=\"checkEmail(this.value);\"></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td><input type=\"password\" name=\"passwordNC\" placeholder=\"Enter password\"></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td><input type=\"password\" name=\"confirmPasswordNC\" placeholder=\"Confirm password\"></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t<input type=\"submit\" id=\"signupNC\" value=\"Sign up\">\t\t\t\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t\t<div id=\"footer\">\r\n");
      out.write("\t\t\t<p><font color=\"#505050\" size=\"2\" face=\"Georgia\">&copy; Copyright 2017. All rights reserved.<br>Best viewed on a resolution of 1920 x 1080 on Google Chrome.</font></p>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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
