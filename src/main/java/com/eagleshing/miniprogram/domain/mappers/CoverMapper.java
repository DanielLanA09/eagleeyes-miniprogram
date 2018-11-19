package com.eagleshing.miniprogram.domain.mappers;

import java.util.List;
import java.util.Set;

import com.eagleshing.miniprogram.domain.*;

public interface CoverMapper {
	
	List<CoverResponse> findAll(String devision,int mark,String district,int page,int size);
	
	Set<CoverResponse> findByDistrictAndPriceAndTag(String district,int minprice,int maxprice,String[] tags,int count,int page,int size,String title);

	Set<CoverResponse> findByDistrictAndPrice(String district,int minPrice,int maxPrice,int page,int size,String title);
	
	CoverResponse findById(int coverId);

	List<CoverResponse> findByPrice(float price,int page,int size);
	
	Set<CoverResponse> findByTitle(String title);
	
	Set<DevisionResponse> findDevisionParams(int coverId,String devType);
	
	Set<DevisionResponse> findAllDevisions(int coverId);
	
	Set<ModuleResponse> findModulesByName(int id,String devisionName);
	
	Set<CoverResponse> findArround(float latitude,float longitude);
	
	Set<ParamResponse> findParams(int devId);
	
	Set<Question> findQuestions();
	
	UserCollectionResponse findCollection(String openId);
	
	BusStation findBus(String station);
	
	List<HomeBlockResponse> findHomeBlock();

	List<HomeBlockResponse> findBlockByType(String blockType);

	List<HomeBlockResponse> findBlockByTypeAndTitle(String blockType, String title);

	List<CoverResponse> findHomeCovers(int page,int size);
	
}
