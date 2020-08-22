package com.freshVotes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.freshVotes.domain.Comment;
import com.freshVotes.service.CommentService;

@RequestMapping("/products/{productId}/features/{featureId}/comments")
@Controller
public class CommentController {
	
	@Autowired
	CommentService commentService;
	
	@ResponseBody
	@GetMapping("")
	public List<Comment> getComments(@PathVariable Long featureId) {
		return commentService.findByFeatureId(featureId);
	}
	
	@PostMapping("")
	public String addComment() {
		return null;
	}
	

}
