package m151.apiu904.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import m223.apiu904.db.DatenbankZugriff;
import m223.apiu904.model.Section;

public class ControllerServlet extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		DatenbankZugriff.getDatenbankZugriff().setZugangsdaten();
		Section s = new Section();
		s.setPrimary("3");
		s.reload();
		if (s!=null)
			req.getSession().setAttribute("section", s);
		else
			req.getSession().setAttribute("section", "nicht geladen!");
		String view = "/section/show.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(view);
		dispatcher.forward(req,resp);
	}
	
}
