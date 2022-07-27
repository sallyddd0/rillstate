package com.baekhwa.song.domain.dto.goods;


import java.util.List;
import java.util.stream.Collectors;

import com.baekhwa.song.domain.entity.Goods;

import lombok.Getter;

@Getter
public class GoodsDetailDTO {
	
	private long gno;
	private String name;
	private int price;
	private int sale;
	private int stock;
	
	private String content;
	private List<GoodsFileDTO> files;

	public GoodsDetailDTO(Goods e) {
		this.gno = e.getGno();
		this.name = e.getName();
		this.price = e.getPrice();
		this.sale = e.getSale();
		this.stock = e.getStock();
		this.content=e.getContent();
		
		// List<GoodsFile> -> List<GoodsFileDTO>
		this.files=e.getFiles().stream()
				.map(GoodsFileDTO::new)
				.collect(Collectors.toList());
	}
		
	
}