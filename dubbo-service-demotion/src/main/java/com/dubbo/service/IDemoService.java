package com.dubbo.service;

import com.dubbo.entity.User;

public interface IDemoService {

	public User methodInvoke(Integer id,String name);
}
