package com.gejianwei_1510121154.dao;

import com.gejianwei_1510121154.domain.User;

public interface IUserDao {

	boolean save(User user);

	User find(String username, String password);
}