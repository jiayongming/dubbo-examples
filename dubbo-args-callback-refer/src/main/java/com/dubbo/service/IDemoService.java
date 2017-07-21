package com.dubbo.service;

import com.dubbo.entity.Computer;

public interface IDemoService {
	/**
	 * 
	 * @param value
	 * @param callbackListener
	 * @return
	 */
	Computer methodInvoke(String value, CallbackListener callbackListener);
}
