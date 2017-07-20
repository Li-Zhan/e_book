package servlet;
import java.io.IOException;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

import org.model.Books;

public class RemoveServlet extends HttpServlet{

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		request.setCharacterEncoding("utf-8");
		int book_id=(Integer) session.getAttribute("book_id");
		HashMap books=(HashMap)session.getAttribute("books");
		Books book=(Books)books.get(book_id);
		//总钱数减少
		float money=(Float)session.getAttribute("money");
		money=money-book.getBooknumber()*book.getPrice();
		session.setAttribute("money", money);
		//移除相应图书
		books.remove(book_id);
		session.removeAttribute("book_id");   //销毁名为book_id的session
		response.sendRedirect("/e_book/showCart.jsp");
	}
  
}
