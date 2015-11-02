package com.physics.api.dao;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.physics.api.commons.QuestionSqlConstants;
import com.physics.api.connection.DBConnection;
import com.physics.api.model.Question;

public class QuestionDAO {

	public byte[] findImageQuestion(Long contetetId, Long questionId) {
		byte[] blobAsBytes = {};

		try {
			Connection con = DBConnection.getConnection();

			PreparedStatement ppStm = con.prepareStatement(QuestionSqlConstants.RETURN_QUESTIONS);
			ppStm.setLong(1, contetetId);
			ppStm.setLong(2, questionId);

			ResultSet result = ppStm.executeQuery();

			while (result.next()) {
				Blob blob = result.getBlob("image_question");
				int blobLenght = (int) blob.length();
				blobAsBytes = blob.getBytes(1, blobLenght);
				blob.free();
			}

			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return blobAsBytes;
	}

}
