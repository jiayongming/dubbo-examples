package com.dubbo.zookeeper;

import java.io.IOException;

import lombok.extern.log4j.Log4j;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;

@Log4j
public class ZkNodeOperation {

    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        ZooKeeper zk = new ZooKeeper("linux.centos7.com:2181", 3000,
                new Watcher() {
                    // 监控所有被触发的事件
                    public void process(WatchedEvent event) {
                        System.out.println("已经触发了" + event.getType() + "事件！");
                    }
                });
        // 创建一个目录节点
        zk.create("/dubbo-dir", "dubbo-data".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        // 创建一个子目录节点
        zk.create("/dubbo-dir/childone", "childone".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        log.info(new String(zk.getData("/dubbo-dir", false, null)));

        // 取出子目录节点列表
        log.info(zk.getChildren("/dubbo-dir", true));

        // 修改子目录节点数据
        zk.setData("/dubbo-dir/childone", "modifyDataOne".getBytes(), -1);
        log.info("目录节点状态：[" + zk.exists("/dubbo-dir", true) + "]");

        // 创建另外一个子目录节点
        zk.create("/dubbo-dir/childtwo", "childtwo".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);

        log.info(new String(zk.getData("/dubbo-dir/childtwo", true, null)));

        // 删除子目录节点
        zk.delete("/dubbo-dir/childtwo", -1);
        zk.delete("/dubbo-dir/childone", -1);
        // 删除父目录节点
        zk.delete("/dubbo-dir", -1);

        // 关闭zk连接
        zk.close();
    }

}