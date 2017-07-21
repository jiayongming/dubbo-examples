import com.dubbo.service.IDemoService;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;
import java.io.IOException;


@Slf4j
public class DubboUseage {

	@Resource
	private IDemoService demoService ;

	public static void main(String[] args) throws IOException {
		com.alibaba.dubbo.container.Main.main(args);

/*
		Computer res = demoService.methodInvoke("zhangsan", new CallbackListener() {
				public User callBack(User v) {
					Computer computer=new Computer();
					computer.setName("客户端设置的Computer");
					v.setComputer(computer);
					return v;
				}
			
		});
*/
		/*log.info(res.getName()+" "+res.getId());*/
		
	}
}
