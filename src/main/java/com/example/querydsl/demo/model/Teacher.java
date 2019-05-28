package com.example.querydsl.demo.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Teacher {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private String subject;

	private Long academyId; // 연관관계 없음

	@Builder
	public Teacher(String name, String subject, Long academyId) {
		this.name = name;
		this.subject = subject;
		this.academyId = academyId;
	}
}
