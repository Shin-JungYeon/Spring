package xml;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;

public class ArticleCacheAdvice {
	private Map<Integer, Article> cache = new HashMap<Integer, Article>();
	
	public Object cache(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("[ACA] cache before 실행.");
		// joinPoint.getArgs() : 핵심 메서드의 매개변수 목록.
		Integer id = (Integer) joinPoint.getArgs()[0];  // id : 1
		Article article = cache.get(id);
		if(article != null) {
			System.out.println("[ACA] cache 에서 Article[" + id + "] 가져옴.");
			return article;  // Article 객체. -> Main2.java에서 a1 이 받음.
		}
		// 다음 메서드 호출. -> 순서에 따라  핵심이 아닌 aop 메서드가 호출 됨.
		//				   LoggingAdvice.before 메서드 호출. -> 결과적으로는 핵심메서드(return new Article(id))까지 가기때문에 ret는 Article 객체를 받음.
		Object ret = joinPoint.proceed();
		System.out.println("[ACA] cache after 실행.");
		if(ret != null && ret instanceof Article) {
			cache.put(id, (Article)ret);
			System.out.println("[ACA] cache 에 Article[" + id + "] 추가함.");
		}
		return ret;  // Article 객체. -> Main2.java에서 a2 가 받음.
	}
}
