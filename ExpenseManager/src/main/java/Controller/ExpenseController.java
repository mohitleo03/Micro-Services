package Controller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import pojo.ExpenseModel;
import dao.ExpenseDAO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daoImpl.ExpenseDAOImpl;

public class ExpenseController extends HttpServlet {

        ExpenseModel exp = new ExpenseModel();
        ExpenseDAOImpl expDao = new ExpenseDAOImpl();
        ExpenseDAO dao;
       
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(request.getParameter("addExpense")!=null){
            String name = request.getParameter("name");
            String descp = request.getParameter("descp");
            int cost = Integer.parseInt(request.getParameter("cost"));
            exp.setName(name);
            exp.setdescp(descp);
            exp.setCost(cost);
            Date date = new Date();
            exp.setDate(date);
            expDao.saveExpense(exp);
            List<ExpenseModel> ExpenseList = new ArrayList();
            ExpenseList = expDao.showAllExpenses();
            request.setAttribute("ExpenseList", ExpenseList);
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        }
        
        if(request.getParameter("showInfo")!=null){
       	 int id1 = Integer.parseInt(request.getParameter("id"));
          ExpenseModel expense = expDao.showOneExpense(id1);
          request.setAttribute("record", expense);
           List<ExpenseModel> ExpenseList = new ArrayList();
           ExpenseList = expDao.showAllExpenses();
           request.setAttribute("ExpenseList", ExpenseList);
           RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
           rd.forward(request, response);
       }
          
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	if(request.getParameter("showExpense")!=null){
            List<ExpenseModel> ExpenseList = new ArrayList();
            ExpenseList = expDao.showAllExpenses();
            request.setAttribute("ExpenseList", ExpenseList);
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        }
         
    	if(request.getParameter("updateExpense")!=null){
            int id1 = Integer.parseInt(request.getParameter("id"));
            String nameupdate = request.getParameter("nameupdate");
            String descpupdate = request.getParameter("descpupdate");
            int costupdate = Integer.parseInt(request.getParameter("costupdate"));
            Date dateupdate = new Date();
            expDao.updateExpense(id1, nameupdate, descpupdate ,costupdate, dateupdate);
            List<ExpenseModel> ExpenseList = new ArrayList();
            ExpenseList = expDao.showAllExpenses();
            request.setAttribute("ExpenseList", ExpenseList);
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
            
        }
          
    	 if(request.getParameter("deleteExpense")!=null){
             int id2 = Integer.parseInt(request.getParameter("id"));
             exp.setId(id2);
             expDao.deleteExpense(exp);
             List<ExpenseModel> ExpenseList = new ArrayList();
             ExpenseList = expDao.showAllExpenses();
             request.setAttribute("ExpenseList", ExpenseList);
             RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
         }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}