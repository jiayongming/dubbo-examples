package com.dubbo.zookeeper;

import lombok.extern.log4j.Log4j;
import org.I0Itec.zkclient.ZkClient;

@Log4j
public class ServiceBProvider {
    //服务名仍然为 A,这样是为了，一个服务名有两个台机器在服务，才能做负载均衡.
    private String serviceName = "service-A";

    //向zookeeper注册服务
    public void init() throws Exception {
        String serverList = "linux.centos7.com:2181";
        String PATH = "/configcenter";//根节点路径

        ZkClient zkClient = new ZkClient(serverList);
        boolean rootExists = zkClient.exists(PATH);
        if (!rootExists) {
            zkClient.createPersistent(PATH);
        }

        boolean serviceExists = zkClient.exists(PATH + "/" + serviceName);
        if (!serviceExists) {
            zkClient.createPersistent(PATH + "/" + serviceName);//創建服務節點
        }

        //注册当前服务
        String ip = "1ocalhost:20880";
        //创建当前服务器节点
        if (!zkClient.exists(PATH + "/" + serviceName + "/" + ip)){
            zkClient.createEphemeral(PATH + "/" + serviceName + "/" + ip);
        }
        log.info("提供的服务节点名称为：" + PATH + "/" + serviceName + "/" + ip);
    }

    public void deleteSelf() {
        String serverList = "linux.centos7.com:2181";
        String PATH = "/configcenter";//根节点路径
        ZkClient zkClient = new ZkClient(serverList);
        boolean rootExists = zkClient.exists(PATH);
        if (!rootExists) {
            zkClient.createPersistent(PATH);
        }
        //判断是否存在，不存在则创建服务节点
        boolean serviceExists = zkClient.exists(PATH + "/" + serviceName);
        if (!serviceExists) {
            zkClient.createPersistent(PATH + "/" + serviceName);
        }
        String ip = "linux.centos7.com:20880";
        //創建當前服務器節點
        if (zkClient.exists(PATH + "/" + serviceName + "/" + ip)) {
            zkClient.delete(PATH + "/" + serviceName + "/" + ip);
        }
    }

    //提供服务
    public void provide() {

    }

    public static void main(String[] args) throws Exception {
        ServiceBProvider service = new ServiceBProvider();
        service.init();
        System.in.read();
        service.deleteSelf();
    }

}