package com.example.querydsl.demo.repository;

import java.util.List;

import com.example.querydsl.demo.model.Academy;
import com.example.querydsl.demo.model.StudentCount;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AcademyRepositoryCustom {

	List<Academy> findByName(String name);
	Page<Academy> findByName(String name, Pageable pageable);

	List<StudentCount> findAllStudentCount();
}
