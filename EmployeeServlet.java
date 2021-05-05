package com.employee;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;


import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.employee.dao.Employee;
import com.employee.dao.EmployeeDAOImpl;

/**
 * SerVlet implementation class EmployeeServeet
 */
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 EmployeeDAOImpl ediObj;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeServlet() {
        super();
        System.out.println("Employee servlet");
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		 System.out.println("init...");
		 ediObj = new EmployeeDAOImpl();
		  
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		 System.out.println("\t\tdestroy....");
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 System.out.println("\tservice....");
		 PrintWriter pw =response.getWriter();
		 pw.println("<h2>Welcome to Employee Portal</h2>");
		 pw.println("<a href ='http://localhost:8080/EmployeeServlet/'> Home</a>");
	List<Employee> empList =ediObj.findEmployees(); 
	Iterator<Employee> iter  = empList.iterator();
	pw.println("<table border=5>");
	while(iter.hasNext()) {
		Employee e = iter.next();
		pw.println("<tr>");
		pw.println("<td>Employee Number</td><td>"+e.getEmployeeNumber()+"</td>");
		pw.println("<td>Employee Name</td><td>"+e.getEmployeeName()+"</td>");
		pw.println("<td>Employee Job</td><td>"+e.getEmployeeJob()+"</td>");
		pw.println("</tr>");
	
	}
	pw.println("</table>");
	}

}
