package com.eagleshing.miniprogram.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eagleshing.miniprogram.domain.AccessHistory;

public interface AccessRepository extends JpaRepository<AccessHistory, Integer>{

}
