package com.eagleshing.miniprogram.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eagleshing.miniprogram.domain.CoverCollection;

public interface CollectionRepository extends JpaRepository<CoverCollection, Integer>{
	CoverCollection findByCoverIdAndUserId(int coverId,int userId);
}
