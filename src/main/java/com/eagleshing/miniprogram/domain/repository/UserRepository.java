package com.eagleshing.miniprogram.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eagleshing.miniprogram.domain.MiniUser;

public interface UserRepository extends JpaRepository<MiniUser,Integer>{
	MiniUser findByOpenId(String openid);
}
