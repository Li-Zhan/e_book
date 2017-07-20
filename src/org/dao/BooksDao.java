package org.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.model.Books;
import org.model.Type;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.util.HibernateSessionFactory;

public class BooksDao { 
	
	private HibernateTemplate hibernateTemplate;
   public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
   
   
public ArrayList getAllbooks() throws Exception{//得到books表中的全部数据
	
    ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
    AdminDao adminDao=(AdminDao)ac.getBean("adminDao");
    return adminDao.getAllBook();

  }


  public Books getidbooks(int bookId)throws Exception{//根据book_id查询图书信息
	List<Books> list = (List<Books>) hibernateTemplate.find("from Books where bookId=?",bookId);
	if(list.size()!=0){
	Books books=(Books) list.get(0);
	if(books!=null){
		return books;
	}else{
		return null;
	}
	}else{
		return null;
	}
  }
  
  public boolean bookByName(String bookname)throws Exception{//根据图书名查询是否存在该图书query.list();
	List<Books> list = (List<Books>) hibernateTemplate.find("from Books where bookname=?",bookname);
	if(list.size()!=0){
		return true;
	}else{
		return false;
	}
  }
  
  
  public Books getbookByName(String bookname)throws Exception{//根据图书名查询该图书
	List<Books> list = (List<Books>) hibernateTemplate.find("from Books where bookname=?",bookname);
	Books books=null;
	for(int i=0;i<list.size();i++){
		books=(Books) list.get(i);

	}
	if(books!=null){
		return books;
	}else{
		return null;
	} 
  }
  
  
public List gettypebooks(int type)throws Exception{//根据类型查询图书信息

	  List<Books> bookses=null;
	  List<Type> list = (List<Type>) hibernateTemplate.find("from Type where typeId=?",type);
	  for(int i=0;i<list.size();i++){
		  Type type2=(Type) list.get(i);
		  bookses=new ArrayList<Books>(type2.getBookses());        //set转换成list
		  Collections.sort(bookses,new Comparator<Books>() {        //将list进行有序排列

			public int compare(Books o1, Books o2) {
				return o1.getBookId().compareTo(o2.getBookId());
			}
		});
		  
	  }
	  return bookses;
  }
  
  
  public void insertBook(Books book)throws Exception{   //添加图书
	  hibernateTemplate.save(book);
  }
  
  public void deleteBook(int book_id)throws Exception{    //删除图书
	  Books book = hibernateTemplate.get(Books.class, book_id);
	  hibernateTemplate.delete(book);
  }
  
  
  //更新图书信息
  public void updateBook(Books book,int book_id,boolean pictureNull)throws Exception{
	List<Books> list = (List<Books>) hibernateTemplate.find("from Books where bookId=?",book_id);
  	Books books=(Books) list.get(0);
  	if(!pictureNull){
  	books.setPicture2(book.getPicture2());
  	}
  	books.setBookname(book.getBookname());
  	books.setBookintroduce(book.getBookintroduce());
  	books.setBookwrite(book.getBookwrite());
  	books.setPrice(book.getPrice());
  	books.setType(book.getType());
  	books.setPublishdate(book.getPublishdate());
  	hibernateTemplate.update(books);
  }


  /**
   * 查询中记录数
   * @return
   */
public int findCount() {
	String hql="select count(*) from Books";
	List<Long> list = (List<Long>) hibernateTemplate.find(hql);
	if(list.size()>0){
		return list.get(0).intValue();
	}
	return 0;
}


/**
 * 分页的每页信息
 * @param begin
 * @param pageSize
 * @return
 */
public List<Books> findPage(int begin, int pageSize) {
	DetachedCriteria criteria=DetachedCriteria.forClass(Books.class);
	List<Books> list = (List<Books>) hibernateTemplate.findByCriteria(criteria, begin, pageSize);
	return list;
}


}