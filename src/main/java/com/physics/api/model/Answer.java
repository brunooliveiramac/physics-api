package com.physics.api.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;



@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Answer implements Serializable {
		
	
		
		private String answer;
		private Long contentId;
		private Long questionId;
		
		
		public Answer() {
			super();
		}
		
		
		public String getAnswer() {
			return answer;
		}
		public void setAnswer(String answer) {
			this.answer = answer;
		}
		public Long getContentId() {
			return contentId;
		}
		public void setContentId(Long contentId) {
			this.contentId = contentId;
		}
		public Long getQuestionId() {
			return questionId;
		}
		public void setQuestionId(Long questionId) {
			this.questionId = questionId;
		}

	
		
		
}
