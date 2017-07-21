package com.dubbo.service;

import java.util.Date;

import com.alibaba.dubbo.rpc.service.GenericException;
import com.alibaba.dubbo.rpc.service.GenericService;
import lombok.extern.log4j.Log4j;

@Log4j
public class IDemoService implements GenericService{

	public Object $invoke(String method, String[] parameterTypes, Object[] args)
			throws GenericException {
		// TODO Auto-generated method stub
		log.info("方法:"+method);
		log.info("parameterTypes:");
		for (Object type : parameterTypes) {
			log.info("\t"+type);
		}
		log.info("args:");
		for (Object arg : args) {
			log.info("\t"+arg);
		}

		log.info("args:"+args);
		return new Date();
	}

}
