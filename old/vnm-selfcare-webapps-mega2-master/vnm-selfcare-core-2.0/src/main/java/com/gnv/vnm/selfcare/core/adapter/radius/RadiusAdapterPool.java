/**
 * RadiusAdapterPool.java
 */
package com.gnv.vnm.selfcare.core.adapter.radius;

import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.AbandonedConfig;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

/**
 * @author nandipinto
 * @param <T>
 *
 */
public class RadiusAdapterPool extends GenericObjectPool<RadiusAdapter> {

	public RadiusAdapterPool(PooledObjectFactory<RadiusAdapter> factory, GenericObjectPoolConfig config,
			AbandonedConfig abandonedConfig) {
		super(factory, config, abandonedConfig);
	}

	public RadiusAdapterPool(PooledObjectFactory<RadiusAdapter> factory, GenericObjectPoolConfig config) {
		super(factory, config);
	}

	public RadiusAdapterPool(PooledObjectFactory<RadiusAdapter> factory) {
		super(factory);
	}

	
}
