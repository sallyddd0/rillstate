package com.baekhwa.song.domain.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.data.annotation.CreatedDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class MediaAnswerEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Mdno;
	
	
	private String subject;
	private String content;
	
	@CreatedDate
	private LocalDateTime createdDate;
	
	@ManyToOne
	private MediaEntity mediaEntity;
	

}
