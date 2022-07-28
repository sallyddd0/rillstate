package com.baekhwa.song.domain.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.baekhwa.song.domain.entity.MediaEntity;

@Repository
public interface MediaRepository extends JpaRepository<MediaEntity, Integer>{

	
}
