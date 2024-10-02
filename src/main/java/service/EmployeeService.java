package service;

import dao.EmployeeDaoImpl;
import model.Employee;

public class EmployeeService {
    EmployeeDaoImpl EmployeeDao;

    public EmployeeService() {
        this.EmployeeDao = new EmployeeDaoImpl();
    }


    public void addEmployee(Employee employee){
        EmployeeDao.AddEmployee(employee);
    }
}
