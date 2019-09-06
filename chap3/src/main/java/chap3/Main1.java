package chap3;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Main1 {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");  // ctx : 컨테이너. --.xml을 분석. -> --.xml이 정의하고 있는 객체를 모두 컨테이너에 저장.
		Project pro = ctx.getBean("project", Project.class);  // getBean으로 객체 가져올 때 Project타입으로 가져와.
//		Project pro = (Project) ctx.getBean("project");  // getBean은 Object 타입. 원래는 이런식으로 코딩했었음.
		pro.build();
		
		WriteImpl w = ctx.getBean("write", WriteImpl.class);
		w.write();
	}
}