package com.eagleshing.miniprogram.controllers;

import javax.transaction.Transactional;

import com.eagleshing.miniprogram.payload.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.eagleshing.miniprogram.domain.CoverCollection;
import com.eagleshing.miniprogram.domain.MiniUser;
import com.eagleshing.miniprogram.domain.UserCollectionResponse;
import com.eagleshing.miniprogram.domain.mappers.CoverMapper;
import com.eagleshing.miniprogram.domain.repository.CollectionRepository;
import com.eagleshing.miniprogram.domain.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Set;


@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserRepository userHelper;
	
	@Autowired
	CollectionRepository collectionHelper;
	
	@Autowired
	CoverMapper coverMapper;
	
	@PostMapping("/collect")
	@Transactional
	public ResponseEntity<?> collect(@RequestBody CollectionRequest request){
		try {
			CoverCollection collection = collectionHelper.findByCoverIdAndUserId(request.getCoverId(), request.getUserId());
			if(collection==null) {
				collection = new CoverCollection();
				collection.setCoverId(request.getCoverId());
				collection.setUserId(request.getUserId());
				collection.setStatus((byte)0);
				collectionHelper.save(collection);
			}else {
				if(collection.getStatus()==-1) {
					collection.setStatus((byte)0);
					collectionHelper.save(collection);
				}
				return ResponseEntity.ok(true);
			}
			
			return ResponseEntity.ok(true);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getCause().getMessage());
		}
	}
	
	@PostMapping("/deletecollect")
	public ResponseEntity<?> deleteCollection(@RequestBody CollectionRequest request){
		try {
			CoverCollection collection;
			collection = collectionHelper.findByCoverIdAndUserId(request.getCoverId(), request.getUserId());
			if(collection==null) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Not found cover collection!");
			}
			collection.setStatus((byte)-1);
			collectionHelper.save(collection);
			return ResponseEntity.ok(false);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getCause().getMessage());
		}
	}

	@PostMapping("/deletecollections")
	public ResponseEntity<?> deleteCollections(@RequestBody CollectionsRequest request){
		try{
			String openId="";
			for (CollectionRequest collection: request.getCollections()) {
				openId = collection.getOpenId();
				CoverCollection coverCollection = collectionHelper.findByCoverIdAndUserId(collection.getCoverId(), collection.getUserId());
				if(coverCollection==null) {
					return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Not found cover collection!");
				}
				coverCollection.setStatus((byte)-1);
				collectionHelper.save(coverCollection);
			}
			UserCollectionResponse result = coverMapper.findCollection(openId);
			return ResponseEntity.ok(result);
		}catch (Exception e){
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getCause().getMessage());
		}
	}
	
	@GetMapping("/findcollection")
	public ResponseEntity<?> findCollection(String openId){
		try {
			UserCollectionResponse result = coverMapper.findCollection(openId);
			return ResponseEntity.ok(result);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getCause().getMessage());
		}
	}
	
	@GetMapping("/iscollected")
	public boolean isCollected(IsCollectedRequest request) {
		CoverCollection coverCollection = collectionHelper.findByCoverIdAndUserId(request.getCoverId(), request.getUserId());
		if(coverCollection!=null) {
			if(coverCollection.getStatus()==-1) {
				return false;
			}else {
				return true;
			}
		}else {
			return false;
		}
	}
	
	@PostMapping("/login")
	@Transactional
	public ResponseEntity<?> saveUser(@RequestBody LoginRequest request){
		try {
			String wxAuthenUrl = "https://api.weixin.qq.com/sns/jscode2session?appid=wx3994889fc2a4b078&secret=f0b1e1a14dbabf39ddb3acfb7abcae67&grant_type=authorization_code&js_code="+request.getCode();
			RestTemplate restTemplate = new RestTemplate();
			
			String resultStr = restTemplate.getForObject(wxAuthenUrl, String.class);

			ObjectMapper mapper = new ObjectMapper();
			OpenIdResponse result = mapper.readValue(resultStr,OpenIdResponse.class);
			
			MiniUser user;
			user = userHelper.findByOpenId(result.getOpenid());
			if(user == null) {
				user = new MiniUser();
				user.setAvatarUrl(request.getAvatarUrl());
				user.setNickName(request.getNickName());
				user.setCity(request.getCity());
				user.setGender(request.isGender());
				user.setLanguage(request.getLanguage());
				user.setProvince(request.getProvince());
				user.setOpenId(result.getOpenid());
				user = userHelper.save(user);
			}
			
			LoginResponse response = new LoginResponse();
			response.setAvatarUrl(user.getAvatarUrl());
			response.setCity(user.getCity());
			response.setGender(user.isGender());
			response.setNickName(user.getNickName());
			response.setOpenId(user.getOpenId());
			response.setProvince(user.getProvince());
			response.setUserId(user.getId());
			
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getCause().getMessage());
		}
	}
	
	
}
