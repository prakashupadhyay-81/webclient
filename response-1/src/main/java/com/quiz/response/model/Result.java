package com.quiz.response.model;

import java.util.List;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

//@Getter
//@Setter
@Component
public class Result {
	private String category;
	private List<Answer> results;
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public List<Answer> getResults() {
		return results;
	}
	public void setResults(List<Answer> results) {
		this.results = results;
	}

}
