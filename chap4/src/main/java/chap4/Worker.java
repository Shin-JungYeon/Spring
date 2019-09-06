package chap4;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value="prototype", proxyMode=ScopedProxyMode.TARGET_CLASS)  // 객체를 일회성으로 주입. 딱 한 번만 사용. 사용할 때마다 새로 만듦.
public class Worker {
	public void work(WorkUnit nuit) {
		System.out.println(this + " : work : " + nuit);  // this의 해시코드값이 다름. -> 다른 객체. @Scope 빼면 같은 객체.
	}
}
