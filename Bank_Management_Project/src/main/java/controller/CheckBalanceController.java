package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RegistrationDao;
import dto.Registration;
@WebServlet("/checkbalance")
public class CheckBalanceController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter printWriter = resp.getWriter();
		 int inputPin = Integer.parseInt(req.getParameter("pin"));
		 
		 RegistrationDao registrationDao = new RegistrationDao();
         Registration registration = registrationDao.fetchByPin(inputPin);
         if (registration != null && registration.getRegistrationPIN() == inputPin) {
             double currentBalance = registration.getRegistrationAmount();
             printWriter.print("Total Bank Balance is: " +currentBalance);
         }
         else {
        	 printWriter.print("Incorrect PIN. Please try again.");
         }
		
	}
}
