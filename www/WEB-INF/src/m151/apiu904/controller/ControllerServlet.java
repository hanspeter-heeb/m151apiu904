package m151.apiu904.controller;

import java.io.IOException;
import java.util.Enumeration;
import java.util.StringTokenizer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import m223.apiu904.db.DatenbankZugriff;
import m223.apiu904.model.Section;

public class ControllerServlet extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		// URI verarbeiten
		HttpSession ses = req.getSession();
		String s = req.getRequestURI();
		String base=null, con=null, controller=null, action=null, id=null;
		StringTokenizer st = new StringTokenizer(s,"/");
		if(st.hasMoreElements())
			ses.setAttribute("base", st.nextToken());
		if(st.hasMoreElements())
			ses.setAttribute("controller", st.nextToken());
		if(st.hasMoreElements())
		{	String tk=st.nextToken();
			if(tk.indexOf(".do")>0)
			{
				ses.setAttribute("action", tk);
			}else
			{
				ses.setAttribute("id", tk);
				if(st.hasMoreElements())
					ses.setAttribute("action", st.nextToken());
			}
		}
		Enumeration<String> ean = req.getAttributeNames();
		while(ean.hasMoreElements())
		{
			String an = ean.nextElement();
			ses.setAttribute(an, req.getAttribute(an));
		}
			
		DatenbankZugriff.getDatenbankZugriff().setZugangsdaten();
		Section s1 = new Section();
		s1.setPrimary("3");
		s1.reload();
		if (s1!=null)
			req.getSession().setAttribute("section", s1);
		else
			req.getSession().setAttribute("section", "nicht geladen!");
		String view = "/section/show.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(view);
		dispatcher.forward(req,resp);
	}
	
}
