package org.filter;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class AdminFilter implements Filter{

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		HttpServletRequest Request=(HttpServletRequest)request;
		HttpServletResponse Response=(HttpServletResponse) response;
		HttpSession session=Request.getSession();
		
		if(session.getAttribute("account")==null){
			Response.sendRedirect("/e_book/loginform.jsp");
			chain.doFilter(request, response);
		}
		else{
			chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
