package com.baekhwa.song.service;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.baekhwa.song.domain.dto.goods.GoodsInsertDTO;

public interface GoodsService {

	String tempFileupload(MultipartFile file);

	String save(GoodsInsertDTO dto);

	String list(Model model);

	String indexlist(Model model);

	String detail(long gno, Model model);

	void goodsListByCaNo(long caNo, Model model);

	void goodsListByCategory(long caNo, Model model);

	Object categoryList(long caNo);

}