package com.baekhwa.song.domain.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicUpdate;

import com.baekhwa.song.domain.dto.visual.VisualUpdateDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@DynamicUpdate
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class VisualFile {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private long vno;
	private String link; //이미지 클릭하면 이동하는페이지 url
	private String url;
	private String orgName;
	private long size;
	private String title;
	private String sub;
	private boolean isShow;
	
	public VisualFile updateIsShow(boolean isShow) {
		this.isShow=isShow;
		return this;
	}

	public VisualFile updateTiele(String title) {
		this.title=title;
		return this;
	}

	public VisualFile updateSub(String sub) {
		this.sub=sub;
		return this;
	}

	public VisualFile updateData(VisualUpdateDto dto) {
		
		this.title=dto.getTitle();
		this.sub=dto.getSub();
		this.link=dto.getLink();
		return this;
	}

}
