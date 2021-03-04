package com.quiz.response.model;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Quiz {
	private List<Result> quiz;

	public List<Result> getQuiz() {
		return quiz;
	}

	public void setQuiz(List<Result> quiz) {
		this.quiz = quiz;
	}

}
