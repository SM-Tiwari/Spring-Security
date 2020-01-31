package com.gnv.vnm.selfcare.core.service;

import java.util.List;

import com.gnv.vnm.selfcare.core.model.VersionUpdate;

public interface VersionUpdateService {

	List<VersionUpdate> viewVersionUpdate(String appVersion, String os);
	
	
}
