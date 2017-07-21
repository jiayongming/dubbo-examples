package com.dubbo.service;

import com.dubbo.entity.User;

public class DemoServicemock implements IDemoService {
	
	public User methodInvoke(Integer id, String name) {
		// TODO Auto-generated method stub
		 User user=new User();
		 user.setName("不可用");
		 user.setId(-1);
		return user;
	}
   

}
