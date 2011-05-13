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
				ses.setAttribute("action", tk.substring(0, tk.indexOf(".do")));
			}else
			{
				ses.setAttribute("id", tk);
				if(st.hasMoreElements())
				{	tk=st.nextToken();
					ses.setAttribute("action", tk.substring(0, tk.indexOf(".do")));
				}
			}
		}
		Enumeration<String> ean = req.getAttributeNames();
		while(ean.hasMoreElements())
		{
			String an = ean.nextElement();
			ses.setAttribute(an, req.getAttribute(an));
		}
		ses.setAttribute("section", null);
		DatenbankZugriff.getDatenbankZugriff().setZugangsdaten();
		Section s1 = new Section();
		s1.setPrimary((String)ses.getAttribute("id"));
		s1.reload();
		if (s1.getPrimary().equals(ses.getAttribute("id")))
			ses.setAttribute("section", s1);
		else
			ses.setAttribute("section", "nicht geladen!");
		String view = "/"+ses.getAttribute("controller")+"/"+ses.getAttribute("action")+".jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(view);
		dispatcher.forward(req,resp);
	}
	
}
