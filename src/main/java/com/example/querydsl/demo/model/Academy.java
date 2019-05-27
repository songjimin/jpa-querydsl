package com.example.querydsl.demo.model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Academy {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private String address;

	@OneToMany(cascade = CascadeType.REMOVE, mappedBy = "academy")
	private List<Student> students = new ArrayList<>();

	@Builder
	public Academy(String name, String address) {
		this.name = name;
		this.address = address;
	}

	public void addStudent(List<Student> students) {
		for (Student student : students) {
			addStudent(student);
		}
	}

	public void addStudent(Student student) {
		this.students.add(student);
		student.setAcademy(this);
	}
}
