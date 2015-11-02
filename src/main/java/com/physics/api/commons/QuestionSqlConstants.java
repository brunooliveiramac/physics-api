package com.physics.api.commons;

public class QuestionSqlConstants {
		
		
		
		public static final String RETURN_QUESTIONS =
				"SELECT image_question FROM questions WHERE id_content = ? and id = ?";
		
		public static final String RETURN_ALL_ANSWERS = 
				"SELECT correct_answer FROM questions WHERE id_content = ?";
}
