/**
 * LMSAdapterPool.java
 */
package com.gnv.vnm.selfcare.core.adapter.loyalty;

import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.AbandonedConfig;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

/**
 * @author nandipinto
 *
 */
public class LMSAdapterPool extends GenericObjectPool<LMSAdapter> {

	public LMSAdapterPool(PooledObjectFactory<LMSAdapter> factory, GenericObjectPoolConfig config,
			AbandonedConfig abandonedConfig) {
		super(factory, config, abandonedConfig);
	}

	public LMSAdapterPool(PooledObjectFactory<LMSAdapter> factory, GenericObjectPoolConfig config) {
		super(factory, config);
	}

	public LMSAdapterPool(PooledObjectFactory<LMSAdapter> factory) {
		super(factory);
	}

}
