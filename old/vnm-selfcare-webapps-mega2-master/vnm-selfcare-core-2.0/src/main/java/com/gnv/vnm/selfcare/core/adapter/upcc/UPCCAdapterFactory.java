/**
 * RTBSAdapterFactory.java
 */
package com.gnv.vnm.selfcare.core.adapter.upcc;

import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;

import com.gnv.vnm.selfcare.core.adapter.BackEndConnection;

/**
 * @author nandipinto
 *
 */
public class UPCCAdapterFactory extends BasePooledObjectFactory<UPCCAdapter> {
	
	private BackEndConnection connection;
	
	public UPCCAdapterFactory(BackEndConnection connection){
		this.connection = connection;
	}
	
	/* (non-Javadoc)
	 * @see org.apache.commons.pool2.BasePooledObjectFactory#create()
	 */
	@Override
	public UPCCAdapter create() throws Exception {
		UPCCAdapter adapter = new UPCCAdapter();
		adapter.init(connection);
		return adapter;
	}

	/* (non-Javadoc)
	 * @see org.apache.commons.pool2.BasePooledObjectFactory#destroyObject(org.apache.commons.pool2.PooledObject)
	 */
	@Override
	public void destroyObject(PooledObject<UPCCAdapter> p) throws Exception {
		p.getObject().shutdown();
	}

	/* (non-Javadoc)
	 * @see org.apache.commons.pool2.BasePooledObjectFactory#validateObject(org.apache.commons.pool2.PooledObject)
	 */
	@Override
	public boolean validateObject(PooledObject<UPCCAdapter> p) {
		return p.getObject().isConnected();
	}

	/* (non-Javadoc)
	 * @see org.apache.commons.pool2.BasePooledObjectFactory#wrap(java.lang.Object)
	 */
	@Override
	public PooledObject<UPCCAdapter> wrap(UPCCAdapter adapter) {
		return new DefaultPooledObject<UPCCAdapter>(adapter);
	}

}
