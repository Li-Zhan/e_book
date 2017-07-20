<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="org.dao.BooksDao"%>
<%@ page import="org.model.Books"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page
	import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<html>
	<head>
		<title>网上书店</title>
		<style type="text/css">
div {
	float: left;
	margin: 10px;
}

div dd {
	margin: 0px;
	font-size: 10pt;
}

div dd.dd_name {
	color: blue;
}

div dd.dd_city {
	color: #000;
}
</style>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">

	</head>

	<body>
		<center>
			<font face="微软雅黑" size="5" color="#008000">以下是向你推荐的书籍</font>
		</center>
		<hr size="3" color="#008000">

		<center>
			<table width="750" height="60" cellpadding="0" cellspacing="0"
				border="0">
				<tr>
					<td>

						<!-- 图书循环开始 -->
						<%
							// BooksDao bdao= new BooksDao(); 
							ApplicationContext ac = new ClassPathXmlApplicationContext(
									"applicationContext.xml");
							BooksDao bdao = (BooksDao) ac.getBean("bookDao");
							ArrayList list = bdao.getAllbooks();
							if (list != null && list.size() > 0) {
								for (int i = 0; i < list.size(); i++) {
									Books bvo = (Books) list.get(i);
						%>
						<div>
							<dl>
								<dt>
									<a href="bookinfo.jsp?id=<%=bvo.getBookId()%>" title="点击进入详情页"><img
											src="getImage2.action?id=<%=bvo.getBookId()%>" width="120"
											height="140" border="1" />
									</a>
								</dt>
								<dd class="dd_name"><%=bvo.getBookname()%><br />
									价格:¥
									<%=bvo.getPrice()%></dd>
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
		</center>
	</body>
</html>

