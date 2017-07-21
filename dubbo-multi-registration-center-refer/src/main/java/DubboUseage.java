import java.io.IOException;

import lombok.extern.log4j.Log4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dubbo.service.IDemoService;

@Log4j
public class DubboUseage {
	//<dubbo:reference id="demoService"  interface="com.baizhi.service.IDemoService" protocol="dubbo" check="false" />
	public static void main(String[] args) throws IOException {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("/config/applicationContext.xml");
		//访问中国的注册中心
		IDemoService demoService1=(IDemoService) ctx.getBean("demoService1");
	    log.info(demoService1.methodInvoke());
	    //访问美国的注册中心
	    IDemoService demoService2=(IDemoService) ctx.getBean("demoService2");
		log.info(demoService2.methodInvoke());
	    
	}
}
