package org.action;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import org.model.Books;
import org.service.IBuyService;

import com.opensymphony.xwork2.ActionSupport;


public class BuyAction extends ActionSupport {
	
	private IBuyService buyService;
	
	
	
	
	public void setBuyService(IBuyService buyService) {
		this.buyService = buyService;
	}


	private String book_id;
	private String bookname;
	private String price;
	private String booknumber;
	public String getBook_id() {
		return book_id;
	}
	public void setBook_id(String bookId) {
		book_id = bookId;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getBooknumber() {
		return booknumber;
	}
	public void setBooknumber(String booknumber) {
		this.booknumber = booknumber;
	}
	
	public String buyCartBook() throws Exception{                            //加入购物车
		
		//得到Session
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		if(session.getAttribute("username")==null){
			request.setAttribute("nologin","请先登录");
			return SUCCESS;
		}
		//总价
		float money=0;
		//封装Books对象
		Books book=new Books();
		book.setBookId(Integer.parseInt(getBook_id()));
		book.setPrice(Float.parseFloat(getPrice()));
		book.setBookname(getBookname());
		book.setBooknumber(Integer.parseInt(getBooknumber()));
		//判断Session是否为空,空则创建购物车，非空则使用原来的购物车
		if(session.getAttribute("books")==null){
		Map bookMap=new HashMap();         //map模拟购物车
		bookMap.put(Integer.parseInt(getBook_id()), book);          //加入到购物车
		//总价增加
		money=Float.parseFloat(getPrice())*Integer.parseInt(getBooknumber());
		session.setAttribute("money",money);
		session.setAttribute("books", bookMap);
		}else{
			Map bookMap=(Map)session.getAttribute("books");
			bookMap.put(Integer.parseInt(getBook_id()), book);
			//总价增加
				Collection values = bookMap.values();
				for (Object object : values) {
					Books b=(Books)object;
					money+=b.getBooknumber()*b.getPrice();
				}
			session.setAttribute("money",money);
			
		}
		return SUCCESS;
	}
	
	public String buyBook()throws Exception{                 //购买图书
		int id=Integer.parseInt(getBook_id());
		int number=0;
	    if(getBooknumber()==null){
	       number=1;
	    }
	    else{
	      number=Integer.parseInt(getBooknumber());
	    }
		HttpServletRequest request = ServletActionContext.getRequest();
	    //if(stockDao.getBookStock(id)>0){
	   // stockDao.buyBooks(id, number);
		if(buyService.buyBook(id, number)){
		request.setAttribute("buysuccess","购买成功！！！");
		removeCartBook();
		return SUCCESS;
	    }else{
	    	request.setAttribute("buyerror","库存不足！！！");
	    	return SUCCESS;
	    }
	}

	public String removeCartBook()throws Exception{            //清空购物车
		
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		int id=Integer.parseInt(getBook_id());
		HashMap bookMap=(HashMap)session.getAttribute("books");
		Books book=(Books)bookMap.get(id);
		//总钱数减少
		float money=(Float)session.getAttribute("money");
		try {
			money=money-book.getBooknumber()*book.getPrice();
		} catch (Exception e) {
			return SUCCESS;
		}
		if(money<=0){
			money=0;
		}
		session.setAttribute("money", money);
		//移除相应图书
		bookMap.remove(id);
		session.removeAttribute("id");   //销毁对应id的session
		return SUCCESS;
	}

}
