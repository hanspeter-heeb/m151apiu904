package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class ajax_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \n");
      out.write("\t\"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write(" <meta http-equiv=\"content-type\" content=\"text/html;charset=UTF-8\" />\n");
      out.write("\t<title>Prototype Beispiel</title>\n");
      out.write("\t<script src=\"/m151/javascripts/prototype.js\" type=\"text/javascript\"></script>\n");
      out.write("\t<script>\n");
      out.write("\t\tzaehlen=function(page) {\n");
      out.write("\t\t\t$('indicator').show();\n");
      out.write("\t\t\tnew Ajax.Updater(\n");
      out.write("\t\t\t\t\"eineID\",\n");
      out.write("\t\t\t\tpage,\n");
      out.write("\t\t\t\t{\n");
      out.write("\t\t\t\t\tmethod: \"post\",\n");
      out.write("\t\t\t\t\tparameters: $('form').serialize(true),\n");
      out.write("\t\t\t    onComplete:function(request){$('indicator').hide()},\n");
      out.write("\t\t\t\t\tonFailure: function(){ alert('Etwas ist schiefgelaufen...') }\n");
      out.write("\t\t\t\t}\n");
      out.write("\t\t\t);\n");
      out.write("\t\t}\n");
      out.write("\t</script>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\t<span id=\"indicator\" style=\"display: none;\">Laden ...</span>\n");
      out.write("\t<span id=\"eineID\">Hier erscheint spÃ¤ter der dynamische Teil</span>\n");
      out.write("\t<hr/>\n");
      out.write("\t<form id=\"form\"\">\n");
      out.write("\t\t<input type=\"text\" size=\"40\" name=\"eingabe\" id=\"eingabe\"><br />\n");
      out.write("\t\t<input type=\"text\" size=\"40\" name=\"eingabe2\" id=\"eingabe2\"><br />\n");
      out.write("\t\t<input type=\"button\"  onclick=\"zaehlen('formElements.jsp');\" value=\"Formularelemente anzeigen\" >\n");
      out.write("\t </form>\n");
      out.write("\t <p><a href=\"#\" onclick=\"zaehlen('counter.jsp');\">HochzÃ¤hlen</a></p>\n");
      out.write("</body>\n");
      out.write("</html>\t");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
