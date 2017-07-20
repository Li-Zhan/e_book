<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>

<!-- 图书管理 -->
<html>
  <head>    
    <title>网上书店</title>
  </head>
  
  <body background="${pageContext.request.contextPath}/images/bj4.png">&nbsp; 
  <font face="微软雅黑" size="7">图书信息</font>
   <font face='微软雅黑'><a href="${pageContext.request.contextPath}/admin/addbook.jsp">添加图书</a></font>
   <font face='微软雅黑'><a href="${pageContext.request.contextPath}/admin/findbook.jsp">查询图书</a></font>
   <a href="${pageContext.request.contextPath}/userAction_findAll.action"><font face='微软雅黑'>返回管理页</font></a>
   <hr><br/><br/><br/>
  <table border="1" cellspacing="0px" align="center" >
  <tr>
    <th>图书编号</th>
    <th>图书名</th>
    <th>图书作者</th>
    <th>图书类型</th>
    <th>图书出版时间</th>
    <th>图书简介</th>
    <th>图书封面</th>
    <th>图书价格</th>
    <th>删除</th>
  </tr>  
     <s:iterator value="list" var="b">
     <tr>
       <td><s:property value="#b.bookId"/></td>
       <td width="100"><s:property value="#b.bookname"/></td>
       <td width="100"><s:property value="#b.bookwrite"/></td>
       <td><s:property value="#b.type.typeName"/></td>
       <td><s:date name="#b.publishdate" format="yyyy-MM-dd"/>
       </td>
       <td>
       <input type="text" value="<s:property value="#b.bookintroduce"/>" readonly="readonly">
       </td>
       <td><img src="getImage2.action?id=<s:property value="#b.bookId"/>" width="60" height="60"></td>
       <td><s:property value="#b.price"/></td>
       <td><a href="deletebook.action?id=<s:property value="#b.bookId"/>">删除</a>
     </tr>
     </s:iterator>
     </table>
     
<table border="0" cellspacing="0" cellpadding="0"  width="900px">
<tr>
<td align="right">
   <span>第<s:property value="currPage"/>/<s:property value="totalPage"/>页</span>&nbsp;&nbsp;
   <span>总记录数:<s:property value="totalCount"/>/每页:<s:property value="pageSize"/>条</span>&nbsp;&nbsp;
   <span>
   <s:if test="currPage!=1">
       <a href="bookAction_findAll.action?currPage=1">[首页]</a>&nbsp;&nbsp;
       <a href="bookAction_findAll.action?currPage=<s:property value="currPage-1"/>">[上一页]</a>&nbsp;&nbsp;
   </s:if>
   <s:if test="currPage!=totalPage">
       <a href="bookAction_findAll.action?currPage=<s:property value="currPage+1"/>">[下一页]</a>&nbsp;&nbsp;
       <a href="bookAction_findAll.action?currPage=<s:property value="totalPage"/>">[尾页]</a>&nbsp;&nbsp;
   </s:if>
   </span>
</td>
</tr>
</table>
     
  </body>
</html>
