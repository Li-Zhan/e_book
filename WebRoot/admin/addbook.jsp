<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!-- 增加图书 -->
<html>
  <head>
    <title>网上书店</title>
  </head>
  
  <body background="${pageContext.request.contextPath}/images/bj4.png">
    <font face="微软雅黑" size="7">添加图书</font><hr/><br/><br/><br/>
  <form action="addbook" method="post" enctype="multipart/form-data">
   <table border="1" cellspacing="0px" align="center" width="800">
      <tr>
    <th>图书名</th>
    <th>图书作者</th>
    <th>图书类型</th>
    <th>图书简介</th>
    <th>图书价格</th>
    <th>图书封面</th>
    <th>库存</th>
    <th>添加</th>
      </tr>
      <tr>
        <td><input type="text" name="book.bookname"></td>
        <td><input type="text" name="book.bookwrite"></td><!--
        <td><input type="text" name="type"></td>
        -->
        <td>
          <select name="type">
            <option value="网络小说">网络小说</option> 
            <option value="教育">教育</option>
            <option value="科技">科技</option>
            <option value="经营">经营</option>
            <option value="古籍">古籍</option>
          </select>
        </td>
        <td><input type="text" name="book.bookintroduce"></td>
        <td><input type="text" name="book.price"></td>
        <td><input type="file" name="picture2"></td>
        <td><input type="text" name="stock_qty"></td>
        <td><input type="submit" value="添加"></td>
      </tr> 
    </table>
    </form>
  </body>
</html>
