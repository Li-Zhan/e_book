package servlet;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

import org.model.Books;

public class AddServlet extends HttpServlet{

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		HttpSession session=request.getSession();
		HashMap books=(HashMap)session.getAttribute("books");
		//获得提交的内容
		int book_id=Integer.parseInt(request.getParameter("book_id"));
		String bookname=request.getParameter("bookname");
		String strprice=request.getParameter("price");
		String strbooknumber=request.getParameter("booknumber");
		//存入购物车
		Books book=new Books();
		book.setBookId(book_id);
		book.setBookname(bookname);
		float price=Float.parseFloat(strprice);
		book.setPrice(price);
		int booknumber=Integer.parseInt(strbooknumber);
		book.setBooknumber(booknumber);
		books.put(book_id, book);
		response.sendRedirect("/e_book/showCart.jsp");
	}
   
}
