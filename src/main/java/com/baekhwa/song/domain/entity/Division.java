package com.baekhwa.song.domain.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Division {
	
	NOTICE("공지사항","notice"),
	PICTURE("사진","picture"),
	GOODS("굿즈","goods"),
	FROMRILLS("릴스로부터","fromHills"),
	TORILLS("릴스에게","tohills"),
	COMMUNITY("커뮤니티","community");
	
	final String title;
	final String url;

}