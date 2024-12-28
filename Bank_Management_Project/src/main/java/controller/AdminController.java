package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdminDao;
import dto.Admin;
@WebServlet("/adminlogin")
public class AdminController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Admin admin=new Admin();
		AdminDao adminDao=new AdminDao();

		String adminemail=req.getParameter("email");
		String adminpassword=req.getParameter("password");
		
		admin.setAdminEmail(adminemail);
		admin.setAdminPassword(adminpassword);
		
		adminDao.insertadmin(admin);
	}
}


