package org.service;

import org.model.Users;

public interface IRegisterService {
	public boolean register(String account,String password,Users users)throws Exception;
	
	public void getImage(String account)throws Exception;

}
