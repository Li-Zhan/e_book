package org.listener;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class SessionListener  implements HttpSessionListener{

	public void sessionCreated(HttpSessionEvent event) {
		// TODO Auto-generated method stub
		HttpSession session=event.getSession();
		//初始化购物车
		HashMap books=new HashMap();
		session.setAttribute("books", books);
		//初始化总钱数
		session.setAttribute("money", 0F);
	}

	public void sessionDestroyed(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
   
}
