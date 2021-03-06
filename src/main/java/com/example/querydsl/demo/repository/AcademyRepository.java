package com.example.querydsl.demo.repository;

import javax.transaction.Transactional;

import com.example.querydsl.demo.model.Academy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface AcademyRepository extends JpaRepository<Academy, Long>, AcademyRepositoryCustom {

	@Transactional
	@Modifying
	@Query(value = "DELETE FROM academy", nativeQuery = true)
	int deleteAllBy();
}
