package com.physics.api.test;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.physics.api.dao.AnimationsDAO;
import com.physics.api.model.Animation;

public class AnimationsTests {

	@Test
	@Ignore
	public void mustReturnListOfAnimationsStoredOnDatabase() {
		List<Animation> animations = new AnimationsDAO().listAnimations();
		System.out.println(animations);
	}
}
