package com.dubbo.service;

import com.dubbo.entity.User;

public interface IDemoService {

	User methodInvoke(Integer id, String value);
}
