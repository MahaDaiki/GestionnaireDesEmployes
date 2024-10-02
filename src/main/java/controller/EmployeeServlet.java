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
                case "edit":
                    ShowEditEmployee(request, response);
                default:
                    showalleployees(request, response);


            }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "add":
                addemployee(request, response);
                break;
            case "update":
                UpdateEmployee(request, response);
                break;
            case "delete":
                DeleteEmployee(request, response);
                break;
            default:
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "Action not found");
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
    private void UpdateEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idParm = request.getParameter("id");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone_number = request.getParameter("phone_number");
        String department = request.getParameter("department");
        String position = request.getParameter("position");

        if (idParm != null) {
            long id = Integer.parseInt(idParm);

            Employee employee = new Employee();
            employee.setName(name);
            employee.setEmail(email);
            employee.setPhone_number(phone_number);
            employee.setDepartment(department);
            employee.setPosition(position);

            employeeService.updateEmployee(employee);
            response.sendRedirect("index.jsp");

        }
        else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid employee details");
        }
    }
    private void ShowEditEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idParm = request.getParameter("id");
        if (idParm != null) {
            long id = Integer.parseInt(idParm);
            Employee employee = employeeService.getEmployee(id);
            if (employee != null) {
                request.setAttribute("employee", employee);
                RequestDispatcher dispatcher = request.getRequestDispatcher("editEmployee.jsp");
                dispatcher.forward(request, response);
            }
            else {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid employee details");
            }
        }else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid employee details");
        }
    }

    private void DeleteEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idParm = request.getParameter("id");
        if (idParm != null) {
            long id = Integer.parseInt(idParm);
            employeeService.deleteEmployee(id);
            response.sendRedirect("index.jsp");
        }
    }

    private void showalleployees(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }

}
