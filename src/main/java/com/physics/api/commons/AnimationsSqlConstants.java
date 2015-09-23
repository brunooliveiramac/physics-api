package com.physics.api.commons;

public class AnimationsSqlConstants {

	
	public static final String RETURN_UNIQUE_ANIMATION_BY_ID 
				= "SELECT animation FROM animations WHERE content_id = ? AND id = ?";
	
	public static final String RETURN_LIST_OF_ALL_ANIMATIONS = "select * from animations";
}
