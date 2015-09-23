package com.physics.api.commons;

public class ImagesSqlConstants {

	public static final String RETURN_UNIQUE_IMAGE_BY_ID
				= "SELECT * FROM images WHERE id_content = ? AND id = ?";
	
	public static final String RETURN_LIST_OF_IMAGES_FROM_CONTENT = "select i.id, i.description, "
			+ "c.description, c.id"
			+ " from images i inner join contents c on c.id = i.id_content where id_content = ?";
}
