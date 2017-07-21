import java.io.IOException;

import lombok.extern.log4j.Log4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.dubbo.rpc.RpcContext;
import com.dubbo.service.IDemoServiceA;
import com.dubbo.service.IDemoServiceB;

@Log4j
public class DubboUseage {
	public static void main(String[] args) throws IOException {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/config/applicationContext.xml");
		
        IDemoServiceA demoServiceA = (IDemoServiceA) ctx.getBean("demoServiceA");
        int sum = demoServiceA.sum(1, 2);
        log.info(sum);
        
        String localAddressString = RpcContext.getContext().getLocalAddress().getHostName();
        log.info(localAddressString);
        IDemoServiceB demoServiceB=(IDemoServiceB) ctx.getBean("demoServiceB");
        int minus = demoServiceB.minus(1, 2);
        log.info(minus);
	}
	
}
