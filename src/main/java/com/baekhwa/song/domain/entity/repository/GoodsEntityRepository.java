package com.baekhwa.song.domain.entity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.baekhwa.song.domain.entity.Goods;

@Repository
public interface GoodsEntityRepository extends JpaRepository<Goods, Long>{

	List<Goods> findAllByCategorysCaNo(long caNo);

	List<Goods> findAllByCategorysCaNoBetween(long caNo, long l);

}
