package com.sh.bos.dao;

import com.sh.bos.dao.base.IBaseDao;
import com.sh.bos.domain.User;

public interface IUserDao extends IBaseDao<User> {

	public User findUserByUsernameAndPassword(String username, String password);

}
