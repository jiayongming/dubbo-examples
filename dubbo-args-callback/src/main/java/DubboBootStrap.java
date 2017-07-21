import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class DubboBootStrap {

	public static void main(String[] args) throws IOException {
		com.alibaba.dubbo.container.Main.main(args);
	}
}
