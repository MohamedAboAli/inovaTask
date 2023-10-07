package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.app.dto.StoryDTO;
import com.app.model.Story;
import com.app.model.UserProfile;
import com.app.repository.StoryRep;
import com.app.repository.UserProfileRep;

@Service
public class StoryService {

	@Autowired
	UserProfileRep profileRep;
	
	@Autowired
	StoryRep storyRep;
	
	public void saveStory(Long userProfileId,StoryDTO storyDTO) {
	
		UserProfile user=profileRep.getReferenceById(userProfileId);
		Story story=new Story();
		story.setTitle(storyDTO.getTitle());
		story.setBody(storyDTO.getBody());
		story.setUserProfile(user);
		user.getStories().add(story);
		profileRep.save(user);
	}

	public Page<StoryDTO> getStoriesByUser(Long userId, Pageable page) {
		// TODO Auto-generated method stub
		Page<Story> stories= storyRep.findByUserProfile_Id(userId, page);
		 List<StoryDTO> storyDTOList = stories.getContent()
		            .stream()
		            .map(story -> new StoryDTO(story.getTitle(), story.getBody()))
		            .collect(Collectors.toList());
	        Page<StoryDTO> storyDTOPage = new PageImpl<>(storyDTOList, page, stories.getTotalElements());

		return storyDTOPage;
	}
	
}
