import com.dubbo.entity.User;
import com.dubbo.service.IDemoService;
import lombok.extern.log4j.Log4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

@Log4j
public final class DubboUseage {
	public static void main(String[] args) throws IOException {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("/config/applicationContext.xml");
		
		IDemoService bean = (IDemoService) ctx.getBean("demoService");
		
		
		User user = bean.methodInvoke(1, "jiayongming");
		
		log.info(user.getName()+"  "+user.getId());
	}
}
