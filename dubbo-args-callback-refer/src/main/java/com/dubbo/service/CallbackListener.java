package com.dubbo.service;

import java.io.Serializable;

import com.dubbo.entity.User;

public interface CallbackListener extends Serializable{
	User callBack(User v);
}
