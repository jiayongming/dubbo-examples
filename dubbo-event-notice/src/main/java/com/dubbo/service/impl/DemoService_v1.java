package com.dubbo.service.impl;

import com.dubbo.entity.User;
import com.dubbo.service.IDemoService;
import lombok.Data;
import lombok.extern.log4j.Log4j;

@Data
@Log4j
public class DemoService_v1 implements IDemoService {

	public User methodInvoke(Integer id,String name) {
		User user = new User();
	    user.setId(id);
		user.setName(name);
		log.info(user);
		if(id<0) {
			throw new RuntimeException("用户参数不合法");
		}
		return user;
	}

}
