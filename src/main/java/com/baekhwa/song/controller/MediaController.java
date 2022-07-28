package com.baekhwa.song.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.baekhwa.song.service.MediaService;

@Controller
public class MediaController {
	
	@Autowired
	private MediaService mediaService;
	
	@GetMapping("/media")
	public String list(Model model) {
		return "media/list";
	}
	
	@GetMapping("/media/write")
	public String write() {
		return "media/write";
	}

}
