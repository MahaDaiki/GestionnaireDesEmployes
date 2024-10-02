package dao;

import config.HibernateUtil;
import model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class EmployeeDaoImpl {

    private SessionFactory sessionFactory;

 public EmployeeDaoImpl() {
     this.sessionFactory = HibernateUtil.getSessionFactory();
 }
 public void AddEmployee(Employee employee) {
     Transaction transaction = null;
     try(Session session = sessionFactory.openSession()) {
         transaction = session.beginTransaction();
         session.save(employee);
         transaction.commit();
     }
     catch(Exception e) {
         if(transaction != null) {
             transaction.rollback();
         }
         e.printStackTrace();
     }
 }
    public void UpdateEmployee(Employee employee) {
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.update(employee);
            transaction.commit();
        }
        catch(Exception e) {
            if(transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public Employee GetEmployeeById(long id) {
        Employee employee = null;
        try(Session session = sessionFactory.openSession()) {
            employee = session.get(Employee.class, id);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return employee;
    }

    public void DeleteEmployee(long id) {
     Transaction transaction = null;
     try(Session session = sessionFactory.openSession()) {
         transaction = session.beginTransaction();
         Employee employee = session.get(Employee.class, id);
          if (employee != null) {
              session.delete(employee);
              transaction.commit();
              System.out.println("Employee deleted successfully");
          }
          else {
              System.out.println("Employee not found");
          }
     }catch(Exception e) {
         if(transaction != null) {
             transaction.rollback();
         }
         e.printStackTrace();
     }
    }
}
