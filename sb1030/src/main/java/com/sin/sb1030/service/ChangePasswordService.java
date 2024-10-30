package com.sin.sb1030.service;

import com.sin.sb1030.dto.Member;
import com.sin.sb1030.dto.MemberDao;
import org.springframework.transaction.annotation.Transactional;

public class ChangePasswordService {

	private MemberDao memberDao;

	@Transactional
	public void changePassword(String email, String oldPwd, String newPwd) {
		Member member = memberDao.selectByEmail(email);
		if (member == null)
			throw new MemberNotFoundException();

		member.changePassword(oldPwd, newPwd);

		memberDao.update(member);
	}

	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

}
