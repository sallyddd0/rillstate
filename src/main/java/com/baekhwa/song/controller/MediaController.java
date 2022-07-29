package com.baekhwa.song.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.baekhwa.song.domain.dto.media.MediaInsertDTO;
import com.baekhwa.song.domain.entity.MediaEntity;
import com.baekhwa.song.domain.entity.repository.MediaRepository;
import com.baekhwa.song.service.MediaService;

@Controller
public class MediaController {
	
	@Autowired
	private MediaService mediaService;
	
	@Autowired
	private MediaRepository mediaRepository;
	
	@RequestMapping("/media")
	public String list(Model model) {
		List<MediaEntity> mediaList = this.mediaRepository.findAll();
		model.addAttribute("mediaList",mediaList);
		return "media/list";
	}
	
	@GetMapping("/media/write")
	public String write() {
		return "media/write";
	}
	
	@PostMapping("/media/write")
	public String media(MediaInsertDTO dto) {
		mediaService.save(dto);
		return "media/list";
	}
	

}
