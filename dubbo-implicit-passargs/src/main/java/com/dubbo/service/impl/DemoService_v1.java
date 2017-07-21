package com.dubbo.service.impl;

import java.util.Map;

import com.alibaba.dubbo.rpc.RpcContext;
import com.dubbo.service.IDemoService;
import lombok.extern.log4j.Log4j;

@Log4j
public class DemoService_v1 implements IDemoService {

	public int sum(Integer x, Integer y) {
		// TODO Auto-generated method stub
		return x+y;
	}

	public int multi(Integer x, Integer y) {
		// TODO Auto-generated method stub
		return x*y;
	}

	public String methodInvoke() {
		Map<String, String> attachments = RpcContext.getContext().getAttachments();
		String attch= attachments.get("attch");
		log.info("附件信息："+attch);
		return "node-A";
	}

}
