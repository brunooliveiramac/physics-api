package com.physics.api.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.physics.api.dao.QuestionDAO;

@Path("questions")
public class QuestionsResource {
	
			@Path("{contentId}/question/{questionId}")
			@GET
			@Produces("image/*")
			public byte[] getBlobQuestion(@PathParam("questionId") Long questionId, @PathParam("contentId") Long contentId){
				byte [] image = new QuestionDAO().findImageQuestion(contentId, questionId);
				return image;
			}
}
