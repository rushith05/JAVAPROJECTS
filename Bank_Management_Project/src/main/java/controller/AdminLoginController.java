package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdminDao;
import dao.RegistrationDao;
import dto.Admin;
import dto.Registration;
@WebServlet("/adminlogin2")
public class AdminLoginController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String adminemail=req.getParameter("email");
		String adminpassword=req.getParameter("password");
		
		AdminDao adminDao=new AdminDao();
		Admin admin=adminDao.fetchByEmail(adminemail);
		RegistrationDao registerationDao=new RegistrationDao();
		
		if(admin.getAdminEmail().equals(adminemail) && admin.getAdminPassword().equals(adminpassword))
		{
			List<Registration> registration=registerationDao.fetchall();
			req.setAttribute("Registrations", registration);
			RequestDispatcher dispatcher=req.getRequestDispatcher("display.jsp");
			dispatcher.forward(req, resp);
		}
		else
		{
			resp.sendRedirect("adminlogin.html");
		}
		
	}
}
