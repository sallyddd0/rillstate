package com.baekhwa.song.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.baekhwa.song.domain.dto.goods.CategoryDto;
import com.baekhwa.song.domain.dto.goods.GoodsDetailDTO;
import com.baekhwa.song.domain.dto.goods.GoodsInsertDTO;
import com.baekhwa.song.domain.dto.goods.GoodsListDTO;
import com.baekhwa.song.domain.entity.CategoryA;
import com.baekhwa.song.domain.entity.CategoryRepository;
import com.baekhwa.song.domain.entity.Goods;
import com.baekhwa.song.domain.entity.GoodsEntityRepository;
import com.baekhwa.song.domain.entity.GoodsFile;
import com.baekhwa.song.domain.entity.GoodsFileRepository;
import com.baekhwa.song.service.GoodsService;

@Service
public class GoodsServiceProc implements GoodsService {

	@Autowired
	GoodsEntityRepository repository;
	
	@Autowired
	CategoryRepository categoryRepository;

	@Override
	public void goodsListByCaNo(long caNo, Model model) {
		for(CategoryA catea:CategoryA.values()) {
			if(catea.getCode()==caNo/100*100) {
				model.addAttribute("catea", catea);
			}
		}
		
		CategoryDto cateInfo=categoryRepository.findById(caNo).map(CategoryDto::new).get();
		model.addAttribute("cateInfo", cateInfo);
		
		
		
		model.addAttribute("list", 
				repository.findAllByCategorysCaNo(caNo)
				.stream()
				.map(GoodsListDTO::new)
				.toList());
		
	}
	
	//카테고리별 상품목록
	@Override
	public void goodsListByCategory(long caNo, Model model) {
		for(CategoryA catea:CategoryA.values()) {
			if(catea.getCode()==caNo) {
				model.addAttribute("catea", catea);
			}
		}
		
		model.addAttribute("list", 
									repository.findAllByCategorysCaNoBetween(caNo, caNo+99).stream()
									.map(GoodsListDTO::new)
									.toList());
	}
	
	@Override
	public String tempFileupload(MultipartFile file) {
		
		String path="/images/goods/temp/";
		ClassPathResource cpr=new ClassPathResource("static"+path);

		try {
			File location=cpr.getFile();
			File targetFile=new File(location, file.getOriginalFilename());
			file.transferTo(targetFile);

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return path+ file.getOriginalFilename(); // /images/goods/temp/파일이름.jpg
	}
	
	@Override
	public String save(GoodsInsertDTO dto) {
		System.out.println(dto);
		//서버에
		String def=dto.getDefImgName();
		String add=dto.getAddImgName();
		String path="/images/goods/temp/";
		ClassPathResource cpr=new ClassPathResource("static"+path);
		
		Goods entity=dto.toEntity();
		
		try {
			File root = cpr.getFile();
			//ClassPathResource target=new ClassPathResource("static"+"/images/goods/");
			///////////////////////////////////////////////////////////////////
			File defFile=new File(root, def);
			defFile.renameTo(new File(root.getParent(),def));
			String name=defFile.getName();
			long size=defFile.length();
			
			GoodsFile defGoodsFile=GoodsFile.builder()
			.newName(name).orgName(name).size(size).isDefImg(true).url("/images/goods/")
			.build();
			/////////////////////////////////////////////////////////////////////
			File addFile=new File(root, add);
			addFile.renameTo(new File(root.getParent(),add));
			name=addFile.getName();
			size=addFile.length();
			GoodsFile addGoodsFile=GoodsFile.builder()
			.newName(name).orgName(name).size(size).url("/images/goods/")
			.build();
			
			repository.save(entity.addFile(defGoodsFile).addFile(addGoodsFile));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:goods";
	}

	@Override
	public String list(Model model) {

		List<GoodsListDTO> result=repository.findAll().stream()
				.map(GoodsListDTO::new)
				.collect(Collectors.toList());
		
		model.addAttribute("list",result);
		
		return "admin/goods/list";
	}

	@Override
	public String indexlist(Model model) {
		List<GoodsListDTO> result=repository.findAll().stream()
				.map(GoodsListDTO::new)
				.collect(Collectors.toList());
		
		model.addAttribute("list",result);
		return "admin/goods/list-Data";
	}

	@Override
	public String detail(long gno, Model model) {
		model.addAttribute(
				"detail",
				repository.findById(gno).map(GoodsDetailDTO::new).get());
		
		return "admin/goods/detail";
	}

	@Override
	public Object categoryList(long caNo) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
