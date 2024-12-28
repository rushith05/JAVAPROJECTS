package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RegistrationDao;
import dto.Registration;

@WebServlet("/delete")
public class DeleteR extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		
		RegistrationDao registrationDao=new RegistrationDao();
		boolean result=registrationDao.deletebyid(id);
		if(result)
		{
			List<Registration> registration=registrationDao.fetchall();
			req.setAttribute("Registrations", registration);
			RequestDispatcher dispatcher=req.getRequestDispatcher("display.jsp");
			dispatcher.forward(req, resp);
		}
	}

}
