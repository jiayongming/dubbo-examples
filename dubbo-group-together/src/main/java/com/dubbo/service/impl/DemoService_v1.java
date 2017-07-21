package com.dubbo.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		return "new";
	}

	public String[] groupArray() {
		// TODO Auto-generated method stub
		return new String[]{"A","B"};
	}

	public List<String> groupList() {
		// TODO Auto-generated method stub
		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add("张三");
		arrayList.add("李四");
		return arrayList;
	}

	public Map<String, Object> groupMap() {
		// TODO Auto-generated method stub
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("user01", "张三");
		map.put("user02", "李四");
		return map;
	}
 
}
