<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!-- 返回登录 -->
<html>
  <head>
    <title>网上书店</title>
    <style type="text/css">
      a:link{color:blue;text-decoration:none;}
      a:hover{color:red;text-decoration:underline;}
    </style>
  </head>
  
  <body>
   <%
    out.println("<font face='微软雅黑' size='5' >密码或账号错误！</font>");
    %><br/>
    <a href="loginform.jsp"> 返回重新登录 </a>
  </body>
</html>
