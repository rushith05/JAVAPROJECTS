package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RegistrationDao;
import dto.Registration;
@WebServlet("/userlogin")
public class UserLogin extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String useremail=req.getParameter("useremail");
		String userpassword=req.getParameter("userpassword");
		
		
		RegistrationDao registrationDao=new RegistrationDao();
		Registration registration=registrationDao.fetchByEmail(useremail);
		
		if(registration.getRegistrationEmail().equals(useremail) && registration.getRegistrationPassword().equals(userpassword))
		{
			resp.sendRedirect("loginoptions.html");
		}
		else
		{
			resp.sendRedirect("userlogin.html");
		}
		
		
		
	
		
	}

}
