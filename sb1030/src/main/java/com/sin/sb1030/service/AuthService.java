package com.sin.sb1030.service;

import com.sin.sb1030.dto.Member;
import com.sin.sb1030.dto.MemberDao;

public class AuthService {

	private MemberDao memberDao;

	public void setMemberDao(MemberDao memberDao) {
		
		this.memberDao = memberDao;
	}
	
	public AuthInfo authenticate(String email, String password) {
		Member member = memberDao.selectByEmail(email);
		if(member==null) {
			throw new WrongIdPasswordException();
		}
		if(!member.matchPassword(password)) {
				throw new WrongIdPasswordException();
			}
			return new AuthInfo(member.getId(),
					member.getEmail(),
					member.getPassword());
		}
	}


