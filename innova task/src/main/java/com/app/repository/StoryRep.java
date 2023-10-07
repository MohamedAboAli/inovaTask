package com.app.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.model.Story;

@Repository
public interface StoryRep extends JpaRepository<Story, Long>{

	Page<Story> findByUserProfile_Id(Long userId, Pageable page);

}
