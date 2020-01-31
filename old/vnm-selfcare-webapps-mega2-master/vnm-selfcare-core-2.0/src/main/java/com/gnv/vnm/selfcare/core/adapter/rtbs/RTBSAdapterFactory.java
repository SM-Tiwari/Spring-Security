/**
 * RTBSAdapterFactory.java
 */
package com.gnv.vnm.selfcare.core.adapter.rtbs;

import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;

import com.gnv.vnm.selfcare.core.adapter.WebServiceBackEndConnection;

/**
 * @author nandipinto
 *
 */
public class RTBSAdapterFactory extends BasePooledObjectFactory<RTBSAdapter> {
	
	private WebServiceBackEndConnection connection;
	
	public RTBSAdapterFactory(WebServiceBackEndConnection connection){
		this.connection = connection;
	}
	
	/* (non-Javadoc)
	 * @see org.apache.commons.pool2.BasePooledObjectFactory#create()
	 */
	@Override
	public RTBSAdapter create() throws Exception {
		RTBSAdapter adapter = new RTBSAdapter();
		adapter.init(connection);
		return adapter;
	}

	/* (non-Javadoc)
	 * @see org.apache.commons.pool2.BasePooledObjectFactory#destroyObject(org.apache.commons.pool2.PooledObject)
	 */
	@Override
	public void destroyObject(PooledObject<RTBSAdapter> p) throws Exception {
		p.getObject().shutdown();
	}

	/* (non-Javadoc)
	 * @see org.apache.commons.pool2.BasePooledObjectFactory#validateObject(org.apache.commons.pool2.PooledObject)
	 */
	@Override
	public boolean validateObject(PooledObject<RTBSAdapter> p) {
		return p.getObject().isConnected();
	}

	/* (non-Javadoc)
	 * @see org.apache.commons.pool2.BasePooledObjectFactory#wrap(java.lang.Object)
	 */
	@Override
	public PooledObject<RTBSAdapter> wrap(RTBSAdapter adapter) {
		return new DefaultPooledObject<RTBSAdapter>(adapter);
	}

}
