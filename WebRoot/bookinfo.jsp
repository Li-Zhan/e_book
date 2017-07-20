<%@ page language="java" import="java.util.*,java.sql.*" pageEncoding="UTF-8"%>
<%@ page import="org.dao.BooksDao" %>
<%@page import="org.model.Books"%>
<%@page import="org.dao.StockDao" %>
<%@page import="org.model.Stock" %>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@page import="java.text.DateFormat"%>
<!--图书详情页  -->
<html>
  <head>
    <title>网上书店</title>
    <style type="text/css">
	   div{
	      float:left;
	      margin-left: 30px;
	      margin-right:30px;
	      margin-top: 5px;
	      margin-bottom: 5px;
	   }
	   div dd{
	      margin:0px;
	      font-size:10pt;
	   }
	   div dd.dd_name
	   {
	      color:blue;
	   }
	   div dd.dd_city
	   {
	      color:#000;
	   }
	  a:link{color:blue;text-decoration:none;}
      a:hover{color:red;text-decoration:underline;}
	</style>
  </head>
  
  <body>
   <table width="1024" height="300" cellpadding="0" cellspacing="0" border="0">
     <tr>
        <!-- 图书详情 -->
        <%
       /// BooksDao bdao=new BooksDao();
       // StockDao sdao=new StockDao();
        ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
        BooksDao bdao=(BooksDao)ac.getBean("bookDao");
        StockDao sdao=(StockDao)ac.getBean("stockDao");
        request.setCharacterEncoding("utf-8");
        Books bvo=bdao.getidbooks(Integer.parseInt(request.getParameter("id")));
        if(bvo!=null){
         %>
          <td width="70%" valign="top">
             <table>
               <tr>
                 <td rowspan="4"><img src="getImage2.action?id=<%=bvo.getBookId() %>" width="180" height="190"/></td>
               </tr>
               <tr>
                 <td><B><%=bvo.getBookname() %></B></td> 
               </tr>
               <tr>
                 <td><%="简介:"+bvo.getBookintroduce() %></td>
               </tr> 
               <tr>
                <td><%="作者："+bvo.getBookwrite() %> </td>
               </tr>
               <tr>
                 <td><%
                   if(bvo.getPublishdate()==null){
                     out.print("出版时间：");
                   }else{
                     out.print("出版时间："+DateFormat.getDateInstance().format(bvo.getPublishdate()));
                   }
                  %>
                 </td>
               </tr>
               <tr>
                 <td><%="价格：¥ "+bvo.getPrice() %></td>
                 <td><%="库存："+sdao.getBookStock(bvo.getBookId())+"本"%></td>
               </tr>
               <tr>
                 <td>
                 <%
                    if(session.getAttribute("username")==null){
                    %>
                    <a href="user/buyForm.jsp?book_id=<%=bvo.getBookId()%> " target="_blank">加入购物车</a>
                   <% 
                    }else{
                  %>
                 <a href="user/buyForm.jsp?book_id=<%=bvo.getBookId()%>">加入购物车</a>
                 <%
                 }
                  %>
                 </td>
                 <td>
                  <%
                    if(session.getAttribute("username")==null){
                    %>
                 <a href="user/showCart.jsp" target="_blank">查看购物车</a>
                    <% 
                    }else{
                  %>
                  <a href="user/showCart.jsp" >查看购物车</a>
                 <%
                 }
                  %>
                  
                 </td> 
               </tr>
             </table>
          <%
          }
           %>
        </td></tr>
    </table>
       <center><a id="aaa" href="e_book_right.jsp" ><font face="微软雅黑" size="3" >
       回到首页</font></a></center>
      </body>
</html>
