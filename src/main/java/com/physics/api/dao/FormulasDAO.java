package com.physics.api.dao;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.physics.api.commons.FormulasSqlConstants;
import com.physics.api.connection.DBConnection;

public class FormulasDAO {

	public byte[] findFormulaAsByte(Long formulaId, Long contentId) {
		byte[] blobAsBytes = {};
		try {
			Connection conn = DBConnection.getConnection();
			
			PreparedStatement ppStm = conn.prepareStatement(FormulasSqlConstants.RETURN_UNIQUE_FORMULA_BY_ID);
			ppStm.setLong(1, contentId);
			ppStm.setLong(2, formulaId);
			
			ResultSet result = ppStm.executeQuery();
			
			while(result.next()) {
				Blob blob = result.getBlob("formula");
				int blobLenght = (int) blob.length();
				blobAsBytes = blob.getBytes(1, blobLenght);
				//libera memória
				blob.free();
			}
			
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return blobAsBytes;
	}
}
