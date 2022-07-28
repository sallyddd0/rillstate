package com.baekhwa.song.security;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.baekhwa.song.domain.entity.Member;
import com.baekhwa.song.domain.entity.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CustomUserDetailsService implements UserDetailsService{
	//DaoAuthenticationProvider. 
	
	//DAO : jpa-Repository
	
	private final MemberRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// username -> login페이지에서 입력한 email 정보입니다.
		System.out.println(username);
		//db에 회원존재하는지 체크 존재하면 UserDetails 으로 세팅해서 리턴
		Optional<Member> result=repository.findByEmailAndIsDeletedAndIsSocial(username, false, false);
		//isDeleted : true는 탈퇴회원, false가 정상회원 
		//isSocial : false 일반회원, true 소셜가입회원
		
		if(result.isEmpty()) {
			throw new UsernameNotFoundException("존재하지 않거나 탈퇴회원");
		}
		
		//UserDetails 타입으로 리턴 User활용		
		System.out.println(">>>>>Role read");
		return new CustomUserDetails(result.get());
	}

}
