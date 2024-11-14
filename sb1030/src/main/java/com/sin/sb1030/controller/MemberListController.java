package com.sin.sb1030.controller;

import java.util.List;

import com.sin.sb1030.dto.Member;
import com.sin.sb1030.dto.MemberDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class MemberListController {
	@Autowired
	private MemberDao memberDao;

	
	@RequestMapping("/members")
	public String list(
			@ModelAttribute("cmd") ListCommand listCommand,
			Errors errors,Model model) {
		if(errors.hasErrors()) {
			return "member/memberList";
		}
		if(listCommand.getFrom()!=null && listCommand.getTo() !=null) {
			List<Member> members= memberDao.selectByRegdate(listCommand.getFrom().atStartOfDay(),
                    listCommand.getTo().atStartOfDay());
					model.addAttribute("members",members);
		}
		return "member/memberList";
	}


}