package com.dubbo.service.impl;

import com.dubbo.entity.Computer;
import com.dubbo.entity.User;
import com.dubbo.service.IDemoService;
import lombok.extern.log4j.Log4j;

import java.util.Date;

@Log4j
public class DemoService_v1 implements IDemoService {

	public int sum(Integer x, Integer y) {
		// TODO Auto-generated method stub
		return x+y;
	}

	public int multi(Integer x, Integer y) {
		// TODO Auto-generated method stub
		return x*y;
	}

	public String methodInvoke() {
		// TODO Auto-generated method stub
		log.info("方法被调用了@"+new Date().toLocaleString()+"@时间");
		return "node-A";
	}

	public User queryUser(Integer id) {
		// TODO Auto-generated method stub
		User user=new User();
		user.setId(id);
		user.setName("张三"+id);
		Computer computer=new Computer();
		computer.setId(id);
		computer.setName("张三的电脑");
		user.setComputer(computer);
		return user;
	}

	public void saveUser(User user) {
		// TODO Auto-generated method stub
		log.info("用户保存了");
		log.info(user.getName());
		log.info(user.getComputer().getName());
	}
	
}
