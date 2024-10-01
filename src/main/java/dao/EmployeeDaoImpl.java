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
}
