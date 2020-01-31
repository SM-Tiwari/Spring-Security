/**
 * StoreManagementServiceImpl.java
 */
package com.gnv.vnm.selfcare.core.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.gnv.vnm.selfcare.core.model.SimOperator;
import com.gnv.vnm.selfcare.core.model.SimOperatorPrefix;
 
import com.gnv.vnm.selfcare.core.service.SimOperatorService;
 
import com.gnv.vnm.selfcare.dao.entity.QSimOperatorPrefixEntity;
import com.gnv.vnm.selfcare.dao.entity.SimOperatorEntity;
import com.gnv.vnm.selfcare.dao.entity.SimOperatorPrefixEntity;
 
import com.gnv.vnm.selfcare.dao.repo.SimOperatorPrefixRepository;
import com.gnv.vnm.selfcare.dao.repo.SimOperatorRepository;

/**
 * @author abhinav
 *
 */

@Service("simOperatorService")
public class SimOperatorServiceImpl implements SimOperatorService {

	private static final Logger logger = LoggerFactory.getLogger(SimOperatorServiceImpl.class);

	@Autowired
	SimOperatorRepository simOperatorRepository;
	@Autowired
	SimOperatorPrefixRepository simOperatorPrefixRepository;

	private SimOperator fromSimOperatorEntity(SimOperatorEntity source) {
		SimOperator entity = new SimOperator(source.getOperatorId(), source.getOperatorName(),
				source.getOperatorStatus());

		return entity;
	}

	private SimOperatorPrefix fromSimOperatorPrefixEntity(SimOperatorPrefixEntity source) {
		SimOperatorPrefix entity = new SimOperatorPrefix(source.getOperatorId(), source.getOldPrefix(),
				source.getNewPrefix(),source.getSimOperatorName(), source.getOperatorPrefixStatus());

		return entity;
	}
	
	@Override
	public List<SimOperator> getAllSimOperator() {
		List<SimOperator> result = new ArrayList<SimOperator>();

		try {
			Iterable<SimOperatorEntity> list = simOperatorRepository.findAll();
			for (SimOperatorEntity se : list) {
				result.add(fromSimOperatorEntity(se));
			}
		} catch (Exception e) {
			logger.error("#getAllSimOperator --- error retrieving sim operator list!", e);
		}
		return result;
	}

	@Override
	public List<SimOperatorPrefix> getOperatorPrefix(int operatorId) {
		List<SimOperatorPrefix> simOperatorPrefixEntities = new ArrayList<SimOperatorPrefix>();

		try {
			Iterable<SimOperatorPrefixEntity> list = simOperatorPrefixRepository
					.findAll(QSimOperatorPrefixEntity.simOperatorPrefixEntity.operatorId.eq(operatorId));
			for (SimOperatorPrefixEntity se : list) {
				simOperatorPrefixEntities.add(fromSimOperatorPrefixEntity(se));
			}
		} catch (Exception e) {
			logger.error("#getOperatorPrefix --- error retrieving Operator Prefix!", e);
		}
		return simOperatorPrefixEntities;
	}

	@Override
	public String saveOperator(String operatorName, int operatorStatus) {

		String message = "";
		SimOperatorEntity simOperatorEntity = new SimOperatorEntity();
		//SimOperator simOperator = new SimOperator();
		List<SimOperatorEntity> entitiesList = new ArrayList<>();

		simOperatorEntity.setOperatorName(operatorName);
		simOperatorEntity.setOperatorStatus(operatorStatus);
		entitiesList.add(simOperatorEntity);

		try {
			simOperatorRepository.save(entitiesList);
			message = "success";
		} catch (Exception ex) {
			message = "fail";
		}
		return message;
	}

	@Override
	public List<SimOperatorPrefix> getAllOperatorPrefix() {
		List<SimOperatorPrefix> result = new ArrayList<SimOperatorPrefix>();

		try {
			Iterable<SimOperatorPrefixEntity> list = simOperatorPrefixRepository.findAll(QSimOperatorPrefixEntity.simOperatorPrefixEntity.operatorPrefixStatus.eq(1));
		
			for (SimOperatorPrefixEntity se : list) {
				
				result.add(fromSimOperatorPrefixEntity(se));
				
			}
			
		} catch (Exception e) {
			logger.error("#getAllOperatorPrefix --- error retrieving all operator prefix list!", e);
		}
		return result;
	}

	@Override
	public String saveOperatorPrefix(int operatorId, String msisdnPrefix, String msisdnValue) {
		String message = "";
		SimOperatorPrefixEntity simOperatorEntity = new SimOperatorPrefixEntity();
		
		List<SimOperatorPrefixEntity> entitiesList = new ArrayList<>();

		simOperatorEntity.setOperatorId(operatorId);
		simOperatorEntity.setOldPrefix(msisdnPrefix);
		simOperatorEntity.setNewPrefix(msisdnValue);
		
		entitiesList.add(simOperatorEntity);

		try {
			simOperatorPrefixRepository.save(entitiesList);
			message = "success";
		} catch (Exception ex) {
			message = "fail";
		}
		return message;
	}

}
