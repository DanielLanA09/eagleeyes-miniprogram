package com.eagleshing.miniprogram.controllers;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eagleshing.miniprogram.domain.AccessHistory;
import com.eagleshing.miniprogram.domain.CoverResponse;
import com.eagleshing.miniprogram.domain.DevisionResponse;
import com.eagleshing.miniprogram.domain.mappers.CoverMapper;
import com.eagleshing.miniprogram.domain.repository.AccessRepository;
import com.eagleshing.miniprogram.payload.CoverFilterRequest;

@RestController
@RequestMapping("/post")
public class PostController {
	
	@Autowired
	private CoverMapper coverMapper;
	
	@Autowired
	private AccessRepository accessHelper;
	
	@GetMapping("/filterbycondition")
	public ResponseEntity<?> findAll(CoverFilterRequest request){
		try {
			List<CoverResponse> results = coverMapper.findAll(request.getDevision(),request.getMark(),
					request.getDistrict(),request.getPage()*request.getSize(),request.getSize());
			return ResponseEntity.ok(results);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getCause().getMessage());
		}
	}
	
	@GetMapping("/findbydistrictandpriceandtag")
	public ResponseEntity<?> findByDistrictAndPriceAndTag(CoverFilterRequest request){
		try {
			String[] tags = request.getTags().split(",");
			int count = tags.length;
			Set<CoverResponse> results = coverMapper.findByDistrictAndPriceAndTag(request.getDistrict(),request.getMinprice(),request.getMaxprice(),tags,count,request.getPage(),request.getSize());
			return ResponseEntity.ok(results);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getCause().getMessage());
		}
	}
	
	@GetMapping("/saveaccess")
	public ResponseEntity<?> saveAccess(AccessHistory request){
		try {
			return ResponseEntity.ok(accessHelper.save(request));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getCause().getMessage());
		}
	}
	
	@GetMapping("/findbyid/{id}")
	public ResponseEntity<?> findById(@PathVariable int id){
		try {
			CoverResponse result = coverMapper.findById(id);
			return ResponseEntity.ok(result);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getCause().getMessage());
		}
	}
	
	@GetMapping("/findbytitle/{title}")
	public ResponseEntity<?> findByTitle(@PathVariable String title){
		try {
			Set<CoverResponse> result = coverMapper.findByTitle(title);
			return ResponseEntity.ok(result);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getCause().getMessage());
		}
	}
	
	/*
	 * FETCH ALL DEVISIONS AND THEIR PARAMS ACOORDING TO DEVISION TYPE ADN COVER ID.
	 */
	@GetMapping("/finddevisionparams/{id}/{type}")
	public ResponseEntity<?> findDevisionsAndParams(@PathVariable int id,@PathVariable String type){
		try {
			Set<DevisionResponse> results = coverMapper.findDevisionParams(id,type);
			return ResponseEntity.ok(results);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getCause().getMessage());
		}
	}
	
	@GetMapping("/findparams/{devisionId}")
	public ResponseEntity<?> findParams(@PathVariable int devisionId) {
		try {
			return ResponseEntity.ok(coverMapper.findParams(devisionId));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getCause().getMessage());
		}
	}
	
	/*
	 * FETCH ONLY ALL DEVISIONS ACCORDING TO COVER ID.
	 */
	@GetMapping("/findalldevisions/{coverId}")
	public ResponseEntity<?> findAllDevisions(@PathVariable int coverId){
		try {
			return ResponseEntity.ok(coverMapper.findAllDevisions(coverId));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getCause().getMessage());
		}
	}
	
	/*
	 * FETCH ALL MODULES REFFER TO DEVISION NAME AND COVER ID.
	 */
	@GetMapping("/findmodulebyname/{cid}")
	public ResponseEntity<?> findModuleByDevname(@PathVariable int cid,String devname){
		try {
			return ResponseEntity.ok(coverMapper.findModulesByName(cid, devname));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getCause().getMessage());
		}
	}
	
	/*
	 * FETCH HOUSES NEAR BY.
	 */
	@GetMapping("/findarround")
	public ResponseEntity<?> findArround(float latitude,float longitude){
		try {
			return ResponseEntity.ok(coverMapper.findArround(latitude, longitude));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getCause().getMessage());
		}
	}
	
	@GetMapping("/findquestions")
	public ResponseEntity<?> findQuestions(){
		try {
			return ResponseEntity.ok(coverMapper.findQuestions());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getCause().getMessage());
		}
	}
	
}
