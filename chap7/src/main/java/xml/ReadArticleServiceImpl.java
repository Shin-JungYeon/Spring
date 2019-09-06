package xml;

public class ReadArticleServiceImpl implements ReadArticleService {
	@Override
	public Article getArticleAndReadCnt(int id) throws Exception {  // pointcut의 대상. aop2.xml의 AOP 설정에 의해 cache 메서드 먼저 호출. 다음 before 메서드 호출 됨.
		System.out.println("getArticleAndReadCnt(" + id + ") 호출");
		if(id == 0) {
			throw new Exception("id는 0이 안 됨.");
		}
		return new Article(id);  // 정상 종료이므로 afterReturning에 Article 객체 전달.
	}
}
