package com.baekhwa.song.service;

import org.springframework.ui.Model;

import com.baekhwa.song.domain.dto.media.MediaInsertDTO;

public interface MediaService {

	void save(MediaInsertDTO dto);


}
