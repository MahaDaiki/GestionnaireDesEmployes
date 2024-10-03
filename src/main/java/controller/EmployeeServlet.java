package controller;

import model.Employee;
import service.EmployeeService;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;

public class EmployeeServlet extends HttpServlet {

    private EmployeeService employeeService;

    public void init(){
        employeeService = new EmployeeService();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            showallEmployees(request, response);
            return;
        }
        switch(action){
            case "add":
                showAddEmployee(request, response);
                break;
            case "edit":
                ShowEditEmployee(request, response);
                break;
            case "search":
                searchEmployees(request, response);
                break;
            case "filter":
                filterEmployees(request, response);
                break;

            default:
                showallEmployees(request, response);


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
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/addEmployee.jsp");
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

        response.sendRedirect("views/index.jsp");

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
            response.sendRedirect("views/index.jsp");

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
                RequestDispatcher dispatcher = request.getRequestDispatcher("views/editEmployee.jsp");
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
            response.sendRedirect("views/index.jsp");
        }
    }

    private void showallEmployees(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Employee> employees = employeeService.getAllEmployees();
        System.out.println(employees.size());
        request.setAttribute("employees", employees);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/index.jsp");
        dispatcher.forward(request, response);
    }

    private void searchEmployees(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String search = request.getParameter("search");
        List<Employee> employees;

        if (search == null || search.isEmpty()) {
            employees = employeeService.getAllEmployees();
        } else {
            employees = employeeService.searchEmployees(search);
        }

        request.setAttribute("employees", employees);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/index.jsp");
        dispatcher.forward(request, response);
    }


        private void filterEmployees(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String department = request.getParameter("department");
        String position = request.getParameter("position");
        List<Employee> employees = employeeService.filterEmployees(department, position);

        request.setAttribute("employees", employees);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/index.jsp");
        dispatcher.forward(request, response);
    }

}
