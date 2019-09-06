package spring;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

// @Component
@Service  // (@Component) + (서비스 기능(알고리즘 도와주는 역할. Coltroller와 dao의 중간 역할 기능.))
public class MemberRegisterService {
	@Autowired
	private MemberDao memberDao;
	
	public MemberRegisterService() {}
	
	public MemberRegisterService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public Long regist(RegisterRequest req) {
		Member member = memberDao.selectByEmail(req.getEmail());
		if(member != null) {
			throw new DuplicateMemberException("dup email " + req.getEmail() + "\n");  // 내가 만든 예외. 예외발생하면 아래로 내려가지 못하고 나를 호출한 곳으로 예외 객체 넘겨줌. Dupli- 클래스의 상위 클래스가 RuntimeExeption이기 때문에 예외처리 필요 없음.
		}
		Member newMember = new Member(req.getEmail(), req.getPassword(), req.getName(), LocalDateTime.now());  // member == null 일 때.
		memberDao.insert(newMember);
		return newMember.getId();
	}
}