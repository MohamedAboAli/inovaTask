package com.app.dto;

public class StoryDTO {

	private String title;
	
	private String body;

	public StoryDTO(String title2, String body2) {
		// TODO Auto-generated constructor stub
		this.body=body2;
		this.title=title2;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
	
	
}
