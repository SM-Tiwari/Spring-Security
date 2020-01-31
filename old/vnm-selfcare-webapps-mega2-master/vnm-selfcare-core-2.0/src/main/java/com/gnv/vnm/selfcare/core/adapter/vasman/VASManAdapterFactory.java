/**
 * RTBSAdapterFactory.java
 */
package com.gnv.vnm.selfcare.core.adapter.vasman;

import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;

import com.gnv.vnm.selfcare.core.adapter.WebServiceBackEndConnection;

/**
 * @author nandipinto
 *
 */
public class VASManAdapterFactory extends BasePooledObjectFactory<VASManAdapter> {
	
	private WebServiceBackEndConnection connection;
	
	public VASManAdapterFactory(WebServiceBackEndConnection connection){
		this.connection = connection;
	}
	
	/* (non-Javadoc)
	 * @see org.apache.commons.pool2.BasePooledObjectFactory#create()
	 */
	@Override
	public VASManAdapter create() throws Exception {
		VASManAdapter adapter = new VASManAdapter();
		adapter.init(connection);
		
		return adapter;
	}

	/* (non-Javadoc)
	 * @see org.apache.commons.pool2.BasePooledObjectFactory#destroyObject(org.apache.commons.pool2.PooledObject)
	 */
	@Override
	public void destroyObject(PooledObject<VASManAdapter> p) throws Exception {
		p.getObject().shutdown();
	}

	/* (non-Javadoc)
	 * @see org.apache.commons.pool2.BasePooledObjectFactory#validateObject(org.apache.commons.pool2.PooledObject)
	 */
	@Override
	public boolean validateObject(PooledObject<VASManAdapter> p) {
		return p.getObject().isConnected();
	}

	/* (non-Javadoc)
	 * @see org.apache.commons.pool2.BasePooledObjectFactory#wrap(java.lang.Object)
	 */
	@Override
	public PooledObject<VASManAdapter> wrap(VASManAdapter adapter) {
		return new DefaultPooledObject<VASManAdapter>(adapter);
	}

}
