package com.gejianwei_1510121154.service;

import com.gejianwei_1510121154.dao.UserDaoImpl;
import com.gejianwei_1510121154.domain.User;
import com.gejianwei_1510121154.exception.UserExistException;
import com.gejianwei_1510121154.exception.UserNotExistException;
import com.gejianwei_1510121154.util.UserUtil;

public class UserServiceImpl implements IUserService {
	private UserDaoImpl dao = new UserDaoImpl();

	/*
	 * @see com.gejianwei_1510121154.service.impl.IUserService#register(com.gejianwei_1510121154.domain.User)
	 */
	@Override
	public boolean register(User user) throws UserExistException {
		// 用MD5加密密码
		String pwd = UserUtil.md5(user.getPassword());		
		User u = dao.find(user.getUsername(), pwd);
		if (u != null) {// 如果发现用户已存在，抛出UserExistException异常，通知web层处理
			throw new UserExistException("用户已存在，请直接登录！！");
		}
		user.setPassword(pwd);
		return dao.save(user);
	}

	/*
	 * @see com.gejianwei_1510121154.service.impl.IUserService#login(java.lang.String, java.lang.String)
	 */
	@Override
	public User login(String username, String password) throws UserNotExistException {
		String m_psw = UserUtil.md5(password);
		User user = dao.find(username, m_psw);
		if(user==null) {
			throw new UserNotExistException("登录出错，用户不存在！！");
		}
		return user;		
	}
}
