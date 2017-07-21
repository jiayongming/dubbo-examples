package com;

import java.io.IOException;
import java.util.List;

import org.I0Itec.zkclient.IZkChildListener;
import org.I0Itec.zkclient.ZkClient;
import org.apache.zookeeper.CreateMode;

import sun.misc.Cleaner;

public class TestWatcher {
	public static void main(String[] args) throws IOException {
		ZkClient client=new ZkClient("192.168.0.103:2181");
		
		client.subscribeChildChanges("/parent",new IZkChildListener(){
	            //@Override
	            public void handleChildChange(String parentPath, List<String> currentChilds)throws Exception{
	                System.out.println(parentPath+" 变化了");
	                
	            	System.out.println(currentChilds);
	            }      
	        });
		System.in.read();
		client.close();
	}
}
