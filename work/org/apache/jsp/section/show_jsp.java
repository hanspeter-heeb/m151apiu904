package org.apache.jsp.section;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import m223.apiu904.model.*;

public final class show_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write('\n');

	Object o = session.getAttribute("section");
	Section s = null;
	if(o instanceof Section)
		s = (Section) o;

      out.write("\n");
      out.write("<html>\n");
      out.write("\t<head>\n");
      out.write("\t\t<title></title>\n");
      out.write("\t</head>\n");
      out.write("\t<body>\n");
      out.write("\t\t\n");
      out.write("\t\t<h3>");
      out.print( s==null? "Datensatz nicht gefunden" : s.getTitle() );
      out.write("</h3>\n");
      out.write("\t\t<p>");
      out.print(  session.getAttribute("base") );
      out.write("</p>\n");
      out.write("\t\t<p>controller");
      out.print(  session.getAttribute("controller") );
      out.write("</p>\n");
      out.write("\t\t<p>action");
      out.print(  session.getAttribute("action") );
      out.write("</p>\n");
      out.write("\t\t<p>id");
      out.print(  session.getAttribute("id") );
      out.write("</p>\n");
      out.write("\t\t\n");
      out.write("\t</body>\n");
      out.write("</html>");
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
