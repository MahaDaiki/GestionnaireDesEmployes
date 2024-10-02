package test;

import model.Employee;
import service.EmployeeService;

public class test {
    public static void main(String[] args) {

        EmployeeService employeeService = new EmployeeService();


        Employee newEmployee = new Employee();
        newEmployee.setName("test");
        newEmployee.setEmail("test@email.com");
        newEmployee.setPhone_number("0837475737");
        newEmployee.setDepartment("IT");
        newEmployee.setPosition("Software Engineer");


        employeeService.addEmployee(newEmployee);


        System.out.println("Employee added successfully!");
    }
}
