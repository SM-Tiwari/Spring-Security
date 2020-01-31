package com.gnv.vnm.selfcare.core.test;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import com.gnv.vnm.selfcare.core.adapter.BackEndAdapterException;
import com.gnv.vnm.selfcare.core.adapter.upcc.UPCCAdapter;
import com.gnv.vnm.selfcare.core.adapter.upcc.UPCCConnection;
import com.gnv.vnm.selfcare.core.adapter.upcc.UPCCSubscriberData;

public class UPCCAdapterTest {

	UPCCConnection conn = new UPCCConnection("localhost", 8480, "Selfcare", "Vnm@2018", "http");
	UPCCAdapter adapter = new UPCCAdapter();
	String sampleRespFile = "UPCC_GetSubscriberAllInfoResponse.xml";
	StringBuffer querySubscriberResponse = new StringBuffer();
	
	@Before
	public void setUp() throws Exception {
		adapter.init(conn);
		/*
		InputStream is = getClass().getClassLoader().getResourceAsStream(sampleRespFile);
		StringWriter writer = new StringWriter();
		IOUtils.copy(is, writer, "UTF-8");
		querySubscriberResponse.append(writer.toString());
		*/
	}

	@Test
	public void testInit() {
//		try {
//			adapter.init(conn);
//		} catch (BackEndAdapterException e) {
//			e.printStackTrace();
//		}
		System.out.println(adapter.isConnected());
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
	public void testSendRequest() {
		fail("Not yet implemented");
	}

	@Test
	public void testShutdown() {
		fail("Not yet implemented");
	}

	@Test
	public void testParseSubscriberData() {
//		fail("Not yet implemented");
		try {
			UPCCSubscriberData subscriber = adapter.parseSubscriberData("1234", querySubscriberResponse.toString());
			System.out.println(subscriber);
		} catch (BackEndAdapterException e) {
			System.out.println(e);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetRequestStatusFromResponse() {
		fail("Not yet implemented");
	}

}
