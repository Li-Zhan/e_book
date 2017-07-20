package org.service.impl;

import java.util.List;

import org.dao.UserDao;
import org.model.PageBean;
import org.model.Users;
import org.service.IUserService;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class UserService implements IUserService {
	private UserDao userDao;
	
	

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}



	public boolean addUser(Users users)
			throws Exception {
		if(userDao.trueLogin(users.getUsername(),users.getPassword())){
			return false;
		}else{
			userDao.insertUser(users);
			return true;
		}
	}



	public boolean deleteUser(int id) throws Exception {
			userDao.deleteUser(id);
			return true;
	}



	public Users findUser(String userName) throws Exception {
		return userDao.getThisUser(userName);
	}



	public boolean updateUser(Users user, int id, boolean pictureNull)
			throws Exception {
		if(userDao.trueLogin(user.getUsername(), user.getPassword())){
			userDao.updateUser(user, id, pictureNull);
			return true;
		}
		return false;
	}



	/**
	 * 分页
	 */
	public PageBean<Users> findAll(int currPage) {
		PageBean<Users> pageBean =new PageBean<Users>();
		// 封装pageBean
		pageBean.setCurrPage(currPage);
		int pageSize = 3;
		pageBean.setPageSize(pageSize);
		int totalCount = userDao.findCount();
		pageBean.setTotalCount(totalCount);
		Double totalPage = Math.ceil((double) totalCount / pageSize);
		pageBean.setTotalPage(totalPage.intValue());
		int begin = (currPage - 1) * pageSize;
		List<Users> list = userDao.findPage(begin, pageSize);
		pageBean.setList(list);
		return pageBean;
	}

}
