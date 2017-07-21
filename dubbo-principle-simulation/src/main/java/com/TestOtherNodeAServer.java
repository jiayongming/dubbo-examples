package com;

import lombok.extern.log4j.Log4j;
import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;

import java.io.IOException;

@Log4j
public class TestOtherNodeAServer {

    private ZkClient zkClient;

    /**
     * 初始化zookeeper
     */
    public void initialize() {
        String connectionString = "linux.centos7.com:2181";
        int connectionTimeout = 500000;
        zkClient = new ZkClient(connectionString, connectionTimeout);
        new Thread(new Runnable() {
            public void run() {
                zkClient.subscribeDataChanges("/root1", new IZkDataListener() {
                    public void handleDataDeleted(String dataPath) throws Exception {
                        log.info("配置信息被删除了：" + dataPath);
                    }

                    public void handleDataChange(String dataPath, Object data) throws Exception {
                        log.info("配置信息被修改了:" + dataPath + ",修改的数据是：" + String.valueOf(data));

                    }
                });
            }
        }).start();
    }

    /**
     * 函数入口
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        TestOtherNodeAServer bootStrap = new TestOtherNodeAServer();
        bootStrap.initialize();
        System.in.read();
    }
}
