package com.quiz.response.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
@Component
//@Setter
public class AllQuestion implements Serializable{
	private List<Question> results ;
	
	private  Long response_code;
//	
//	AllQuestion(){
//		super();
//	}
//	
//	public AllQuestion(List<Question> results, int response_code) {
//		//super();
//		this.results = results;
//		this.response_code = response_code;
//	}

	public List<Question> getResults() {
		return results;
	}

	public void setResults(List<Question> results) {
		this.results = results;
	}

	public Long getResponse_code() {
		return response_code;
	}

	public void setResponse_code(Long response_code) {
		this.response_code = response_code;
	}

}
