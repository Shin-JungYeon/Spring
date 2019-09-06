package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import xml.Article;
import xml.Member;
import xml.MemberService;
import xml.ReadArticleService;
import xml.UpdateInfo;

public class Main2 {
	public static void main(String[] args) {
		String[] config = {"di.xml", "aop2.xml"};
		ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
		// readArticleService : ReadArticleService는 인터페이스이기 때문에 이 인터페이스를 구현한 ReadArticleServiceImpl 객체로 생성. -> ReadArticleService 로 형변환 됨.
		ReadArticleService service = ctx.getBean("readArticleService", ReadArticleService.class);
		try {
			/*
			 * cacheAdvice 추가 전 : 해시값이 다르므로 다른 객체. 컨테이너객체가 아님. ReadArticleServiceImpl에서 new 로 만든 Article 객체를 리턴 받은 것.
			 * 					  id값으로 같은 값을 넣어도 다른 객체로 생성.
			 * 						a1 : new Article(1)
			 * 						a2 : new Article(2)
			 */
			/*
			 * cacheAdvice 추가 : cache(order=2) -> logging(order=3) -> 핵심메서드 -> logging(order=3) -> cache(order=2)
			 * 					 예외 발생 시 정상 실행을 할 수 없으므로 around(cache after)로는 가지 않음.
			 * 						a1 : ret
			 * 						a2 : article -> a1을 실행했을 때 Map 객체에 저장되어 있던 Article 객체 가져옴. -> a1과 a2 객체가 같은 객체.
			 */
			
			Article a1 = service.getArticleAndReadCnt(1);
			Article a2 = service.getArticleAndReadCnt(1);
			System.out.println("[main] a1==a2 : " + (a1==a2));
			service.getArticleAndReadCnt(0);  // 예외가 발생하므로 객체가 생성될 수 없음.
		} catch(Exception e) {
			System.out.println("[main] " + e.getMessage());  // AOP를 통해서 메인까지 예외 객체 전달. afterThrowing에서 발생한 예외 객체와 같은 예외 객체임
		}
		
		/*
		 * traceAdvice 추가 : logging(order=2) -> 핵심메서드 -> logging(order=2) -> trace(order=1, after-returning)  order가 1이라고 해서 무조건 가장 먼저 실행되는 것은 아님. advice에 따라 달라질 수 있음.
		 */
		System.out.println("\nUpdateMemberInfoTrace Aspect 연습");
		MemberService msvc = ctx.getBean("memberService", MemberService.class);  // xml 패키지에 속한 클래스. loggingAspect 메서드의 pointcut 대상임. -> [LA] 먼저 실행.
		msvc.regist(new Member());
		msvc.update("hong", new UpdateInfo());  // 얘만 TA의 대상임.
		msvc.delete("hong2", "test");
		
		MemberService2 msvc2 = ctx.getBean("memberService2", MemberService2.class);
		msvc2.test("test", new UpdateInfo());
	}
}