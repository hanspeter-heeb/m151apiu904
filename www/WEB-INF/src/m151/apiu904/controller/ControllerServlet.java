package m151.apiu904.controller;

import java.io.IOException;

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
		s.setTitle(getServletName());
		s.save();
	}
	
}
