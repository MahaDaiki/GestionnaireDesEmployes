package controller;

import model.Employee;
import service.EmployeeService;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import javax.servlet.RequestDispatcher;

public class EmployeeServlet extends HttpServlet {

    private EmployeeService employeeService;

    public void init(){
        employeeService = new EmployeeService();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String action = request.getParameter("action");
            switch(action){
                case "add":
                    showAddEmployee(request, response);
                    break;
            }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "add":
                addemployee(request, response);
                break;
        }
    }

    private void showAddEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("addEmployee.jsp");
        dispatcher.forward(request, response);
    }

    private void addemployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone_number = request.getParameter("phone_number");
        String department = request.getParameter("department");
        String position = request.getParameter("position");

        Employee employee = new Employee();
        employee.setName(name);
        employee.setEmail(email);
        employee.setPhone_number(phone_number);
        employee.setDepartment(department);
        employee.setPosition(position);

        employeeService.addEmployee(employee);

        response.sendRedirect("index.jsp");

    }
}
