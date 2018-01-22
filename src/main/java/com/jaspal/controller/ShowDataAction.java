package com.jaspal.controller;

import java.util.ArrayList;
import java.util.List;

import com.jaspal.bean.UserDetailBean;
import com.jaspal.service.UserCRUDService;
import com.opensymphony.xwork2.Action;

public class ShowDataAction implements Action{
	
	private List<UserDetailBean> bean;
	public List<UserDetailBean> getBean() {
		return bean;
	}
	public void setBean(List<UserDetailBean> bean) {
		this.bean = bean;
	}
	@Override
	public String execute() throws Exception {
		
		UserCRUDService u=new UserCRUDService();
		bean=new ArrayList<UserDetailBean>();
		bean=u.getUsers();
		
		
		System.out.println("in action");
		return "success";
	}

}
