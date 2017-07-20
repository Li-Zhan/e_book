<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="org.model.Books"%>
<!-- 搜索图书-->
<html>
  <head>
    <title>网上书店</title>
  </head>
  
  <body background="${pageContext.request.contextPath}/images/bj4.png">
    <font face="微软雅黑" size="7">查找图书</font><hr/><br/><br/>
    <form action="findbook" method="post">
        <font face="微软雅黑" size="3">根据图书编号查询</font>
        <input type="text" name="id">
        <input type="submit" value="查询">
    </form>
    <%
    Books bvo=(Books)request.getAttribute("findbook");
    String string=(String)request.getAttribute("errorfind");
   if(bvo!=null&&string==null){
    %>
    <form action="updatebook" method="post" enctype="multipart/form-data">
   <table border="1" cellspacing="0px" align="center" width="1300">
      <tr>
    <th>图书ID</th>  
    <th>图书名</th>
    <th>图书作者</th>
    <th>图书类型</th>
    <th>出版时间</th>
    <th>图书简介</th>
    <th>图书封面</th>
    <th>更换封面</th>
    <th>图书价格</th>
    <th>点击修改</th>
     </tr>
     <tr>
       <td><%=bvo.getBookId() %></td>
       <td><input type="text" name="book.bookname" value="<%=bvo.getBookname() %>"></td>
       <td><input type="text" name="book.bookwrite" value="<%=bvo.getBookwrite() %>"></td>
       <td><input type="text" name="type" value="<%=bvo.getType().getTypeName() %>"></td>
       <td><input type="text" name="book.publishdate" value="<%=bvo.getPublishdate()  %>"></td>
       <td><input type="text" name="book.bookintroduce" value="<%=bvo.getBookintroduce() %>"></td>
       <td><img src="getImage2.action?id=<%=bvo.getBookId() %>" width="60" height="60"></td>
       <td><input type="file" name="picture2"></td>
       <td><input type="text" name="book.price" value="<%=bvo.getPrice()  %>"></td>
       <td><input type="hidden" name="id" value="<%=bvo.getBookId() %>">
           <input type="submit" value="修改"></td>
     </tr>
   </table>
   </form>
    <%
   }else if(string!=null){
   %>
   <font color="red" size="10"><%=string %></font>
   <%
   }
     %>
  </body>
</html>
