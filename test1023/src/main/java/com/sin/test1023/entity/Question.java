package com.sin.test1023.entity;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;

@Entity
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public void setTitle(String title) {
		this.title = title;
	}

	private String title;

	public void setOptions(List<String> options) {
		this.options = options;
	}

	@ElementCollection
	private List<String> options;

	public Question() {}

	public Question(String title, List<String> options) {
		this.title = title;
		this.options = options;
	}
	public Question(String title) {
		this(title, Collections.emptyList());
	}

	public String getTitle() {
		return title;
	}

	public List<String> getOptions() {
		return options;
	}

	public boolean isChoice() {
		return options != null && !options.isEmpty();
	}

}
