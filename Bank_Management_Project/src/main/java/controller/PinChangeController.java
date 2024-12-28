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
@WebServlet("/pinchange")
public class PinChangeController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter printWriter = resp.getWriter();
		int oldPin = Integer.parseInt(req.getParameter("oldpin"));
		int newpin = Integer.parseInt(req.getParameter("newpin"));
		
		Registration registration=new Registration();
		RegistrationDao registrationDao = new RegistrationDao();
		boolean result=registrationDao.updatepin(oldPin, newpin, registration);
		if(result)
		{
			printWriter.print("PIN Changed Successfully");
		}
		else {
			printWriter.print("Invalid input. Please provide valid amount and PIN.");
		}
	}
}
