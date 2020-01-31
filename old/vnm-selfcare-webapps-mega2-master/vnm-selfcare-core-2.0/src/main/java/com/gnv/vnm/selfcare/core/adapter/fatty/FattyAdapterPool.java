package com.gnv.vnm.selfcare.core.adapter.fatty;

import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.AbandonedConfig;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

public class FattyAdapterPool  extends GenericObjectPool<FattyAdapter> {
	
	public FattyAdapterPool(PooledObjectFactory<FattyAdapter> factory, GenericObjectPoolConfig config,
			AbandonedConfig abandonedConfig) {
		super(factory, config, abandonedConfig);
	}

	public FattyAdapterPool(PooledObjectFactory<FattyAdapter> factory, GenericObjectPoolConfig config) {
		super(factory, config);
	}

	public FattyAdapterPool(PooledObjectFactory<FattyAdapter> factory) {
		super(factory);
	}
}
