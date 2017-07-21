package com.dubbo.service.impl;

import java.util.Date;

import com.dubbo.service.IDemoService;

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
		System.out.println("方法被调用了@"+new Date().toLocaleString()+"@时间");
		return "node-A";
	}

}
