package com.eagleshing.miniprogram.domain.mappers;

import com.eagleshing.miniprogram.domain.question.QuestionResponse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface QuestionMapper {

    List<QuestionResponse> findHotQuestion(@Param("page")int page, @Param("size")int size);

    List<QuestionResponse> findMyQuestion(@Param("userId")int userId);
}
