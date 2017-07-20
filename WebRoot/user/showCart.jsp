<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="org.model.Books" %>
<%@ page import="org.dao.BooksDao" %> 
<!-- 购物车 -->
<html>
  <head>
   <title>网上书店</title>
  </head>
  
  <body>
    <table align="center">
       <tr>
         <td>书本名称</td>
         <td>书本价格</td>
         <td>数量</td>
         <td>删除</td>
         <td>购买</td>
       </tr>
       <%
       Books book=new Books();
       HashMap books=(HashMap)session.getAttribute("books");
       if(books==null){
          return;
       }
       Set set =books.keySet();
       Iterator ite=set.iterator();
       while(ite.hasNext()){
             int book_id=(Integer)ite.next();
             book=(Books)books.get(book_id);
             session.setAttribute("book_id",book.getBookId());
        %>  
        <tr>
          <td><%=book.getBookname() %></td>
          <td><%=book.getPrice() %></td>
          <td><%=book.getBooknumber() %></td>
          <td><a href="removecartbook.action?book_id=<%=book.getBookId() %>">删除</a></td>
          <td><a href="buybook.action?book_id=<%=book.getBookId() %>&booknumber=<%=book.getBooknumber()%>">购买</a> </td>
       </tr>
       <%
       }
        %>   
    </table>  
    现金总额:<%=session.getAttribute("money")%> 元<hr/>
    <a href="../e_book_right.jsp">继续买书</a>
    <center>
    <%
    String buysuccess=(String)request.getAttribute("buysuccess");
    String nologin=(String)request.getAttribute("nologin");
    String buyerror=(String)request.getAttribute("buyerror");
    if(buysuccess!=null){
      out.print("<font face='微软雅黑' size='5' color='green'>"+buysuccess+"</font>");
    }
    if(nologin!=null){
      out.print("<a href='loginform.jsp' target='_blank'>"+
      "<font face='微软雅黑' size='5' color='red'>"+nologin+"</font></a>");
    }
    if(buyerror!=null){
      out.print("<font face='微软雅黑' size='5' color='green'>"+buyerror+"</font>");
    }
     %>
    </center> 
  </body>
</html>
