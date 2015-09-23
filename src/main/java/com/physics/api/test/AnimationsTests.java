package com.physics.api.test;

import java.util.List;

import org.junit.Test;

import com.physics.api.dao.AnimationsDAO;
import com.physics.api.model.Animation;

public class AnimationsTests {

	@Test
	public void mustReturnListOfAnimationsStoredOnDatabase() {
		List<Animation> animations = new AnimationsDAO().listAnimationsOnDatabase();
		System.out.println(animations);
	}
}
