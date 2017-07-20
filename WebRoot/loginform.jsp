<%@ page language="java" import="java.util.*,java.sql.*" pageEncoding="UTF-8"%>
<!-- 账号密码登陆 -->
<html>
  <head>
    <title>网上书店</title>
    <style  type="text/css">
      a:link{color:blue;text-decoration:none;}
      a:hover{color:red;text-decoration:underline;}
    </style>
  </head>
  <body background="images/bj2.jpg">
 <center>
  <script type="text/javascript">
    function refresh(){
      //passwordform.imgValidate.src ="code.jsp";
      document.getElementById("imgValidate").src="code.jsp?"+new Date();
    }
 </script>
  
    <form name="passwordform" action="login" method="post">
       <font face="微软雅黑" size="5" color="white">账号密码登陆！</font><hr><br/><br/>
       <table>
         <tr height="100px">
           <td>
         <font face="微软雅黑" size="6" color="white">登录类型：</font>
           </td>
           <td>
         <select name="type">
           <option value="admin">管理员</option>
           <option value="user" selected>用户</option>
         </select> 
           </td>
         </tr>
    	<tr height="100px">
    	  <td><font face="微软雅黑" size="6" color="white">请输入您的账号：</font></td>
    	  <td><input name="account" type="text"></td>
    	</tr>
        <tr height="100px">
          <td><font face="微软雅黑" size="6" color="white">请输入您的密码：</font></td>
          <td><input name="password" type="password"></td>
        </tr>
        <tr height="100px">
          <td><font face="微软雅黑" size="6" color="white">请输入验证码:</font></td>
          <td><input type="text" name="code" size="10">
                      <img id="imgValidate" src="code.jsp" onclick="refresh()" title="看不清可单击图片刷新"></td>
        <td><input type="submit" value="登录"/>&nbsp;</td>
        </tr>
        <tr>
          <td><input type="checkbox" value="true" name="checked" checked>
          <font face="微软雅黑" size="3" color="white"> 一小时之内记住密码</font></td>
          <td><a href="register.jsp">没有账号？来注册一个</a> </td>
          <td><a href="javascript:window.opener=null;window.open('','_self');window.close();">关闭</a></td>
       </tr>   
                      
        </table>
   </form>     
        <%
        request.setCharacterEncoding("utf-8");
       String error=(String)request.getAttribute("error1");
              if(error!=null){
          out.print("<font face='微软雅黑' size='5' color='white'>"+error+"</font>");
       }
         %>         
</center> 
  </body>
</html>
