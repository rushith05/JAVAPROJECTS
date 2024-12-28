package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RegistrationDao;
import dto.Registration;
@WebServlet("/registrationform")
public class RegistrationController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String firstname=req.getParameter("firstname");
		String lastname=req.getParameter("lastname");
		String dob=req.getParameter("dateofbirth");
		String email=req.getParameter("email");
		long phone=Long.parseLong(req.getParameter("phonenumber"));
		int pin=Integer.parseInt(req.getParameter("pin"));
		String address=req.getParameter("address");
		double balance=Double.parseDouble(req.getParameter("balance"));
		String password=req.getParameter("password");
		String gender=req.getParameter("gender");
		
		Registration registration=new Registration();
		RegistrationDao registrationDao=new RegistrationDao();
		
		registration.setRegistrationFirstName(firstname);
		registration.setRegistrationLastName(lastname);
		registration.setRegistrationDOB(dob);
		registration.setRegistrationEmail(email);
		registration.setRegistrationPhone(phone);
		registration.setRegistrationPIN(pin);
		registration.setRegistrationAddress(address);
		registration.setRegistrationAmount(balance);
		registration.setRegistrationPassword(password);
		registration.setRegistrationGender(gender);
		
		
		registrationDao.insert(registration);
		
		resp.sendRedirect("userlogin.html");
		
	}
}
