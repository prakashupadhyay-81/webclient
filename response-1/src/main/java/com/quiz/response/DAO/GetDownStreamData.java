package com.quiz.response.DAO;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.quiz.response.model.AllQuestion;
import com.quiz.response.model.Quiz;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.ParallelFlux;
import reactor.core.scheduler.Schedulers;

@Service
public class GetDownStreamData {

	// @Autowired
	// WebClient webClient; //= WebClient.create("http://localhost:8080");

	public List<AllQuestion> getData() {
		final String uri1 = "https://opentdb.com/api.php?amount=5&category=11";
		final String uri2 = "https://opentdb.com/api.php?amount=5&category=12";
		// ResponseEntity<AllQuestion> result = null;

		List<AllQuestion> result = fetchUserAndOtherUser(uri1, uri2);

//		
//		/// this needs to be done as threading 
//		if(option == 1)
//			result = restTemplate.getForEntity(uri1,AllQuestion.class);
//		if(option == 2)
//			result = restTemplate.getForEntity(uri2,AllQuestion.class);

		return result;
	}

	public Mono<AllQuestion> getData1(String url) {
		WebClient client = WebClient.create(url);
		return client.get().uri(url).retrieve().bodyToMono(AllQuestion.class);
	}

	public Mono<AllQuestion> getData2(String url) {
		WebClient client = WebClient.create(url);
		return client.get().uri(url).retrieve().bodyToMono(AllQuestion.class);
	}

	public List<AllQuestion> fetchUserAndOtherUser(String url1, String url2) {
		Comparator<AllQuestion> byRanking = Comparator.comparing(AllQuestion::getResponse_code);
		return Flux.merge(getData1(url1), getData2(url2)).collectList().block();

	}

}
