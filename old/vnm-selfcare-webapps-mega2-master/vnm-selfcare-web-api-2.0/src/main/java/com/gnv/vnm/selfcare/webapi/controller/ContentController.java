/**
 * ContentController.java
 */
package com.gnv.vnm.selfcare.webapi.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gnv.vnm.selfcare.core.AppDefaultValues;
import com.gnv.vnm.selfcare.core.enums.OperatingSystem;
import com.gnv.vnm.selfcare.core.model.AppsCategory;
import com.gnv.vnm.selfcare.core.model.AppsContent;
import com.gnv.vnm.selfcare.core.model.GameCategory;
import com.gnv.vnm.selfcare.core.model.GameContent;
import com.gnv.vnm.selfcare.core.model.MovieCategory;
import com.gnv.vnm.selfcare.core.model.MovieContent;
import com.gnv.vnm.selfcare.core.model.MusicCategory;
import com.gnv.vnm.selfcare.core.model.MusicContent;

/**
 * @author nandipinto
 *
 */

@RestController
@RequestMapping("/content")
public class ContentController extends BaseRestController {
	
	private static final int PREVIEW_ITEMS_CNT = 3;
	
	@GetMapping("/music/categories")
	public ResponseEntity<?> getMusicCategories(){
		
		List<MusicCategory> categories = contentManagementService.getMusicCategories();
		//add content previews
		
		for (MusicCategory cat : categories) {
			PageRequest pageRequest = new PageRequest(0, PREVIEW_ITEMS_CNT, new Sort(Direction.ASC, "code"));
			Page<MusicContent> musicList = contentManagementService.getMusicContents(cat.getId(), pageRequest);
			
			cat.setContents(musicList.getContent());
		}
		return new ResponseEntity<>(categories, HttpStatus.OK);
	}
	
	@GetMapping("/music/list/{categoryId}/{page}")
	public ResponseEntity<?> getMusicList(@PathVariable int categoryId, @PathVariable int page){
		
		if (page > 0) page = page - 1;
		PageRequest pageRequest = new PageRequest(page, getPageSize(), new Sort(Direction.ASC, "code"));
		Page<MusicContent> musicList = contentManagementService.getMusicContents(categoryId, pageRequest);
		
		return new ResponseEntity<>(musicList, HttpStatus.OK);
	}
	
	@GetMapping("/music/details/{code}")
	public ResponseEntity<?> getMusicDetails(@PathVariable String code){
		return new ResponseEntity<>(contentManagementService.getMusicContentDetailsByCode(code), HttpStatus.OK);
	}

	@GetMapping("/movie/categories")
	public ResponseEntity<?> getMovieCategories(){
		
		List<MovieCategory> categories = contentManagementService.getMovieCategories();
		for (MovieCategory cat : categories) {
			PageRequest pageRequest = new PageRequest(0, PREVIEW_ITEMS_CNT, new Sort(Direction.ASC, "code"));
			Page<MovieContent> movieList = contentManagementService.getMovieContents(cat.getId(), pageRequest);
			
			cat.setContents(movieList.getContent());
		}
		return new ResponseEntity<>(categories, HttpStatus.OK);
	}
	
	@GetMapping("/movie/list/{categoryId}/{page}")
	public ResponseEntity<?> getMovieList(@PathVariable int categoryId, @PathVariable int page){
		
		if (page > 0) page = page - 1;
		PageRequest pageRequest = new PageRequest(page, getPageSize(), new Sort(Direction.ASC, "code"));
		Page<MovieContent> movieList = contentManagementService.getMovieContents(categoryId, pageRequest);
		
		return new ResponseEntity<>(movieList, HttpStatus.OK);
	}
	
	@GetMapping("/movie/details/{code}")
	public ResponseEntity<?> getMovieDetails(@PathVariable String code){
		return new ResponseEntity<>(contentManagementService.getMovieContentDetailsByCode(code), HttpStatus.OK);
	}

	@GetMapping("/game/categories/{osType}")
	public ResponseEntity<?> getGameCategories(@PathVariable String osType){
		
		List<GameCategory> categories = contentManagementService.getGameCategories();
		OperatingSystem os = OperatingSystem.ALL;
		try {
			os = OperatingSystem.valueOf(osType.trim().toUpperCase());
		} catch (Exception e) {}

		for (GameCategory cat : categories) {
			PageRequest pageRequest = new PageRequest(0, PREVIEW_ITEMS_CNT, new Sort(Direction.ASC, "code"));
			Page<GameContent> gameList = contentManagementService.getGameContents(cat.getId(), os, pageRequest);
			
			cat.setContents(gameList.getContent());
		}
		return new ResponseEntity<>(categories, HttpStatus.OK);
	}

	@GetMapping("/game/list/{categoryId}/{page}/{osType}")
	public ResponseEntity<?> getGameList(@PathVariable int categoryId, @PathVariable int page, @PathVariable String osType){
		
		if (page > 0) page = page - 1;
		PageRequest pageRequest = new PageRequest(page, getPageSize(), new Sort(Direction.ASC, "code"));
		
		OperatingSystem os = OperatingSystem.ALL;
		try {
			os = OperatingSystem.valueOf(osType.trim().toUpperCase());
		} catch (Exception e) {}

		Page<GameContent> gameList = contentManagementService.getGameContents(categoryId, os, pageRequest);
		
		return new ResponseEntity<>(gameList, HttpStatus.OK);
	}
	
	@GetMapping("/game/details/{code}")
	public ResponseEntity<?> getGameDetails(@PathVariable String code){
		return new ResponseEntity<>(contentManagementService.getGameContentDetailsByCode(code), HttpStatus.OK);
	}
	
	@GetMapping("/apps/categories/{osType}")
	public ResponseEntity<?> getAppsCategories(@PathVariable String osType){
		
		List<AppsCategory> categories = contentManagementService.getAppsCategories();
		OperatingSystem os = OperatingSystem.ALL;
		try {
			os = OperatingSystem.valueOf(osType.trim().toUpperCase());
		} catch (Exception e) {}

		for (AppsCategory cat : categories) {
			PageRequest pageRequest = new PageRequest(0, PREVIEW_ITEMS_CNT, new Sort(Direction.ASC, "code"));
			Page<AppsContent> appsList = contentManagementService.getAppsContents(cat.getId(), os, pageRequest);
			
			cat.setContents(appsList.getContent());
		}
		return new ResponseEntity<>(categories, HttpStatus.OK);
	}
	
	@GetMapping("/apps/list/{categoryId}/{page}/{osType}")
	public ResponseEntity<?> getAppsList(@PathVariable int categoryId, @PathVariable int page, @PathVariable String osType){
		
		if (page > 0) page = page - 1;
		PageRequest pageRequest = new PageRequest(page, getPageSize(), new Sort(Direction.ASC, "code"));
		
		OperatingSystem os = OperatingSystem.ALL;
		try {
			os = OperatingSystem.valueOf(osType.trim().toUpperCase());
		} catch (Exception e) {}
		Page<AppsContent> appsList = contentManagementService.getAppsContents(categoryId, os, pageRequest);
		
		return new ResponseEntity<>(appsList, HttpStatus.OK);
	}
	
	@GetMapping("/apps/details/{code}")
	public ResponseEntity<?> getAppsDetails(@PathVariable String code){
		return new ResponseEntity<>(contentManagementService.getAppsContentDetailsByCode(code), HttpStatus.OK);
	}
	
	@GetMapping("/music/banner")
	public ResponseEntity<?> getMusicBanner(){
		return new ResponseEntity<>(contentManagementService.getPromotedMusicContents(), HttpStatus.OK);
	}
	
	@GetMapping("/movie/banner")
	public ResponseEntity<?> getMovieBanner(){
		return new ResponseEntity<>(contentManagementService.getPromotedMovieContents(), HttpStatus.OK);
	}
	
	@GetMapping("/game/banner")
	public ResponseEntity<?> getGameBanner(){
		return new ResponseEntity<>(contentManagementService.getPromotedGameContents(), HttpStatus.OK);
	}
	
	@GetMapping("/apps/banner")
	public ResponseEntity<?> getAppsBanner(){
		return new ResponseEntity<>(contentManagementService.getPromotedAppsContents(), HttpStatus.OK);
	}
	
	private int getPageSize(){
		return Integer.parseInt(applicationConfigurationService.get("pagedlist.itemsperpage.all", AppDefaultValues.PAGED_LIST_SIZE + "").toString());
	}
	
}
