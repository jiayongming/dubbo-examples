package com.dubbo.service;

public interface IDemoService {
	/**
	 * 求和
	 * @param x
	 * @param y
	 * @return
	 */
	int sum(Integer x ,Integer y);
	/**
	 * 计算连个数的乘积
	 * @param x
	 * @param y
	 * @return
	 */
	int multi(Integer x ,Integer y);
	
	/**
	 * 普通的方法遍历
	 * @return
	 */
	String methodInvoke();
	
}
