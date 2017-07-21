package com.dubbo.service;

import com.dubbo.entity.User;

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
	 * 查询用户
	 * @param id
	 * @return
	 */
	public User queryUser(Integer id);
	/**
	 * 
	 * @param user
	 */
	public void saveUser(User user);
}
