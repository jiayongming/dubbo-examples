import org.I0Itec.zkclient.ZkClient;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.server.auth.DigestAuthenticationProvider;

import java.security.NoSuchAlgorithmException;


public class TestNodeACL {
    ZkClient zkClient = new ZkClient("192.168.1.128:2181");

    /**
     * digest:用户名:密码:权限(crwa)
     *
     * @throws NoSuchAlgorithmException
     */
    public void testNodeACL() throws NoSuchAlgorithmException {
        String generateDigest = DigestAuthenticationProvider.generateDigest("jiangzz:123");
        System.out.println(generateDigest);
        zkClient.addAuthInfo("digest", generateDigest.getBytes());
        zkClient.createPersistent("/root", "你好", Ids.CREATOR_ALL_ACL);
    }

    /**
     * 通过ACL访问
     *
     * @throws NoSuchAlgorithmException
     */
    public void testGetNodeACL() throws NoSuchAlgorithmException {
        String generateDigest = DigestAuthenticationProvider.generateDigest("jiangzz:123");
        zkClient.addAuthInfo("digest", generateDigest.getBytes());
        /*Object readData = zkClient.readData("/root");
        System.out.println(readData);*/
        zkClient.delete("/root");
    }

}
