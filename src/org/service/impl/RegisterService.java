package org.service.impl;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.dao.UserDao;
import org.model.Users;
import org.service.IRegisterService;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class RegisterService implements IRegisterService {
	private UserDao userDao;
	
	

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}



	public boolean register(String account, String password,Users users) throws Exception {
		if(userDao.trueLogin(account, password)){
			return false;
		}else{
			userDao.insertUser(users);
			return true;
		}
	}



	public void getImage(String account) throws Exception {
		
//		HttpServletRequest request = ServletActionContext.getRequest();
		// 得到照片的字节数组
		Users users = userDao.getThisUser(account);
		if(users.getPhoto()!=null){
		byte[] zp = users.getPhoto();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("image/jpeg");
		// 得到输出流
		ServletOutputStream os = response.getOutputStream();
		if (zp != null && zp.length > 0) {
			for (int i = 0; i < zp.length; i++) {
				os.write(zp[i]);
			}
		}
		}
	}

}
