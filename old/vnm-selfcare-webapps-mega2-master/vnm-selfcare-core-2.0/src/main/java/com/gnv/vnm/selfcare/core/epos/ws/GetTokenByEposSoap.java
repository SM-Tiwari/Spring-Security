package com.gnv.vnm.selfcare.core.epos.ws;

import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpVersion;
import org.apache.commons.httpclient.methods.PostMethod;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import com.gnv.vnm.selfcare.core.model.EposTokenModel;
import com.gnv.vnm.selfcare.core.utils.Constant;
 
public class GetTokenByEposSoap {
	//public  String mode=ConstantForEpos.MODE;
	
	public static String ePoswsdl = "";
	public static String username = "";
	public static String password = "";
	public static String agentMsIsdn = "";
	public static String mpin = "";
	public  String mode=Constant.MODE;
	
	//for dev server 
 	/* 	public static String ePoswsdl = "http://10.8.13.61:7865/eload/services/API?wsdl";
	public static String username = "AXIENTA";
	public static String password = "7c4a8d09ca3762af61e59520943dc26494f8941b";
	public static String agentMsIsdn = "0927000053";
	public static String mpin = "7F245E0ED2E0531272856A053B191F3A2B5D2F64";*/
 
	 
	 //for prod server
  /*  public static String ePoswsdl = "http://10.8.2.205:7883/eload/services/API?wsdl";
	  String username ="selfcare";
	   String password ="FzcjHnqRzyGwhwZSmjrSlX1OHtM=";
	   String agentMsIsdn = "01864312047";
	   String mpin = "25C9E6CFAC1DE756F1C17349787C5F4D0B6BC7EB"; */
	   //String agentMsIsdn = "01864182465";
		 // String mpin = "F1ACC1E7D224D8F6552B4E2D822B0B4F37AC9B65";
	List<EposTokenModel> eposTokenModelList = new ArrayList<>();
	
	public  List<EposTokenModel> getToken(String agentMsisdn) {
		
		if(mode.equalsIgnoreCase("test")){
			 ePoswsdl = "http://10.8.13.61:7865/eload/services/API?wsdl";
			 username = "AXIENTA";
			 password = "fEqNCco3Yq9h5ZUglD3CZJT4lBs=";
			 agentMsIsdn = "0927000053";
			 mpin = "7F245E0ED2E0531272856A053B191F3A2B5D2F64";
		}
		else
		{
		    ePoswsdl = "http://10.8.2.205:7883/eload/services/API?wsdl";
		    username ="selfcare";
		    password ="FzcjHnqRzyGwhwZSmjrSlX1OHtM=";
		    agentMsIsdn = "01864312047";
		    mpin = "25C9E6CFAC1DE756F1C17349787C5F4D0B6BC7EB";
		}
		
		String responseBody = "error for Code";
		
		HttpClient client = new HttpClient();
		client.getParams().setParameter("http.protocol.version", HttpVersion.HTTP_1_0);

		try {
			URI uri = new URI(String.format(ePoswsdl));
			PostMethod method = new PostMethod(uri.toString());
			method.setRequestHeader("SOAPAction", "");
			method.addRequestHeader("Content-Type", "text/xml");

			 
			
			String tokenKey = "";
			String requestBody = "<soapenv:Envelope xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' xmlns:xsd='http://www.w3.org/2001/XMLSchema' xmlns:soapenv='http://schemas.xmlsoap.org/soap/envelope/' xmlns:ser='http://services.SMSUtility.fss.com'><soapenv:Header/><soapenv:Body><ser:getTokenNow soapenv:encodingStyle='http://schemas.xmlsoap.org/soap/encoding/'><in xsi:type='sms:BasicInput' xmlns:sms='http://SMSUtility.fss.com'><username xsi:type='xsd:string'>"
					+ username + "</username><password xsi:type='xsd:string'>" + password
					+ "</password><agentMsIsdn xsi:type='xsd:string'>" + agentMsIsdn
					+ "</agentMsIsdn><mpin xsi:type='xsd:string'>" + mpin
					+ "</mpin><tokenKey xsi:type='soapenc:string' xmlns:soapenc='http://schemas.xmlsoap.org/soap/encoding/'/></in></ser:getTokenNow></soapenv:Body></soapenv:Envelope>";
			method.setRequestBody(requestBody);
			int returncode = client.executeMethod(method);
			System.out.println("requestBody TOKEN : " + requestBody);

			if (returncode == 200) {
				responseBody = method.getResponseBodyAsString();
				//System.out.println("responseBody TOKEN : " + responseBody);
				eposTokenModelList = parseResponseBody(responseBody);
			} else {
				 
				responseBody = "Token is not getting from EPOS wsdl";
			}

			
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return eposTokenModelList;
	}

	public List<EposTokenModel> parseResponseBody(String responseBody) {

		//System.out.println(responseBody);
		EposTokenModel eposTokenModel = new EposTokenModel();
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		InputSource is;
		try {
			builder = factory.newDocumentBuilder();
			is = new InputSource(new StringReader(responseBody));
			Document doc = builder.parse(is);
			NodeList listSession = doc.getElementsByTagName("sessionid");
			NodeList listMsg = doc.getElementsByTagName("message");
			NodeList listStatus = doc.getElementsByTagName("status");
		//	System.out.println(listSession.item(0).getTextContent());
		//	System.out.println(listMsg.item(0).getTextContent());
		//	System.out.println(listStatus.item(0).getTextContent());
			
			eposTokenModel.setStatus(listStatus.item(0).getTextContent());
			eposTokenModel.setMessage(listMsg.item(0).getTextContent());
			eposTokenModel.setSessionid(listSession.item(0).getTextContent());
			eposTokenModelList.add(eposTokenModel);
			
		} catch (ParserConfigurationException e) {
		} catch (SAXException e) {
		} catch (IOException e) {
		}
		return eposTokenModelList;
	}
}
