package com.physics.api.dao;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.physics.api.commons.ImagesSqlConstants;
import com.physics.api.connection.DBConnection;
import com.physics.api.model.Content;
import com.physics.api.model.Image;

public class ImagesDAO {
	
	public Image findImageAsBase64(Long imageId, Long contentId) {
		Image image = null;
		try {
			Connection conn = DBConnection.getConnection();
			
			PreparedStatement ppStm = conn.prepareStatement(ImagesSqlConstants.RETURN_UNIQUE_IMAGE_BY_ID);
			ppStm.setLong(1, contentId);
			ppStm.setLong(2, imageId);
			
			ResultSet result = ppStm.executeQuery();
			
			while(result.next()) {
				image = new Image();
				image.setId(result.getLong("id"));
				image.setDescription(result.getString("description"));
//				image.setImage(result.getString("image"));
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} return image;
	}
	
	public byte[] findImageAsByte(Long imageId, Long contentId) {
		byte[] blobAsBytes = {};
		try {
			Connection conn = DBConnection.getConnection();
			
			PreparedStatement ppStm = conn.prepareStatement(ImagesSqlConstants.RETURN_UNIQUE_IMAGE_BY_ID);
			ppStm.setLong(1, contentId);
			ppStm.setLong(2, imageId);
			
			ResultSet result = ppStm.executeQuery();
			
			while(result.next()) {
				Blob blob = result.getBlob("image");
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
	

	//Error MIME Type
	
	public List<byte[]> findAllImagesFromContent(Long contentId) {
		List<byte[]> images = new ArrayList<>();
		byte[] blobAsBytes = {};
		
		try{
			Connection conn = DBConnection.getConnection();
			PreparedStatement ppStm = conn.prepareStatement(ImagesSqlConstants.RETURN_LIST_OF_IMAGES_FROM_CONTENT);
			ppStm.setLong(1, contentId);
			
			ResultSet rSet = ppStm.executeQuery();
			
			while(rSet.next()) {
				Blob blob = rSet.getBlob("image");
				int blobLenght = (int) blob.length();
				blobAsBytes = blob.getBytes(1, blobLenght);
				//libera memória
				blob.free();
				
				images.add(blobAsBytes);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return images;
	}
	
//	public List<Image> findAllImagesFromContent(Long contentId) {
//		List<Image> images = new ArrayList<>();
//		
//		try{
//			Connection conn = DBConnection.getConnection();
//			PreparedStatement ppStm = conn.prepareStatement(ImagesSqlConstants.RETURN_LIST_OF_IMAGES_FROM_CONTENT);
//			ppStm.setLong(1, contentId);
//			
//			ResultSet rSet = ppStm.executeQuery();
//			
//			while(rSet.next()) {
//				
//				Image image = new Image();
//				image.setId(rSet.getLong("id"));
//				image.setDescription(rSet.getString("description"));
//				
//				images.add(image);
//			}
//			conn.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return images;
//	}
}
