package com.sin.sb1024.spring;



import com.sin.sb1024.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MemberRegisterService {
	private MemberDao memberDao;
	private PasswordEncoder passwordEncoder;

	@Autowired
	public MemberRegisterService(MemberDao memberDao, PasswordEncoder passwordEncoder) {
		this.memberDao = memberDao;
		this.passwordEncoder = passwordEncoder;
	}

	public Long regist(RegisterRequest req) {
		Member member = memberDao.selectByEmail(req.getEmail());
		if (member != null) {
			throw new DuplicateMemberException("dup email " + req.getEmail());
		}
		String encodePassword = passwordEncoder.encode(req.getPassword());

		Member newMember2 = new Member(
				req.getEmail(),  req.getName(), encodePassword,
				"USER",LocalDateTime.now());
		memberDao.insert(newMember2);
		return newMember2.getId();
	}
}
