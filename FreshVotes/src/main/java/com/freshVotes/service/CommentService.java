package com.freshVotes.service;

import java.util.List;

import javax.print.attribute.standard.DateTimeAtCompleted;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.freshVotes.dao.CommentRepository;
import com.freshVotes.domain.Comment;
import com.freshVotes.domain.Feature;
import com.freshVotes.domain.User;

@Service
public class CommentService {

	@Autowired
	CommentRepository commentRepository;
	
	public List<Comment> findByFeatureId(Long featureId){
		return commentRepository.findByFeatureId(featureId);
	}
	
	public Comment createComment(Comment comment) {
		//Comment comment = new Comment();
		//comment.setComment(parentComment);
		//comment.setFeature(feature);
		//comment.setUser(user);
		//comment.setCreation_date();
		return null;
	}
}
