/**
 * ContentManagementServiceImpl.java
 */
package com.gnv.vnm.selfcare.core.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gnv.vnm.selfcare.core.enums.DataStatus;
import com.gnv.vnm.selfcare.core.enums.OperatingSystem;
import com.gnv.vnm.selfcare.core.metadata.DefaultContentCategoryMetaData;
import com.gnv.vnm.selfcare.core.model.AppsCategory;
import com.gnv.vnm.selfcare.core.model.AppsContent;
import com.gnv.vnm.selfcare.core.model.GameCategory;
import com.gnv.vnm.selfcare.core.model.GameContent;
import com.gnv.vnm.selfcare.core.model.MovieCategory;
import com.gnv.vnm.selfcare.core.model.MovieContent;
import com.gnv.vnm.selfcare.core.model.MusicCategory;
import com.gnv.vnm.selfcare.core.model.MusicContent;
import com.gnv.vnm.selfcare.core.service.ApplicationConfigurationService;
import com.gnv.vnm.selfcare.core.service.ContentManagementService;
import com.gnv.vnm.selfcare.dao.entity.AppsBannerEntity;
import com.gnv.vnm.selfcare.dao.entity.AppsCategoryEntity;
import com.gnv.vnm.selfcare.dao.entity.AppsEntity;
import com.gnv.vnm.selfcare.dao.entity.GameBannerEntity;
import com.gnv.vnm.selfcare.dao.entity.GameCategoryEntity;
import com.gnv.vnm.selfcare.dao.entity.GameEntity;
import com.gnv.vnm.selfcare.dao.entity.MetaDataEntity;
import com.gnv.vnm.selfcare.dao.entity.MovieBannerEntity;
import com.gnv.vnm.selfcare.dao.entity.MovieCategoryEntity;
import com.gnv.vnm.selfcare.dao.entity.MovieEntity;
import com.gnv.vnm.selfcare.dao.entity.MusicBannerEntity;
import com.gnv.vnm.selfcare.dao.entity.MusicCategoryEntity;
import com.gnv.vnm.selfcare.dao.entity.MusicEntity;
import com.gnv.vnm.selfcare.dao.entity.QAppsBannerEntity;
import com.gnv.vnm.selfcare.dao.entity.QAppsCategoryEntity;
import com.gnv.vnm.selfcare.dao.entity.QAppsEntity;
import com.gnv.vnm.selfcare.dao.entity.QGameBannerEntity;
import com.gnv.vnm.selfcare.dao.entity.QGameCategoryEntity;
import com.gnv.vnm.selfcare.dao.entity.QGameEntity;
import com.gnv.vnm.selfcare.dao.entity.QMovieBannerEntity;
import com.gnv.vnm.selfcare.dao.entity.QMovieCategoryEntity;
import com.gnv.vnm.selfcare.dao.entity.QMovieEntity;
import com.gnv.vnm.selfcare.dao.entity.QMusicBannerEntity;
import com.gnv.vnm.selfcare.dao.entity.QMusicCategoryEntity;
import com.gnv.vnm.selfcare.dao.entity.QMusicEntity;
import com.gnv.vnm.selfcare.dao.repo.AppsBannerRepository;
import com.gnv.vnm.selfcare.dao.repo.AppsCategoryRepository;
import com.gnv.vnm.selfcare.dao.repo.AppsRepository;
import com.gnv.vnm.selfcare.dao.repo.GameBannerRepository;
import com.gnv.vnm.selfcare.dao.repo.GameCategoryRepository;
import com.gnv.vnm.selfcare.dao.repo.GameRepository;
import com.gnv.vnm.selfcare.dao.repo.MovieBannerRepository;
import com.gnv.vnm.selfcare.dao.repo.MovieCategoryRepository;
import com.gnv.vnm.selfcare.dao.repo.MovieRepository;
import com.gnv.vnm.selfcare.dao.repo.MusicBannerRepository;
import com.gnv.vnm.selfcare.dao.repo.MusicCategoryRepository;
import com.gnv.vnm.selfcare.dao.repo.MusicRepository;
import com.querydsl.core.types.dsl.BooleanExpression;

/**
 * @author nandipinto
 *
 */

@Service("contentManagementService")
public class ContentManagementServiceImpl implements ContentManagementService {

	private static final Logger logger = LoggerFactory.getLogger(ContentManagementServiceImpl.class);
	
	@Autowired MusicCategoryRepository musicCategoryRepository;
	@Autowired MovieCategoryRepository movieCategoryRepository;
	@Autowired GameCategoryRepository gameCategoryRepository;
	@Autowired AppsCategoryRepository appsCategoryRepository;
	@Autowired MusicRepository musicRepository;
	@Autowired MovieRepository movieRepository;
	@Autowired GameRepository gameRepository;
	@Autowired AppsRepository appsRepository;
	@Autowired MusicBannerRepository musicBannerRepository;
	@Autowired MovieBannerRepository movieBannerRepository;
	@Autowired GameBannerRepository gameBannerRepository;
	@Autowired AppsBannerRepository appsBannerRepository;
	
	
	@Autowired ApplicationConfigurationService applicationConfigurationService;
	
	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.service.ContentManagementService#getMusicCategories(java.lang.String)
	 */
	@Override
	public List<MusicCategory> getMusicCategories() {

		List<MusicCategory> result = new ArrayList<>();
		
		try {
			Iterable<MusicCategoryEntity> list = musicCategoryRepository.findAll(QMusicCategoryEntity.musicCategoryEntity.displayOrder.asc());
			if (list != null){
				for (MusicCategoryEntity mce:list){
					Map<String, String> pmetadata = metaDataAsMap(mce.getMetadata());
					MusicCategory category = new MusicCategory(mce.getId(), mce.getParentCategoryId(), mce.getCode());
					
					category.setNameEN(mce.getNameEN());
					if (StringUtils.hasText(mce.getNameVI())){
						category.setNameVI(mce.getNameVI());
					}else{
						category.setNameVI(mce.getNameEN());
					}
					category.setDescriptionEN(category.getNameEN());
					category.setDescriptionVI(category.getNameVI());
					
					category.setSmallIcon(pmetadata.get(DefaultContentCategoryMetaData.ICON_SMALL.name()));
					category.setMediumIcon(pmetadata.get(DefaultContentCategoryMetaData.ICON_MEDIUM.name()));
					category.setLargeIcon(pmetadata.get(DefaultContentCategoryMetaData.ICON_LARGE.name()));

					Iterable<MusicCategoryEntity> sublist = musicCategoryRepository.findAll(QMusicCategoryEntity.musicCategoryEntity.parentCategoryId.eq(mce.getId()));
					if (sublist != null){
						for (MusicCategoryEntity sce:sublist){
							Map<String, String> smetadata = metaDataAsMap(sce.getMetadata());
							
							MusicCategory subcategory = new MusicCategory(sce.getId(), sce.getParentCategoryId(), sce.getCode());
							
							subcategory.setNameEN(sce.getNameEN());
							if (StringUtils.hasText(sce.getNameVI())){
								subcategory.setNameVI(sce.getNameVI());
							}else{
								subcategory.setNameVI(sce.getNameEN());
							}
							subcategory.setDescriptionEN(subcategory.getNameEN());
							subcategory.setDescriptionVI(subcategory.getNameVI());
														
							subcategory.setSmallIcon(smetadata.get(DefaultContentCategoryMetaData.ICON_SMALL.name()));
							subcategory.setMediumIcon(smetadata.get(DefaultContentCategoryMetaData.ICON_MEDIUM.name()));
							subcategory.setLargeIcon(smetadata.get(DefaultContentCategoryMetaData.ICON_LARGE.name()));
							
							category.getSubCategories().add(subcategory);
						}
					}
					
					result.add(category);
				}
			}
			
		} catch (Exception e) {
			logger.error("#getMusicCategories --- error when retrieving music categories!", e);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.service.ContentManagementService#getMovieCategories(java.lang.String)
	 */
	@Override
	public List<MovieCategory> getMovieCategories() {

		List<MovieCategory> result = new ArrayList<>();
		
		try {
			Iterable<MovieCategoryEntity> list = movieCategoryRepository.findAll(QMovieCategoryEntity.movieCategoryEntity.displayOrder.asc());
			if (list != null){
				for (MovieCategoryEntity mce:list){
					Map<String, String> pmetadata = metaDataAsMap(mce.getMetadata());
					MovieCategory category = new MovieCategory(mce.getId(), mce.getParentCategoryId(), mce.getCode());
					
					category.setNameEN(mce.getNameEN());
					if (StringUtils.hasText(mce.getNameVI())){
						category.setNameVI(mce.getNameVI());
					}else{
						category.setNameVI(mce.getNameEN());
					}
					category.setDescriptionEN(category.getNameEN());
					category.setDescriptionVI(category.getNameVI());
					
					category.setSmallIcon(pmetadata.get(DefaultContentCategoryMetaData.ICON_SMALL.name()));
					category.setMediumIcon(pmetadata.get(DefaultContentCategoryMetaData.ICON_MEDIUM.name()));
					category.setLargeIcon(pmetadata.get(DefaultContentCategoryMetaData.ICON_LARGE.name()));

					Iterable<MovieCategoryEntity> sublist = movieCategoryRepository.findAll(QMovieCategoryEntity.movieCategoryEntity.parentCategoryId.eq(mce.getId()));
					if (sublist != null){
						for (MovieCategoryEntity sce:sublist){
							Map<String, String> smetadata = metaDataAsMap(sce.getMetadata());
							
							MovieCategory subcategory = new MovieCategory(sce.getId(), sce.getParentCategoryId(), sce.getCode());
							
							subcategory.setNameEN(sce.getNameEN());
							if (StringUtils.hasText(sce.getNameVI())){
								subcategory.setNameVI(sce.getNameVI());
							}else{
								subcategory.setNameVI(sce.getNameEN());
							}
							subcategory.setDescriptionEN(subcategory.getNameEN());
							subcategory.setDescriptionVI(subcategory.getNameVI());
							
							subcategory.setSmallIcon(smetadata.get(DefaultContentCategoryMetaData.ICON_SMALL.name()));
							subcategory.setMediumIcon(smetadata.get(DefaultContentCategoryMetaData.ICON_MEDIUM.name()));
							subcategory.setLargeIcon(smetadata.get(DefaultContentCategoryMetaData.ICON_LARGE.name()));
							
							category.getSubCategories().add(subcategory);
						}
					}
					
					result.add(category);
				}
			}
		} catch (Exception e) {
			logger.error("#getMovieCategories --- error when retrieving movie categories!", e);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.service.ContentManagementService#getGameGategories(java.lang.String)
	 */
	@Override
	public List<GameCategory> getGameCategories() {

		List<GameCategory> result = new ArrayList<>();
		try {
			Iterable<GameCategoryEntity> list = gameCategoryRepository.findAll(QGameCategoryEntity.gameCategoryEntity.displayOrder.asc());
			if (list != null){
				for (GameCategoryEntity mce:list){
					Map<String, String> pmetadata = metaDataAsMap(mce.getMetadata());
					GameCategory category = new GameCategory(mce.getId(), mce.getParentCategoryId(), mce.getCode());

					category.setNameEN(mce.getNameEN());
					if (StringUtils.hasText(mce.getNameVI())){
						category.setNameVI(mce.getNameVI());
					}else{
						category.setNameVI(mce.getNameEN());
					}
					category.setDescriptionEN(category.getNameEN());
					category.setDescriptionVI(category.getNameVI());
					
					category.setSmallIcon(pmetadata.get(DefaultContentCategoryMetaData.ICON_SMALL.name()));
					category.setMediumIcon(pmetadata.get(DefaultContentCategoryMetaData.ICON_MEDIUM.name()));
					category.setLargeIcon(pmetadata.get(DefaultContentCategoryMetaData.ICON_LARGE.name()));

					Iterable<GameCategoryEntity> sublist = gameCategoryRepository.findAll(QGameCategoryEntity.gameCategoryEntity.parentCategoryId.eq(mce.getId()));
					if (sublist != null){
						for (GameCategoryEntity sce:sublist){
							Map<String, String> smetadata = metaDataAsMap(sce.getMetadata());
							
							GameCategory subcategory = new GameCategory(sce.getId(), sce.getParentCategoryId(), sce.getCode());
							
							subcategory.setNameEN(sce.getNameEN());
							if (StringUtils.hasText(sce.getNameVI())){
								subcategory.setNameVI(sce.getNameVI());
							}else{
								subcategory.setNameVI(sce.getNameEN());
							}
							subcategory.setDescriptionEN(subcategory.getNameEN());
							subcategory.setDescriptionVI(subcategory.getNameVI());
							
							subcategory.setSmallIcon(smetadata.get(DefaultContentCategoryMetaData.ICON_SMALL.name()));
							subcategory.setMediumIcon(smetadata.get(DefaultContentCategoryMetaData.ICON_MEDIUM.name()));
							subcategory.setLargeIcon(smetadata.get(DefaultContentCategoryMetaData.ICON_LARGE.name()));
							
							category.getSubCategories().add(subcategory);
						}
					}
					
					result.add(category);
				}
			}
		} catch (Exception e) {
			logger.error("#getGameGategories --- error when retrieving game categories!", e);
		}
		return result;
	}

	
	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.service.ContentManagementService#getAppsCategories(java.lang.String)
	 */
	@Override
	public List<AppsCategory> getAppsCategories() {

		List<AppsCategory> result = new ArrayList<>();
		try {
			Iterable<AppsCategoryEntity> list = appsCategoryRepository.findAll(QAppsCategoryEntity.appsCategoryEntity.displayOrder.asc());
			if (list != null){
				for (AppsCategoryEntity mce:list){
					Map<String, String> pmetadata = metaDataAsMap(mce.getMetadata());
					AppsCategory category = new AppsCategory(mce.getId(), mce.getParentCategoryId(), mce.getCode());

//					if (langCode.equalsIgnoreCase(SupportedLanguage.ENGLISH.code())){
//						category.setNameEN(mce.getNameEN());
//						
//					}else if (langCode.equalsIgnoreCase(SupportedLanguage.VIETNAMESE.code())){
//						if (StringUtils.hasText(mce.getNameVI())){
//							category.setNameVI(mce.getNameVI());
//						}else{
//							category.setNameVI(mce.getNameEN());
//						}
//					}
					category.setNameEN(mce.getNameEN());
					if (StringUtils.hasText(mce.getNameVI())){
						category.setNameVI(mce.getNameVI());
					}else{
						category.setNameVI(mce.getNameEN());
					}
					category.setDescriptionEN(category.getNameEN());
					category.setDescriptionVI(category.getNameVI());
					
					category.setSmallIcon(pmetadata.get(DefaultContentCategoryMetaData.ICON_SMALL.name()));
					category.setMediumIcon(pmetadata.get(DefaultContentCategoryMetaData.ICON_MEDIUM.name()));
					category.setLargeIcon(pmetadata.get(DefaultContentCategoryMetaData.ICON_LARGE.name()));

					Iterable<AppsCategoryEntity> sublist = appsCategoryRepository.findAll(QAppsCategoryEntity.appsCategoryEntity.parentCategoryId.eq(mce.getId()));
					if (sublist != null){
						for (AppsCategoryEntity sce:sublist){
							Map<String, String> smetadata = metaDataAsMap(sce.getMetadata());
							
							AppsCategory subcategory = new AppsCategory(sce.getId(), sce.getParentCategoryId(), sce.getCode());
							
//							if (langCode.equalsIgnoreCase(SupportedLanguage.ENGLISH.code())){
//								subcategory.setNameEN(sce.getNameEN());
//								
//							}else if (langCode.equalsIgnoreCase(SupportedLanguage.VIETNAMESE.code())){
//								if (StringUtils.hasText(sce.getNameVI())){
//									subcategory.setNameVI(sce.getNameVI());
//								}else{
//									subcategory.setNameVI(sce.getNameEN());
//								}
//							}	
							subcategory.setNameEN(sce.getNameEN());
							if (StringUtils.hasText(sce.getNameVI())){
								subcategory.setNameVI(sce.getNameVI());
							}else{
								subcategory.setNameVI(sce.getNameEN());
							}
							subcategory.setDescriptionEN(subcategory.getNameEN());
							subcategory.setDescriptionVI(subcategory.getNameVI());
							
							subcategory.setSmallIcon(smetadata.get(DefaultContentCategoryMetaData.ICON_SMALL.name()));
							subcategory.setMediumIcon(smetadata.get(DefaultContentCategoryMetaData.ICON_MEDIUM.name()));
							subcategory.setLargeIcon(smetadata.get(DefaultContentCategoryMetaData.ICON_LARGE.name()));
							
							category.getSubCategories().add(subcategory);
						}
					}
					
					result.add(category);
				}
			}
		} catch (Exception e) {
			logger.error("#getAppsCategories --- error when retrieving apps categories!", e);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.service.ContentManagementService#getMusicContents(java.lang.Integer, java.lang.String, org.springframework.data.domain.PageRequest)
	 */
	@Override
	public Page<MusicContent> getMusicContents(Integer categoryId, Pageable page) {

		List<MusicContent> result = new ArrayList<>();
		long total = 0;
		try {
			Page<MusicEntity> list = null;
			if (categoryId != null){
				list = musicRepository.findAll(QMusicEntity.musicEntity.category().isNotNull().and(QMusicEntity.musicEntity.category().id.eq(categoryId)), page);
			}else{
				list = musicRepository.findAll(page);
			}
			
			total = list.getTotalElements();
			
			for (MusicEntity me:list.getContent()){
				result.add(fromMusicEntity(me));
			}
		} catch (Exception e) {
			logger.error("#getMusicContents --- error retrieving music contents!", e);
		}
		return new PageImpl<>(result, page, total);
	}

	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.service.ContentManagementService#getMovieContents(java.lang.Integer, java.lang.String, org.springframework.data.domain.PageRequest)
	 */
	@Override
	public Page<MovieContent> getMovieContents(Integer categoryId, Pageable page) {

		List<MovieContent> result = new ArrayList<>();
		long total = 0;
		try {
			Page<MovieEntity> list = null;
			BooleanExpression expr = QMovieEntity.movieEntity.status.eq(DataStatus.ACTIVE.ordinal());
			if (categoryId != null){
				list = movieRepository.findAll(expr.and(QMovieEntity.movieEntity.category().isNotNull().and(QMovieEntity.movieEntity.category().id.eq(categoryId))), page);
			}else{
				list = movieRepository.findAll(expr, page);
			}
			total = list.getTotalElements();
			
			for (MovieEntity me:list){
				result.add(fromMovieEntity(me));
			}
		} catch (Exception e) {
			logger.error("#getMovieContents --- error retrieving movie contents!", e);
		}
		return new PageImpl<>(result, page, total);
	}

	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.service.ContentManagementService#getGameContents(java.lang.Integer, java.lang.String, org.springframework.data.domain.PageRequest)
	 */
	@Override
	public Page<GameContent> getGameContents(Integer categoryId, OperatingSystem osType, Pageable page) {

		List<GameContent> result = new ArrayList<>();
		long total = 0;
		BooleanExpression expr = QGameEntity.gameEntity.status.eq(DataStatus.ACTIVE.ordinal())
				.and(QGameEntity.gameEntity.supportedSystems.isNotNull())
				.and(QGameEntity.gameEntity.supportedSystems.trim().equalsIgnoreCase(osType.name())
						.or(QGameEntity.gameEntity.supportedSystems.equalsIgnoreCase(OperatingSystem.ALL.name())));
		try {
			Page<GameEntity> list = null;
			if (categoryId != null){
				expr = expr.and(QGameEntity.gameEntity.category().isNotNull().and(QGameEntity.gameEntity.category().id.eq(categoryId)));
				list = gameRepository.findAll(expr, page);
			}else{
				list = gameRepository.findAll(expr, page);
			}
			total = list.getTotalElements();
			for (GameEntity ge:list){
				result.add(fromGameEntity(ge));
			}
		} catch (Exception e) {
			logger.error("#getGameContents --- error retrieving game contents!", e);
		}
		return new PageImpl<>(result, page, total);
	}

	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.service.ContentManagementService#getAppsContents(java.lang.Integer, java.lang.String, org.springframework.data.domain.Pageable)
	 */
	@Override
	public Page<AppsContent> getAppsContents(Integer categoryId, OperatingSystem osType, Pageable page) {
		List<AppsContent> result = new ArrayList<>();
		long total = 0;
		
		BooleanExpression expr = QAppsEntity.appsEntity.status.eq(DataStatus.ACTIVE.ordinal())
				.and(QAppsEntity.appsEntity.supportedSystems.isNotNull())
				.and(QAppsEntity.appsEntity.supportedSystems.trim().equalsIgnoreCase(osType.name())
						.or(QAppsEntity.appsEntity.supportedSystems.equalsIgnoreCase(OperatingSystem.ALL.name())));
		try {
			Page<AppsEntity> list = null;
			if (categoryId != null){
				expr = expr.and(QAppsEntity.appsEntity.category().isNotNull().and(QAppsEntity.appsEntity.category().id.eq(categoryId)));
				list = appsRepository.findAll(expr, page);

			}else{
				list = appsRepository.findAll(expr, page);
			}
			
			total = list.getTotalElements();
			for (AppsEntity ae:list){
				result.add(fromAppsEntity(ae));
			}
		} catch (Exception e) {
			logger.error("#getAppsContents --- error retrieving apps contents!", e);
		}
		return new PageImpl<>(result, page, total);
	}

	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.service.ContentManagementService#getMusicContentDetailsById(java.lang.Integer, java.lang.String)
	 */
	@Override
	public MusicContent getMusicContentDetailsById(Integer id) {
		try {
			return fromMusicEntity(musicRepository.findOne(id));
		} catch (Exception e) {
			logger.error("#getMusicContentDetailsById --- error retrieving music content details, id= " + id, e);
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.service.ContentManagementService#getMoviceContentDetailsById(java.lang.Integer, java.lang.String)
	 */
	@Override
	public MovieContent getMovieContentDetailsById(Integer id) {

		try {
			return fromMovieEntity(movieRepository.findOne(id));
		} catch (Exception e) {
			logger.error("#getMovieeContentDetailsById --- error retrieving movie content details, id= " + id, e);
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.service.ContentManagementService#getGameContentDetailsById(java.lang.Integer, java.lang.String)
	 */
	@Override
	public GameContent getGameContentDetailsById(Integer id) {

		try {
			return fromGameEntity(gameRepository.findOne(id));
		} catch (Exception e) {
			logger.error("#getGameContentDetailsById --- error retrieving game content details, id= " + id, e);
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.service.ContentManagementService#getAppsContentDetailsById(java.lang.Integer, java.lang.String)
	 */
	@Override
	public AppsContent getAppsContentDetailsById(Integer id) {

		try {
			return fromAppsEntity(appsRepository.findOne(id));
		} catch (Exception e) {
			logger.error("#getAppsContentDetailsById --- error retrieiving apps content details, id= " + id, e);
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.service.ContentManagementService#getMusicContentDetailsByCode(java.lang.String, java.lang.String)
	 */
	@Override
	public MusicContent getMusicContentDetailsByCode(String code) {

		try {
			return fromMusicEntity(musicRepository.findOne(QMusicEntity.musicEntity.code.equalsIgnoreCase(code)));
		} catch (Exception e) {
			logger.error("#getMusicContentDetailsByCode --- error retrieving music content details, code= " + code, e);
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.service.ContentManagementService#getMoviceContentDetailsByCode(java.lang.String, java.lang.String)
	 */
	@Override
	public MovieContent getMovieContentDetailsByCode(String code) {

		try {
			return fromMovieEntity(movieRepository.findOne(QMovieEntity.movieEntity.code.equalsIgnoreCase(code)));
		} catch (Exception e) {
			logger.error("#getMovieeContentDetailsByCode --- error retrieving movie content details, code= " + code, e);
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.service.ContentManagementService#getGameContentDetailsByCode(java.lang.String, java.lang.String)
	 */
	@Override
	public GameContent getGameContentDetailsByCode(String code) {
		try {
			return fromGameEntity( gameRepository.findOne(QGameEntity.gameEntity.code.equalsIgnoreCase(code)));
		} catch (Exception e) {
			logger.error("#getGameContentDetailsByCode --- error retrieving game content details, code= " + code, e);
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.service.ContentManagementService#getAppsContentDetailsByCode(java.lang.String, java.lang.String)
	 */
	@Override
	public AppsContent getAppsContentDetailsByCode(String code) {
		try {
			return fromAppsEntity(appsRepository.findOne(QAppsEntity.appsEntity.code.equalsIgnoreCase(code)));
		} catch (Exception e) {
			logger.error("#getAppsContentDetailsByCode --- error retrieiving apps content details, code= " + code, e);
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.service.ContentManagementService#getPromotedMusicContents(java.lang.String)
	 */
	@Override
	public List<MusicContent> getPromotedMusicContents() {

		List<MusicContent> result = new ArrayList<>();
		try {
			Iterable<MusicBannerEntity> list = musicBannerRepository.findAll(QMusicBannerEntity.musicBannerEntity.id.desc());
			if (list != null){
				for (MusicBannerEntity mbe : list){
					MusicContent music = fromMusicEntity(musicRepository.findOne(mbe.getMusicId()));
					if (music != null) result.add(music);
				}
			}
		} catch (Exception e) {
			logger.error("#getPromotedMusicContents --- error retrieving music banner!", e);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.service.ContentManagementService#getPromotedMovieContents(java.lang.String)
	 */
	@Override
	public List<MovieContent> getPromotedMovieContents() {

		List<MovieContent> result = new ArrayList<>();
		try {
			Iterable<MovieBannerEntity> list = movieBannerRepository.findAll(QMovieBannerEntity.movieBannerEntity.id.asc());
			if (list != null){
				for (MovieBannerEntity mbe : list){
					MovieContent movie = fromMovieEntity(movieRepository.findOne(mbe.getMovieId()));
					if (movie != null) result.add(movie);
				}
			}
				
		} catch (Exception e) {
			logger.error("#getPromotedMovieContents --- error retrieving movie banner!", e);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.service.ContentManagementService#getPromotedGameContents(java.lang.String)
	 */
	@Override
	public List<GameContent> getPromotedGameContents() {
		
		List<GameContent> result = new ArrayList<>();
		try {
			Iterable<GameBannerEntity> list = gameBannerRepository.findAll(QGameBannerEntity.gameBannerEntity.id.desc());
			if (list != null){
				for (GameBannerEntity abe : list){
					GameContent game = fromGameEntity(gameRepository.findOne(abe.getGameId()));
					if (game != null) result.add(game);
				}
			}
		} catch (Exception e) {
			logger.error("#getPromotedGameContents --- error retrieving game banner!", e);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.service.ContentManagementService#getPromotedAppsContents(java.lang.String)
	 */
	@Override
	public List<AppsContent> getPromotedAppsContents() {
		List<AppsContent> result = new ArrayList<>();
		try {
			Iterable<AppsBannerEntity> list = appsBannerRepository.findAll(QAppsBannerEntity.appsBannerEntity.id.desc());
			if (list != null){
				for (AppsBannerEntity abe : list){
					AppsContent apps = fromAppsEntity(appsRepository.findOne(abe.getAppsId()));
					if (apps != null) result.add(apps);
				}
			}
		} catch (Exception e) {
			logger.error("#getPromotedAppsContents --- error retrieving apps banner!", e);
		}
		return result;
	}
	
	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.service.ContentManagementService#getRelatedMovieContents(java.lang.Integer, java.lang.Integer, java.lang.String, org.springframework.data.domain.Pageable)
	 */
	@Override
	public Page<MovieContent> getRelatedMovieContents(Integer categoryId, Integer movieId, 
			Pageable page) {
		
		List<MovieContent> result = new ArrayList<>();
		long total = 0;
		try {
			Page<MovieEntity> list = movieRepository.findAll(QMovieEntity.movieEntity.category().isNotNull().and(
					QMovieEntity.movieEntity.category().id.eq(categoryId).and(QMovieEntity.movieEntity.id.ne(movieId))), page);
			
			total = list.getTotalElements();
			
			for (MovieEntity me:list){
				result.add(fromMovieEntity(me));
			}
			
			Collections.shuffle(result);
		} catch (Exception e) {
			logger.error("#getRelatedMovieContents --- error retrieving related movie contents!", e);
		}
		return new PageImpl<>(result, page, total);
	}

	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.service.ContentManagementService#getRelatedGameContents(java.lang.Integer, java.lang.Integer, java.lang.String, org.springframework.data.domain.Pageable)
	 */
	@Override
	public Page<GameContent> getRelatedGameContents(Integer categoryId, Integer gameId, 
			Pageable page) {
		
		List<GameContent> result = new ArrayList<>();
		long total = 0;
		try {
			Page<GameEntity> list = gameRepository.findAll(QGameEntity.gameEntity.category().isNotNull().and(
					QGameEntity.gameEntity.category().id.eq(categoryId).and(QGameEntity.gameEntity.id.ne(gameId))), page);
			
			total = list.getTotalElements();
			
			for (GameEntity source:list){
				result.add(fromGameEntity(source));
			}
			
			Collections.shuffle(result);
		} catch (Exception e) {
			logger.error("#getRelatedGameContents --- error retrieving related game contents!", e);
		}
		return new PageImpl<>(result, page, total);
	}

	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.service.ContentManagementService#getRelatedAppsContents(java.lang.Integer, java.lang.Integer, java.lang.String, org.springframework.data.domain.Pageable)
	 */
	@Override
	public Page<AppsContent> getRelatedAppsContents(Integer categoryId, Integer appsId, 
			Pageable page) {
		
		List<AppsContent> result = new ArrayList<>();
		long total = 0;
		try {
			Page<AppsEntity> list = appsRepository.findAll(QAppsEntity.appsEntity.category().isNotNull().and(
					QAppsEntity.appsEntity.category().id.eq(categoryId).and(QAppsEntity.appsEntity.id.ne(appsId))), page);
			
			total = list.getTotalElements();
			
			for (AppsEntity source:list){
				result.add(fromAppsEntity(source));
			}
			
			Collections.shuffle(result);
		} catch (Exception e) {
			logger.error("#getRelatedMovieContents --- error retrieving related apps contents!", e);
		}
		return new PageImpl<>(result, page, total);
	}

	private MusicContent fromMusicEntity(MusicEntity source){
		if (source == null) return null;
		
		MusicCategoryEntity category = source.getCategory();
		
		MusicContent target = new MusicContent();
		target.setAlbumName(source.getAlbumName());
		target.setArtistName(source.getArtistName());
		target.setCategoryId(category != null ? category.getId() : null);
		target.setCode(source.getCode());
		target.setDefaultIcon(createImageURL(source.getDefaultIcon()));
		target.setDefaultImage(createImageURL(source.getDefaultImage()));
		target.setDuration(source.getDuration());
		target.setFormat(source.getFormat());
		target.setId(source.getId());
		target.setMetadata(metaDataAsMap(source.getMetadata()));
		target.setPreviewURL(source.getPreviewURL());
		target.setPrice(source.getPrice() != null ? source.getPrice().doubleValue() : 0);
		target.setQuality(source.getQuality());
		target.setReleaseDate(source.getReleaseDate());
		
		if (source.getReleaseDate() != null){
			Calendar cal = Calendar.getInstance();
			cal.setTime(source.getReleaseDate());
			target.setReleaseYear(cal.get(Calendar.YEAR));
		}
		
		target.setSourceURL(source.getSourceURL());
		target.setStatus(DataStatus.valueOf(source.getStatus()));

		target.setNameEN(source.getProductNameEN());
		target.setTitleEN(source.getDisplayNameEN());
		target.setDescriptionEN(source.getDescriptionEN());

		target.setNameVI(source.getProductNameVI());
		target.setTitleVI(source.getDisplayNameVI());
		target.setDescriptionVI(source.getDescriptionVI());

		if (category != null) {
			target.setCategoryNameEN(category.getNameEN());
			if (StringUtils.hasText(category.getNameVI())){
				target.setCategoryNameVI(category.getNameVI());
			}else{
				target.setCategoryNameVI(category.getNameEN());
			}
		}
		
		if (StringUtils.hasText(source.getDefaultBanner())){
			target.setDefaultBanner(createImageURL(source.getDefaultBanner()));
		}else{
			target.setDefaultBanner(createImageURL(source.getDefaultImage()));
		}

		if (StringUtils.hasText(source.getDefaultWebBanner())){
			target.setWebBanner(createImageURL(source.getDefaultWebBanner()));
		}else{
			target.setWebBanner(target.getDefaultBanner());
		}

		target.setSmallImage(target.getDefaultImage());
		target.setMediumImage(target.getDefaultImage());
		target.setLargeImage(target.getDefaultImage());
		target.setXlargeImage(target.getDefaultBanner());

		return target;
	}
	
	private MovieContent fromMovieEntity(MovieEntity source){
		if (source == null) return null;
		
		MovieCategoryEntity category = source.getCategory();
		MovieContent target = new MovieContent();
		target.setActors(source.getActors());
		target.setCategoryId(category != null ? category.getId() : null);
		target.setCode(source.getCode());
		target.setDefaultIcon(createImageURL(source.getDefaultIcon()));
		target.setDefaultImage(createImageURL(source.getDefaultImage()));
		
		if (StringUtils.hasText(source.getDefaultBanner())){
			target.setDefaultBanner(createImageURL(source.getDefaultBanner()));
		}else{
			target.setDefaultBanner(createImageURL(source.getDefaultImage()));
		}
		
		if (StringUtils.hasText(source.getDefaultWebBanner())){
			target.setWebBanner(createImageURL(source.getDefaultWebBanner()));
		}else{
			target.setWebBanner(target.getDefaultBanner());
		}

		target.setSmallImage(target.getDefaultImage());
		target.setMediumImage(target.getDefaultImage());
		target.setLargeImage(target.getDefaultImage());
		target.setXlargeImage(target.getDefaultBanner());

		target.setDirectors(source.getDirectors());
		target.setDuration(source.getDuration());
		target.setId(source.getId());
		target.setMetadata(metaDataAsMap(source.getMetadata()));
		target.setPreviewURL(source.getPreviewURL());
		target.setPrice(source.getPrice() != null ? source.getPrice().doubleValue() : 0);
		target.setProducers(source.getProducers());
		target.setReleaseDate(source.getReleaseDate());
		
		if (source.getReleaseDate() != null){
			Calendar cal = Calendar.getInstance();
			cal.setTime(source.getReleaseDate());
			target.setReleaseYear(cal.get(Calendar.YEAR));
		}
		
		target.setSourceURL(source.getSourceURL());
		target.setStatus(DataStatus.valueOf(source.getStatus()));

		target.setNameEN(source.getProductNameEN());
		target.setTitleEN(source.getDisplayNameEN());
		target.setDescriptionEN(source.getDescriptionEN());
		target.setStoryLineEN(source.getStoryLineEN());

		target.setNameVI(source.getProductNameVI());
		target.setTitleVI(source.getDisplayNameVI());
		target.setDescriptionVI(source.getDescriptionVI());
		if (StringUtils.hasText(source.getStoryLineVI())){
			target.setStoryLineVI(source.getStoryLineVI());
		}else{
			target.setStoryLineVI(source.getStoryLineEN());
		}
		
		if (category != null) {
			target.setCategoryNameEN(category.getNameEN());
			if (StringUtils.hasText(category.getNameVI())){
				target.setCategoryNameVI(category.getNameVI());
			}else{
				target.setCategoryNameVI(category.getNameEN());
			}
		}
		
		return target;
	}
	
	private GameContent fromGameEntity(GameEntity source){
		if (source == null) return null;
		
		GameCategoryEntity category = source.getCategory();
		GameContent target = new GameContent();
		target.setCategoryId(category != null ? category.getId() : null);
		target.setCode(source.getCode());
		target.setDefaultIcon(createImageURL(source.getDefaultIcon()));
		target.setDefaultImage(createImageURL(source.getDefaultImage()));
		
		if (StringUtils.hasText(source.getDefaultBanner())){
			target.setDefaultBanner(createImageURL(source.getDefaultBanner()));
		}else{
			target.setDefaultBanner(createImageURL(source.getDefaultImage()));
		}

		if (StringUtils.hasText(source.getDefaultWebBanner())){
			target.setWebBanner(createImageURL(source.getDefaultWebBanner()));
		}else{
			target.setWebBanner(target.getDefaultBanner());
		}

		target.setSmallImage(target.getDefaultImage());
		target.setMediumImage(target.getDefaultImage());
		target.setLargeImage(target.getDefaultImage());
		target.setXlargeImage(target.getDefaultBanner());

		target.setFileSize(source.getFileSize());
		target.setId(source.getId());
		target.setMetadata(metaDataAsMap(source.getMetadata()));
		target.setPreviewURL(source.getPreviewURL());
		target.setPrice(source.getPrice() != null ? source.getPrice().doubleValue() : 0);
		target.setProducers(source.getProducers());
		target.setAndroidProductURL(source.getAndroidSourceURL());
		target.setIosProductURL(source.getIosSourceURL());
		target.setStatus(DataStatus.valueOf(source.getStatus()));
		target.setSupportedSystems(source.getSupportedSystems());

		target.setDescriptionEN(source.getDescriptionEN());
		target.setNameEN(source.getProductNameEN());
		target.setNotesEN(source.getNotesEN());
		target.setTitleEN(source.getDisplayNameEN());
		
		target.setDescriptionVI(source.getDescriptionVI());
		target.setNameVI(source.getProductNameVI());
		target.setNotesVI(source.getNotesVI());
		target.setTitleVI(source.getDisplayNameVI());
		
		if (category != null) {
			target.setCategoryNameEN(category.getNameEN());
			if (StringUtils.hasText(category.getNameVI())){
				target.setCategoryNameVI(category.getNameVI());
			}else{
				target.setCategoryNameVI(category.getNameEN());
			}
		}
//		LoggingUtil.debug(logger, "#fromGameEntity --- " + source.getId() + ", result= " + target);
		return target;
	}
	
	private AppsContent fromAppsEntity(AppsEntity source){
		
		if (source == null) return null;
		
		AppsCategoryEntity category = source.getCategory();
		AppsContent target = new AppsContent();
		target.setCategoryId(category != null ? category.getId() : null);
		target.setCode(source.getCode());
		target.setDefaultIcon(createImageURL(source.getDefaultIcon()));
		target.setDefaultImage(createImageURL(source.getDefaultImage()));

		if (StringUtils.hasText(source.getDefaultBanner())){
			target.setDefaultBanner(createImageURL(source.getDefaultBanner()));
		}else{
			target.setDefaultBanner(createImageURL(source.getDefaultImage()));
		}
		if (StringUtils.hasText(source.getDefaultWebBanner())){
			target.setWebBanner(createImageURL(source.getDefaultWebBanner()));
		}else{
			target.setWebBanner(target.getDefaultBanner());
		}

		target.setSmallImage(target.getDefaultImage());
		target.setMediumImage(target.getDefaultImage());
		target.setLargeImage(target.getDefaultImage());
		target.setXlargeImage(target.getDefaultBanner());
		
		target.setFileSize(source.getFileSize());
		target.setId(source.getId());
		target.setMetadata(metaDataAsMap(source.getMetadata()));
		target.setPreviewURL(source.getPreviewURL());
		target.setPrice(source.getPrice() != null ? source.getPrice().doubleValue() : 0);
		target.setProducers(source.getProducers());
		target.setAndroidProductURL(source.getAndroidSourceURL());
		target.setIosProductURL(source.getIosSourceURL());
		target.setStatus(DataStatus.valueOf(source.getStatus()));
		target.setSupportedSystems(source.getSupportedSystems());

		target.setDescriptionEN(source.getDescriptionEN());
		target.setNameEN(source.getProductNameEN());
		target.setNotesEN(source.getNotesEN());
		target.setTitleEN(source.getDisplayNameEN());
		target.setDescriptionVI(source.getDescriptionVI());
		target.setNameVI(source.getProductNameVI());
		target.setNotesVI(source.getNotesVI());
		target.setTitleVI(source.getDisplayNameVI());

		if (category != null){
			target.setCategoryNameEN(category.getNameEN());
			if (StringUtils.hasText(category.getNameVI())){
				target.setCategoryNameVI(category.getNameVI());
			}else{
				target.setCategoryNameVI(category.getNameEN()); //fall back to EN
			}
		}
		
//		LoggingUtil.debug(logger, "#fromAppsEntity --- " + source.getId() + ", result= " + target);
		return target;
	}
	
	
	private Map<String, String> metaDataAsMap(Set<?> metadata){
		
		Map<String, String> map = new HashMap<>();
		if (metadata != null){
			Iterator<?> it = metadata.iterator();
			while (it.hasNext()){
				MetaDataEntity mde = (MetaDataEntity)it.next();
				if (mde.getValue() != null){
					if (mde.getName().startsWith(METADATA_NAME_ICON) || mde.getName().startsWith(METADATA_NAME_IMAGE)){
						map.put(mde.getName(), createImageURL(mde.getValue()));
					}else{
						map.put(mde.getName(), mde.getValue());
					}
				}
			}
		}
		return map;
	}
	
	private String createImageURL(String productImg){
		if (!StringUtils.hasText(productImg)) return "";
		
		String imageSvr = applicationConfigurationService.get("imageserver.url", "").toString();
		String imageDir = applicationConfigurationService.get("imageserver.imgdir", "").toString();
		
		return imageSvr + imageDir + productImg;
	}	
}
