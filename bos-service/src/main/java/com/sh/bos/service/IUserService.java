package com.sh.bos.service;

import com.sh.bos.domain.User;

public interface IUserService {

	public User login(User model);

    public void editPassword(String id, String password);
}
