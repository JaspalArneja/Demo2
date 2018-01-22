package com.jaspal.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.jaspal.controller.*;
//import com.jaspal.bean.CountryBean;
import com.jaspal.dao.UserDao;

import com.jaspal.bean.UserDetailBean;

public class UserCRUDService {

	private List<UserDetailBean> list = null;

	public String userRegister(UserRegisterAction userDetails) {
		UserDao dao = new UserDao();
		Connection con = dao.getconnection();
		return dao.userRegister(con, userDetails);
	}

	public String userUpdate(UpdateUserDetailsAction user) {
		UserDao dao = new UserDao();
		Connection con = dao.getconnection();
		return dao.userUpdate(con, user);
	}

	public List<UserDetailBean> getUsers() {
		UserDao dao = new UserDao();
		Connection con = dao.getconnection();
		ResultSet rs = dao.getAllUsers(con);
		list = new ArrayList<UserDetailBean>();
		try {
			while (rs.next()) {
				UserDetailBean bean = new UserDetailBean();
				bean.setId(rs.getInt("id"));
				bean.setName(rs.getString("name"));
				bean.setEmail(rs.getString("email"));
				bean.setPhone(rs.getString("phone"));
				bean.setAge(rs.getString("age"));
				bean.setPassword(rs.getString("password"));
				bean.setCountry(rs.getString("country"));
				bean.setState(rs.getString("state"));
				bean.setCity(rs.getString("city"));
				bean.setStreet_address(rs.getString("street_address"));
				bean.setCountryid(rs.getInt("countryid"));
				bean.setStateid(rs.getInt("stateid"));
				bean.setCityid(rs.getInt("cityid"));
				list.add(bean);
			}
		} catch (Exception e) {
			System.out.println("exception");
		} finally {
			try {
				con.close();
			} catch (Exception e1) {
				System.out.println("exception in closing connection");
			}
		}
		// System.out.println("in service");
		return list;
	}

	public String deleteUser(DeleteUserAction deleteUserAction) {
		UserDao dao = new UserDao();
		Connection con = dao.getconnection();

		return dao.deleteUser(con, deleteUserAction);

	}

	/*public List<CountryBean> getCountryList() {
		UserDao dao = new UserDao();
		Connection con = dao.getconnection();
		List<CountryBean> list = new ArrayList<>();
		try {
			ResultSet rs = dao.getCountries(con);
			while (rs.next()) {
				CountryBean bn = new CountryBean();
				bn.setCountryid(rs.getInt("id"));
				bn.setCountryname(rs.getString("name"));
				list.add(bn);
			}

		} catch (Exception e) {

		}

		return list;
	}*/
}
