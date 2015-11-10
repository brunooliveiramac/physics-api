package com.physics.api.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.physics.api.dao.AnswerDAO;
import com.physics.api.model.Answer;
import com.physics.api.model.Answers;

@Path("answers")
public class AnswersResource {

			@Path("/{contentId}")
			@GET
			@Produces(MediaType.APPLICATION_JSON)
			public Answers getAllAnswer(@PathParam("contentId") Long contentId){
				List<Answer> ans = new AnswerDAO().getAllAnswers(contentId);
				Answers answers = new Answers();
				answers.setAnswers(ans);
				return answers;
			}
}
