package org.action;

import java.io.File;
import java.io.FileInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import org.model.Users;
import org.service.IRegisterService;

import com.opensymphony.xwork2.ActionSupport;


public class RegisterAction extends ActionSupport {
	
	private IRegisterService registerService;
	
	
	
	public void setRegisterService(IRegisterService registerService) {
		this.registerService = registerService;
	}

	private String account;
	private String sex;
	private String password;
	private String npassword;
	private String email;
	private String phone;
	private String truename;
	private String address;
	private File photo;

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

	public String getNpassword() {
		return npassword;
	}

	public void setNpassword(String npassword) {
		this.npassword = npassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getTruename() {
		return truename;
	}

	public void setTruename(String truename) {
		this.truename = truename;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String execute() throws Exception {

		byte[] buffer = null;
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
				}

		HttpServletRequest request = ServletActionContext.getRequest();
		if (getSex().equals("1")) {
			sex = "男";
		} else {
			sex = "女";
		}
		
		
		Users user=new Users();
		user.setUsername(getAccount());
		user.setPassword(getPassword());
		user.setSex(sex);
		user.setPhone(getPhone());
		user.setEmail(getEmail());
		user.setTrueName(getTruename());
		user.setAddress(getAddress());
		user.setPhoto(buffer);
		
		
		if (getAccount() != null && getPassword() != null
				&& getNpassword().equals(getPassword())) {
			
			if(registerService.register(getAccount(), getPassword(), user)){
				request.setAttribute("error3", "注册成功,请登录！");
				return SUCCESS;
			}else{
				request.setAttribute("error2", "此用户已存在");
				return ERROR;
			}
//			if (userDao.trueLogin(getAccount(), getPassword())) {
//				request.setAttribute("error2", "此用户已存在");
//				return ERROR;
//			} else {
//
//				userDao.insertUser(getAccount(), getPassword(), getPhone(),
//						getEmail(), getTruename(),sex, getAddress(), buffer);
//				request.setAttribute("error3", "注册成功,请登录！");
//				return SUCCESS;
//			}
		} else {
			request.setAttribute("error2", "两次输入的密码不一致！");
			return ERROR;
		}
	}

	// 读取照片信息
	public String getImage() throws Exception {

		HttpServletRequest request = ServletActionContext.getRequest();
		// 得到照片的字节数组
//		Users users = userDao.getThisUser(
		String account=(String) request.getAttribute("account");
		registerService.getImage(account);
//		byte[] zp = users.getPhoto();
//		HttpServletResponse response = ServletActionContext.getResponse();
//		response.setContentType("image/jpeg");
//		// 得到输出流
//		ServletOutputStream os = response.getOutputStream();
//		if (zp != null && zp.length > 0) {
//			for (int i = 0; i < zp.length; i++) {
//				os.write(zp[i]);
//			}
//		}
		// 不去任何页面
		return NONE;
	}

}
