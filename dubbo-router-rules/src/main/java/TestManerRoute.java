import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.ExtensionLoader;
import com.alibaba.dubbo.registry.Registry;
import com.alibaba.dubbo.registry.RegistryFactory;


public class TestManerRoute {
	public static void main(String[] args) {
		testCreateForbideIP();
	}
	/**
	 * 禁止指定的ip访问自己的服务
	 */
	public static void testCreateForbideIP(){
		RegistryFactory registryFactory = 
				ExtensionLoader.getExtensionLoader(RegistryFactory.class).getAdaptiveExtension();
		
		Registry registry = registryFactory.getRegistry(URL.valueOf("zookeeper://127.0.0.1:2181"));
		String rules="192.168.184.1=>";
		String condition="condition://0.0.0.0/com.dubbo.service.IDemoServiceA?category=routers&dynamic=false&rule=" + URL.encode(rules) ;
		URL url = URL.valueOf(condition);
		//registry.register(url);
		registry.unregister(url);//取消静止
	}
	
}
