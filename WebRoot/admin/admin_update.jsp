<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="org.model.Users" %>
<%@ page import="org.model.Administrator" %>
<%@ page import="org.dao.UserDao" %>
<%@page import="org.dao.AdminDao" %>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<!-- 修改 用户信息  -->
<html>
  <head>
   <title>网上书店</title>
  </head>
  
  <body background="${pageContext.request.contextPath}/images/bj4.png">
  <form action="${pageContext.request.contextPath}/updateuser" method="post" enctype="multipart/form-data">
     
    <%
    request.setCharacterEncoding("utf-8");
    String username=request.getParameter("username");
       //UserDao udao=new UserDao(); 
       ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
       UserDao udao=(UserDao)ac.getBean("userDao");
       if(request.getAttribute("username")!=null){
          username=(String)request.getAttribute("username");
       }
     Users uvo=udao.getThisUser(username);
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
        <th>更换头像</th>
       </tr>
   <tr>
          <td><%=uvo.getUserId() %>
          <input type="hidden" name="id" value="<%=uvo.getUserId() %>">
          </td>
          <td><input value="<%=uvo.getUsername() %>" name="user.username" type="text"/></td>
          <td><input value="<%=uvo.getPassword() %>" name="user.password" type="text"/></td>
          <td><input value="<%=uvo.getPhone() %>" name="user.phone" type="text"/></td>
          <td><input value="<%=uvo.getEmail() %>" name="user.email" type="text"/></td>
          <td><input value="<%=uvo.getTrueName() %>" name="user.trueName" type="text"/></td>
          <td>			<%
							if (uvo.getSex().equals("男")) {
						%>

						<input type="radio" name="sex" value="1" checked>
						男
						<input type="radio" name="sex" value="0">
						女
						<%
							} else {
						%>
						<input type="radio" name="sex" value="1">
						男
						<input type="radio" name="sex" value="0" checked>
						女
						<%
							}
						%></td>
          <td><input value="<%=uvo.getAddress() %>" name="user.address" type="text"/></td>
          <td><input type="file" name="photo"/></td>
        </tr>
    	   </table>
    	   
    	   <%
    	}
    
     %>
    
      <center>修改用户信息：<input type="submit" value="更改提交"/></center>
      </form>
      <center>
       
       <br><a href="${pageContext.request.contextPath}/userAction_findAll.action"><font face='微软雅黑'>返回管理页</font></a><br/>
      </center>
  </body>
</html>
