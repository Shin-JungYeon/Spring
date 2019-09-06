package chap2;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Main2 {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");  // xml을 읽어서 나의 컨테이너에 저장.
		Message m = ctx.getBean("message", Message.class);
		m.sayHello("홍길동");
	}
}
