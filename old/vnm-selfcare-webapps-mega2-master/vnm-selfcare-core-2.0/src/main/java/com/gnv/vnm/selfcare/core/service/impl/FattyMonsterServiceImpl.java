package com.gnv.vnm.selfcare.core.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.gnv.vnm.selfcare.core.AppDefaultValues;
import com.gnv.vnm.selfcare.core.adapter.BackEndAdapterResponse;
import com.gnv.vnm.selfcare.core.adapter.loyalty.ws.RedeemPoint;
import com.gnv.vnm.selfcare.core.enums.RequestStatus;
import com.gnv.vnm.selfcare.core.model.FattyMonsterDetails;
import com.gnv.vnm.selfcare.core.model.FattyRedeemPointRequest;
import com.gnv.vnm.selfcare.core.model.TopUpHistory;
import com.gnv.vnm.selfcare.core.service.ApplicationConfigurationService;
import com.gnv.vnm.selfcare.core.service.BackEndRequestProcessor;
import com.gnv.vnm.selfcare.core.service.FattyMonsterService;
import com.gnv.vnm.selfcare.core.utils.AppUtils;
import com.gnv.vnm.selfcare.core.utils.Constant;
import com.gnv.vnm.selfcare.core.utils.Constant.FattyRedeemStatus;
import com.gnv.vnm.selfcare.core.utils.Constant.FattyWeight;
import com.gnv.vnm.selfcare.dao.entity.FattyItemMappingsEntity;
import com.gnv.vnm.selfcare.dao.entity.FattyRedeemEntity;
import com.gnv.vnm.selfcare.dao.entity.QFattyItemMappingsEntity;
import com.gnv.vnm.selfcare.dao.entity.QFattyRedeemEntity;
import com.gnv.vnm.selfcare.dao.repo.FattyKeywordMappingsRepository;
import com.gnv.vnm.selfcare.dao.repo.FattyRedeemRepository;
import com.querydsl.core.types.Order;

/**
 * This class is implementation of FattyMonsterService.
 * 
 * @author kuldeep Singh
 *
 */
@Component
public class FattyMonsterServiceImpl implements FattyMonsterService {
	/**
	 * Instance of Logger {@link Logger}
	 */
	private static final Logger logger = LoggerFactory.getLogger(FattyMonsterServiceImpl.class);

	@Autowired
	protected BackEndRequestProcessor backEndRequestProcessor;

	@Autowired
	private ApplicationConfigurationService applicationConfigurationService;

	@Autowired
	private FattyKeywordMappingsRepository fattyKeywordMappingsRepository;

	@Autowired
	private FattyRedeemRepository fattyRedeemRepository;

	/**
	 * This method is used for fetch fatty monster details based msisdn
	 * 
	 * @param msisdn
	 *            {@link String}
	 * @return {@link FattyMonster}
	 * @author kuldeep.singh
	 */
	public FattyMonsterDetails getFattyMonsterDetailsBasedOnMsisdn(String msisdn,
			FattyMonsterDetails fattyMonsterDetails) {
		try {
			logger.info("Inside FattyMonsterServiceImpl in getFattyMonsterDetailsBasedOnMsisdn method :::::");

			int point = backEndRequestProcessor.getFattyPoint(msisdn);

			/* point=fattyMonsterDetails.getPoint(); */
			/*
			 * get monster level based on pont
			 */
			int weight = getMonsterFattyWeightBasedOnPoints(point);
			FattyItemMappingsEntity fattyItemMappingsEntity = fattyKeywordMappingsRepository
					.findOne(QFattyItemMappingsEntity.fattyItemMappingsEntity.monsterWeight.eq(weight));
			if ((fattyItemMappingsEntity != null) && fattyItemMappingsEntity.getFattyStatus()==1) {
				fattyMonsterDetails.setPoint(point);
				fattyMonsterDetails.setDisplayNameEn(fattyItemMappingsEntity.getDisplayNameEN());
				fattyMonsterDetails.setDisplayNameVi(fattyItemMappingsEntity.getDisplayNameVI());
				fattyMonsterDetails.setProductName(fattyItemMappingsEntity.getProductName());
				fattyMonsterDetails.setFattyImageUrl(createFattyImageURL(fattyItemMappingsEntity.getMonsterImage()));
				fattyMonsterDetails.setWeight(fattyItemMappingsEntity.getMonsterWeight() + " KG");
				fattyMonsterDetails.setRemainingDays(Constant.getDaysRemainingInCurrentMonth());
				fattyMonsterDetails.setKeyward(fattyItemMappingsEntity.getKeyword());
                fattyMonsterDetails.setSuccessMessageEn(fattyItemMappingsEntity.getMessageEn());
                fattyMonsterDetails.setSuccessMessageVi(fattyItemMappingsEntity.getMessageVi());
				fattyMonsterDetails.setLevel(fattyItemMappingsEntity.getLevel());
				List<FattyRedeemEntity> fattyRedeemLists = new ArrayList<>();
				Iterable<FattyRedeemEntity> list = fattyRedeemRepository
						.findAll(QFattyRedeemEntity.fattyRedeemEntity.msisdn.eq(msisdn)
								.and(QFattyRedeemEntity.fattyRedeemEntity.createTimestamp
										.goe(getFirstDateOfCurrentMonth()))
								.and(QFattyRedeemEntity.fattyRedeemEntity.status.eq(1))
								.and(QFattyRedeemEntity.fattyRedeemEntity.status.eq(1)));

				if (list != null) {
					Iterator<FattyRedeemEntity> fattyRedeemList = list.iterator();
					fattyRedeemList.forEachRemaining(fattyRedeemLists::add);
					if (fattyRedeemLists != null) {
						/*
						 * Sort List based on CreateTimeStamp .
						 */
						List<FattyRedeemEntity> sortedFattyItemMapping = fattyRedeemLists.stream()
								.sorted(Comparator.comparing(FattyRedeemEntity::getCreateTimestamp).reversed())
								.collect(Collectors.toList());
						/*
						 * Get First Object from sorted List.
						 */
						if (sortedFattyItemMapping.size() > 0) {
							FattyRedeemEntity fattyRedeemEntity = sortedFattyItemMapping.get(0);
							/*
							 * check redeem level and current level() .
							 */
							if (fattyMonsterDetails.getLevel() > fattyRedeemEntity.getLevel()) {
								fattyMonsterDetails.setAvilableForRedeem(true);
							} 
							else
							{
								/*
								 * Get Fatty Monster details based post redeem level .
								 * */
								FattyItemMappingsEntity postredeemFattyDetails = fattyKeywordMappingsRepository
										.findOne(QFattyItemMappingsEntity.fattyItemMappingsEntity.level.eq(fattyRedeemEntity.getLevel()));
								if (postredeemFattyDetails != null) {
									fattyMonsterDetails.setPoint(point);
									fattyMonsterDetails.setDisplayNameEn(postredeemFattyDetails.getDisplayNameEN());
									fattyMonsterDetails.setDisplayNameVi(postredeemFattyDetails.getDisplayNameVI());
									fattyMonsterDetails.setProductName(postredeemFattyDetails.getProductName());
									fattyMonsterDetails.setFattyImageUrl(createFattyImageURL(postredeemFattyDetails.getMonsterImage()));
									fattyMonsterDetails.setWeight(postredeemFattyDetails.getMonsterWeight() + " KG");
									fattyMonsterDetails.setRemainingDays(Constant.getDaysRemainingInCurrentMonth());
									fattyMonsterDetails.setKeyward(postredeemFattyDetails.getKeyword());
									fattyMonsterDetails.setAvilableForRedeem(false);
									fattyMonsterDetails.setLevel(postredeemFattyDetails.getLevel());
									fattyMonsterDetails.setSuccessMessageEn(postredeemFattyDetails.getMessageEn());
					                fattyMonsterDetails.setSuccessMessageVi(postredeemFattyDetails.getMessageVi());
								}
							}
						}
					}

				}
				// Boolean status = getCurrentMonthRedeemOffer(msisdn);
				if (fattyItemMappingsEntity.getLevel() == 1)
					fattyMonsterDetails.setAvilableForRedeem(false);
			}
			fattyMonsterDetails.setExpdate("2018-11-29");
			//fattyMonsterDetails.setRemainingDays(2);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return fattyMonsterDetails;
	}

	/**
	 * This method is used for fetch fatty monster details based msisdn
	 * 
	 * @param msisdn
	 *            {@link String}
	 * @return {@link FattyMonster}
	 * @author kuldeep.singh
	 */
	public FattyMonsterDetails getFattyMonsterLevel(String msisdn, FattyMonsterDetails fattyMonsterDetails) {
		try {
			logger.info("Inside FattyMonsterServiceImpl in getFattyMonsterDetailsBasedOnMsisdn method :::::");

			int point = backEndRequestProcessor.getFattyPoint(msisdn);
			/*
			 * get monster level based on pont
			 */
			int weight = getMonsterFattyWeightBasedOnPoints(point);

			FattyItemMappingsEntity fattyItemMappingsEntity = fattyKeywordMappingsRepository
					.findOne(QFattyItemMappingsEntity.fattyItemMappingsEntity.monsterWeight.eq(weight));
			if (fattyItemMappingsEntity != null) {
				fattyMonsterDetails.setPoint(point);
				fattyMonsterDetails.setDisplayNameEn(fattyItemMappingsEntity.getDisplayNameEN());
				fattyMonsterDetails.setDisplayNameVi(fattyItemMappingsEntity.getDisplayNameVI());
				fattyMonsterDetails.setProductName(fattyItemMappingsEntity.getProductName());
				fattyMonsterDetails.setFattyImageUrl(createFattyImageURL(fattyItemMappingsEntity.getMonsterImage()));
				fattyMonsterDetails.setWeight(fattyItemMappingsEntity.getMonsterWeight() + " KG");
				fattyMonsterDetails.setRemainingDays(Constant.getDaysRemainingInCurrentMonth());
				fattyMonsterDetails.setKeyward(fattyItemMappingsEntity.getKeyword());
				fattyMonsterDetails.setLevel(fattyItemMappingsEntity.getLevel());
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return fattyMonsterDetails;
	}

	/**
	 * This method is used for total Amount based on msisdn number, start and
	 * endDate
	 * 
	 * @param msisdn
	 *            {@link String}
	 * @return {@link Amount}
	 */
	@Deprecated
	private double getOneMonthRechargeAmount(String msisdn) {
		logger.info("Inside FattyMonsterServiceImpl in getOneMonthRechargeAmount method :::::");
		double amount = 0.0;
		System.out.println("date is ::::" + AppUtils.stringToDate("04-10-2018", AppDefaultValues.DATE_FORMAT));
		try {
			/*
			 * Get fatty offer start date ...
			 */
			String startDate = Constant.getstartDate();
			/*
			 * Get current date ...
			 */
			String endDate = Constant.getCurrentDate();

			System.out.println("offer Start Date:::" + startDate + " current date is :::" + endDate);

			List<TopUpHistory> history = backEndRequestProcessor.getTopUpHistory(msisdn,
					AppUtils.stringToDate(startDate, AppDefaultValues.DATE_FORMAT),
					AppUtils.stringToDate(endDate, AppDefaultValues.DATE_FORMAT));
			System.out.println("Size IS :::::::::::::::" + history.size());
			if (history.size() != 0) {
				for (int topupIndex = 0; topupIndex < history.size(); topupIndex++) {
					if (history.get(topupIndex).getAmount() != 0) {
						amount = amount + history.get(topupIndex).getAmount();
					}
				}
			}
			System.out.println("amount is +++" + amount);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return amount;
	}

	/**
	 * This method is used for get monster weight is based on the point.
	 * 
	 * @param amount
	 *            {@link double}
	 * @return {@link Amount}
	 */
	public int getMonsterFattyWeightBasedOnPoints(int point) {
		/* point=150; */
		int weight = FattyWeight.FirstLevelWeight.getWeightValue();
		logger.info("Inside FattyMonsterServiceImpl in getPackageWeightBasedOnPoints method :::::");
		try {

			List<FattyItemMappingsEntity> fattyItemMappings = fattyKeywordMappingsRepository.findAll();
			if (fattyItemMappings != null && fattyItemMappings.size() != 0) {
				List<FattyItemMappingsEntity> sortedFattyItemMapping = fattyItemMappings.stream()
						.sorted(Comparator.comparing(FattyItemMappingsEntity::getLevel)).collect(Collectors.toList());
				int size = sortedFattyItemMapping.size();
				for (int index = 0; index < sortedFattyItemMapping.size(); index++) {
					FattyItemMappingsEntity fattyItemMappingsEntity = sortedFattyItemMapping.get(index);
					if (fattyItemMappingsEntity != null) {
						if (fattyItemMappingsEntity.getMinPoint() != null) {
							int minPoint = fattyItemMappingsEntity.getMinPoint();
							int maxPoint = fattyItemMappingsEntity.getMinPoint();
							if (fattyItemMappingsEntity.getMaxPoint() != null) {
								maxPoint = fattyItemMappingsEntity.getMaxPoint();
							}
							if ((point >= minPoint) && (point < maxPoint)) {
								return fattyItemMappingsEntity.getMonsterWeight();
							}
							if ((point >= minPoint) && (size - 1) == index) {
								return fattyItemMappingsEntity.getMonsterWeight();
							}
						}

					}
				}
			}
			/*
			 * if (point < 20) { weight =
			 * FattyWeight.FirstLevelWeight.getWeightValue(); return weight; }
			 * else if (point >= 20 && point < 50) { weight =
			 * FattyWeight.SeoundLevelWeight.getWeightValue(); return weight; }
			 * else if (point >= 50 && point < 100) { weight =
			 * FattyWeight.ThirdLevelWeight.getWeightValue(); return weight; }
			 * else if (point >= 100) { weight =
			 * FattyWeight.FourthLevelWeight.getWeightValue(); return weight; }
			 */
		} catch (Exception e) {
			// TODO: handle exception
		}
		return weight;
	}

	/**
	 * This method used create fatty image url .
	 * 
	 * @param {@link
	 * 			fattyImageUrl}
	 * @return {@value String}
	 * @author kuldeep singh
	 */
	private String createFattyImageURL(String fattyImg) {
		if (!StringUtils.hasText(fattyImg))
			return "";

		String imageSvr = applicationConfigurationService.get("imageserver.url", "").toString();
		String imageDir = applicationConfigurationService.get("imageserver.imgdir", "").toString();
		if (!imageDir.endsWith("/"))
			imageDir = imageDir + "/";

		return imageSvr + imageDir + fattyImg;
	}

	/**
	 * This method used for redeem fatty points. Before redeem fatty point . we
	 * check user already redeem point or not .if user redeem point then we
	 * check level of redeem point .
	 * 
	 * @param {@link
	 * 			FattyRedeemPointRequest}
	 * @author kuldeep singh
	 */
	public BackEndAdapterResponse redeemPoint(FattyRedeemPointRequest fattyRedeemPoint) {
		BackEndAdapterResponse backEndAdapterResponse = new BackEndAdapterResponse();
		try {
			logger.info("Inside FattyMonsterServiceImpl in redeemPoint method :::::" + fattyRedeemPoint.getLevel());
			Boolean status = getCurrentMonthRedeemOffer(fattyRedeemPoint.getMsisdn());
		
			if (status) {
				backEndAdapterResponse = backEndRequestProcessor.redeemFattyPoint(
						AppUtils.prependCountryCodeToMsisdn(fattyRedeemPoint.getMsisdn(),
								applicationConfigurationService.getDefaultCountryCode()),
						fattyRedeemPoint.getKeyward(), fattyRedeemPoint.getPoint(), fattyRedeemPoint.getDescription());
				logger.info("Inside FattyMonsterServiceImpl in redeemPoint method :::::responce code ::"
						+ backEndAdapterResponse.getOriginRequestId());
				FattyRedeemEntity fattyRedeemEntity = new FattyRedeemEntity();
				fattyRedeemEntity.setCreatedBy(fattyRedeemPoint.getCreatedBy());
				fattyRedeemEntity.setLastModifiedBy(fattyRedeemPoint.getLastModifiedBy());
				fattyRedeemEntity.setMsisdn(fattyRedeemPoint.getMsisdn());
				int point=fattyRedeemPointBasedOnLevel(fattyRedeemPoint.getLevel());
				fattyRedeemEntity.setPoint(point);
				if (backEndAdapterResponse.getResponseCode().equalsIgnoreCase("1"))
					fattyRedeemEntity.setStatus(1);
				else
					fattyRedeemEntity.setStatus(0);
				fattyRedeemEntity.setWeight(fattyRedeemPoint.getWeight());
				fattyRedeemEntity.setUserType(fattyRedeemPoint.getUserType());
				fattyRedeemEntity.setLevel(fattyRedeemPoint.getLevel());
				fattyRedeemEntity.setFattyResponceMessage(backEndAdapterResponse.getResponseDescription());
				fattyRedeemRepository.save(fattyRedeemEntity);

			} else {
				backEndAdapterResponse.setResponseCode(FattyRedeemStatus.USER_ALREADY_REDEEM.getRedeemStatus());
				backEndAdapterResponse.setStatus(RequestStatus.FAIL);
				backEndAdapterResponse.setResponseDescription("User already redeem point");
			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Inside FattyMonsterServiceImpl in redeemPoint method :::::" + e);
			// TODO: handle exception
		}
		return backEndAdapterResponse;
	}

	/**
	 * check user already redeem Current Month and redeem Level
	 * 
	 * @param {@link
	 * 			msisdn}
	 * @return {@link boolean}
	 * @author kuldeep singh
	 */
	public boolean getCurrentMonthRedeemOffer(String msisdn) {
		boolean status = true;
		try {
			logger.info("Inside FattyMonsterServiceImpl in getCurrentMonthRedeemOffer method :::::");
			Iterable<FattyRedeemEntity> list = fattyRedeemRepository
					.findAll(QFattyRedeemEntity.fattyRedeemEntity.msisdn.eq(msisdn)
							.and(QFattyRedeemEntity.fattyRedeemEntity.createTimestamp.goe(getFirstDateOfCurrentMonth()))
							.and(QFattyRedeemEntity.fattyRedeemEntity.status.eq(1))
							.and(QFattyRedeemEntity.fattyRedeemEntity.status.eq(1)));
			if (list != null) {
				Iterator<FattyRedeemEntity> fattyRedeemList = list.iterator();
				while (fattyRedeemList.hasNext()) {
					FattyRedeemEntity fattyRedeemEntity = fattyRedeemList.next();
					FattyMonsterDetails fattyMonsterlevel = new FattyMonsterDetails();
					fattyMonsterlevel = getFattyMonsterLevel(msisdn, fattyMonsterlevel);
					if (fattyMonsterlevel.getLevel() > fattyRedeemEntity.getLevel()) {
						return true;
					} else
						status = false;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return status;
	}

	/**
	 * Get current month first date
	 * 
	 * @return {@link Date}
	 * @author kuldeep singh
	 */
	public Date getFirstDateOfCurrentMonth() {
		try {
			Calendar c = Calendar.getInstance(); // this takes current date
			c.set(Calendar.DAY_OF_MONTH, 1);
			return c.getTime();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	/**
	 * Get redeemPoint Based On fattylevel.
	 * @param level
	 * @return {@link Integer}
	 * */
	public int fattyRedeemPointBasedOnLevel(int level)
	{
		logger.info("Inside FattyMonsterServiceImpl in fattyRedeemPointBasedOnLevel method :::::");
		int point=0;
		try
		{
			FattyItemMappingsEntity fattyItemMappingsEntity = fattyKeywordMappingsRepository
					.findOne(QFattyItemMappingsEntity.fattyItemMappingsEntity.level.eq(level));
			if (fattyItemMappingsEntity != null) {
				point=fattyItemMappingsEntity.getMonsterWeight();
			}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return point;
	}

}
