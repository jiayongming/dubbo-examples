package com.dubbo.service;

import com.dubbo.entity.User;

public interface IDemoService {

	Object sum(int x,int y);
	Object saveUser(User user);
}
