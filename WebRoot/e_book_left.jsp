<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!-- 页面左侧 -->
<html>
	<head>
		<title>网上书店</title>
		<style type="text/css">
a {
	color: #06329b;
	font-size: 25px;
	text-decoration: none;
	line-height: 30px;
}

#div2 {
	width: 150px;
}

font {
	font-weight: bold;
}
</style>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">  

	</head>

	<body>
		<div id="div2">
			<table width="100%" border="0" cellspacing="0" cellpadding="0"
				frame="void">
				<tr>
					<td bgcolor="#C0FF3E" align="center">
						<font face="微软雅黑" size="3">图书分类</font>
					</td>
				</tr>
			</table>

			<img src="images/triangle.jpg" height="25" width="25" />
			<a href="e_book_right2.jsp?type=1" target="right">网络小说</a>
			<br />
			<img src="images/triangle.jpg" height="25" width="25" />
			<a href="e_book_right2.jsp?type=2" target="right">教育图书</a>
			<br />
			<img src="images/triangle.jpg" height="25" width="25" />
			<a href="e_book_right2.jsp?type=3" target="right">科普书籍</a>
			<br />
			<img src="images/triangle.jpg" height="25" width="25" />
			<a href="e_book_right2.jsp?type=4" target="right">经营宝典</a>
			<br />
			<img src="images/triangle.jpg" height="25" width="25" />
			<a href="e_book_right2.jsp?type=5" target="right">先秦古籍</a>
			<br />
		</div>
		<br />
		<form action="e_book_right3.jsp" method="post" target="right">
			<table width="150px">
				<tr>
					<td bgcolor="#C0FF3E" align="center">
						<font face="微软雅黑" size="3">图书搜索</font>
					</td>
				</tr>
				<tr>
					<td>
						<input type="text" name="bookname" />
					</td>
					<td>
						<input type="submit" value="查询" />
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
