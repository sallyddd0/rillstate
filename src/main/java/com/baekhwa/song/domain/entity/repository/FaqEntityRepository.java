package com.baekhwa.song.domain.entity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.baekhwa.song.domain.entity.Division;
import com.baekhwa.song.domain.entity.FaqEntity;

@Repository
public interface FaqEntityRepository extends JpaRepository<FaqEntity, Long>{

	List<FaqEntity> findAllByDivision(Division division);

}