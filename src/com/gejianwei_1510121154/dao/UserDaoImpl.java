package com.gejianwei_1510121154.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.gejianwei_1510121154.domain.User;
import com.gejianwei_1510121154.util.JdbcUtils;

public class UserDaoImpl implements IUserDao {
	/* 
	 * @see com.gejianwei_1510121154.dao.impl.IUserDao#save(com.gejianwei_1510121154.domain.User)
	 */
	@Override
	public boolean save(User user) {
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		boolean flag = false;
		String command = null;
		if (user.getUid() == null) {
			command = "insert into t_user(username, password, gender, phone, email, usericon) values(?,?,?,?,?,?)";
		} else {
			command = "update t_user set username = ?, password = ?, gender = ?, phone = ?, email = ?, usericon = ? where uid = ?";
		}
		try {
			conn = JdbcUtils.getConnection();
			stat = conn.prepareStatement(command);
			stat.setString(1, user.getUsername());
			stat.setString(2, user.getPassword());
			stat.setString(3, user.getGender());
			stat.setString(4, user.getPhone());
			stat.setString(5, user.getEmail());
			stat.setString(6, user.getUsericon());
			if (user.getUid() != null) {
				stat.setString(7, user.getUid());
			}
			int num = stat.executeUpdate();
			if (num > 0) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.release(conn, stat, rs);
		}
		return flag;
	}

	/* 
	 * @see com.gejianwei_1510121154.dao.impl.IUserDao#find(java.lang.String, java.lang.String)
	 */
	@Override
	public User find(String username, String password) {
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		User user = null;
		
		String command = "select * from t_user where username = ? && password = ?";		
		try {
			conn = JdbcUtils.getConnection();
			stat = conn.prepareStatement(command);
			stat.setString(1, username);
			stat.setString(2, password);
			
			rs = stat.executeQuery();
			if (rs.next()) {
				user = new User();
				user.setUid(rs.getString(1));
				user.setUsername(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setGender(rs.getString(4));
				user.setPhone(rs.getString(5));
				user.setEmail(rs.getString(6));
				user.setUsericon(rs.getString(7));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.release(conn, stat, rs);
		}
		return user;
	}	
}
