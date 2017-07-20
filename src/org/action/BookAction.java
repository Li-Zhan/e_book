package org.action;

import java.io.File;
import java.io.FileInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import org.model.Books;
import org.model.PageBean;
import org.model.Stock;
import org.model.Type;
import org.service.IBookService;
import org.service.impl.BookService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class BookAction extends ActionSupport {	

	private IBookService bookService;
	

	public void setBookService(IBookService bookService) {
		this.bookService = bookService;
	}

	private Books book;
	private File picture2;
	private String type;
	private String stock_qty;
	private int id;
	//当前页
	private int currPage=1;
	

	public int getCurrPage() {
		return currPage;
	}

	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public File getPicture2() {
		return picture2;
	}

	public void setPicture2(File picture2) {
		this.picture2 = picture2;
	}

	public Books getBook() {
		return book;
	}

	public void setBook(Books book) {
		this.book = book;
	}

	public String getStock_qty() {
		return stock_qty;
	}

	public void setStock_qty(String stockQty) {
		stock_qty = stockQty;
	}

	// 判断图书类型
	public int bookType(String type) {
		int booktype = 1;
		if (type.equals("网络小说")) {
			return booktype;
		} else if (type.equals("教育")) {
			booktype = 2;
			return booktype;
		} else if (type.equals("科技")) {
			booktype = 3;
			return booktype;
		} else if (type.equals("经营")) {
			booktype = 4;
			return booktype;
		} else if (type.equals("古籍")) {
			booktype = 5;
			return booktype;
		}
		return booktype;
	}

	// 添加图书
	public String addBook() throws Exception {

		Books book = getBook();
			// 处理图片信息
			File file = getPicture2();
			byte[] buffer = null;
			if (file != null) {
				FileInputStream fis = new FileInputStream(file);
				buffer = new byte[fis.available()];
				fis.read(buffer);
				fis.close();
			}
	    book.setPicture2(buffer);
	    System.out.println("type"+getType());
		book.setType(new Type(bookType(getType())));
//		if (booksDao.bookByName(book.getBookname())) {
//			return ERROR;
//		} else {
//			booksDao.insertBook(book);
//			Books thisBook = booksDao.getbookByName(book.getBookname());
//			stockDao.addStock(thisBook, Integer.parseInt(getStock_qty()));
//			return SUCCESS;
//		}
		
		
		
		if(bookService.addBook(book.getBookname(), book,getStock_qty())){
			return SUCCESS;
		}else{
			return ERROR;
		}
		//System.out.println(getStock_qty());
		//return NONE;
		
	}

	// 读取照片信息
	public String getImage2() throws Exception {

//		HttpServletRequest request = ServletActionContext.getRequest();
//		// 得到照片的字节数组
//		Books book = booksDao.getidbooks(getId());
//		byte[] zp = book.getPicture2();
//		HttpServletResponse response = ServletActionContext.getResponse();
//		response.setContentType("image/jpeg");
//		// 得到输出流
//		ServletOutputStream os = response.getOutputStream();
//		if (zp != null && zp.length > 0) {
//			for (int i = 0; i < zp.length; i++) {
//				os.write(zp[i]);
//			}
//		}
		bookService.getImage(getId());
		// 不去任何页面
		return NONE;
	}

	// 删除图书
	public String deleteBook() throws Exception {

//		booksDao.deleteBook(getId());
//		stockDao.delStock(getId());
//		return SUCCESS;
		
		if(bookService.deleteBook(getId())){
			return SUCCESS;
		}else{
			return ERROR;
		}
		
	}

	// 查询图书
	public String findBook() throws Exception {

//		Books book = booksDao.getidbooks(getId());
		HttpServletRequest request = ServletActionContext.getRequest();
		Books book=bookService.findBook(getId());
		if ( book!= null) {
			request.setAttribute("findbook", book);
			return SUCCESS;
		} else {
			request.setAttribute("errorfind", "没有要查询的图书！！！");
			return ERROR;
		}
	}

	// 修改图书信息
	public String updateBook() throws Exception {

		Books book = getBook();
		boolean pictureNull = false; // 判断图片是否为空
		byte[] buffer = null;
		if (getPicture2()!= null) {
			// 处理图片信息
			File file = getPicture2();

			if (file != null) {
				FileInputStream fis = new FileInputStream(file);
				buffer = new byte[fis.available()];
				fis.read(buffer);
				fis.close();
			}
			book.setPicture2(buffer);
		} else {
			pictureNull = true;
		}
		book.setType(new Type(bookType(getType())));
//		try {
//			booksDao.updateBook(book, getId(), pictureNull);
//			return SUCCESS;
//		} catch (Exception e) {
//			e.printStackTrace();
//			return ERROR;
//		}
		
		
		if(bookService.updateBook(book, getId(), pictureNull)){
			return SUCCESS;
		}else{
			return ERROR;
		}
		
	}
	
	/**
	 * 分页
	 */
	public String findAll(){
		PageBean<Books> pageBean=bookService.findAll(currPage);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}
	
	
}
