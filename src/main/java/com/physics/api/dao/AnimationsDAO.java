package com.physics.api.dao;

import java.io.Serializable;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.physics.api.commons.AnimationsSqlConstants;
import com.physics.api.connection.DBConnection;
import com.physics.api.model.Animation;
import com.physics.api.model.Content;

public class AnimationsDAO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public byte[] findAnimationAsByte(Long animationId, Long contentId) {
		byte[] animationAsBytes = {};
		try {
			Connection conn = DBConnection.getConnection();
			
			PreparedStatement ppStm = conn.prepareStatement(AnimationsSqlConstants.RETURN_UNIQUE_ANIMATION_BY_ID);
			ppStm.setLong(1, contentId);
			ppStm.setLong(2, animationId);
			
			ResultSet result = ppStm.executeQuery();
			
			while(result.next()) {
				Blob blob = result.getBlob("animation");
				int blobLenght = (int) blob.length();
				animationAsBytes = blob.getBytes(1, blobLenght);
				//libera memória
				blob.free();
			}
			
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return animationAsBytes;
	}
	
	public List<Animation> listAnimationsOnDatabase() {
		List<Animation> animations = new ArrayList<>();
		
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement ppStm = conn.prepareStatement(AnimationsSqlConstants.RETURN_LIST_OF_ALL_ANIMATIONS);
			
			ResultSet rSet = ppStm.executeQuery();
			
			while(rSet.next()) {
				Content content = new Content();
				content.setId(rSet.getLong("content_id"));
				
				Animation animation = new Animation();
				animation.setId(rSet.getLong("id"));
				animation.setDescription(rSet.getString("description"));
//				animation.setAnimation(rSet.getBlob("animation"));
				animation.setContent(content);
				
				animations.add(animation);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return animations;
	}

}
