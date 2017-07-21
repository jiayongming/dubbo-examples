import java.io.IOException;

import lombok.extern.log4j.Log4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dubbo.service.IDemoService;


@Log4j
public class DubboUseage {
	public static void main(String[] args) throws IOException {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/config/applicationContext.xml");
		
		IDemoService demoService = (IDemoService) ctx.getBean("demoService");
        //注意区分<dubbo:reference cahe/>和<dubbo:service cahe=""/>区别
		for(int i=0;i<5;i++){
	    	demoService.methodInvoke();
	    }
		
	}
}
