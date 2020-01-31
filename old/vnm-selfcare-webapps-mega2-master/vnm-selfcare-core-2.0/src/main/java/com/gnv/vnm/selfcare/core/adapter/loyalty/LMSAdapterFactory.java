/**
 * LMSAdapterFactory.java
 */
package com.gnv.vnm.selfcare.core.adapter.loyalty;

import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;

import com.gnv.vnm.selfcare.core.adapter.WebServiceBackEndConnection;

/**
 * @author nandipinto
 *
 */
public class LMSAdapterFactory extends BasePooledObjectFactory<LMSAdapter> {

	private WebServiceBackEndConnection connection;
	
	public LMSAdapterFactory(WebServiceBackEndConnection connection) {
		this.connection = connection;
	}

	/* (non-Javadoc)
	 * @see org.apache.commons.pool2.BasePooledObjectFactory#create()
	 */
	@Override
	public LMSAdapter create() throws Exception {
		LMSAdapter adapter = new LMSAdapter();
		adapter.init(connection);
		
		return adapter;
	}

	/* (non-Javadoc)
	 * @see org.apache.commons.pool2.BasePooledObjectFactory#wrap(java.lang.Object)
	 */
	@Override
	public PooledObject<LMSAdapter> wrap(LMSAdapter adapter) {
		return new DefaultPooledObject<LMSAdapter>(adapter);
	}

	/* (non-Javadoc)
	 * @see org.apache.commons.pool2.BasePooledObjectFactory#validateObject(org.apache.commons.pool2.PooledObject)
	 */
	@Override
	public boolean validateObject(PooledObject<LMSAdapter> p) {
		return p.getObject().isConnected();
	}

}
