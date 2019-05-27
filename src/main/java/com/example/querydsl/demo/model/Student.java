package com.example.querydsl.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	private String name;
	private int academyNo;

	@ManyToOne
	@JoinColumn(name = "academy_id")
	private Academy academy;

	@Builder
	public Student(String name, int academyNo) {
		this.name = name;
		this.academyNo = academyNo;
	}

	public void setAcademy(Academy academy) {
		this.academy = academy;
	}
}
