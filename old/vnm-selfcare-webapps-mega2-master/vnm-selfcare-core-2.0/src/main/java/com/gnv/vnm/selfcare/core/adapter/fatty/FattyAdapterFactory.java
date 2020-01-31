package com.gnv.vnm.selfcare.core.adapter.fatty;

import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;
import com.gnv.vnm.selfcare.core.adapter.WebServiceBackEndConnection;
public class FattyAdapterFactory extends BasePooledObjectFactory<FattyAdapter> {

	private WebServiceBackEndConnection connection;
	
	public FattyAdapterFactory(WebServiceBackEndConnection connection) {
		this.connection = connection;
	}

	/* (non-Javadoc)
	 * @see org.apache.commons.pool2.BasePooledObjectFactory#create()
	 */
	@Override
	public FattyAdapter create() throws Exception {
		FattyAdapter adapter = new FattyAdapter();
		adapter.init(connection);
		
		return adapter;
	}

	/* (non-Javadoc)
	 * @see org.apache.commons.pool2.BasePooledObjectFactory#wrap(java.lang.Object)
	 */
	@Override
	public PooledObject<FattyAdapter> wrap(FattyAdapter adapter) {
		return new DefaultPooledObject<FattyAdapter>(adapter);
	}

	/* (non-Javadoc)
	 * @see org.apache.commons.pool2.BasePooledObjectFactory#validateObject(org.apache.commons.pool2.PooledObject)
	 */
	@Override
	public boolean validateObject(PooledObject<FattyAdapter> p) {
		return p.getObject().isConnected();
	}

}
