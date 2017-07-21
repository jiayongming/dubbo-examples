package com.dubbo.service.impl;

import com.dubbo.service.INotify;
import lombok.extern.log4j.Log4j;

@Log4j
public class Notify implements INotify {

	public void onreturn(Object res, Object... args) {
		log.info("返回值："+res);
		for (Object object : args) {
			log.info("参数："+object);
		}
	}

	public void onthrow(Throwable ex, Object... args) {
		log.info("异常："+ex.getMessage());
		for (Object object : args) {
			log.info("异常参数："+object);
		}
	}


}
