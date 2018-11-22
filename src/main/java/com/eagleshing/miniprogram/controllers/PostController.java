package com.eagleshing.miniprogram.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;
import javax.validation.Valid;

import com.eagleshing.miniprogram.domain.*;
import com.eagleshing.miniprogram.domain.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eagleshing.miniprogram.domain.mappers.CoverMapper;
import com.eagleshing.miniprogram.payload.CoverFilterRequest;

@RestController
@RequestMapping("/post")
public class PostController {

	@Autowired
	private CoverMapper coverMapper;

	@Autowired
	private AccessRepository accessRepository;

	@Autowired
	private CoverRepository CoverRepository;
	
	@Autowired
	private EagleVavabularyRepository vacabularyRepository;

	@Autowired
	AdviceRepository adviceRepository;

	@Autowired
	ArticleLinkRepository linkRepository;



	@GetMapping("/filterbycondition")
	public ResponseEntity<?> findAll(CoverFilterRequest request) {
		try {
			List<CoverResponse> results = coverMapper.findAll(request.getDevision(), request.getMark(),
					request.getDistrict(), request.getPage() * request.getSize(), request.getSize());
			return ResponseEntity.ok(results);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getCause().getMessage());
		}
	}

	@GetMapping("/findbydistrictandpriceandtag")
	public ResponseEntity<?> findByDistrictAndPriceAndTag(CoverFilterRequest request) {
		try {
			Set<CoverResponse> results = new HashSet<>();
			if (request.getTags().length() > 0) {
				String[] tags = request.getTags().split(",");
				int count = tags.length;
				results = coverMapper.findByDistrictAndPriceAndTag(request.getDistrict(), request.getMinprice(),
						request.getMaxprice(), tags, count, request.getPage(), request.getSize(), request.getTitle());
			} else {
				results = coverMapper.findByDistrictAndPrice(request.getDistrict(), request.getMinprice(),
						request.getMaxprice(), request.getPage(), request.getSize(), request.getTitle());
			}
			return ResponseEntity.ok(results);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getCause().getMessage());
		}
	}

	@GetMapping("/findbydistrictandprice")
	public ResponseEntity<?> findByDistrictAndPriceAndTitle(CoverFilterRequest request) {
		try {
			Set<CoverResponse> results = coverMapper.findByDistrictAndPrice(request.getDistrict(),
					request.getMinprice(), request.getMaxprice(), request.getPage(), request.getSize(),
					request.getTitle());
			return ResponseEntity.ok(results);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getCause().getMessage());
		}
	}

	@GetMapping("/saveaccess")
	public ResponseEntity<?> saveAccess(AccessHistory request) {
		try {
			return ResponseEntity.ok(accessRepository.save(request));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getCause().getMessage());
		}
	}

	@GetMapping("/findbyid/{id}")
	public ResponseEntity<?> findById(@PathVariable int id) {
		try {
			CoverResponse result = coverMapper.findById(id);
			return ResponseEntity.ok(result);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getCause().getMessage());
		}
	}

	@GetMapping("/findbytitle/{title}")
	public ResponseEntity<?> findByTitle(@PathVariable String title) {
		try {
			Set<CoverResponse> result = coverMapper.findByTitle(title);
			return ResponseEntity.ok(result);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getCause().getMessage());
		}
	}

	/*
	 * FETCH ALL DEVISIONS AND THEIR PARAMS ACOORDING TO DEVISION TYPE AND COVER ID.
	 */
	@GetMapping("/finddevisionparams/{id}/{type}")
	public ResponseEntity<?> findDevisionsAndParams(@PathVariable int id, @PathVariable String type) {
		try {
			Set<DevisionResponse> results = coverMapper.findDevisionParams(id, type);
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
	public ResponseEntity<?> findAllDevisions(@PathVariable int coverId) {
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
	public ResponseEntity<?> findModuleByDevname(@PathVariable int cid, String devname) {
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
	public ResponseEntity<?> findArround(float latitude, float longitude) {
		try {
			return ResponseEntity.ok(coverMapper.findArround(latitude, longitude));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getCause().getMessage());
		}
	}

	@GetMapping("/findquestions")
	public ResponseEntity<?> findQuestions() {
		try {
			return ResponseEntity.ok(coverMapper.findQuestions());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getCause().getMessage());
		}
	}

	@GetMapping("/addviewpoint/{coverid}")
	public ResponseEntity<?> addViewPoint(@PathVariable int coverid) {
		try {
			return ResponseEntity.ok(CoverRepository.findById(coverid).map(c -> {
				c.setViewC(c.getViewC() + 1);
				return CoverRepository.save(c);
			}));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getCause().getMessage());
		}
	}
	
	@GetMapping("/getvacabulary")
	public ResponseEntity<?> getVacabulary(String title){
		try {
			List<EagleVacabulary> result = vacabularyRepository.findByTitle(title);
			return ResponseEntity.ok(result.get(0));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getCause().getMessage());
		}
	}
	
	@GetMapping("/findbus")
	public ResponseEntity<?> findBus(String station){
		try {
			BusStation busStation = coverMapper.findBus(station);
			return ResponseEntity.ok(busStation);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getCause().getMessage());
		}
	}

	@PostMapping("/advice")
	public ResponseEntity<?> saveAdvice(@Valid @RequestBody Advice advice){
		return ResponseEntity.ok(adviceRepository.save(advice));
	}

	@GetMapping("/homeblocks")
	public ResponseEntity<?> findHomeBlocks(){
		return ResponseEntity.ok(coverMapper.findHomeBlock());
	}

	@GetMapping("/findblock")
	public ResponseEntity<?> findBlockByType(String blockType){
		return ResponseEntity.ok(coverMapper.findBlockByType(blockType));
	}

	@GetMapping("/findblockbytypeandtype")
	public ResponseEntity<?> findBlockByTypeAndTitle(String blockType,String title){
		return ResponseEntity.ok(coverMapper.findBlockByTypeAndTitle(blockType,title));
	}

	@GetMapping("/homecovers")
	public ResponseEntity<?> findHomeCovers(int page,int size){
		return ResponseEntity.ok(coverMapper.findHomeCovers(page,size));
	}

	@GetMapping("/articlelinkviewadd")
	@Transactional
	public ResponseEntity<?> addLinkView(int id){
		ArticleLink link = linkRepository.findById(id).get();
		link.setView(link.getView()+1);
		return ResponseEntity.ok(linkRepository.save(link));
	}

	@GetMapping("/findCoverByPrice")
	public ResponseEntity<?> findCoverByPrice(float price,int page,int size){
		return  ResponseEntity.ok(coverMapper.findByPrice(price,page,size));
	}



}
