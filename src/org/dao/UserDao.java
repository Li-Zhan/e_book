package org.dao;
import java.util.*;
import java.sql.*;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.model.Users;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.util.HibernateSessionFactory;
public class UserDao {
	
	private HibernateTemplate hibernateTemplate;
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
    
    
	public ArrayList getAllUser()throws Exception{//获取users表所有信息
//    	ArrayList arr=new ArrayList();
//    	Session session=HibernateSessionFactory.getSession();
//    	Transaction t=session.beginTransaction();
//    	Query query=session.createQuery("from Users");
//    	List list = query.list();
//    	t.commit();
//    	for(int i=0;i<list.size();i++){
//    		Users users=(Users) list.get(i);
//    		arr.add(users);
//    	}
//    	return arr;
		List<Users> users = (List<Users>) hibernateTemplate.find("from Users");
		return (ArrayList) users;
    }
	
	
    public Users getThisUser(String username)throws Exception{//根据用户名查询
 
//    	Session session=HibernateSessionFactory.getSession();
//    	Transaction t=session.beginTransaction();
//    	Query query=session.createQuery("from Users where username=?");
//    	query.setParameter(0, username);
//    	List list = query.list();
//    	t.commit();
    	List<Users> list = (List<Users>) hibernateTemplate.find("from Users where username=?",username);
    	if(list.size()!=0){
    		Users users=(Users) list.get(0);
    		return users;
    	}else{
    		return null;
    	}
    }
    
    public boolean trueLogin(String account,String pwd)throws Exception{//验证登录

//    	Session session=HibernateSessionFactory.getSession();
//    	Transaction t=session.beginTransaction();
//    	Query query=session.createQuery("from Users where username=? and password=?");
//    	query.setParameter(0, account);
//    	query.setParameter(1, pwd);
//    	List list = query.list();
//    	t.commit();
    	List<?> list = hibernateTemplate.find("from Users where username=? and password=?",account,pwd);
    	if(list.size()!=0){
    		return true;
    	}else{
    		return false;
    	}
    }
    
    public void insertUser(Users users
//    		String username,String password,String phone,String email,//向users表插入数据
//    		String true_name,String sex,String address,byte[] photo
    		)throws Exception{
    	
//    	Session session=HibernateSessionFactory.getSession();
//    	Transaction t=session.beginTransaction();
//    	Users users=new Users();
//    	users.setUsername(username);
//    	users.setPassword(password);
//    	users.setPhone(phone);
//    	users.setEmail(email);
//    	users.setTrueName(true_name);
//    	users.setSex(sex);
//    	users.setAddress(address);
//    	users.setPhoto(photo);
    	hibernateTemplate.save(users);
//    	session.save(users);
//    	t.commit();
//    	HibernateSessionFactory.closeSession();
    	
    }
    
    
    public void updateUser(Users user,int user_id,boolean pictureNull)throws Exception{ //根据userId更新数据

//    	Session session=HibernateSessionFactory.getSession();
//    	Transaction t=session.beginTransaction();
//    	Users users= (Users) session.get(Users.class,user_id);
    	Users users = hibernateTemplate.get(Users.class,user_id);
    	users.setUsername(user.getUsername());
    	users.setPassword(user.getPassword());
    	users.setPhone(user.getPhone());
    	users.setEmail(user.getEmail());
    	users.setTrueName(user.getTrueName());
    	users.setSex(user.getSex());
    	users.setAddress(user.getAddress());
    	if(!pictureNull){
    	users.setPhoto(user.getPhoto());
    	}
//    	session.update(users);
//    	t.commit();
//    	HibernateSessionFactory.closeSession();
    	hibernateTemplate.update(users);
    	
    }
    
    
    public void deleteUser(int user_id)throws Exception{//删除usrs表中的记录，根据用户ID删除
//
//    	Session session=HibernateSessionFactory.getSession();
//    	Transaction t=session.beginTransaction();
//    	Users users= (Users) session.get(Users.class,user_id);
//    	session.delete(users);
//    	t.commit();
//    	HibernateSessionFactory.closeSession();
    	Users users = hibernateTemplate.get(Users.class,user_id);
    	hibernateTemplate.delete(users);
    }


	/**
	 * 查询总记录数
	 */
	public int findCount() {
		String hql="select count(*) from Users";
		List<Long> list = (List<Long>) hibernateTemplate.find(hql);
		if(list.size()>0){
			return list.get(0).intValue();
		}
		return 0;
	}


	/**
	 * 分页信息
	 */
	public List<Users> findPage(int begin, int pageSize) {
		DetachedCriteria criteria=DetachedCriteria.forClass(Users.class);
		List<Users> list = (List<Users>) hibernateTemplate.findByCriteria(criteria, begin, pageSize);
		return list;
	}

}
