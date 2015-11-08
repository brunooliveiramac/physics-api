package com.physics.api.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.physics.api.commons.FormulasSqlConstants;
import com.physics.api.connection.DataSourceFactory;

public class FormulasDAO {
	
	private JdbcTemplate jdbcTemplate;
	private DataSource dataSource = new DataSourceFactory().getDataSource();
	
	public FormulasDAO() {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public byte[] findFormulaAsBytes(Long formulaId, Long contentId) {
		byte[] result = this.jdbcTemplate.queryForObject(FormulasSqlConstants.RETURN_UNIQUE_FORMULA_BY_ID, 
				new Object[]{formulaId, contentId}, byte[].class);
		
		return result;
	}

//	public byte[] findFormulaAsByte(Long formulaId, Long contentId) {
//		byte[] blobAsBytes = {};
//		try {
//			Connection conn = DBConnection.getConnection();
//			
//			PreparedStatement ppStm = conn.prepareStatement(FormulasSqlConstants.RETURN_UNIQUE_FORMULA_BY_ID);
//			ppStm.setLong(1, contentId);
//			ppStm.setLong(2, formulaId);
//			
//			ResultSet result = ppStm.executeQuery();
//			
//			while(result.next()) {
//				Blob blob = result.getBlob("formula");
//				int blobLenght = (int) blob.length();
//				blobAsBytes = blob.getBytes(1, blobLenght);
//				//libera memória
//				blob.free();
//			}
//			
//			conn.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return blobAsBytes;
//	}
}
