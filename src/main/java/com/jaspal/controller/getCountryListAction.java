package com.jaspal.controller;

//import com.jaspal.service.UserCRUDService;
import com.opensymphony.xwork2.Action;

public class getCountryListAction implements Action
{

	@Override
	public String execute() throws Exception
	{
		//UserCRUDService u=new UserCRUDService();
		//u.getCountryList();
		return "success";
	}
	
}
