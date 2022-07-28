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
public class MediaDTO {
	
	private long no;
	private String title;
	private String content;
	private String writer;
	private int readCount;
	private LocalDateTime createdDate;
	private LocalDateTime updatedDate;
}
