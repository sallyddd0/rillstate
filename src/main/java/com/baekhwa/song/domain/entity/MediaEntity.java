package com.baekhwa.song.domain.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
public class MediaEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Mdno;
	
	
	private String subject;
	private String content;
	
	private LocalDateTime createdDate;
	
	@OneToMany(mappedBy = "mediaEntity", cascade = CascadeType.REMOVE)
	private List<MediaAnswerEntity> answerList;

}
