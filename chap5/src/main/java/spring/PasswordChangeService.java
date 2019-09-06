package spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PasswordChangeService {
	@Autowired
	private MemberDao memberDao;
	
	public void change(String[] arg) {
		Member member = memberDao.selectByEmail(arg[1]);
		if(member == null) {
			throw new MemberNotFoundException("Not Found Email " + arg[1] + "\n");
		} else if(!arg[2].equals(member.getPassword())) {
			throw new RuntimeException("Wrong Password " + arg[2] + "\n");
		}
		memberDao.passChg(arg);
	}
}
