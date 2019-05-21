package com.eagleshing.miniprogram.domain.repository;

import com.eagleshing.miniprogram.domain.MyUnlockedProject;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * MyUnlockProjectRepository
 */
public interface MyUnlockProjectRepository extends JpaRepository<MyUnlockedProject, Integer>{
    
}