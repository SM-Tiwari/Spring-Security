package com.gnv.vnm.selfcare.core.test;

import static org.junit.Assert.fail;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.gnv.vnm.selfcare.core.adapter.BackEndAdapterResponse;
import com.gnv.vnm.selfcare.core.adapter.radius.RadiusAdapter;
import com.gnv.vnm.selfcare.core.adapter.radius.RadiusConnection;
import com.gnv.vnm.selfcare.core.adapter.radius.RadiusQueryRequest;
import com.gnv.vnm.selfcare.core.enums.RequestType;

public class RadiusAdapterTest {
	
	final String ipAddress = "10.200.37.109";
	RadiusAdapter adapter = new RadiusAdapter();

	@Before
	public void setUp() throws Exception {
		System.setProperty("java.naming.ldap.version", "2");
		RadiusConnection conn = new RadiusConnection("localhost", 4667, "cn=vmcp0003,o=radius", "Vnmcp3", "ldap");
		conn.setConnectionPoolEnabled(true);
		adapter.init(conn);
	}

	@Test
	public void testInit() {
		fail("Not yet implemented");
	}

	@Test
	public void testLogin() {
		fail("Not yet implemented");
	}

	@Test
	public void testLogout() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsConnected() {
		fail("Not yet implemented");
	}

	@Test
	public void testSendRequest() {
//		fail("Not yet implemented");
		RadiusQueryRequest request = new RadiusQueryRequest("12345", RequestType.QUERY, new Date());
		request.setIpAddress(ipAddress);
		
		BackEndAdapterResponse response = adapter.sendRequest(request);
		System.out.println(response);
		
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("-------------");
		response = adapter.sendRequest(request);
		System.out.println(response);
		
		adapter.shutdown();
	}

	@Test
	public void testShutdown() {
		fail("Not yet implemented");
	}

}
