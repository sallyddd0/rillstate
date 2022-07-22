package com.baekhwa.song.domain.dto.goods;

import java.util.List;
import java.util.stream.Collectors;

import com.baekhwa.song.domain.entity.Goods;

import ch.qos.logback.core.filter.Filter;
import lombok.Getter;

@Getter
public class GoodsListDTO {
	
	private long gno;
	private String name;
	private int price;
	private int sale;
	private int stock;
	
	private String defImgUrl;

	public GoodsListDTO(Goods e) {
		this.gno = e.getGno();
		this.name = e.getName();
		this.price = e.getPrice();
		this.sale = e.getSale();
		this.stock = e.getStock();
		e.getFiles().forEach(fe->{
			if(fe.isDefImg())defImgUrl=fe.getUrl()+fe.getOrgName();
		});
		
	}
	
	
	
}
