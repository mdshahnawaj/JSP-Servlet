package com.registration.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.registration.dao.EmployeeDaoImpl;
import com.registration.dao.EmployeeDao;
import com.registration.model.Employee;

/**
 * Class is used for servlet implementation and perform save/prevent duplicate
 * contact number into a database
*/
@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * This method is used to get a value from a form
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	*/
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		String contact = request.getParameter("contact");
		String contactNumber = request.getParameter("contactNo");

		Employee employee = new Employee();
		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		employee.setUserName(userName);
		employee.setPassword(password);
		employee.setAddress(address);
		employee.setContact(contact);

		EmployeeDao service = new EmployeeDaoImpl();

		/**
		 * This statement is used to call saveRegistration method and and get result in boolean form
		 * @param employee object
		*/
		boolean success = service.saveRegistration(employee);

		if (success) {
			request.setAttribute("message", "Registration done successfully:)");
			request.setAttribute("firstName", employee.getFirstName());
			request.setAttribute("lastName", employee.getLastName());
			request.setAttribute("userName", employee.getUserName());
			request.setAttribute("password", employee.getPassword());
			request.setAttribute("address", employee.getAddress());
			request.setAttribute("contact", employee.getContact());

			request.getRequestDispatcher("welcome.jsp").forward(request, response);
		}

		/**
		 * This statement is used to call isMobileNumberExists method and and get result in boolean form
		 * @param contactNumber
		*/
		boolean contactExists = service.isMobileNumberExists(contactNumber);
		response.getWriter().write(String.valueOf(contactExists));
	}

}