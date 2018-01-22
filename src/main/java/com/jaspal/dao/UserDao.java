package com.jaspal.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.jaspal.controller.DeleteUserAction;
import com.jaspal.controller.UpdateUserDetailsAction;
import com.jaspal.controller.UserRegisterAction;

public class UserDao
{
	public Connection getconnection()
	{
		Connection con=null;
		try{  
		    Class.forName("com.mysql.jdbc.Driver");  
		        con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/testdb","root","jaspal");  
		  			    }catch(Exception e)
		    {System.out.println(e);}
		return con;
	}
	public String userRegister(Connection con, UserRegisterAction bn)
	{
		String msg="";
		int key1=0,key2=0;
		try{  
			  
			PreparedStatement ps=con.prepareStatement("insert into userss(uid,name,email,phone,age,password) values(null,?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, bn.getName());
			ps.setString(2, bn.getEmail());
			ps.setString(3, bn.getPhone());
			ps.setString(4, bn.getAge());
			ps.setString(5, bn.getPassword());
			int i=ps.executeUpdate(); 
			ResultSet rs = ps.getGeneratedKeys();
			 
			
			if (rs.next()) {
			    key1 = (int) rs.getLong(1);
			}
			              
			if(i!=0)
			{
				ps=con.prepareStatement("insert into address(aid,country,state,city,street_address) values(null,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
				ps.setString(1, bn.getCountry());
				ps.setString(2, bn.getState());
				ps.setString(3, bn.getCity());
				ps.setString(4, bn.getStreet_address());
				int j=ps.executeUpdate();
				rs = ps.getGeneratedKeys();

				if (rs.next()) {
				    key2 = (int) rs.getLong(1);
				}
				if(j!=0)
				{
				ps=con.prepareStatement("insert into userss_address_mapping(id,uid,aid) values(null,?,?)");
				ps.setInt(1,key1);	
				ps.setInt(2,key2);	
				
				int k=ps.executeUpdate();
					if(k!=0)
						msg="Registration has been completed Successfully!!!";
				}
				
			}
			else
			{
				msg="Data insertion Unsuccessfull!!!";
			}
			
			}catch(Exception e){e.printStackTrace();}  
			         
			
			return msg;
			
	}
	public ResultSet getAllUsers(Connection con)
	{
		PreparedStatement ps=null;
		ResultSet rs=null;
		 try
		 {
			 ps=con.prepareStatement("select temp1.id,temp1.name,email,phone,age,password,countries.name as country,states.name as state,cities.name as city,temp1.country as countryid,temp1.state as stateid,temp1.city as cityid,street_address from (select id,name,email,phone,age,password,country,state,city,street_address from userss,userss_address_mapping,address where userss.uid=userss_address_mapping.uid and address.aid=userss_address_mapping.aid) as temp1,countries,states,cities where temp1.country=countries.id and temp1.state=states.id and temp1.city=cities.id");	 
			 rs=ps.executeQuery();
			 
		 }catch(Exception e)
		 {
			 System.out.println("exception in dao");
		 }
		 
		 //System.out.println("in dao");
		return rs;
	}
	public String userUpdate(Connection con, UpdateUserDetailsAction user) 
	{
		String msg="";
		int uid=0,aid=0;
		try
		{
			PreparedStatement ps=con.prepareStatement("select uid,aid from userss_address_mapping where id=?");
			ps.setInt(1, user.getId());
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				uid=rs.getInt("uid");
				aid=rs.getInt("aid");
			}
			ps=con.prepareStatement("update userss set name=?,email=?,phone=?,age=?,password=? where uid=?");
			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPhone());
			ps.setString(4, user.getAge());
			ps.setString(5, user.getPassword());
			ps.setInt(6, uid);
			int i=ps.executeUpdate();
			
			ps=con.prepareStatement("update address set country=?,state=?,city=?,street_address=? where aid=?");
			ps.setString(1, user.getCountry());
			ps.setString(2, user.getState());
			ps.setString(3, user.getCity());
			ps.setString(4, user.getStreet_address());
			ps.setInt(5, aid);
			int j=ps.executeUpdate();
			if(i!=0 && j!=0)
			{
				msg="Updated Successfully!!! ";
			}
			else
			{
				msg="Update Operation Failed!!!";
			}
		}catch(Exception e)
		{
			
		}
		return msg;
	}
	public String deleteUser(Connection con, DeleteUserAction deleteUserAction) {
		String msg="";
		try
		{
			PreparedStatement ps=con.prepareStatement("delete from userss_address_mapping where id=?");
			ps.setInt(1, deleteUserAction.getId());
			int i=ps.executeUpdate();
			if(i!=0)
				msg="Deleted Successfully!!!";
			else
				msg="Delete Operation Unsuccessful!!!";
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return msg;
	}
	/*public ResultSet getCountries(Connection con) 
	{
		try{
			PreparedStatement ps=con.prepareStatement("select id,name from countries");
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}*/
}
