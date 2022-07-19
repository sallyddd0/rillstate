package com.baekhwa.song.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import net.bytebuddy.implementation.bytecode.Division;

@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class FaqEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long faqNo;
	
	private String question;//질문
	private String answer; //응답E
	
	@Column(name = "divs")
	@Enumerated(EnumType.STRING)
	private Division division; 

}
