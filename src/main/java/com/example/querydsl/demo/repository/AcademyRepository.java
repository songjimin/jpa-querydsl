package com.example.querydsl.demo.repository;

import com.example.querydsl.demo.model.Academy;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AcademyRepository extends JpaRepository<Academy, Long>, AcademyRepositoryCustom {
}
