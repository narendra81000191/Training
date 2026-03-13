package com.coforge.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.coforge.dao.EmployeeDAO;
import com.coforge.models.Employee;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Employeeservlet")
public class Employeeservlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Employeeservlet() { }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null) action = "list";

        RequestDispatcher rd;

        switch (action) {

            case "list":
                List<Employee> empList = EmployeeDAO.getAllEmployees();
                request.setAttribute("empList", empList);
                rd = request.getRequestDispatcher("employeelist.jsp");
                rd.forward(request, response);
                break;

            case "new":
                rd = request.getRequestDispatcher("Employeeform.jsp");
                rd.forward(request, response);
                break;

            case "edit":
                long eid = Long.parseLong(request.getParameter("eid"));
                Employee emp = EmployeeDAO.getEmployeeById(eid);
                request.setAttribute("employee", emp);
                rd = request.getRequestDispatcher("Employeeform.jsp");
                rd.forward(request, response);
                break;

			case "delete":
			    int delId = Integer.parseInt(request.getParameter("eid"));
			    EmployeeDAO.deleteEmployee(delId);
			    response.sendRedirect("Employeeservlet?action=list");
			    break;

			case "info":
				long infoid = Long.parseLong(request.getParameter("eid"));
				Employee info = EmployeeDAO.getEmployeeById(infoid);

				request.setAttribute("employee", info);
				request.getRequestDispatcher("info.jsp").forward(request, response);
				break;

			case "search": {
                String keyword = request.getParameter("keyword");

                List<Employee> empList1;

                if (keyword == null || keyword.trim().isEmpty()) {
                    empList1 = EmployeeDAO.getAllEmployees();
                } else {
                    empList1 = EmployeeDAO.searchEmployees(keyword.trim());
                }

                request.setAttribute("empList", empList1);
                RequestDispatcher rd1 = request.getRequestDispatcher("employeelist.jsp");
                rd1.forward(request, response);
                return;
            }


            default:
                response.sendRedirect("Employeeservlet?action=list");
        }
    }

    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//    	System.out.println(">>> doPost called <<<");
//        //String eidStr = request.getParameter("eid");
//        String ename = request.getParameter("ename");
//        long salary = Long.parseLong(request.getParameter("salary"));
//        String email = request.getParameter("email");
//        String mobile = request.getParameter("mobile");
//        LocalDate doj = LocalDate.parse(request.getParameter("doj"));
//        LocalDate dob = LocalDate.parse(request.getParameter("dob"));
//
//        Employee emp = new Employee(ename, salary, email, mobile, doj, dob);
//
//        EmployeeDAO.addEmployee(emp);
//
//       // response.sendRedirect("Employeeservlet?action=list");
//        System.out.println(
//        	    "ename=" + ename +
//        	    ", salary=" + salary +
//        	    ", email=" + email +
//        	    ", mobile=" + mobile +
//        	    ", doj=" + doj +
//        	    ", dob=" + dob
//        	);
//       
//        response.sendRedirect("Employeeservlet?action=list");
//    }
//}





protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
	String eid = request.getParameter("eid");
	String ename = request.getParameter("ename");
	long salary = Long.parseLong(request.getParameter("salary"));
	String email = request.getParameter("email");
	String mobile = request.getParameter("mobile");
	LocalDate doj = LocalDate.parse(request.getParameter("doj"));
	LocalDate dob = LocalDate.parse(request.getParameter("dob"));
	
	PrintWriter out = response.getWriter();
	RequestDispatcher rd = null;
	if(eid==null || eid.isEmpty()) {
		Employee e = new Employee(ename,salary,email,mobile,doj,dob);
		EmployeeDAO.addEmployee(e);
	
//		if(EmployeeDAO.addEmployee(e) == null) {
//			out.println("Data not added");
//		}
		out.println(e+"Employee added");
		List<Employee> empList = EmployeeDAO.getAllEmployees();
		request.setAttribute("empList", empList);
		rd = request.getRequestDispatcher("employeelist.jsp");
		rd.forward(request, response);
	}

//	} else {
//		
//	}
	
	else {
		long empid = Long.parseLong(eid);
		Employee employee = new Employee();
		employee.setEid(empid);
		employee.setEname(ename);
		employee.setSalary(salary);
		employee.setEmail(email);
		employee.setMobile(mobile);
		employee.setDoj(doj);
		employee.setDob(dob);
		EmployeeDAO.updateEmployee(employee);
		
	}
	response.sendRedirect("Employeeservlet?action=list");

}
    }

    

