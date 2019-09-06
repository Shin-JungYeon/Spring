package annotation;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import xml.Article;

@Component
@Aspect
@Order(2)
public class ArticleCacheAspect {
	private Map<Integer, Article> cache = new HashMap<>();
	@Around("execution(public * *..ReadArticleService.*(..))")
	public Object cache(ProceedingJoinPoint joinPoint) throws Throwable {
		Integer id = (Integer) joinPoint.getArgs()[0];
		Article article = cache.get(id);
		if(article != null) {
			System.out.println("[ACA] cache 에서 Article[" + id + "] 가져옴.");
			return article;
		}
		Object ret = joinPoint.proceed();
		if(ret != null  && ret instanceof Article) {
			cache.put(id, (Article)ret);
			System.out.println("[ACA] cache 에 Article[" + id + "] 추가함.");
		}
		return ret;
	}
}
