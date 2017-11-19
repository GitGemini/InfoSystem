package junit.test;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.gejianwei_1510121154.dao.IUserDao;
import com.gejianwei_1510121154.dao.UserDaoImpl;
import com.gejianwei_1510121154.domain.IconList;
import com.gejianwei_1510121154.domain.User;
import com.gejianwei_1510121154.exception.UserExistException;
import com.gejianwei_1510121154.service.UserServiceImpl;

public class testUser {
	
	@Test
	public void testAdd() {
		UserServiceImpl us = new UserServiceImpl();
		User user = new User();
		user.setUsername("niconi");
		user.setPassword("123");
		user.setGender("女");
		user.setPhone("110");
		user.setEmail("aa@qq.com");
		user.setUsericon("a.png");
		try {
			us.register(user);
		} catch (UserExistException e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void testGet() {
//		UserServiceImpl us = new UserServiceImpl();
//		User user;
//		try {
//			user = us.login("niconi","4123");
//		} catch (UserNotExistException e) {
//			System.out.println(e.getMessage());
//		}
	}
	
	@Test
	public void testUpdate() {
		IUserDao ud = new UserDaoImpl();
		User user = ud.find("nico","123");
		System.out.println(user);
		user.setEmail("qqwe@qq.com");
		ud.save(user);
	}
	
	@Test
	public void testGetList() {
		IconList iconlist = new IconList();
		List<String> list = iconlist.getIconList();
		System.out.println(list.size());
	}
}
