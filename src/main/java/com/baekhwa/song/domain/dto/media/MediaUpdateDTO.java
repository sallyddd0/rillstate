package com.baekhwa.song.domain.dto.media;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class MediaUpdateDTO {

	private int no;
	private String title;
	private String content;
}
