package com.baekhwa.song.domain.entity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.baekhwa.song.domain.entity.VisualFile;

@Repository
public interface VisualFileRepository extends JpaRepository<VisualFile, Long>{

	List<VisualFile> findAllByIsShowOrderByNum(boolean isShow);

	@Query("select max(v.num) from VisualFile v")
	long getLastNum();


	
}
