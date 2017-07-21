import java.io.IOException;

import lombok.extern.log4j.Log4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dubbo.service.IDemoService;


@Log4j
public class DubboUseage {
	//<dubbo:reference id="demoService"  interface="com.dubbo.service.IDemoService" protocol="dubbo" check="false" />
	public static void main(String[] args) throws IOException {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/config/applicationContext.xml");
		
		IDemoService demoService = (IDemoService) ctx.getBean("demoService");
		//打印代理类型 底层dubbo使用NIO的RCP做远程调度
		log.info("打印引用类型:"+demoService.getClass());
		
	}
}
