package com.baekhwa.song.domain.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.baekhwa.song.domain.entity.GoodsFile;

@Repository
public interface GoodsFileRepository extends JpaRepository<GoodsFile, Long>{


	
}
