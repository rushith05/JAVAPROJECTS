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
@WebServlet("/transfer")
public class MoneyTransferController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
        PrintWriter printWriter = resp.getWriter();

        try {
           
            double inputAmount = Double.parseDouble(req.getParameter("money"));
            int inputPin = Integer.parseInt(req.getParameter("pin"));

            RegistrationDao registrationDao = new RegistrationDao();
            Registration registration = registrationDao.fetchByPin(inputPin);

            if (registration != null && registration.getRegistrationPIN() == inputPin) {
                double currentBalance = registration.getRegistrationAmount();
                if (currentBalance >= inputAmount || currentBalance<=inputAmount) {
                    double updatedBalance = currentBalance - inputAmount;
                    registration.setRegistrationAmount(updatedBalance);
                    registrationDao.updateAmount(updatedBalance, inputPin); 
                    printWriter.print("Transfered successful. Total balance is: " + updatedBalance);
                } else {
                    printWriter.print("Insufficient balance. Please try again.");
                }
            } else {
                printWriter.print("Incorrect PIN. Please try again.");
            }
        } catch (NumberFormatException e) {
            printWriter.print("Invalid input. Please provide valid amount and PIN.");
        } catch (Exception e) {
            printWriter.print("An error occurred. Please try again later.");
            e.printStackTrace();
        } finally {
            printWriter.close();
        }
}
	}


