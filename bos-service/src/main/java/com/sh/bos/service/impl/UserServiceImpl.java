package com.sh.bos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sh.bos.dao.IUserDao;
import com.sh.bos.domain.User;
import com.sh.bos.service.IUserService;
import com.sh.bos.utils.MD5Utils;
@Service
@Transactional
public class UserServiceImpl implements IUserService{
	@Autowired
	private IUserDao userDao;
	/***
	 * 用户登录
	 */
	public User login(User user) {
		//使用MD5加密密码
		String password = MD5Utils.md5(user.getPassword());
		return userDao.findUserByUsernameAndPassword(user.getUsername(),password);
	}

	/**
	 * 根据用户ID修改密码
	 * @param id
	 * @param password
	 */
	public void editPassword(String id, String password) {
		password = MD5Utils.md5(password);
		userDao.executeUpdate("user.editpassword",password,id);
	}
}
