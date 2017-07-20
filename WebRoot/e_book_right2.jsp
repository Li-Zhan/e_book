<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="org.dao.BooksDao" %>
<%@ page import="org.model.Books" %>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<html>
  <head>
   <title>网上书店</title>
<style type="text/css">
	   div{
	      float:left;
	      margin: 10px;
	   }
	   div dd{
	      margin:0px;
	      font-size:10pt;
	   }
	   div dd.dd_name
	   {
	      color:blue;
	   }
	   div dd.dd_city
	   {
	      color:#000;
	   }
	  a:link{color:blue;text-decoration:none;}
      a:hover{color:red;text-decoration:underline;}
	</style>
	
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">  
	
  </head>
  
  <body>
    <table width="750" height="60" cellpadding="0" cellspacing="0" border="0">
      <tr>
        <td>
          
          <!-- 图书循环开始 -->
           <%   
               request.setCharacterEncoding("utf-8");
                String type=request.getParameter("type");
                //BooksDao bdao= new BooksDao(); 
                ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
                BooksDao bdao=(BooksDao)ac.getBean("bookDao");
              List<Books> list=bdao.gettypebooks(Integer.parseInt(type)); 
               if(list!=null&&list.size()>0)
               {
                        for(Books bvo:list){
           %>   
          <div>
             <dl>
               <dt>
                 <a href="bookinfo.jsp?id=<%=bvo.getBookId()%>" title="点击进入详情页"><img src="getImage2.action?id=<%=bvo.getBookId() %>" width="120" height="140" border="1"/></a>
               </dt>
               <dd class="dd_name"><%=bvo.getBookname()%><br/>
                                      价格:¥ <%=bvo.getPrice()%></dd> 
             </dl>
          </div>
          <!-- 图书循环结束 -->
        
          <%
                   }
              } 
          %>
        </td>
      </tr>
    </table>
       <center><a href="e_book_right.jsp" >回到首页</a></center>
  </body>
</html>

