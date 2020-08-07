
package com.freshVotes.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class VoteId implements Serializable {

	private static final long serialVersionUID = -2727959345239837489L;
	@ManyToOne
	private User user;
	@ManyToOne
	private Feature feature;
	
	
	public VoteId(User user_id, Feature feature_id) {
		super();
		this.user = user_id;
		this.feature = feature_id;
	}
	
	
	
	public User getUser_id() {
		return user;
	}
	public void setUser_id(User user_id) {
		this.user = user_id;
	}
	
	public Feature getFeature_id() {
		return feature;
	}
	public void setFeature_id(Feature feature_id) {
		this.feature = feature_id;
	}
	
	
	
}


