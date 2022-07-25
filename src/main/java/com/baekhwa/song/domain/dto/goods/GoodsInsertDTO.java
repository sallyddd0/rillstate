package com.baekhwa.song.domain.dto.goods;

import com.baekhwa.song.domain.entity.Goods;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class GoodsInsertDTO {
	
	private String name;
	private int price;
	private int sale;
	private boolean isRate;
	private int stock;
	private String defImgName;
	private String addImgName;
	private String content;
	
	public Goods toEntity() {
		if(isRate) {
			sale=price*sale/100;
		}
		return Goods.builder()
				.name(name).price(price).sale(sale).content(content).stock(stock)
				.build();
	}

}
