package com.sin.test1023.controller;

import java.util.Arrays;
import java.util.List;

import com.sin.test1023.entity.AnsweredData;
import com.sin.test1023.entity.Question;
import com.sin.test1023.service.AnswereDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/survey")
public class SurveyController {
	@Autowired
	private AnswereDataService answereDataService;

	public SurveyController(AnswereDataService answereDataService) {
		this.answereDataService = answereDataService;
	}

	@GetMapping
	public String form(Model model) {
		List<Question> questions = createQuestions();
		model.addAttribute("questions", questions);
		return "survey/surveyForm";
	}

	private List<Question> createQuestions() {
		Question q1 = new Question("당신의 역할은 무엇입니까?",
				Arrays.asList("서버", "프론트", "풀스택"));
		Question q2 = new Question("많이 사용하는 개발도구는 무엇입니까?",
				Arrays.asList("이클립스", "인텔리J", "서브라임"));
		Question q3 = new Question("하고 싶은 말을 적어주세요.");
		return Arrays.asList(q1, q2, q3);
	}

	@PostMapping
	public String submit(@ModelAttribute("ansData") AnsweredData data) {
		answereDataService.saveAnsweredDate(data);
		return "survey/submitted";
	}

}