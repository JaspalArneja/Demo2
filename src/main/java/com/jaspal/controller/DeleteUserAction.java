package com.jaspal.controller;

import com.jaspal.service.UserCRUDService;
import com.opensymphony.xwork2.Action;

public class DeleteUserAction implements Action
{
	private String msg;
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	@Override
	public String execute() throws Exception {
		UserCRUDService user=new UserCRUDService();
		msg=user.deleteUser(this);
		return "success";
	}

}
