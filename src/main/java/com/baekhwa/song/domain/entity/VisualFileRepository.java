package com.baekhwa.song.domain.entity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VisualFileRepository extends JpaRepository<VisualFile, Long>{

	List<VisualFile> findAllByIsShow(boolean isShow);


	
}
