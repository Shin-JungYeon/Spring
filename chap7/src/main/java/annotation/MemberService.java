package annotation;

import org.springframework.stereotype.Component;

import xml.Member;
import xml.UpdateInfo;

@Component
public class MemberService {
	public void regist(Member member) {  // 핵심 메서드.
		System.out.println("MemberService.regist() 메서드 실행");
	}
	public boolean update(String memberId, UpdateInfo info) {  // traceAspect의 pointcut 대상. 매개변수의 이름과 상관없음. 자료형으로 찾아옴.
		System.out.println("MemberService.update() 메서드 실행");
		return true;
	}
	public boolean delete(String id, String str) {
		System.out.println("MemberService.delete() 메서드 실행");
		return false;
	}
}