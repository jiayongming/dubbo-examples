package com.dubbo.service.impl;

import com.dubbo.entity.User;
import com.dubbo.service.IDemoService;
import lombok.extern.log4j.Log4j;

@Log4j
public class DemoService_v1 implements IDemoService {

	public User methodInvoke(Integer id, String name) {
		log.info("id:"+id+","+name);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			log.error("error:",e);
		}
		return null;
		
	}
   
	

}
