package com.eagleshing.miniprogram.domain.repository;

import com.eagleshing.miniprogram.domain.UserAnswer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAnswerRepository extends JpaRepository<UserAnswer,Integer> {
}
