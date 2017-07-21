package com.dubbo.service.impl;

import com.dubbo.entity.Computer;
import com.dubbo.entity.User;
import com.dubbo.service.CallbackListener;
import com.dubbo.service.IDemoService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DemoService_v1 implements IDemoService {

	public Computer methodInvoke(String value, CallbackListener callbackListener) {
		// TODO Auto-generated method stub
		User user=new User();
		user.setName(value);
		log.info("-----------");
		User callUser = callbackListener.callBack(user);
		callUser.getComputer().setId(1);
		log.info(callUser.getComputer().getName());

		log.info("{}" ,callUser.getComputer());
		
		return callUser.getComputer();
	}

}
