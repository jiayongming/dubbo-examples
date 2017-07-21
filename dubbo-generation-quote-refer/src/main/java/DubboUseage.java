import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import lombok.extern.log4j.Log4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.expression.spel.ast.Identifier;

import com.alibaba.dubbo.rpc.cluster.support.FailoverCluster;
import com.alibaba.dubbo.rpc.service.GenericService;


@Log4j
public class DubboUseage {
	public static void main(String[] args) throws IOException {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("/config/applicationContext.xml");
		
		GenericService genericService=(GenericService) ctx.getBean("demoService");
        
		Object result = genericService.$invoke("sum", 
					new String[] { "java.lang.Integer","java.lang.Integer" }, 
					new Object[] { 1,5 });
		
		log.info(result);

		Object resultUser = genericService.$invoke("queryUser", 
				new String[] { "java.lang.Integer"}, 
				new Object[] { 1 });
		HashMap<String, Object> userMap=(HashMap<String, Object>) resultUser;
		for(Map.Entry<String, Object> entry1: userMap.entrySet()){
			if(entry1.getValue() instanceof HashMap){
				HashMap<String, Object> computerMap=(HashMap<String, Object>) entry1.getValue();
				log.info(entry1.getKey());
				for(Map.Entry<String, Object> entry: computerMap.entrySet()){
					log.info("\t"+entry.getValue());
				}
			}else{
				log.info(entry1.getKey()+" "+entry1.getValue());
			}
			
		}
		
		//演示用户数据的封装
		Map<String, Object> user = new HashMap<String, Object>(); 
		user.put("name", "张三"); 
		HashMap<String, String> value = new HashMap<String, String>();
		value.put("name", "张三的电脑");
		user.put("computer", value);
		
		genericService.$invoke("saveUser", new String[]{"com.dubbo.entity.User"},
				new Object[]{user});
	}
}
