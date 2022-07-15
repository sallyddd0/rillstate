package com.baekhwa.song.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baekhwa.song.domain.dto.member.MemberInsertDTO;
import com.baekhwa.song.service.MailService;
import com.baekhwa.song.service.MemberService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class MemberController {
	
	
	private final MemberService service;
	private final MailService mailService;
	
	@PostMapping("/common/signup")
	public String signup(MemberInsertDTO dto, HttpServletRequest request) {
		return service.save(dto, request);
	}
	//*
	@ResponseBody
	@PostMapping("/request-key/mail")
	public boolean requestMailKey(String email) {
		System.out.println(email);
		return mailService.mailSend(email);
	}
	//*/

}
