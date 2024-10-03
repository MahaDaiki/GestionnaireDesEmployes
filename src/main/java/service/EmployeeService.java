package service;

import dao.EmployeeDaoImpl;
import model.Employee;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<Employee> SerchEmployee(String search){
        List<Employee> employees = getAllEmployees();

        if (search == null || search.isEmpty()){
            return employees;
        }
        return employees.stream().filter(
                employee->employee.getName().toLowerCase().contains(search.toLowerCase())||
                        employee.getEmail().toLowerCase().contains(search.toLowerCase())||
                        employee.getDepartment().toLowerCase().contains(search.toLowerCase())||
                        employee.getPosition().toLowerCase().contains(search.toLowerCase()))
                .collect(Collectors.toList());
    }


}
