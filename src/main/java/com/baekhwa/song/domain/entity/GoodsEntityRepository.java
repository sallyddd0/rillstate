package com.baekhwa.song.domain.entity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodsEntityRepository extends JpaRepository<Goods, Long>{

	List<Goods> findAllByCategorysCaNo(long caNo);

	List<Goods> findAllByCategorysCaNoBetween(long caNo, long l);

}
