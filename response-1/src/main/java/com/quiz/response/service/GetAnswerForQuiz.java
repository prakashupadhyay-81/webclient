package com.quiz.response.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.function.Consumer;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.quiz.response.DAO.GetDownStreamData;
import com.quiz.response.model.AllQuestion;
import com.quiz.response.model.Answer;
import com.quiz.response.model.Question;
import com.quiz.response.model.Quiz;
import com.quiz.response.model.Result;

@Service
public class GetAnswerForQuiz {

	@Autowired
	GetDownStreamData getDownStreamDataService;

	public ResponseEntity<Quiz> getDataForAnswer() {
		Quiz q = new Quiz();

//		List<Result> setR= new ArrayList<Result>();
//	
//		setR.add(createResponse(getDownStreamDataService.getData()));
		// setR.add(createResponse(getDownStreamDataService.getData(2)));
		q.setQuiz(createResponse(getDownStreamDataService.getData()));

		return new ResponseEntity<Quiz>(q, HttpStatus.OK);
	}

	String[] f(String[] first, String[] second) {
		List<String> both = new ArrayList<String>(first.length + second.length);
		Collections.addAll(both, first);
		Collections.addAll(both, second);
		return both.toArray(new String[both.size()]);
	}
	

	public List<Result> createResponse(List<AllQuestion> downStreamResponse) {

		List<Result> r_all = new ArrayList<Result>();
		
				for(AllQuestion i: downStreamResponse) {
					i.getResults();
			
		}

		downStreamResponse.stream().forEach(a->{
				 Result r = new Result();
				List<Question> ds = (List<Question>) a.getResults();
				ListIterator<Question> listIterator = ds.listIterator();
				r.setCategory(ds.get(0).getCategory());
				List<Answer> as = new ArrayList<Answer>();
				while(listIterator.hasNext()) {	
					Question qu = listIterator.next();

					Answer ans = new Answer();
					ans.setType(qu.getType());
					ans.setDifficulty(qu.getDifficulty());
					ans.setQuestion(qu.getQuestion());
					ans.setCorrect_answer(qu.getCorrect_answer());
					String [] all = {qu.getCorrect_answer()};
					String[] all_answers = Stream.concat(Arrays.stream(all), Arrays.stream(qu.getIncorrect_answers())).toArray(String[]::new);
					ans.setAll_answers(all_answers);                  
					as.add(ans);
					
				}
				r.setResults(as);
				r_all.add(r);
		});
		
//		
//			r = new Result();
//			List<Question> ds = (List<Question>) listIterator_all.next().getResults();
//			ListIterator<Question> listIterator = ds.listIterator();
//			r.setCategory(ds.get(0).getCategory());
//			List<Answer> as = new ArrayList<Answer>();
//			while(listIterator.hasNext()) {	
//				Question qu = listIterator.next();
//
//				Answer ans = new Answer();
//				ans.setType(qu.getType());
//				ans.setDifficulty(qu.getDifficulty());
//				ans.setQuestion(qu.getQuestion());
//				ans.setCorrect_answer(qu.getCorrect_answer());
//				String [] all = {qu.getCorrect_answer()};
//				String[] all_answers = Stream.concat(Arrays.stream(all), Arrays.stream(qu.getIncorrect_answers())).toArray(String[]::new);
//				ans.setAll_answers(all_answers);                  
//				as.add(ans);
//				
//			}
//			r.setResults(as);
//			r_all.add(r);
			
		//}
		
		//List<Question> ds = downStreamResponse.getBody().getResults();
		
		
		return r_all;
	}

}
