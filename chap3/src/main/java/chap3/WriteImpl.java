package chap3;

public class WriteImpl {
	private ArticleDao dao;
	
	public WriteImpl(ArticleDao dao) {  // setter가 아닌 생성자를 통해서도 객체에 주입될 수 있음.
		this.dao = dao;
	}
	
	public void write() {
		System.out.println("WriteImpo.write() 메서드 호출");
		dao.insert();
	}
}
