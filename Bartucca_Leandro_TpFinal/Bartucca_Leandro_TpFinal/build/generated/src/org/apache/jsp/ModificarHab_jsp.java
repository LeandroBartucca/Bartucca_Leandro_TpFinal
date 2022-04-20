package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Logica.Habitacion;

public final class ModificarHab_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <title>Modificar Habitacion</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/bootstrap.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/fontawesome.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/style.css\">\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css?family=Lobster|Lobster+Two|Noto+Serif\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css?family=Roboto\" rel=\"stylesheet\">\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        ");

            HttpSession miSesion = request.getSession();

            String usu = (String) miSesion.getAttribute("usuario");
            if (usu == null) {
                response.sendRedirect("Login.jsp");
            } else {

        
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"contact main-font-family text-center\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <h2 id=\"contact\">Modificar Habitacion</h2>\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-6\">\n");
      out.write("                        <div class=\"contact-form\">\n");
      out.write("                            \n");
      out.write("                            ");
 
                            
                            HttpSession miSesionMH = request.getSession();
                                Habitacion hab = (Habitacion) miSesionMH.getAttribute("habitacion");
                            
                            
      out.write("\n");
      out.write("                            \n");
      out.write("                            <form action=\"SvModificarHab\" method=\"get\">\n");
      out.write("                                <input type=\"text\" name=\"num_hab\" placeholder=\"Numero de habitacion\" value=\"");
      out.print( hab.getNum_hab());
      out.write("\">\n");
      out.write("                                <input type=\"text\" name=\"piso\" placeholder=\"Piso\" value=\"");
      out.print( hab.getPiso());
      out.write("\">\n");
      out.write("                                <input type=\"text\" name=\"nombre\" placeholder=\"Nombre\" value=\"");
      out.print( hab.getNombre());
      out.write("\">\n");
      out.write("                                \n");
      out.write("                                    <select class=\"selectbonito\" name=\"tipo\">\n");
      out.write("                                       <option>Single</option>\n");
      out.write("                                       <option>Doble</option>\n");
      out.write("                                       <option>Triple</option>\n");
      out.write("                                       <option>Multiple</option>\n");
      out.write("                                    </select>\n");
      out.write("                                ");
 String prec_aux =Float.toString(hab.getPrecio_noche());
      out.write("\n");
      out.write("                                <input type=\"number\" name=\"precio_noche\" placeholder=\"Precio por noche\" value=\"");
      out.print( prec_aux );
      out.write("\">\n");
      out.write("                                \n");
      out.write("                                <input type=\"hidden\" name=\"id_hab\" value=\"");
      out.print( hab.getId_hab());
      out.write("\">\n");
      out.write("\n");
      out.write("                                <input type=\"submit\" value=\"Registrar\">\n");
      out.write("                            </form>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-6\">\n");
      out.write("                        <h2 class=\"text-right\"></h2>\n");
      out.write("                        <img src=\"imgs/shape.png\">\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div></div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        ");
            }
        
      out.write("\n");
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
