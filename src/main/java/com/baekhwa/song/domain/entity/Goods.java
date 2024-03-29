package com.baekhwa.song.domain.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Goods extends BaseTimeEntity{
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private long gno;
	
	private String name;
	private int price;
	private int sale;
	private int stock;
	
	@Column(columnDefinition = "text", nullable = false)
	private String content;
	//색상
	@Builder.Default
	@Enumerated(EnumType.STRING)
	//@CollectionTable(name = "colors")
	@ElementCollection
	private Set<Color> colors=new HashSet<>();
	
	//사이즈
	@Builder.Default
	@Enumerated(EnumType.STRING)
	//@CollectionTable(name = "sizes")
	@ElementCollection
	private Set<Size> size=new HashSet<>();
	
	//1:N 단방향설정 연관테이블 생성시키지 않기위해 @JoinColumn 해주어야한다
	@Builder.Default
	@JoinColumn(name = "gno") //fk이름설정가능 - default: Goods_Entity_gno
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	List<GoodsFile> files=new ArrayList<>();
	
	public Goods addFile(GoodsFile file) {
		files.add(file);
		return this;
	}

	@Builder.Default	
	@JoinColumn//categorys_ca_no
	@ManyToMany(cascade = CascadeType.ALL)
	Set<Category> categorys=new HashSet<>();
	
	public Goods addCategory(Category category) {
		categorys.add(category);
		return this;
	}
}