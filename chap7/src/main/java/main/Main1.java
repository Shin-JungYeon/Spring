package main;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import spring.WriteImpl;

public class Main1 {
	public static void main(String[] args) {
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:aop.xml");
		WriteImpl been = ctx.getBean("write", WriteImpl.class);
		been.write();  // 단순 메서드 호출. 핵심 기능.  -> pointcut 대상이 되는 메서드. -> logging 메서드가 먼저 시작.
	}
}
