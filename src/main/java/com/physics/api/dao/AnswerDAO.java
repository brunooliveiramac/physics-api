package com.physics.api.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.physics.api.commons.AnswerSqlConstants;
import com.physics.api.connection.DBConnection;
import com.physics.api.model.Answer;

public class AnswerDAO {

	/*
	 * public List<String> allAnswers(Long idContent){ List<String> answers =
	 * null; String answer = null; try { Connection con =
	 * DBConnection.getConnection();
	 * 
	 * PreparedStatement prepara =
	 * con.prepareStatement(AnswerSqlConstants.RETURN_LIST_ANSWER);
	 * prepara.setLong(1, idContent);
	 * 
	 * ResultSet resultSet = prepara.executeQuery();
	 * 
	 * while(resultSet.next()){ answer = resultSet.getString("answer");
	 * answers.add(answer); } con.close(); } catch (Exception e) {
	 * e.printStackTrace(); } return answers; }
	 */

	public List<Answer> allAnswers(Long idContent) {
		List<Answer> answers = new ArrayList<Answer>();
		try {
			Connection con = DBConnection.getConnection();

			PreparedStatement prepara = con
					.prepareStatement(AnswerSqlConstants.RETURN_LIST_ANSWER);
			prepara.setLong(1, idContent);

			ResultSet resultSet = prepara.executeQuery();

			while (resultSet.next()) {
				Answer a = new Answer();
				a.setAnswer(resultSet.getString("answer"));
				a.setContentId(resultSet.getLong("id_content"));
				a.setQuestionId(resultSet.getLong("id_question"));
				answers.add(a);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return answers;
	}

}
