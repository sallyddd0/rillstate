package com.baekhwa.song.domain.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodsFileRepository extends JpaRepository<Goods, Long>{

}
