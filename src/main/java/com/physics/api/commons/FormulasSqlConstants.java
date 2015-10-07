package com.physics.api.commons;

public class FormulasSqlConstants {

	public static final String RETURN_UNIQUE_FORMULA_BY_ID
						= "SELECT formula FROM formulas WHERE content_id = ? AND id = ?";
}
