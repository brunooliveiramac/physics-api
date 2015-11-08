package com.physics.api.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.physics.api.model.Video;

public class VideosDAO {
	
	private VideoDAO dao;

	@Before
	public void setUp() throws Exception {
		dao = new VideoDAO();
	}

//	@Test
//	public void test() {
//		fail("Not yet implemented");
//	}
	
	@Test
	public void mustReturnListOfVideosFromContent() {
		List<Video> result = dao.getVideosByContent(1L);
		System.out.println(result);
	}

}
