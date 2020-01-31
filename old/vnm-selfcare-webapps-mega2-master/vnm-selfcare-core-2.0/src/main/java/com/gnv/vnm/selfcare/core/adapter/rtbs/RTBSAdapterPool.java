/**
 * RTBSAdapterPool.java
 */
package com.gnv.vnm.selfcare.core.adapter.rtbs;

import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.AbandonedConfig;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

/**
 * @author nandipinto
 *
 */

public class RTBSAdapterPool extends GenericObjectPool<RTBSAdapter> {

	/**
	 * @param factory
	 * @param config
	 * @param abandonedConfig
	 */
	public RTBSAdapterPool(PooledObjectFactory<RTBSAdapter> factory, GenericObjectPoolConfig config,
			AbandonedConfig abandonedConfig) {
		super(factory, config, abandonedConfig);
	}

	/**
	 * @param factory
	 * @param config
	 */
	public RTBSAdapterPool(PooledObjectFactory<RTBSAdapter> factory, GenericObjectPoolConfig config) {
		super(factory, config);
	}

	/**
	 * @param factory
	 */
	public RTBSAdapterPool(PooledObjectFactory<RTBSAdapter> factory) {
		super(factory);
	}
	
}
