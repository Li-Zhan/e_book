package org.filter;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginFilter3 implements Filter{

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest Request=(HttpServletRequest)request;
		HttpServletResponse Response=(HttpServletResponse)response;
		HttpSession session=Request.getSession();
		
        String account=null;
        //String pwd=null;
		Cookie[] cookies=Request.getCookies();
	if(cookies!=null){
	    for(int i=0;i<cookies.length;i++){
	    	if(cookies[i].getName().equals("account")){
	    		account=cookies[i].getValue();
	    		break;
	    	}
	    	/*if(cookies[i].getName().equals("password")){
	    		pwd=cookies[i].getValue();
	    		break;
	    	}*/
	    }
	}  
	if(account!=null){
        session.setAttribute("username",account);
		Response.sendRedirect("index.html");
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
