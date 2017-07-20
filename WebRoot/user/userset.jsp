<%@ page language="java" import="java.util.*,java.sql.*" pageEncoding="UTF-8"%>
<%@ page import="org.model.Users"%>
<%@ page import="org.dao.UserDao"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<!-- 普通用户修改自己信息 -->
<html>
	<head>
		<title>网上书店</title>
	</head>

	<body background="${pageContext.request.contextPath}/images/bj4.png">
		<center>
			&nbsp;&nbsp;
			<font face="微软雅黑">修改您的信息</font>
			<hr>
		</center>
		<br />
		<br />
		<br />
		<form action="updateuser" method="post" enctype="multipart/form-data">
			<table border="1" cellspacing="0px" align="center">
				<%
					request.setCharacterEncoding("utf-8");
					String pwd = null;
					String account = (String) session.getAttribute("username");
					//UserDao udao = new UserDao();
					ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
					UserDao udao = (UserDao)ac.getBean("userDao");
					Users uvo = udao.getThisUser(account);
					if (uvo != null) {
				%>
				<tr height="60">
						<input type="hidden" name="id" value="<%=uvo.getUserId()%>">
					<td>
						用户名
					</td>
					<td>
						<input value="<%=uvo.getUsername()%>" name="user.username"
							type="text" />
					</td>
					<td>
						密码
					</td>
					<td>
						<input value="<%=uvo.getPassword()%>" name="user.password"
							type="text" />
					</td>
					<td>
						电话
					</td>
					<td>
						<input value="<%=uvo.getPhone()%>" name="user.phone" type="text" />
					</td>
					<td>
						邮箱
					</td>
					<td>
						<input value="<%=uvo.getEmail()%>" name="user.email" type="text" />
					</td>
					<td>
						真实姓名
					</td>
					<td>
						<input value="<%=uvo.getTrueName()%>" name="user.trueName"
							type="text" />
					</td>
				</tr>
				<tr>
					<td>
						性别
					</td>
					<td>
						<%
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
						%>
					</td>
					<td>
						地址
					</td>
					<td>
						<input value="<%=uvo.getAddress()%>" name="user.address"
							type="text" />
					</td>
					<td>
						头像
					</td>
					<td>
						<img src="getImage.action?account=<%=uvo.getUsername()%>"
							width="60" height="60">
					</td>
					<td>
						上传头像
					</td>
					<td>
						<input type="file" name="photo" />
					</td>
				</tr>
				<%
					}
				%>
			</table>
			<center>
				<font face="微软雅黑">修改之后，点击提交：</font>
				<input type="submit" value="更改提交" />
			</center>
		</form>

		<center>

			<%
				String error = (String) request.getAttribute("updateerror");
				String success = (String) request.getAttribute("updatesuccess");
				if (error != null) {
					out.print("<font face='微软雅黑' size='5' color='red'>" + error
							+ "</font>");
				}
				if (success != null) {
					out.print("<font face='微软雅黑' size='5' color='green'>" + success
							+ "</font>");
					response.setHeader("Refresh","3;URL='${pageContext.request.contextPath}/loginform.jsp'");
				}
			%>

		</center>
	</body>
</html>
