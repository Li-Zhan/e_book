package org.action;

import java.io.File;
import java.io.FileInputStream;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import org.model.PageBean;
import org.model.Users;
import org.service.IUserService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


public class UserAction extends ActionSupport {
	
	private IUserService userService;
	
	//分页的首页
	private int currPage;
	

	public int getCurrPage() {
		return currPage;
	}

	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}
	
	
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}


	private Users user;
	private String sex;
	private File photo;
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public File getPhoto() {
		return photo;
	}

	public void setPhoto(File photo) {
		this.photo = photo;
	}

	public String addUser() throws Exception { // 添加用户

		byte[] buffer = null;
			// 处理照片信息
			File file =getPhoto();
				// 得到输入流
			if (file != null) {
				FileInputStream fis = new FileInputStream(file);
				// 创建大小为fis.available()的字节数组
				buffer = new byte[fis.available()];
				// 把输入流读到字节数组中
				fis.read(buffer);
				fis.close();
			}
		HttpServletRequest request = ServletActionContext.getRequest();
		if (getSex().equals("1")) {
			sex = "男";
		} else {
			sex = "女";
		}
		
		
		Users user=getUser();
		user.setSex(sex);
		user.setPhoto(buffer);
		
		
		
		if (getUser().getUsername() != null && getUser().getPassword() != null) {
			if(userService.addUser(user)){
				request.setAttribute("addusersuccess", "注册成功！");
				return ERROR;
			}else{
				request.setAttribute("addusererror", "此用户已存在");
				return SUCCESS;
			}
			
		} else {
			request.setAttribute("addusererror", "两次输入的密码不一致！");
			return ERROR;
		}
	}

	public String deleteUser() throws Exception { // 删除用户
		
		if(userService.deleteUser(getId())){
			return SUCCESS;
		}
		return ERROR;
	}

	public String findUser() throws Exception { // 查询用户
		Users thisUser = userService.findUser(getUser().getUsername());
		HttpServletRequest request = ServletActionContext.getRequest();
		if (thisUser != null) {
			request.setAttribute("user", thisUser);
			return SUCCESS;
		} else {
			request.setAttribute("findusererror", "没有查询到该用户！！！");
			return ERROR;
		}
	}

	public String updateUser()throws Exception{            //管理员修改用户信息
		byte[] buffer = null;
		boolean pictureNull = false; // 判断图片是否为空
			// 处理照片信息
			File file =getPhoto();
			if (file != null) {
				// 得到输入流
				FileInputStream fis = new FileInputStream(file);
				// 创建大小为fis.available()的字节数组
				buffer = new byte[fis.available()];
				// 把输入流读到字节数组中
				fis.read(buffer);
				fis.close();
		}else{
			pictureNull=true;
		}
		//处理性别
		if (getSex().equals("1")) {
			sex = "男";
		} else {
			sex = "女";
		}
		HttpServletRequest request = ServletActionContext.getRequest();
		Users user=getUser();
		if(user!=null){
		user.setSex(sex);
		user.setPhoto(buffer);
		if(userService.updateUser(user, getId(), pictureNull)){
			return SUCCESS;
		}else {
			return ERROR;
		}
		}else{
			request.setAttribute("username",user.getUsername());
			request.setAttribute("updateerror","发生内部错误,请稍后再试！！！");
			return ERROR;
		}

	}
	
	public String updateUser2()throws Exception{            //用户修改自己信息
		
		if(updateUser().equals("success")){
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
	
	/**
	 * 分页
	 */
	public String findAll(){
		PageBean<Users> pageBean=userService.findAll(currPage);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}
	
}
