package com.baekhwa.song.domain.dto.media;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MediaListDTO {

	private long no;
	private String title;
	private String writer;
	private int readCount;
	private LocalDateTime createdDate;//created_date
	private LocalDateTime updatedDate;
	
	public MediaListDTO(MediaDTO dto) {
		this.no = dto.getNo();
		this.title = dto.getTitle();
		this.writer = dto.getWriter();
		this.readCount = dto.getReadCount();
		this.createdDate = dto.getCreatedDate();
		this.updatedDate = dto.getUpdatedDate();
	}
}
