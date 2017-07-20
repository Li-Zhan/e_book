package org.service;

import java.util.List;

import org.model.Books;
import org.model.PageBean;

public interface IBookService {
	public boolean addBook(String bookName,Books book,String qty)throws Exception;
	
	public boolean deleteBook(int bookId)throws Exception;
	
	public Books findBook(int bookId)throws Exception;
	
	public boolean updateBook(Books book,int bookId,boolean pictureNull)throws Exception;
	
	public void getImage(int id)throws Exception;

	public PageBean<Books> findAll(int currPage);


}
