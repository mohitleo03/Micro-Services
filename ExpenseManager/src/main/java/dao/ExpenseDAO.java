package dao;

import java.util.Date;
import java.util.List;

import pojo.ExpenseModel;

public interface ExpenseDAO {
	
	 public void saveExpense (ExpenseModel Expense);
	    public List<ExpenseModel> showAllExpenses();
	    public void updateExpense (int id, String name, String desc , float price , Date date);
	    public void deleteExpense (ExpenseModel Expense);
		public ExpenseModel showOneExpense(int id);

}
