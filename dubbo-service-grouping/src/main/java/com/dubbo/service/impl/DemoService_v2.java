package com.dubbo.service.impl;

import com.dubbo.service.IDemoService;

public class DemoService_v2 implements IDemoService {

	public int sum(Integer x, Integer y) {
		return x+y;
	}

	public int multi(Integer x, Integer y) {
		return x*y;
	}

	public String methodInvoke() {
		return "old";
	}

}
