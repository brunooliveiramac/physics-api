package com.physics.api.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.physics.api.dao.VideoDAO;
import com.physics.api.model.Video;
import com.physics.api.model.VideoResponse;

@Path("videos")
public class VideosResource {

	@Path("{contentId}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public VideoResponse getVideosFromContent(@PathParam("contentId") Long contentId) {
		List<Video> result = new VideoDAO().getVideosByContent(contentId);
		VideoResponse response = new VideoResponse();
		response.setVideos(result);
		return response;
	}
}
