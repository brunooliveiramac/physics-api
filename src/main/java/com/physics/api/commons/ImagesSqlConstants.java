package com.physics.api.commons;

public class ImagesSqlConstants {

	public static final String RETURN_UNIQUE_IMAGE_BY_ID
				= "SELECT * FROM images WHERE id_content = ? AND id = ?";
	
	public static final String RETURN_LIST_OF_IMAGES_FROM_CONTENT = "select id, description"
			+ " from images where id_content = ?";
	
//	public static final String RETURN_LIST_OF_IMAGES_FROM_CONTENT = "select image from images where id_content = 1";
}
