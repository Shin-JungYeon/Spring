package chap2;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Main1 {
	public static void main(String[] args) {
		/*
		 * 컨테이너 : 객체들의 집합소. 이 것 자체도 객체이고 그 아래에 여러 개의 객체 저장 가능.
		 * BeanFactory : 가장 간단한 컨테이너. 컨테이너의 최상단 인터페이스.
		 * 				 DI만 처리가 가능한 컨테이너. AOP 기능은 사용 불가.
		 * 				 4버전 이후 deprecated 됨. 가능한 사용하지 말기. 
		 * ApplicationContext : BeanFactory의 하위 인터페이스이므로 DI 처리 가능.
		 * 						AOP 기능도 사용 가능.
		 * webApplicationContext : ApplicationContext의 하위 인터페이스. DI 처리 가능, AOP 사용 가능.
		 * 						   Web 환경에서 사용되는 컨테이너.
		 * 
		 * Main1.java -> applicationContext.xml -> Greeter.java -> Main1.java
		 */
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");  // xml을 읽어서 나의 컨테이너에 저장.
		Greeter g = ctx.getBean("greeter", Greeter.class);
		System.out.println(g.greet("스프링"));
		Greeter g2 = ctx.getBean("greeter", Greeter.class);  // 이미 만들어져 있는 객체(g)를 가져와서 사용하기 때문에 g2는 g와 같은 객체.
		System.out.println(g == g2);  // true
	}
}