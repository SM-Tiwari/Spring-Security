/**
 * RadiusAdapterFactory.java
 */
package com.gnv.vnm.selfcare.core.adapter.radius;

import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;

/**
 * @author nandipinto
 *
 */
public class RadiusAdapterFactory extends BasePooledObjectFactory<RadiusAdapter> {
	
	private RadiusConnection connection;
	
	public RadiusAdapterFactory(RadiusConnection connection){
		this.connection = connection;
	}

	/* (non-Javadoc)
	 * @see org.apache.commons.pool2.BasePooledObjectFactory#create()
	 */
	@Override
	public RadiusAdapter create() throws Exception {
		RadiusAdapter adapter = new RadiusAdapter();
		adapter.init(connection);
		
		return adapter;
	}

	/* (non-Javadoc)
	 * @see org.apache.commons.pool2.BasePooledObjectFactory#destroyObject(org.apache.commons.pool2.PooledObject)
	 */
	@Override
	public void destroyObject(PooledObject<RadiusAdapter> p) throws Exception {
		p.getObject().shutdown();
	}

	/* (non-Javadoc)
	 * @see org.apache.commons.pool2.BasePooledObjectFactory#validateObject(org.apache.commons.pool2.PooledObject)
	 */
	@Override
	public boolean validateObject(PooledObject<RadiusAdapter> p) {
		return true;
//		return p.getObject().isConnected();
	}

	
	/* (non-Javadoc)
	 * @see org.apache.commons.pool2.BasePooledObjectFactory#wrap(java.lang.Object)
	 */
	@Override
	public PooledObject<RadiusAdapter> wrap(RadiusAdapter adapter) {
		return new DefaultPooledObject<RadiusAdapter>(adapter);
	}

}
