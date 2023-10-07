package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.StoryDTO;
import com.app.model.Story;
import com.app.service.StoryService;

@RestController
@RequestMapping("/post")
public class PostController {

	@Autowired
	StoryService storyService;
	
	@PostMapping("userProfile/{profileId}/story")  // u need  loginUser ID = {id}  and liked User Name = {likedUser}
    public void addPost(@RequestBody StoryDTO storyDTO,
			@PathVariable(name = "profileId") Long profileId) {
		storyService.saveStory(profileId, storyDTO);
    }
	
	
	 @GetMapping("/getByUser")
	    public Page<StoryDTO> getPostsByUser(
	            @RequestParam Long userId,
	            @RequestParam(defaultValue = "0") int page,
	            @RequestParam(defaultValue = "10") int size
	    ) {
	        return storyService.getStoriesByUser(userId, PageRequest.of(page, size));
	    }
	
}
