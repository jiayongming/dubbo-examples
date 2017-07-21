import com.dubbo.entity.User;
import com.dubbo.service.IDemoService;
import lombok.extern.log4j.Log4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

@Log4j
public class DubboUseage {
	public static void main(String[] args) throws IOException {
		
	   ApplicationContext ctx=new ClassPathXmlApplicationContext("/config/applicationContext.xml");

	   IDemoService demoService=(IDemoService) ctx.getBean("demoService");
	   Object date= demoService.sum(1, 3);
	   log.info(date.toString());
	   
	   User user = new User();
	   user.setId(1);
	   user.setName("张三");
	   Object obj= demoService.saveUser(user);
		log.info(obj.toString());
	   
	   
	}
}
