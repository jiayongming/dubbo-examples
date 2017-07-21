import java.io.IOException;
import java.util.Map;

import lombok.extern.log4j.Log4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dubbo.service.IDemoService;

@Log4j
public class DubboUseage {
    //<dubbo:reference id="demoService"  interface="com.dubbo.service.IDemoService" protocol="dubbo" check="false" />
    public static void main(String[] args) throws IOException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/config/applicationContext.xml");
        //分组聚合
        IDemoService demoService = (IDemoService) ctx.getBean("demoService");
        for (String string : demoService.groupArray()) {
            log.info(string);
        }
        for (String string : demoService.groupList()) {
            log.info(string);
        }
        for (Map.Entry<String, Object> entry : demoService.groupMap().entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            log.info(key + " " + value);
        }

    }
}
