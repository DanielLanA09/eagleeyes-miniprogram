package com.eagleshing.miniprogram.controllers;

import com.eagleshing.miniprogram.domain.UserQuestion;
import com.eagleshing.miniprogram.domain.mappers.QuestionMapper;
import com.eagleshing.miniprogram.domain.repository.UserAnswerRepository;
import com.eagleshing.miniprogram.domain.repository.UserQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    UserQuestionRepository userQuestionRepository;

    @Autowired
    UserAnswerRepository userAnswerRepository;

    @Autowired
    QuestionMapper questionMapper;

    @PostMapping("/commit")
    public ResponseEntity<?> commitQuestion(@Valid @RequestBody UserQuestion question){
        if(question.getQuestion().length()<5){
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("文字太短，请输入至少10个字符");
        }
        return ResponseEntity.ok(userQuestionRepository.save(question));
    }

    @GetMapping("/questions")
    public ResponseEntity<?> findQuestions(Pageable pageable){
        return ResponseEntity.ok(questionMapper.findHotQuestion(pageable.getPageNumber(),pageable.getPageSize()));
    }


}
