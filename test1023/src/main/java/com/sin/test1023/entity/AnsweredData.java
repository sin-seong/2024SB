package com.sin.test1023.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data

public class AnsweredData {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;



	@OneToMany
	@JoinColumn(name = "answered_data_id")
	private List<Question> questions;

	@ElementCollection
	@CollectionTable(name = "answered_data_responses", joinColumns = @JoinColumn(name = "answered_data_id"))
	@Column(name = "response_text")
	private List<String> responses;

	@Embedded
	private Respondent res;

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public List<String> getResponses() {
		return responses;
	}

	public void setResponses(List<String> responses) {
		this.responses = responses;
	}

	public Respondent getRes() {
		return res;
	}

	public void setRes(Respondent res) {
		this.res = res;
	}

}
