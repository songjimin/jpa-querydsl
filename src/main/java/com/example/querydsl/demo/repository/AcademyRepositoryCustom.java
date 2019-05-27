package com.example.querydsl.demo.repository;

import java.util.List;

import com.example.querydsl.demo.model.Academy;

public interface AcademyRepositoryCustom {
	List<Academy> findByName(String name);
}
