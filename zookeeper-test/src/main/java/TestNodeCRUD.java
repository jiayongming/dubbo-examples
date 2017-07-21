import org.I0Itec.zkclient.ZkClient;
import org.apache.zookeeper.CreateMode;

import java.util.Date;
import java.util.List;

/**
 * zookeeper的节点操作
 * @author Administrator
 *
 */
public class TestNodeCRUD {
	private static ZkClient zkClient=new ZkClient("192.168.1.128:2181");
	/**
	 * 节点创建 
	 * 节点类型：PERSISTENT(_SEQUENTIAL) EPHEMERAL(_SEQUENTIAL)
	 * 等价的写法： zkClient.createPersistent(path)
	 *          zkClient.createPersistentSequential(path, data)
	 * 			zkClient.createEphemeral(path)
	 *          zkClient.createEphemeralSequential(path, data)
	 */
	public void testCreateNode(){
		String node="/zpark";
	    zkClient.create(node, "你好吗", CreateMode.PERSISTENT);
	}
	/**
	 * 节点的删除
	 */
	public void testDeletNode(){
		String node="/zpark";
		boolean deleteState = zkClient.delete(node);
		System.out.println("节点删除状态："+deleteState);
	}
	/**
	 * 节点是否存在
	 */
	public void testNodeExits(){
		String node="/zpark";
		boolean deleteState = zkClient.exists(node);
		System.out.println("节点是否存在："+deleteState);
	}
	/**
	 * 节点数据获取
	 */
	public void testGetNodeData(){
		String node="/zpark";
		Object nodeData = zkClient.readData(node);
		System.out.println("node Data:"+nodeData.getClass());
	}
	/**
	 * 节点数据修改
	 */
	public void testModifyNodeData(){
		String node="/root";
		zkClient.writeData(node, new Date());
	}
	/**
	 * 级联创建父子节点
	 */
	public void testCreateMany(){
		String path1="/zpark/student";
		String path2="/zpark/teacher";
		zkClient.createPersistent(path1, true);//级联创建父子节点
		zkClient.createPersistent(path2, true);
	}
	/**
	 * 获取所有孩子节点
	 */
	public void testGetChilds(){
		String node="/zpark";
		List<String> path = zkClient.getChildren(node);
		System.out.println(path);
	}
}
