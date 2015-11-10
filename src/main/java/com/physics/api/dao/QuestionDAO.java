package com.physics.api.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.physics.api.commons.QuestionSqlConstants;
import com.physics.api.connection.DataSourceFactory;

public class QuestionDAO {
	
	private JdbcTemplate jdbcTemplate;
	private DataSource dataSource = new DataSourceFactory().getDataSource();
	

//	public byte[] findImageQuestion(Long contentId, Long questionId) {
//		byte[] blobAsBytes = {};
//
//		try {
//			Connection con = DBConnection.getConnection();
//
//			PreparedStatement ppStm = con.prepareStatement(QuestionSqlConstants.RETURN_QUESTIONS);
//			ppStm.setLong(1, contentId);
//			ppStm.setLong(2, questionId);
//
//			ResultSet result = ppStm.executeQuery();
//
//			while (result.next()) {
//				Blob blob = result.getBlob("image_question");
//				int blobLenght = (int) blob.length();
//				blobAsBytes = blob.getBytes(1, blobLenght);
//				blob.free();
//			}
//
//			con.close();
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		return blobAsBytes;
//	}
	
	public QuestionDAO() {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public byte[] findImageQuestion(Long contentId, Long questionId) {
		byte[] result = this.jdbcTemplate.queryForObject(QuestionSqlConstants.RETURN_QUESTIONS, 
				new Object[]{contentId, questionId}, byte[].class);
		
		return result;
	}


}
