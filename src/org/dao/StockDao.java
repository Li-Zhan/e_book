package org.dao;

import java.util.*;
import java.sql.*;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.model.Books;
import org.model.Stock;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.util.HibernateSessionFactory;

public class StockDao {
	
	private HibernateTemplate hibernateTemplate;
	   public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
			this.hibernateTemplate = hibernateTemplate;
		}
    
    
public int getBookStock(int book_id)throws Exception{    //根据图书ID查询库存

//	   HibernateSessionFactory.closeSession();
//	   Session session=HibernateSessionFactory.getSession();
//	   Transaction t=session.beginTransaction();
//	   Query query=session.createQuery("from Stock where stockId=?");
//	   query.setParameter(0, book_id);
//	   Stock stock = (Stock)query.list().get(0);
//	   t.commit();
	   Stock stock = hibernateTemplate.get(Stock.class, book_id);
	   if(stock!=null){
		   return stock.getStockQty();
	   }else{
		   return 0;
	   }
   }


public void buyBooks(int book_id,int number)throws Exception{     //根据图书ID改变库存,可以购买多本

//	   Session session=HibernateSessionFactory.getSession();
//	   Transaction t=session.beginTransaction();
//	   Stock stock = (Stock) session.get(Stock.class, book_id);
	   Stock stock = hibernateTemplate.get(Stock.class, book_id);
	   Integer stockQty = stock.getStockQty();
	   stockQty-=number;
	   stock.setStockQty(stockQty);
	   hibernateTemplate.update(stock);
//	   session.update(stock);
//	   t.commit();
//	   HibernateSessionFactory.closeSession();	
   }
   
   public void addStock(Books book,int stockQty){         //插入库存记录
//	   Session session=HibernateSessionFactory.getSession();
//	   Transaction t=session.beginTransaction();
	   Stock stock=new Stock(book.getBookId(),stockQty);
	   hibernateTemplate.save(stock);
//	   session.save(stock);
//	   t.commit();
//	   HibernateSessionFactory.closeSession();   
   }
   
   public void delStock(int id){                //删除记录
//	   Session session=HibernateSessionFactory.getSession();
//	   Transaction t=session.beginTransaction();
//	   Stock stock=(Stock)session.get(Stock.class, id);
//	   session.delete(stock);
//	   t.commit();
//	   HibernateSessionFactory.closeSession();
	   Stock stock = hibernateTemplate.get(Stock.class, id);
	   hibernateTemplate.delete(stock);
   }
}
