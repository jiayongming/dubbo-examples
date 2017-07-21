package com;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.I0Itec.zkclient.ZkClient;

import java.io.IOException;
import java.util.UUID;

@Log4j
public class TestConfigServer {

    @Getter
    @Setter
    private ZkClient zkClient;

    /**
     * 函数入口
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        TestConfigServer bootStrap = new TestConfigServer();
        bootStrap.initialize();
        log.info("配置服务服务启动");
        System.in.read();

    }

    /**
     * 初始化zookeeper
     */
    public void initialize() {
        String connectionString = "linux.centos7.com:2181";
        int connectionTimeout = 50000;

        zkClient = new ZkClient(connectionString, connectionTimeout);

        if (!zkClient.exists("/root1")) {
            zkClient.createEphemeral("/root1", new Long(System.currentTimeMillis()));
        }

        new Thread(new RootNodeChangeThread()).start();
    }

    /**
     * @author Administrator
     *         每隔5秒执行修改一次配置
     */
    private class RootNodeChangeThread implements Runnable {

        public void run() {

            while (true) {

                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    log.error("RootNodeChangeThread error:",e);
                }

                String uuidStr = "配置：" + UUID.randomUUID().toString();

                log.info("你可以理解为集群配置文件发生变化了" + uuidStr);

                zkClient.writeData("/root1", uuidStr);

            }

        }

    }
}
