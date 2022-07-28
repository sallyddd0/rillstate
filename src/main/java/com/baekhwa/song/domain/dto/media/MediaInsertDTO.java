package com.baekhwa.song.domain.dto.media;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MediaInsertDTO {

	private String title;
	private String content;
	private String writer;

}
