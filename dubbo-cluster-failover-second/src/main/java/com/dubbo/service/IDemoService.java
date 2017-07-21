package com.dubbo.service;

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
	 * 普通的方法
	 * @return
	 */
	public String methodInvoke();
}
