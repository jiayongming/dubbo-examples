package com;

import lombok.extern.log4j.Log4j;
import org.I0Itec.zkclient.ZkClient;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.server.auth.DigestAuthenticationProvider;

import java.util.List;

/**
 * zk的ACL控制
 *
 * @author Administrator
 */

@Log4j
public class TestZookeeperACL {

    final static String PATH = "/root";
    final static String PATH_DEL = "/root/child";
    final static String authentication_type = "digest";
    final static String correctAuthentication = "jiayongming:123";
    final static String badAuthentication = "zookeeper:456";
    final static String superAuthentication = "super:jiayongming2013";
    static ZkClient zkClient = null;
    private static final String HOSTPORT = "linux.centos7.com:2181";

    public static void main(String[] args) throws Exception {
        log.info(DigestAuthenticationProvider.generateDigest("super:jiayongming2013"));
        List<ACL> acls = Ids.CREATOR_ALL_ACL;

        zkClient = new ZkClient(HOSTPORT, 50000);
        zkClient.addAuthInfo("digest", correctAuthentication.getBytes());


        zkClient.createPersistent(PATH, "init content", acls);
        log.info("使用授权key：" + correctAuthentication + "创建节点：" + PATH + ", 初始内容是: init content");


        zkClient.createPersistent(PATH_DEL, "待删节点", acls);
        log.info("使用授权key：" + correctAuthentication + "创建节点：" + PATH_DEL + ", 初始内容是: init content");


//        // 获取数据 
//        getDataByNoAuthentication(); 
//      getDataByBadAuthentication(); 
//      getDataByCorrectAuthentication(); 
//      getDataBySuperAuthentication(); 
// 
//      // 更新数据 
//        updateDataByNoAuthentication(); 
//      updateDataByBadAuthentication(); 
        //   updateDataByCorrectAuthentication();
// 
//      // 获取数据 
//      getDataByNoAuthentication(); 
//      getDataByBadAuthentication(); 
//      getDataByCorrectAuthentication(); 
// 
//      //删除数据 
        //  deleteNodeByBadAuthentication();
        //  deleteNodeByNoAuthentication();
        //  deleteNodeByCorrectAuthentication();

        //   deleteNodeByCorrectAuthentication();
        //    deleteParent();
        zkClient.close();
    }

    /**
     * 获取数据：采用错误的密码
     */
    static void getDataByBadAuthentication() {
        String prefix = "[使用错误的授权信息]";
        try {
            log.info(prefix + "获取数据：" + PATH);
            zkClient = new ZkClient(HOSTPORT, 50000);
            zkClient.addAuthInfo(authentication_type, badAuthentication.getBytes());
            log.info(prefix + "成功获取数据：" + zkClient.readData(PATH));
        } catch (Exception e) {
            log.info(prefix + "获取数据失败，原因：" + e.getMessage());
        }
    }

    /**
     * 获取数据：不采用密码
     */
    static void getDataByNoAuthentication() {
        String prefix = "[不使用任何授权信息]";
        try {
            log.info(prefix + "获取数据：" + PATH);
            zkClient = new ZkClient(HOSTPORT, 50000);
            log.info(prefix + "成功获取数据：" + zkClient.readData(PATH));
        } catch (Exception e) {
            log.info(prefix + "获取数据失败，原因：" + e.getMessage());
        }
    }

    /**
     * 采用正确的密码
     */
    static void getDataByCorrectAuthentication() {
        String prefix = "[使用正确的授权信息]";
        try {
            log.info(prefix + "获取数据：" + PATH);
            zkClient = new ZkClient(HOSTPORT, 50000);
            zkClient.addAuthInfo(authentication_type, correctAuthentication.getBytes());
            log.info(prefix + "成功获取数据：" + zkClient.readData(PATH));
        } catch (Exception e) {
            log.info(prefix + "获取数据失败，原因：", e);
        }
    }

    /**
     * 采用超级用户的密码
     */
    static void getDataBySuperAuthentication() {
        String prefix = "[使用超级用户的授权信息]";
        try {
            log.info(prefix + "获取数据：" + PATH);
            zkClient = new ZkClient(HOSTPORT, 50000);
            zkClient.addAuthInfo(authentication_type, superAuthentication.getBytes());
            log.info(prefix + "成功获取数据：" + zkClient.readData(PATH));
        } catch (Exception e) {
            log.error(prefix + "获取数据失败，原因：" + e.getMessage());
        }
    }

    /**
     * 更新数据：不采用密码
     */
    static void updateDataByNoAuthentication() {

        String prefix = "[不使用任何授权信息]";

        log.info(prefix + "更新数据： " + PATH);
        try {
            zkClient = new ZkClient(HOSTPORT, 50000);
            if (zkClient.exists(PATH)) {
                zkClient.writeData(PATH, prefix);
                log.info(prefix + "更新成功");
            }
        } catch (Exception e) {
            log.error(prefix + "更新失败，原因是：" + e.getMessage());
        }
    }

    /**
     * 更新数据：采用错误的密码
     */
    static void updateDataByBadAuthentication() {

        String prefix = "[使用错误的授权信息]";

        log.info(prefix + "更新数据：" + PATH);
        try {
            zkClient = new ZkClient(HOSTPORT, 50000);
            zkClient.addAuthInfo(authentication_type, badAuthentication.getBytes());
            if (zkClient.exists(PATH)) {
                zkClient.writeData(PATH, prefix);
                log.info(prefix + "更新成功");
            }
        } catch (Exception e) {
            log.error(prefix + "更新失败，原因是：" + e.getMessage());
        }
    }

    /**
     * 更新数据：采用正确的密码
     */
    static void updateDataByCorrectAuthentication() {

        String prefix = "[使用正确的授权信息]";

        log.info(prefix + "更新数据：" + PATH);
        try {
            zkClient = new ZkClient(HOSTPORT, 50000);
            zkClient.addAuthInfo(authentication_type, correctAuthentication.getBytes());
            if (zkClient.exists(PATH)) {
                zkClient.writeData(PATH, prefix);
                log.info(prefix + "更新成功");
            }
        } catch (Exception e) {
            log.error(prefix + "更新失败，原因是：", e);
        }
    }


    /**
     * 不使用密码 删除节点
     */
    static void deleteNodeByNoAuthentication() throws Exception {

        String prefix = "[不使用任何授权信息]";

        try {
            log.info(prefix + "删除节点：" + PATH_DEL);
            zkClient = new ZkClient(HOSTPORT, 50000);
            if (zkClient.exists(PATH_DEL)) {
                zkClient.delete(PATH_DEL);
                log.info(prefix + "删除成功");
            }
        } catch (Exception e) {
            log.error(prefix + "删除失败，原因是：" + e.getMessage());
        }
    }


    /**
     * 采用错误的密码删除节点
     */
    static void deleteNodeByBadAuthentication() throws Exception {

        String prefix = "[使用错误的授权信息]";

        try {
            log.info(prefix + "删除节点：" + PATH_DEL);
            zkClient = new ZkClient(HOSTPORT, 50000);
            zkClient.addAuthInfo(authentication_type, badAuthentication.getBytes());
            if (zkClient.exists(PATH_DEL)) {
                zkClient.delete(PATH_DEL);
                log.info(prefix + "删除成功");
            }
        } catch (Exception e) {
            log.error(prefix + "删除失败，原因是：" + e.getMessage());
        }
    }


    /**
     * 使用正确的密码删除节点
     */
    static void deleteNodeByCorrectAuthentication() throws Exception {

        String prefix = "[使用正确的授权信息]";

        try {
            log.info(prefix + "删除节点：" + PATH_DEL);
            zkClient = new ZkClient(HOSTPORT, 50000);
            zkClient.addAuthInfo(authentication_type, correctAuthentication.getBytes());
            if (zkClient.exists(PATH_DEL)) {
                zkClient.delete(PATH_DEL);
                log.info(prefix + "删除成功");
            }
        } catch (Exception e) {
            log.info(prefix + "删除失败，原因是：" + e.getMessage());
        }
    }


    /**
     * 使用正确的密码删除节点
     */
    static void deleteParent() throws Exception {
        try {
            zkClient = new ZkClient(HOSTPORT, 50000);
            zkClient.addAuthInfo(authentication_type, correctAuthentication.getBytes());
            if (zkClient.exists(PATH)) {
                zkClient.delete(PATH);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void process(WatchedEvent event) {
        // TODO Auto-generated method stub 
        log.info("数据变化了");
    }
}