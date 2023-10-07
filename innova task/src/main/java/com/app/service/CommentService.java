package com.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.CommentDTO;
import com.app.model.Comment;
import com.app.model.Story;
import com.app.model.UserProfile;
import com.app.repository.StoryRep;
import com.app.repository.UserProfileRep;

@Service
public class CommentService {

	@Autowired
	StoryRep storyRep;

	@Autowired
	UserProfileRep profileRep;
	
	public void saveComment(CommentDTO commentDTO, Long profileId, Long storyId) {
		Story story=storyRep.getReferenceById(storyId);
		Comment comment=new Comment();
		comment.setContent(commentDTO.getContent());
		comment.setCommentRating(commentDTO.getCommentRating());
		
		UserProfile userProfile=profileRep.getReferenceById(profileId);
		comment.setUserProfile(userProfile);
		comment.setStory(story);
		story.getComments().add(comment);
		storyRep.save(story);
		
	}
	
	
}
