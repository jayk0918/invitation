package com.jayk0918.www.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Links {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long linkId;
	
	@Column(nullable = false)
	private Long userId;
	
	@Column(nullable = false)
	private String url;
	
	@Column(nullable = false)
	private boolean usage;
	
	
	@Builder
	public Links(
				Long userId,
				String url,
				boolean usage
				) {
		this.userId = userId;
		this.url = url;
		this.usage = usage;
	}
	
}
