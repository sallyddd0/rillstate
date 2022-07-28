package com.baekhwa.song.domain.entity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.baekhwa.song.domain.entity.Category;
import com.baekhwa.song.domain.entity.CategoryA;

public interface CategoryRepository extends JpaRepository<Category, Long>{

	long countByCateA(CategoryA cateA);

	List<Category> findByCaNoBetween(long caNo, long l);

	List<Category> findByCateA(CategoryA catea);
}
