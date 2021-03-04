package com.quiz.response.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.quiz.response.DAO.GetDownStreamData;
import com.quiz.response.model.AllQuestion;
import com.quiz.response.model.Quiz;
import com.quiz.response.service.GetAnswerForQuiz;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
public class BaseController {
	
	
	
	@Autowired
	GetAnswerForQuiz getAnswerForQuiz;
	
	@GetMapping(value="/coding/exercise/quiz")
	public ResponseEntity<Quiz> testSite()  {
		
		return getAnswerForQuiz.getDataForAnswer();
	}
	

}
