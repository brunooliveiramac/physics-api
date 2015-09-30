package com.physics.api.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import com.physics.api.dao.ImagesDAO;
import com.physics.api.model.Image;

public class ImageTests {
	
	@Test
	@Ignore
	public void mustReturnUniqueImageinBytes() {
		ImagesDAO dao = new ImagesDAO();
		byte[] image = dao.findImageAsByte(1L, 4L);
		System.out.println(image);
	}
	
//	@Test
//	public void mustReturnListOfImagesInContent() {
//		List<Image> images = new ImagesDAO().findAllImagesFromContent(1L);
//		System.out.println(images);
//	}

}
