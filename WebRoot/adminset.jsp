<%@page language="java" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<!-- 管理员页 -->
<html>
  <head>
    <title>网上书店</title>
     <style  type="text/css">
      a:link{color:blue;text-decoration:none;}
      a:hover{color:red;text-decoration:underline;}
    </style>
  </head>
  <body background="images/bj4.png">
<font face='微软雅黑' size='7'>欢迎管理员</font>
<font face='微软雅黑'><a href="admin/admin_add.jsp">添加用户</a></font>
     <font face='微软雅黑'><a href="admin/admin_find.jsp">查询用户</a></font>
     <font face='微软雅黑'><a href="bookAction_findAll.action">管理图书</a></font><hr><br/><br/><br/>
   <form action="update.jsp" method="post">
     <table border="1" cellspacing="0px" align="center" width="800">
       <tr>
        <th>用户ID</th>
        <th>用户名</th>
        <th>密码</th>
        <th>手机号</th>
        <th>E-mail</th>
        <th>真实姓名</th>
        <th>性别</th>
        <th>地址</th>
        <th>头像</th>
        <th>删除</th>
       </tr>
        <s:iterator value="list" var="u">
      <tr>
          <td><s:property value="#u.userId"/></td>
          <td><s:property value="#u.username"/></td>
          <td><s:property value="#u.password"/></td>
          <td><s:property value="#u.phone"/></td> 
          <td><s:property value="#u.email"/></td>
          <td><s:property value="#u.trueName"/></td>
          <td><s:property value="#u.sex"/></td>
          <td><s:property value="#u.address"/></td>
          <td><img src="getImage.action?account=<s:property value="#u.username"/>" width="60" height="60"/></td>
          <td><a href="deleteuser.action?id=<s:property value="#u.userId"/>">删除</a></td>
        </tr>
        </s:iterator>
        </table>
        </form>     
        
<table border="0" cellspacing="0" cellpadding="0"  width="900px">
<tr>
<td align="right">
   <span>第<s:property value="currPage"/>/<s:property value="totalPage"/>页</span>&nbsp;&nbsp;
   <span>总记录数:<s:property value="totalCount"/>/每页:<s:property value="pageSize"/>条</span>&nbsp;&nbsp;
   <span>
   <s:if test="currPage!=1">
       <a href="userAction_findAll.action?currPage=1">[首页]</a>&nbsp;&nbsp;
       <a href="userAction_findAll.action?currPage=<s:property value="currPage-1"/>">[上一页]</a>&nbsp;&nbsp;
   </s:if>
   <s:if test="currPage!=totalPage">
       <a href="userAction_findAll.action?currPage=<s:property value="currPage+1"/>">[下一页]</a>&nbsp;&nbsp;
       <a href="userAction_findAll.action?currPage=<s:property value="totalPage"/>">[尾页]</a>&nbsp;&nbsp;
   </s:if>
   </span>
</td>
</tr>
</table>
   
  </body>
</html>