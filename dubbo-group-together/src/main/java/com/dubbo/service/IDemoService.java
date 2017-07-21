package com.dubbo.service;

import java.util.List;
import java.util.Map;

public interface IDemoService {
	/**
	 * 求和
	 * @param x
	 * @param y
	 * @return
	 */
	public int sum(Integer x ,Integer y);
	/**
	 * 计算连个数的乘积
	 * @param x
	 * @param y
	 * @return
	 */
	public int multi(Integer x ,Integer y);
	
	/**
	 * 普通的方法遍历
	 * @return
	 */
	public String methodInvoke();
	/**
	 * 测试分组聚合
	 * @return
	 */
	public String[] groupArray();
	
	/**
	 * 测试分组聚合
	 * @return
	 */
	public List<String> groupList();
	
	/**
	 * 测试分组聚合
	 * @return
	 */
	public Map<String,Object> groupMap();
}
