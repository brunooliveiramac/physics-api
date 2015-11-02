package com.physics.api.test;

import org.junit.Test;

import com.physics.api.dao.QuestionDAO;

public class QuestionTest {
	
	
	@Test
	public void testQustion(){
		byte[] image = new QuestionDAO().findImageQuestion(1L, 1L);
		System.out.println(image);
	}
}
