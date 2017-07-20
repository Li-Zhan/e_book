<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!-- 添加用户信息 -->
<html>
  <head>
    <title>网上书店</title>
    <style  type="text/css">
      a:link{color:blue;text-decoration:none;}
      a:hover{color:red;text-decoration:underline;}
    </style>
  </head>
  
  <body background="${pageContext.request.contextPath}/images/bj4.png">
  <font face="微软雅黑" size="7">添加用户</font><hr/>
 <center>
  <form action="adduser" method="post" enctype="multipart/form-data">
   <table>
     <tr height="50px">
        <td><font face="微软雅黑" size="6">户名:</font></td>
        <td><input type="text" name="user.username"></td>
     </tr>
     <tr height="50px">  
      <td><font face="微软雅黑" size="6"> 密码:</font></td>
      <td><input type="text" name="user.password"></td>
     </tr>
     <tr> 
       <td><font face="微软雅黑" size="6">手机号:</font></td>
       <td><input type="text" name="user.phone"></td>
    </tr>
    <tr height="50px">  
       <td><font face="微软雅黑" size="6">E-mail:</font></td>
       <td><input type="text" name="user.email"></td>
    </tr>
    <tr height="50px">
        <td><font face="微软雅黑" size="6">真实姓名:</font></td>
        <td><input type="text" name="user.trueName"></td>
    </tr>
    <tr height="50px">   
        <td><font face="微软雅黑" size="6">性别:</font></td>
        <td> <input type="radio" name="sex" value="1" checked>男
             <input type="radio" name="sex" value="0">女</td>
    </tr>
    <tr height="50px">
       <td><font face="微软雅黑" size="6">地址:</font></td>
       <td><input type="text" name="user.address"></td>
    </tr>
     <tr height="50px">
      <td><font face="微软雅黑" size="6">头像:</font></td>
          <!-- 上传照片 -->
          <td><input type="file" name="photo"/> </td>
    </tr>      
    <tr height="50px">
       <td><input type="submit" value="提交"></td>

       <td><a href="bookAction_findAll.action">
              <font face='微软雅黑'>返回管理页</font></a></td>
      </tr> 
    </table>   
      </form> 
      <%
      String error=(String)request.getAttribute("addusererror");
      String success=(String)request.getAttribute("addusersuccess");
      if(error!=null){
       out.print("<font face='微软雅黑' size='5' color='red'>"+error+"</font>");
    }
    if(success!=null){
     out.print("<font face='微软雅黑' size='5' color='green'>"+success+"</font>");
    }
       %>
</center>
  </body>
</html>
