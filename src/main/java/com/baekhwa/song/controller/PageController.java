package com.baekhwa.song.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
	
	//로그인 페이지 이동
	@GetMapping("/signin")
	public String login() {
		return "sign/signin";
	}
	
	@GetMapping("/loginPage")
	public String loginPage() {
		return "redirect:/";
	}
	
	
	@GetMapping("/sign/signup")
	public String signup() {
		return "sign/signup";
	}
	
	@GetMapping("/tohills")
	public String toHills() {
		return "toHills/index";
	}

	@GetMapping("/goods")
	public String goods() {
		return "goods/index";
	}
	
	@GetMapping("/match")
	public String match() {
		return "match/index";
	}
	@GetMapping("/media")
	public String media() {
		return "media/index";
	}
	@GetMapping("/ticket")
	public String ticket() {
		return "ticket/index";
	}
	@GetMapping("/club")
	public String club() {
		return "club/index";
	}
}
