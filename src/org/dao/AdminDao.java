package org.dao;
import java.util.*;
import java.util.Date;
import java.sql.*;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.model.Administrator;
import org.model.Books;
import org.model.Type;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.util.HibernateSessionFactory;

public class AdminDao {
	
	private HibernateTemplate hibernateTemplate;
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
    
    
	public ArrayList getAllAdmin()throws Exception{//获得administrator表中的数据
 //   	ArrayList al=new ArrayList();
//    	Session session=HibernateSessionFactory.getSession();
//    	Transaction t=session.beginTransaction();
//    	Query query=session.createQuery("from Administrator");
//    	t.commit();
//    	List list=query.list();
//    	for(int i=0;i<list.size();i++){
//    		Administrator adao=(Administrator) list.get(i);
//    		al.add(adao);
//    	}
    	
    	List<Administrator> admin = (List<Administrator>) hibernateTemplate.find("from Administrator");
    	return (ArrayList) admin;
    }
	
	
    public boolean trueAdminLogin(String account,String pwd)throws Exception{   //验证管理员

//    	Session session=HibernateSessionFactory.getSession();
//    	Transaction t=session.beginTransaction();
//    	Query query=session.createQuery("from Administrator where administratorName=? and administratorPassword=?");
//    	query.setParameter(0, account);
//    	query.setParameter(1, pwd);
//    	List list=query.list();
//    	t.commit();
//		HibernateSessionFactory.closeSession();
    	List<Administrator> admin = (List<Administrator>) hibernateTemplate.find("from Administrator where administratorName=? and administratorPassword=?",account,pwd);
    	if(admin.size()!=0){
    		return true;
    	}else{
    		return false;
    	}
    }
    
    
    public void insertBook(String bookname,String bookwrite,int booktype,    //添加图书
    		String bookintroduce ,String picture,float price)throws Exception{

//    	Session session=HibernateSessionFactory.getSession();
//    	Transaction t=session.beginTransaction();
    	Books books=new Books();
    	books.setBookname(bookname);
    	books.setBookwrite(bookwrite); 
    	books.setType(new Type(booktype));
    	books.setBookintroduce(bookintroduce);
    	books.setPicture(picture);
    	books.setPrice(price);
//    	session.save(books);
//    	t.commit();
//    	HibernateSessionFactory.closeSession();
    	hibernateTemplate.save(books);
    	
    }
    
    
    public void deleteBook(int book_id)throws Exception{    //删除图书

//    	Session session=HibernateSessionFactory.getSession();
//    	Transaction t=session.beginTransaction();
//    	String hql="delete from Books where bookId=?";
//    	Query query=session.createQuery(hql);
//    	query.setParameter(0, book_id);
//    	query.executeUpdate();
//    	t.commit();
//    	HibernateSessionFactory.closeSession();
    	hibernateTemplate.delete("delete from Books where bookId=?", book_id);
    }
    
    
    public void updateBook(String bookname,String bookwrite,int booktype,    //修改图书信息
    		String bookintroduce ,String picture,float price,int book_id)throws Exception{

//    	Session session=HibernateSessionFactory.getSession();
//    	Transaction t=session.beginTransaction();
//    	Query query=session.createQuery("from Books where bookId=?");
//    	query.setParameter(0, book_id);
//    	List list=query.list();
    	List<Books> book = (List<Books>) hibernateTemplate.find("from Books where bookId=?", book_id);
    	Books books=(Books) book.get(0);
    	books.setBookname(bookname);
    	books.setBookwrite(bookwrite);
    	books.setType(new Type(booktype));
    	books.setBookintroduce(bookintroduce);
    	books.setPicture(picture);
    	books.setPrice(price);
//    	session.update(books);
//    	t.commit();
//    	HibernateSessionFactory.closeSession();
    	hibernateTemplate.update(books);
    }
    
    
	public ArrayList getAllBook()throws Exception{     //得到所有图书信息
    	ArrayList al=new ArrayList();
//    	Session session=HibernateSessionFactory.getSession();
//    	Transaction t=session.beginTransaction();
//    	Query query=session.createQuery("from Books");
//    	List list = query.list();
//    	t.commit();
    	List<Books> list = (List<Books>) hibernateTemplate.find("from Books");
    	for(int i=0;i<list.size();i++){
    		Books books=(Books) list.get(i);
    		al.add(books);
    	}
    	return al;
    }

}
