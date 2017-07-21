package com.dubbo.service;

public interface INotify {
	void onreturn(Object res, Object... args);
	void onthrow(Throwable ex, Object... args);
}
