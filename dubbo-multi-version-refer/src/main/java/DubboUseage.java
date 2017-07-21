import java.io.IOException;

import lombok.extern.log4j.Log4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dubbo.service.IDemoService;

@Log4j
public class DubboUseage {
	//<dubbo:reference id="demoService"  interface="com.dubbo.service.IDemoService" protocol="dubbo" check="false" />
	public static void main(String[] args) throws IOException {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("/config/applicationContext.xml");
		//访问新版本
		IDemoService demoService1=(IDemoService) ctx.getBean("demoService1");
	    log.info(demoService1.methodInvoke());
	    //访问old版本
	    IDemoService demoService2=(IDemoService) ctx.getBean("demoService2");
		log.info(demoService2.methodInvoke());
	    
	    //访问随机版本
	    IDemoService demoService3=(IDemoService) ctx.getBean("demoService3");
		log.info(demoService3.methodInvoke());
	    
	}
}
