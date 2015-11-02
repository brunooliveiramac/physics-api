package com.physics.api.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Question implements Serializable {
	
		
			private Long id;
			private String correct_answer;
			private Content content;
			public Long getId() {
				return id;
			}
			public void setId(Long id) {
				this.id = id;
			}
			public String getCorrect_answer() {
				return correct_answer;
			}
			public void setCorrect_answer(String correct_answer) {
				this.correct_answer = correct_answer;
			}
			public Content getContent() {
				return content;
			}
			public void setContent(Content content) {
				this.content = content;
			}
			
			
}
