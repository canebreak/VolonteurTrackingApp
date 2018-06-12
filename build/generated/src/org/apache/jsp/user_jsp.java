package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class user_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

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

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head> \n");
      out.write("        <script\n");
      out.write("            src=\"https://code.jquery.com/jquery-3.3.1.js\"\n");
      out.write("            integrity=\"sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60=\"\n");
      out.write("        crossorigin=\"anonymous\"></script>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/bootstrap.css\"/>\n");
      out.write("        <script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"row\">\n");
      out.write("            <div class=\"col-md-6 col-md-offset-3\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-md-4 col-md-offset-4\">\n");
      out.write("                        <div class=\"col-md-2\">Ime:</div>\n");
      out.write("                        <div class=\"col-md-2 col-md-offset-2 pull-right\">Ime</div>\n");
      out.write("                    </div></div>\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-md-4 col-md-offset-4\">\n");
      out.write("                        <div class=\"col-md-2\">Prezime:</div>\n");
      out.write("                        <div class=\"col-md-2 col-md-offset-2 pull-right\">Prezime</div>\n");
      out.write("                    </div></div>\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-md-4 col-md-offset-4\">\n");
      out.write("                        <div class=\"col-md-2\">Datum rodjenja:</div>\n");
      out.write("                        <div class=\"col-md-2 col-md-offset-2 pull-right\">Datum rodjenja</div>\n");
      out.write("                    </div></div>\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-md-4 col-md-offset-4\">\n");
      out.write("                        <div class=\"col-md-2\">Broj sati:</div>\n");
      out.write("                        <div class=\"col-md-2 col-md-offset-2 pull-right\">Broj sati</div>\n");
      out.write("                    </div></div>\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-md-4 col-md-offset-4\">\n");
      out.write("                        <div class=\"col-md-2\">Aktivan od: </div>\n");
      out.write("                        <div class=\"col-md-2 col-md-offset-2 pull-right\">Aktivan od</div>\n");
      out.write("                    </div></div>\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-md-4 col-md-offset-4\">\n");
      out.write("                        <div class=\"col-md-2\">Korisnicko ime: </div>\n");
      out.write("                        <div class=\"col-md-2 col-md-offset-2 pull-right\">Korisnicko ime</div>\n");
      out.write("                    </div></div>\n");
      out.write("                \n");
      out.write("                <table class=\"table table-striped\">\n");
      out.write("                    <thead>\n");
      out.write("                        <tr>\n");
      out.write("                            <th>Ime</th>\n");
      out.write("                            <th>Mesto</th>\n");
      out.write("                            <th>Datum</th>\n");
      out.write("                            <th>Pocetak</th>\n");
      out.write("                            <th>Kraj</th>\n");
      out.write("                            <th>Trajanje</th>\n");
      out.write("                        </tr>\n");
      out.write("                    </thead>\n");
      out.write("                    <tbody>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>John</td>\n");
      out.write("                            <td>Doe</td>\n");
      out.write("                            <td>john@example.com</td>\n");
      out.write("                            <td>John</td>\n");
      out.write("                            <td>Doe</td>\n");
      out.write("                            <td>john@example.com</td>\n");
      out.write("                        </tr> <tr>\n");
      out.write("                            <td>John</td>\n");
      out.write("                            <td>Doe</td>\n");
      out.write("                            <td>john@example.com</td>\n");
      out.write("                            <td>John</td>\n");
      out.write("                            <td>Doe</td>\n");
      out.write("                            <td>john@example.com</td>\n");
      out.write("                        </tr> \n");
      out.write("                        <tr>\n");
      out.write("                            <td>John</td>\n");
      out.write("                            <td>Doe</td>\n");
      out.write("                            <td>john@example.com</td>\n");
      out.write("                            <td>John</td>\n");
      out.write("                            <td>Doe</td>\n");
      out.write("                            <td>john@example.com</td>\n");
      out.write("                        </tr>\n");
      out.write("                    </tbody>\n");
      out.write("                </table>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
