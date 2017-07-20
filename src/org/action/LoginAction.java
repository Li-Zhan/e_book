package org.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import org.dao.AdminDao;
import org.dao.UserDao;
import org.model.PageBean;
import org.model.Users;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


public class LoginAction extends ActionSupport{
	private AdminDao adminDao;
	private UserDao userDao;
	
	
  public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

private String account;
  private String password;
  private String code;
  private String type;

  

public String getAccount() {
	return account;
}
public void setAccount(String account) {
	this.account = account;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getCode() {
	return code;
}
public void setCode(String code) {
	this.code = code;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}

public String execute() throws Exception {
	HttpServletRequest request=ServletActionContext.getRequest();
	HttpSession session=request.getSession();
	String randStr=(String) session.getAttribute("randStr");
	if(code!=null){
		if(code.equals(randStr)){
			if(getType().equals("admin")){
				boolean trueAdminLogin = adminDao.trueAdminLogin(getAccount(),getPassword());
				if(trueAdminLogin){
					session.setAttribute("account", getAccount());
					session.setAttribute("password", getPassword());					
					return "admin";
				}else{
					request.setAttribute("error1", "请检查账号密码是否正确！");
					return ERROR;
				}
			}else{
				if(userDao.trueLogin(getAccount(), getPassword())&&request.getParameter("checked").equals("true")){
					session.setAttribute("username",getAccount());
					return "user";
				}else{
					request.setAttribute("error1", "请检查账号密码是否正确！");
					return ERROR;
				}
			}
		}else{
			request.setAttribute("error1", "验证码错误！");
			return ERROR;
		}
	}else{
		request.setAttribute("error1", "验证码错误！");
		return ERROR;
	}
}
  
}
