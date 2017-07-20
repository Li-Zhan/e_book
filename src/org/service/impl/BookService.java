package org.service.impl;

import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.dao.BooksDao;
import org.dao.StockDao;
import org.model.Books;
import org.model.PageBean;
import org.service.IBookService;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class BookService implements IBookService {
	private BooksDao booksDao;
	private StockDao stockDao;

	public void setBooksDao(BooksDao booksDao) {
		this.booksDao = booksDao;
	}
	
	


	public void setStockDao(StockDao stockDao) {
		this.stockDao = stockDao;
	}




	public boolean addBook(String bookName,Books book,String qty)throws Exception{
		//if (booksDao.bookByName(bookName)) {
			//return false;
		//}else{
			booksDao.insertBook(book);
			Books thisBook = booksDao.getbookByName(bookName);
//			System.out.println("aaa"+thisBook.getBookname());
//			System.out.println("bbb"+qty);
			stockDao.addStock(thisBook, Integer.parseInt(qty));
			return true;
		//}
	}




	public boolean deleteBook(int bookId) throws Exception {
		Books book = booksDao.getidbooks(bookId);
		if(book!=null){
			booksDao.deleteBook(bookId);
			stockDao.delStock(bookId);
			return true;
		}
		return false;
	}




	public Books findBook(int bookId) throws Exception {
		return booksDao.getidbooks(bookId);
	}




	public boolean updateBook(Books book,int bookId,boolean pictureNull) throws Exception {
		Books books= booksDao.getidbooks(bookId);
		if(books!=null){
			booksDao.updateBook(book, bookId, pictureNull);
			return true;
		}
		return false;
	}




	public void getImage(int id)throws Exception {
//		HttpServletRequest request = ServletActionContext.getRequest();
		// 得到照片的字节数组
		Books book = booksDao.getidbooks(id);
		byte[] zp = book.getPicture2();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("image/jpeg");
		// 得到输出流
		ServletOutputStream os = response.getOutputStream();
		if (zp != null && zp.length > 0) {
			for (int i = 0; i < zp.length; i++) {
				os.write(zp[i]);
			}
		}
	}




	/**
	 * 分页
	 */
	public PageBean<Books> findAll(int currPage) {
		PageBean<Books> pageBean=new PageBean<Books>();
		//封装pageBean
		pageBean.setCurrPage(currPage);
		int pageSize=6;
		pageBean.setPageSize(pageSize);
		int totalCount=booksDao.findCount();
		pageBean.setTotalCount(totalCount);
		Double totalPage=Math.ceil((double)totalCount/pageSize);
		pageBean.setTotalPage(totalPage.intValue());
		int begin=(currPage-1)*pageSize;
		List<Books> list=booksDao.findPage(begin,pageSize);
		pageBean.setList(list);
		return pageBean;
	}

}
