package com.baekhwa.song.domain.dto.visual;

import com.baekhwa.song.domain.entity.VisualFile;

import lombok.Getter;

@Getter
public class VisualListDTO {
	
	private long vno;
	private String url;
	private String link;
	private String orgName;
	private long size;
	private String title;
	private String sub;
	private boolean isShow;
	
	public VisualListDTO(VisualFile e) {
		this.vno = e.getVno();
		this.url = e.getUrl();
		this.link=e.getLink();
		this.orgName = e.getOrgName();
		this.size = e.getSize();
		this.title = e.getTitle();
		this.sub = e.getSub();
		this.isShow=e.isShow();
	}
	
	

}
