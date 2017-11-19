package com.gejianwei_1510121154.service;

import com.gejianwei_1510121154.domain.User;
import com.gejianwei_1510121154.exception.UserExistException;
import com.gejianwei_1510121154.exception.UserNotExistException;

public interface IUserService {

	boolean register(User user) throws UserExistException;

	User login(String username, String password) throws UserNotExistException;
}