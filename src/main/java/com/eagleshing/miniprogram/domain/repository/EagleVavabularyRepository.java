package com.eagleshing.miniprogram.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eagleshing.miniprogram.domain.EagleVacabulary;

public interface EagleVavabularyRepository extends JpaRepository<EagleVacabulary, Integer> {
	
	List<EagleVacabulary> findByTitle(String title);

}
