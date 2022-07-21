package com.baekhwa.song.domain.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Color {
 
	BLACK("검정색"),
	WHITE("흰색");
	
	final String colorName;
}
