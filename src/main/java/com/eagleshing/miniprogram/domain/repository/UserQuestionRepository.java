package com.eagleshing.miniprogram.domain.repository;

import com.eagleshing.miniprogram.domain.UserQuestion;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserQuestionRepository extends JpaRepository<UserQuestion,Integer> {
    List<UserQuestion> findByViewPointGreaterThan(int point, Pageable pageable);
}
