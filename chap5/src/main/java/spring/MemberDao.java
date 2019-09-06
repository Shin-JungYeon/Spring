package spring;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

// @Component
@Repository  // (@Component) + (model 관련 객체) : @Component이면서 dao 의 의미 부여.
public class MemberDao {
	private static long nextId = 0;  // static : 객체가 만들어지기 전에 클래스가 load되기만 해도 설정 됨. 모든 객체가 공통으로 사용하는 공통변수의 역할.
	// a@aaa.bbb=1,a@aaa.bbb,홍길동,1234,현재일자 를 저장하고 있는 Member 객체 . key 값이 이메일.
	private Map<String, Member> map = new HashMap<>();
	
	public Member selectByEmail(String email) {
		return map.get(email);
	}
	
	public void insert(Member member) {
		member.setId(++nextId);
		map.put(member.getEmail(), member);
	}

	public Collection<Member> selectAll() {
		// Map<Key, Value> 객체.
		// Set keySet() : map 객체들의 key 들만 리턴.
		// Map.Entry entrySet() : map 객체들의 (key, value) 리턴.
		return map.values();  // map 객체들의 value 들만 리턴
	}

	public void passChg(String[] arg) {
		Member member = map.get(arg[1]);
		member.setPassword(arg[3]);  // 새로 값을 지정해주기만 하면 자동으로 update.
	}

	public void delete(String email) {
		map.remove(email);
	}
}