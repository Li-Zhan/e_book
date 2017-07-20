<%@ page language="java" import="java.util.*,java.sql.*" pageEncoding="UTF-8"%>
<%@ page import="org.model.Users" %>
<%@ page import="org.model.Administrator" %>
<%@ page import="org.dao.UserDao" %>
<%@page import="org.dao.AdminDao" %>
<!-- 搜索用户  -->
<html>
<head>
  <title>网上书店</title>
    <style  type="text/css">
      a:link{color:blue;text-decoration:none;}
      a:hover{color:red;text-decoration:underline;}
    </style>
</head>
<body background="${pageContext.request.contextPath}/images/bj4.png">
     <font face="微软雅黑" size="7">搜索用户</font><hr/><br/><br/>
    <form action="finduser" method="get">
      <font face="微软雅黑" size="3">根据用户名查询</font>
         <input type="text" name="user.username">
      <input type="submit" value="查询">
    </form>
    <%
       Users uvo=(Users)request.getAttribute("user");
   if(uvo!=null){
    	   %>
    	  <table border="1" cellspacing="0px" align="center">
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
       </tr>
   <tr>
          <td><%=uvo.getUserId() %>
          <input type="hidden" name="user_id" value="<%=uvo.getUserId() %>">
          </td>
          <td><%=uvo.getUsername() %></td>
          <td><%=uvo.getPassword() %></td>
          <td><%=uvo.getPhone() %></td>
          <td><%=uvo.getEmail() %></td>
          <td><%=uvo.getTrueName() %></td>
          <td><%=uvo.getSex() %></td>
          <td><%=uvo.getAddress() %></td>
          <td><img src="getImage.action?account=<%=uvo.getUsername() %>" width="60" height="60"/></td>
        </tr>
    	   </table>
    	   <a href="admin_update.jsp?username=<%=uvo.getUsername() %>">修改此用户信息</a>
    	   <%
    	}
     %>
      <a href="${pageContext.request.contextPath}/userAction_findAll.action">
         <font face='微软雅黑'>返回管理页</font></a>
  </body>
</html>
