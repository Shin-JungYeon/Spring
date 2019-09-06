package spring;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("listPrinter")  // 이름 지정.
public class MemberListPrinter {
	@Autowired
	private MemberDao memberDao;  // @Autowired 가 없으면 단순히 변수를 선언한 것일뿐.
	@Autowired
	private MemberPrinter printer;
	
	public MemberListPrinter() {}

	public MemberListPrinter(MemberDao memberDao, MemberPrinter printer) {  // @Autowired 를 통해 자동으로 생성하는 것 대신 생성자를 통해서 객체 주입.
		this.memberDao = memberDao;
		this.printer = printer;
	}

	public void printAll() {
		Collection<Member> members = memberDao.selectAll();  // MembetDao의 map 객체에 저장된 전체 value들.
		members.forEach(m -> printer.print(m));  // m : members 객체 중 하나의 요소. Member 타입 객체.
	}
}

// 메서드 위에 @Autowired 가 있으면 해당 메서드를 실행하겠다는 의미. 매개변수에 해당하는 타입의 객체가 필요하니까 자동으로 생성해서 주입해주겠다는 것.
