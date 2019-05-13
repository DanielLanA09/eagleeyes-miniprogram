package com.eagleshing.miniprogram.domain.repository;

import com.eagleshing.miniprogram.domain.WxToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WxTokenRepository extends JpaRepository<WxToken,Integer> {
}
