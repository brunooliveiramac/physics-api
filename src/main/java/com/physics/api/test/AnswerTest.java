package com.physics.api.test;

import java.util.List;

import org.junit.Test;

import com.physics.api.dao.AnswerDAO;
import com.physics.api.model.Answer;

public class AnswerTest {
				
				@Test
				public void testRespostas(){
					List<Answer> resps = new AnswerDAO().getAllAnswers(1L);
					System.out.println(resps);
				}
}
