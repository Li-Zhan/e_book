<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="org.model.Books" %>
<%@ page import="org.dao.BooksDao" %>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="org.springframework.context.support.ClassPathXmlApplicationContext"%> 
<!--购买图书数量  -->
<html>
  <head>
    <title>网上书店</title>
  </head>
  
  <body>
    <%
    int book_id=Integer.parseInt(request.getParameter("book_id"));
    ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
    BooksDao bdao=(BooksDao)ac.getBean("bookDao");
    Books book=bdao.getidbooks(book_id);
     %>
     欢迎购买:<%=book.getBookname() %>
     <form action="buycartbook" method="post">
       书本价格:<%=book.getPrice() %><br/>
       <input name="book_id" type="hidden" value="<%=book.getBookId() %>">
       <input name="bookname" type="hidden" value="<%=book.getBookname() %>">
       <input name="price" type="hidden" value="<%=book.getPrice() %>">
       数量：<input name="booknumber">
       <input type="submit" value="购买">
     </form>
  </body>
</html>
