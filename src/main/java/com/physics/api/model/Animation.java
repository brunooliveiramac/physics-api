package com.physics.api.model;

import java.sql.Blob;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Animation {

	private Long id;
	private String description;
//	private Blob animation;
	private Content content;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

//	public Blob getAnimation() {
//		return animation;
//	}
//
//	public void setAnimation(Blob animation) {
//		this.animation = animation;
//	}

	public Content getContent() {
		return content;
	}

	public void setContent(Content content) {
		this.content = content;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Animation other = (Animation) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Animation [id=" + id + ", description=" + description + ", content="
				+ content + "]";
	}

}
