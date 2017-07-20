<%@ page language="java" import="java.util.*,java.sql.*" pageEncoding="UTF-8"%>
<%@ page import="org.model.Users" %>
<%@ page import="org.dao.UserDao" %>
<!-- 注册用户账号  -->
<html>
  <head>
    <title>网上书店</title>
    <style type="text/css">
      body{text-align:center;}
      .zhuce{font-size:20px;align:center;width:860px;margin:0 auto;}
      .zhuce td{border:3px solid black;padding:2px 3px;text-align:center;}
      .zhuce.ibg{text-align:left;}
    </style>
  </head>
  
  <body background="images/bj3.jpg">
      <script type="text/javascript">
      function check(){
        if(loginForm.account.value==""){
            alert("昵称不能为空!!");
            return;
        }
        if(loginForm.password.value==""){
            alert("密码不能为空!!");
            return;
        }
         if(loginForm.npassword.value==""){
            alert("确认密码不能为空!!");
            return;
        }
      loginForm.submit();
      }
    </script>
 <font face="微软雅黑" size="5"> 注册用户账号
  <hr><br/><br/><br/>
    <form action="register" method="post" name="loginForm" enctype="multipart/form-data">
    <table class="zhuce" height="300" >
    <tr>
      <td width="100">昵称</td>  
      <td class="ibg"><input name="account" type="text"></td>
      <td>性别 </td> 
      <td class="ibg"> <input type="radio" name="sex" value="1" checked>男
      <input type="radio" name="sex" value="0">女</td>
    </tr>
    <tr>  
     <td> 密码</td>  
     <td class="ibg"><input name="password" type="password"/></td>
      <td>确认密码</td>
      <td class="ibg"><input name="npassword" type="password"></td>
    </tr>
    <tr> 
    <td> 邮箱 </td> 
    <td class="ibg"><input type="text" name="email"></td>
     <td>电话</td>  
     <td class="ibg"><input type="text" name="phone"/></td>
    </tr>
    <tr> 
       <td>真实姓名</td>
       <td class="ibg"><input type="text" name="truename"></td>
      <td>地址</td>  
      <td class="ibg"><input type="text" name="address" style="width:400px"/></td>
    </tr>
    <tr>
      <td>头像:</td>
          <!-- 上传照片 -->
          <td><input type="file" name="photo"/> </td>
    </tr>    
     </table>
  <input type="checkbox" checked="checked"><font face="微软雅黑" size="2"/>我已阅读并同意相关服务条款和隐私政策
  <input type="button" value="提交注册" onClick="check()">
  <input type="reset" value="重置"/>
    </form>
    <%
    request.setCharacterEncoding("utf-8");
    String error2=(String)request.getAttribute("error2");
    String error3=(String)request.getAttribute("error3");
    if(error2!=null){
       out.print("<font face='微软雅黑' size='5' color='red'>"+error2+"</font>");
    }
    if(error3!=null){
       out.print("<font face='微软雅黑' size='5' color='green'>"+error3+"</font>");
       response.setHeader("Refresh","3;URL='loginform.jsp'");
    }
     %>
     </font>
  </body>
</html>
