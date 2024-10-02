package service;

import dao.EmployeeDaoImpl;
import model.Employee;

import java.util.List;

public class EmployeeService {
    EmployeeDaoImpl EmployeeDao;

    public EmployeeService() {
        this.EmployeeDao = new EmployeeDaoImpl();
    }


    public void addEmployee(Employee employee){
        EmployeeDao.AddEmployee(employee);
    }

    public void updateEmployee(Employee employee){
        EmployeeDao.UpdateEmployee(employee);
    }

    public Employee getEmployee(long id){
        return EmployeeDao.GetEmployeeById(id);
    }

    public void deleteEmployee(long id){
        EmployeeDao.DeleteEmployee(id);
    }

    public List<Employee> getAllEmployees(){
        return EmployeeDao.GetAllEmployees();
    }
}
