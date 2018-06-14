package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class new_005fevent_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/head.html");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        ");
      out.write("<script src=\"https://code.jquery.com/jquery-3.3.1.js\" \r\n");
      out.write("        integrity=\"sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60=\" \r\n");
      out.write("crossorigin=\"anonymous\"></script>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"css/bootstrap.css\"/>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"css/main.css\"/>\r\n");
      out.write("<script src=\"js/bootstrap.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("        <script src=\"js/new-event.js\"></script>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>VTA | nova akcija</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("            <div class=\"row\">\r\n");
      out.write("                <div class=\"col-md-4 col-md-offset-4\">\r\n");
      out.write("                    <img src=\"img/logo.png\" alt=\"Logo\" class=\"img-center\"/>\r\n");
      out.write("                    <form action=\"AddEvent\" method=\"POST\">\r\n");
      out.write("                        Ime <input type=\"text\" name=\"name\" class=\"form-control\" required autofocus />\r\n");
      out.write("                        Datum <input type=\"date\" name=\"date\" class=\"form-control\" required />\r\n");
      out.write("                        Adresa <input type=\"text\" name=\"place\" class=\"form-control\" required />\r\n");
      out.write("                        Pocetak akcije <input type=\"text\" name=\"startTime\"  class=\"form-control\" id=\"eventStart\" required/>\r\n");
      out.write("                        Kraj akcije <input type=\"text\" name=\"endTime\" class=\"form-control\" id=\"eventEnd\" required/>\r\n");
      out.write("                        Broj volontera <input type=\"text\" name=\"volonteurNumber\" class=\"form-control\" required />\r\n");
      out.write("                        Trajanje u satima (automatski se popunjava)<input type=\"text\" name=\"hoursDuration\" class=\"form-control\" id=\"hours\" readonly />\r\n");
      out.write("                        <input type=\"submit\" value=\"Dodaj akciju\" class=\"submit-button\" />\r\n");
      out.write("                    </form>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
