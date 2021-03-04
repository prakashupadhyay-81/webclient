package com.quiz.response.model;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

//@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
//@JsonIgnoreProperties(ignoreUnknown = true)
//@Setter
@Component
public class Question implements Serializable{
	
	private String type;
	private String difficulty;
	private String question;
	private String category;
	private String correct_answer;
	private String [] incorrect_answers;
	
	
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
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getCorrect_answer() {
		return correct_answer;
	}
	public void setCorrect_answer(String correct_answer) {
		this.correct_answer = correct_answer;
	}
	public String[] getIncorrect_answers() {
		return incorrect_answers;
	}
	public void setIncorrect_answers(String[] incorrect_answers) {
		this.incorrect_answers = incorrect_answers;
	}
	
//	Question(){
//		super();
//	}
//	
//	public Question(String type, String difficulty, String question, String category, String correct_answer,
//			String[] incorrect_answers) {
//		
//		this.type = type;
//		this.difficulty = difficulty;
//		this.question = question;
//		this.category = category;
//		this.correct_answer = correct_answer;
//		this.incorrect_answers = incorrect_answers;
//	}
	
	
}
	