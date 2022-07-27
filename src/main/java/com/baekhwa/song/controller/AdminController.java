package com.baekhwa.song.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/admin/*")
@Controller
public class AdminController {

	@GetMapping("home")
	public String adminHome() {
		return "/admin/default";
	}
	
	
}
