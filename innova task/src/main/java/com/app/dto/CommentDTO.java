package com.app.dto;

import jakarta.persistence.Column;

public class CommentDTO {

    private String content;
    
    private int commentRating;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getCommentRating() {
		return commentRating;
	}

	public void setCommentRating(int commentRating) {
		this.commentRating = commentRating;
	}
	
    
}
