package com.dubbo.service;

import com.dubbo.entity.Computer;

public interface IDemoService {

	Computer methodInvoke(String value,CallbackListener callbackListener);
}
