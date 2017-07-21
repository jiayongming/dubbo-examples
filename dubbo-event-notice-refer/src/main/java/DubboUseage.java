import java.io.IOException;

import lombok.extern.log4j.Log4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dubbo.entity.User;
import com.dubbo.service.IDemoService;

@Log4j
public class DubboUseage {
	public static void main(String[] args) throws IOException {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/config/applicationContext.xml");
		IDemoService demoService = (IDemoService) ctx.getBean("demoService");
		try {
			while(true){
				User user = demoService.methodInvoke(200, "jiayongming");
				log.info(user.getName()+"  "+user.getId());
			}
		} catch (Exception e) {
			log.error("error:",e);
		}
		
	}
}
