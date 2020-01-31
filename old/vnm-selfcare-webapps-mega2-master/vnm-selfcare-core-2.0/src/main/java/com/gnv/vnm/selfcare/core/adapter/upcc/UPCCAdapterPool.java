/**
 * RTBSAdapterPool.java
 */
package com.gnv.vnm.selfcare.core.adapter.upcc;

import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.AbandonedConfig;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

/**
 * @author nandipinto
 *
 */
public class UPCCAdapterPool extends GenericObjectPool<UPCCAdapter> {

	/**
	 * @param factory
	 * @param config
	 * @param abandonedConfig
	 */
	public UPCCAdapterPool(PooledObjectFactory<UPCCAdapter> factory, GenericObjectPoolConfig config,
			AbandonedConfig abandonedConfig) {
		super(factory, config, abandonedConfig);
	}

	/**
	 * @param factory
	 * @param config
	 */
	public UPCCAdapterPool(PooledObjectFactory<UPCCAdapter> factory, GenericObjectPoolConfig config) {
		super(factory, config);
	}

	/**
	 * @param factory
	 */
	public UPCCAdapterPool(PooledObjectFactory<UPCCAdapter> factory) {
		super(factory);
	}
	
}
