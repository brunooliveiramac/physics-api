package com.physics.api.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.physics.api.dao.AnimationsDAO;
import com.physics.api.model.Animation;

@Path("/animations")
public class AnimationResource {

	@Path("{contentId}/{gifId}")
	@GET
	@Produces("image/*")
	public byte[] getBlobGifAnimation(@PathParam("contentId") Long contentId, @PathParam("gifId") Long gifId) {
		byte[] gif = new AnimationsDAO().findAnimationAsByte(gifId, contentId);
		return gif;
	}
	
	@Path("all")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Animation> getAllAnimationsStored() {
		List<Animation> animations = new AnimationsDAO().listAnimationsOnDatabase();
		return animations;
	}
}
