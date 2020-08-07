
package com.freshVotes.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class CommentId implements Serializable {

	private static final long serialVersionUID = -3521102746828050957L;
	
	@ManyToOne
	private User user;
	@ManyToOne
	private Feature feature;
	
	
	public CommentId(User userId, Feature feature_id) {
		super();
		this.user = userId;
		this.feature = feature_id;
	}
	public User getUserId() {
		return user;
	}
	public void setUserId(User userId) {
		this.user = userId;
	}
	public Feature getFeature_id() {
		return feature;
	}
	public void setFeature_id(Feature feature_id) {
		this.feature = feature_id;
	}

	
}

