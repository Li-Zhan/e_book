package org.service;

import org.model.PageBean;
import org.model.Users;

public interface IUserService {
	public boolean addUser(Users users)throws Exception;
	
	public boolean deleteUser(int id)throws Exception;
	
	public Users findUser(String userName)throws Exception;
	
	public boolean updateUser(Users user,int id,boolean pictureNull)throws Exception;

	public PageBean<Users> findAll(int currPage);

}
