package com.quiz.response.model;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

//@Getter
//@Setter
@Component
public class Answer {
	
	private String type;
	private String difficulty;
	private String question;
	private String correct_answer;
	private String [] all_answers;
	
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getCorrect_answer() {
		return correct_answer;
	}
	public void setCorrect_answer(String correct_answer) {
		this.correct_answer = correct_answer;
	}
	public String[] getAll_answers() {
		return all_answers;
	}
	public void setAll_answers(String[] all_answers) {
		this.all_answers = all_answers;
	}

}
