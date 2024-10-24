package com.sin.sb1022secu4.spring;


import com.sin.sb1022secu4.entity.Member;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MemberRegisterService {
	private MemberDao memberDao;

	public MemberRegisterService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	public Long regist(RegisterRequest req) {
		Member member = memberDao.selectByEmail(req.getEmail());
		if (member != null) {
			throw new DuplicateMemberException("dup email " + req.getEmail());
		}
		Member newMember2 = new Member(
				req.getEmail(),  req.getName(),req.getPassword(),
				"USER",LocalDateTime.now());
		memberDao.insert(newMember2);
		return newMember2.getId();
	}
}
