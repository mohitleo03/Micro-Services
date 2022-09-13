package daoImpl;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import pojo.ExpenseModel;

public class ExpenseDAOImpl {
	
SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	
	public void saveExpense(ExpenseModel exep) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(exep);
		transaction.commit();
		session.close();
	}
	
	public List <ExpenseModel> showAllExpenses()
	{
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<ExpenseModel> exList= session.createQuery("From ExpenseModel").getResultList();
		session.close();
        return exList;
		
	}
	
    public ExpenseModel showOneExpense(int id) {
		Session session = sessionFactory.openSession();
		ExpenseModel expense = session.get(ExpenseModel.class, id);		
		session.close();
		return expense;
    }
	
	public void updateExpense(int id,String name, String descp,int cost,Date date) {
		
		 	Session session = sessionFactory.openSession();
	        Transaction transaction = session.beginTransaction();
	        ExpenseModel exp = (ExpenseModel)session.load(ExpenseModel.class, id);
	        exp.setName(name);
	        exp.setdescp(descp);
	        exp.setCost(cost);
	        exp.setDate(date);
	        session.update(exp);
	        transaction.commit();
	        session.close();
	}
	public void deleteExpense(ExpenseModel exp) {
		Session session = sessionFactory.openSession();
		Transaction transaction  = session.beginTransaction();
		session.delete(exp);
		transaction.commit();
		session.close();
		
		
	}

}
