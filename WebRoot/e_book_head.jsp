<%@ page language="java" import="java.util.*,java.sql.*" pageEncoding="utf-8" contentType="text/html"%>
<!-- 页面头部 -->
<html>
<head>
     <title>网上书店头部</title>
  <style type="text/css">
      body{background:#cae4ff;}
      a:link{color:blue;text-decoration:none;}
      a:hover{color:red;text-decoration:underline;}
      font{font-weight:bold;}
      	#div1{
    width: 1350px;
}
  </style>
</head>

 <body >

       <div id="div1">
       <table>
       <tr>
       <td> <img src="images/lysf.jpg" height="55px"; width="55px" alt="欢迎来到洛阳师范学院网上书店。"/></td>
       <td><font face="微软雅黑" size="5">欢迎来到洛阳师范学院网上书店</font></td>
       <td width="700">&nbsp;</td>
       <td>
       <%
       if(session.getAttribute("username")!=null){
          %>
          <a href="user/userset.jsp" target="_blank" title="您好， <%=session.getAttribute("username")%>">
            <img src="getImage.action?account=<%=session.getAttribute("username")%>" width="40" height="40">
          </a>
          <%
       }
       else{
       %>
       <a href="loginform.jsp" target="_blank">登录注册</a>
       <%
       }
        %>
       </td>
       <td>  |</td>
       <td>关于</td>
       <td>  |</td>
       <td>联系我们</td>
       </tr>
       
       </table>
       </div>

 </body>
</html>