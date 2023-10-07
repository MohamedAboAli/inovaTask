package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.CommentDTO;
import com.app.dto.StoryDTO;
import com.app.service.CommentService;

@RestController
@RequestMapping("/review")
public class ReviewController {
	
	@Autowired
	CommentService commentService;

	@PostMapping("userProfile/{profileId}/story/{storyId}") // u need loginUser ID = {id} and liked User Name = {likedUser}
	public void addPost(@RequestBody CommentDTO commentDTO, @PathVariable(name = "profileId") Long profileId, @PathVariable(name = "storyId") Long storyId) {
		commentService.saveComment(commentDTO,profileId, storyId);
	}

}
