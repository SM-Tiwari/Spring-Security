/**
 * RTBSAdapterPool.java
 */
package com.gnv.vnm.selfcare.core.adapter.vasman;

import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.AbandonedConfig;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

/**
 * @author nandipinto
 *
 */

public class VASManAdapterPool extends GenericObjectPool<VASManAdapter> {

	/**
	 * @param factory
	 * @param config
	 * @param abandonedConfig
	 */
	public VASManAdapterPool(PooledObjectFactory<VASManAdapter> factory, GenericObjectPoolConfig config,
			AbandonedConfig abandonedConfig) {
		super(factory, config, abandonedConfig);
	}

	/**
	 * @param factory
	 * @param config
	 */
	public VASManAdapterPool(PooledObjectFactory<VASManAdapter> factory, GenericObjectPoolConfig config) {
		super(factory, config);
	}

	/**
	 * @param factory
	 */
	public VASManAdapterPool(PooledObjectFactory<VASManAdapter> factory) {
		super(factory);
	}
	
}
