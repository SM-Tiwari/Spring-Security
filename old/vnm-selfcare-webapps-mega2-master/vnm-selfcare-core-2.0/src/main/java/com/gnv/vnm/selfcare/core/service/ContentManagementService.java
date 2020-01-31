/**
 * ContentManagementService.java
 */
package com.gnv.vnm.selfcare.core.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

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
public interface ContentManagementService {
	
	public static final String METADATA_NAME_ICON	= "ICON_";
	public static final String METADATA_NAME_IMAGE 	= "IMAGE_";

	
	List<MusicCategory> getMusicCategories();
	
	List<MovieCategory> getMovieCategories();
	
	List<GameCategory> getGameCategories();
	
	List<AppsCategory> getAppsCategories();
	
	Page<MusicContent> getMusicContents(Integer categoryId, Pageable page);
	
	Page<MovieContent> getMovieContents(Integer categoryId, Pageable page);
	
	Page<GameContent> getGameContents(Integer categoryId, OperatingSystem osType, Pageable page);
	
	Page<AppsContent> getAppsContents(Integer categoryId, OperatingSystem osType, Pageable page);
	
	MusicContent getMusicContentDetailsById(Integer id);
	
	MovieContent getMovieContentDetailsById(Integer id);
	
	GameContent getGameContentDetailsById(Integer id);
	
	AppsContent getAppsContentDetailsById(Integer id);

	MusicContent getMusicContentDetailsByCode(String code);
	
	MovieContent getMovieContentDetailsByCode(String code);
	
	GameContent getGameContentDetailsByCode(String code);
	
	AppsContent getAppsContentDetailsByCode(String code);

	List<MusicContent> getPromotedMusicContents();
	
	List<MovieContent> getPromotedMovieContents();
	
	List<GameContent> getPromotedGameContents();
	
	List<AppsContent> getPromotedAppsContents();
	
	Page<MovieContent> getRelatedMovieContents(Integer categoryId, Integer movieId, Pageable page);
	Page<GameContent> getRelatedGameContents(Integer categoryId, Integer gameId, Pageable page);
	Page<AppsContent> getRelatedAppsContents(Integer categoryId, Integer appsId, Pageable page);
}
