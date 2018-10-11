package com.eagleshing.miniprogram.domain.mappers;

import java.util.List;
import java.util.Set;

import com.eagleshing.miniprogram.domain.CoverResponse;
import com.eagleshing.miniprogram.domain.DevisionResponse;
import com.eagleshing.miniprogram.domain.ModuleResponse;
import com.eagleshing.miniprogram.domain.ParamResponse;
import com.eagleshing.miniprogram.domain.Question;
import com.eagleshing.miniprogram.domain.UserCollectionResponse;

public interface CoverMapper {
	
	List<CoverResponse> findAll(String devision,int mark,String district,int page,int size);
	
	Set<CoverResponse> findByDistrictAndPriceAndTag(String district,int minprice,int maxprice,String[] tags,int count,int page,int size);
	
	CoverResponse findById(int coverId);
	
	Set<CoverResponse> findByTitle(String title);
	
	Set<DevisionResponse> findDevisionParams(int coverId,String devType);
	
	Set<DevisionResponse> findAllDevisions(int coverId);
	
	Set<ModuleResponse> findModulesByName(int id,String devisionName);
	
	Set<CoverResponse> findArround(float latitude,float longitude);
	
	Set<ParamResponse> findParams(int devId);
	
	Set<Question> findQuestions();
	
	UserCollectionResponse findCollection(String openId);
	
}
