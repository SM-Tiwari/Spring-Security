package com.gnv.vnm.selfcare.core.epos.ws;

import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpVersion;
import org.apache.commons.httpclient.methods.PostMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.gnv.vnm.selfcare.core.model.UpdateCustomerInforModel;
import com.gnv.vnm.selfcare.core.service.MicInformationService;
import com.gnv.vnm.selfcare.core.utils.Constant;

public class UpdateCustomerInforByEposSoap {


	 
	List<UpdateCustomerInforModel> customerInforModelList = new ArrayList<>();
    String host="hanwebslfdb-scan.vietnamobile.net.vn";
    String dbusername = "scuser";
    String dbpassword= "Selfcare2017";
    //for dev server 
    
    public static String ePoswsdl = "";
	public static String username = "";
	public static String password = "";
	public static String agentMsIsdn = "";
	public static String mpin = "";
	public  String mode=Constant.MODE;
    
	
    /*public static String ePoswsdl = "http://10.8.13.61:7865/eload/services/API?wsdl";
	public static String username = "AXIENTA";
	public static String password = "7c4a8d09ca3762af61e59520943dc26494f8941b";
	public static String agentMsIsdn = "0927000053";
	public static String mpin = "7F245E0ED2E0531272856A053B191F3A2B5D2F64";*/
 
 //for prod server
 /*public static String ePoswsdl = "http://10.8.2.205:7883/eload/services/API?wsdl";
	  String username ="selfcare";
	   String password ="FzcjHnqRzyGwhwZSmjrSlX1OHtM=";
	   String agentMsIsdn = "01864312047";
	   String mpin = "25C9E6CFAC1DE756F1C17349787C5F4D0B6BC7EB";
	  */
	 @Autowired
     private MicInformationService micInformationService;
	 
	@SuppressWarnings("deprecation")
	public List<UpdateCustomerInforModel> updateMicInEpos(String tokenKeystr,String firstName_cust, String lastName_cust, String dob_cust, String idCard_cust,
			String date_of_issue, String placeOfIssue_cust, String address, String province_cust, String districtt, String country,
			String msisdn, String firstSideIdcard, String secondSideIdcard, String customerPortrait,
			String customerSignature, String client_type) {
		
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
			
			method.addRequestHeader("Content-Type", "text/xml;charset=utf-8");

			String addres = address;//"HANAOI";
			String companyName = "oneclick";//"";//"oneclick";
			String contract_img1 = "";//msisdn+"_firstside_idcard"+".jpg";//"FirstSideID.jpg";
			String contract_img1_Body = "";//firstSideIdcard;//"";
			String contract_img1_Length = "0";
			String contract_img1_Name = msisdn+"_firstside_idcard"+".jpg";//"FirstSideID.jpg";
			
			String contract_img2 = "";// msisdn+"_secondside_idcard"+".jpg";//"SecondSideID.jpg";
			String contract_img2_Body = "";//secondSideIdcard;//"";
			String contract_img2_Length = "0";
			String contract_img2_Name = "";//msisdn+"_secondside_idcard"+".jpg";//"SecondSideID.jpg";
			
			String countryy = country;//"Vietnaam";
			String cust_img = msisdn+"_cust_portrait";//msisdn+"_portrait"+".jpg";//"cust_portrait.jpg";
			String cust_img_Body = customerPortrait;//"";
			String cust_img_Length = String.valueOf(customerPortrait.length());//"0";
			String cust_img_Name = msisdn.concat("3")+".jpg";//msisdn+"_portrait"+".jpg";//"cust_portrait.jpg";
			
			String customer_type = "1";
			String dateOfIssue = date_of_issue;//"12/12/2011";
			String district = districtt;//"sdsdsds";
			String dob = dob_cust;//"12/12/1990";
			String firstName = firstName_cust;//"Dhiraj";
			
			String gender = "0";
			String idCard = idCard_cust;//"123456789";
			String imgBody = firstSideIdcard;//"";
			String imgID = msisdn+"_firstside_idcard";//"0";
			String imgID_2 = msisdn+"_secondside_idcard";//"";
			String imgID_2_Body = secondSideIdcard;//"";//customerSignature;//"";
			String imgID_2_Length =String.valueOf(secondSideIdcard.length());//"";// String.valueOf(customerSignature.length());//"0";
			String imgID_2_Name = msisdn.concat("2")+".jpg";//"";//msisdn+"_sign"+".jpg";//"cust_signature.jpg";
			String imgLength = String.valueOf(firstSideIdcard.length());//"0";
			String imgName = msisdn.concat("1")+".jpg";//"";//msisdn+"_sign"+".jpg";//"cust_signature.jpg";
			String lastName = lastName_cust;//"Kumar";
			String fullName = firstName+" "+lastName; //"Dhiraj Kumar";
			String compactMdn = "";
			String fullMdn = "";
			String mdn = msisdn;
			String normalMdn = "";

			String placeOfIssue = placeOfIssue_cust;//"Hanaoi";
			String province = province_cust;//"dsdsds";
			String taxCode = "";
	 
			String tokenKey = tokenKeystr;
			String signature_Id=msisdn+"_cust_signature";
            String signature_Body=customerSignature;
            String signature_Length=String.valueOf(customerSignature.length());
            String signature_Name=msisdn.concat("4")+".jpg";

    		String requestBody = "<soapenv:Envelope xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' xmlns:xsd='http://www.w3.org/2001/XMLSchema' xmlns:soapenv='http://schemas.xmlsoap.org/soap/envelope/' xmlns:ser='http://services.SMSUtility.fss.com'><soapenv:Header/><soapenv:Body><ser:updateCustomerInfor soapenv:encodingStyle='http://schemas.xmlsoap.org/soap/encoding/'><req xsi:type='ser:UpdateCustomerRequest' xmlns:ser='http://service.oom3.fss.com'><address xsi:type='soapenc:string' xmlns:soapenc='http://schemas.xmlsoap.org/soap/encoding/'>"+ addres+"</address><companyName xsi:type='soapenc:string' xmlns:soapenc='http://schemas.xmlsoap.org/soap/encoding/'>"+ companyName+"</companyName><contract_img1 xsi:type='soapenc:string' xmlns:soapenc='http://schemas.xmlsoap.org/soap/encoding/'>"+ contract_img1+"</contract_img1><contract_img1_Body xsi:type='soapenc:base64Binary' xmlns:soapenc='http://schemas.xmlsoap.org/soap/encoding/'>"+contract_img1_Body+"</contract_img1_Body><contract_img1_Length xsi:type='xsd:int'>"+contract_img1_Length+"</contract_img1_Length><contract_img1_Name xsi:type='soapenc:string' xmlns:soapenc='http://schemas.xmlsoap.org/soap/encoding/'>"+ contract_img1_Name+ "</contract_img1_Name><contract_img2 xsi:type='soapenc:string' xmlns:soapenc='http://schemas.xmlsoap.org/soap/encoding/'>"+contract_img2+ "</contract_img2><contract_img2_Body xsi:type='soapenc:base64Binary' xmlns:soapenc='http://schemas.xmlsoap.org/soap/encoding/'>"+ contract_img2_Body + "</contract_img2_Body><contract_img2_Length xsi:type='xsd:int'>"+ contract_img2_Length+ "</contract_img2_Length><contract_img2_Name xsi:type='soapenc:string' xmlns:soapenc='http://schemas.xmlsoap.org/soap/encoding/'>"+ contract_img2_Name+ "</contract_img2_Name><country xsi:type='soapenc:string' xmlns:soapenc='http://schemas.xmlsoap.org/soap/encoding/'>"+ countryy+ "</country><cust_img xsi:type='soapenc:string' xmlns:soapenc='http://schemas.xmlsoap.org/soap/encoding/'>"+cust_img+"</cust_img><cust_img_Body xsi:type='soapenc:base64Binary' xmlns:soapenc='http://schemas.xmlsoap.org/soap/encoding/'>"+cust_img_Body+"</cust_img_Body><cust_img_Length xsi:type='xsd:int'>"+cust_img_Length+"</cust_img_Length><cust_img_Name xsi:type='soapenc:string' xmlns:soapenc='http://schemas.xmlsoap.org/soap/encoding/'>"+cust_img_Name+"</cust_img_Name><customer_type xsi:type='soapenc:string' xmlns:soapenc='http://schemas.xmlsoap.org/soap/encoding/'>"+customer_type+"</customer_type><dateOfIssue xsi:type='soapenc:string' xmlns:soapenc='http://schemas.xmlsoap.org/soap/encoding/'>"+dateOfIssue+"</dateOfIssue><district xsi:type='soapenc:string' xmlns:soapenc='http://schemas.xmlsoap.org/soap/encoding/'>"+district+"</district><dob xsi:type='soapenc:string' xmlns:soapenc='http://schemas.xmlsoap.org/soap/encoding/'>"+dob+"</dob><firstName xsi:type='soapenc:string' xmlns:soapenc='http://schemas.xmlsoap.org/soap/encoding/'>"+firstName+"</firstName><fullName xsi:type='soapenc:string' xmlns:soapenc='http://schemas.xmlsoap.org/soap/encoding/'>"+fullName+"</fullName><gender xsi:type='soapenc:string' xmlns:soapenc='http://schemas.xmlsoap.org/soap/encoding/'>"+gender+"</gender><idCard xsi:type='soapenc:string' xmlns:soapenc='http://schemas.xmlsoap.org/soap/encoding/'>"+idCard+"</idCard><imgBody xsi:type='soapenc:base64Binary' xmlns:soapenc='http://schemas.xmlsoap.org/soap/encoding/'>"+imgBody+"</imgBody><imgID xsi:type='soapenc:string' xmlns:soapenc='http://schemas.xmlsoap.org/soap/encoding/'>"+imgID+"</imgID><imgID_2 xsi:type='soapenc:string' xmlns:soapenc='http://schemas.xmlsoap.org/soap/encoding/'>"+imgID_2+"</imgID_2><imgID_2_Body xsi:type='soapenc:base64Binary' xmlns:soapenc='http://schemas.xmlsoap.org/soap/encoding/'>"+imgID_2_Body+"</imgID_2_Body><imgID_2_Length xsi:type='xsd:int'>"+imgID_2_Length+"</imgID_2_Length><imgID_2_Name xsi:type='soapenc:string' xmlns:soapenc='http://schemas.xmlsoap.org/soap/encoding/'>"+imgID_2_Name+"</imgID_2_Name><imgLength xsi:type='xsd:int'>"+imgLength+"</imgLength><imgName xsi:type='soapenc:string' xmlns:soapenc='http://schemas.xmlsoap.org/soap/encoding/'>"+imgName+"</imgName><lastName xsi:type='soapenc:string' xmlns:soapenc='http://schemas.xmlsoap.org/soap/encoding/'>"+lastName+"</lastName><mdn xsi:type='ent:Mdn' xmlns:ent='http://entity.oom3.fss.com'><compactMdn xsi:type='xsd:string'>"+compactMdn+"</compactMdn><fullMdn xsi:type='xsd:string'>"+fullMdn+"</fullMdn><mdn xsi:type='xsd:string'>"+mdn+"</mdn><normalMdn xsi:type='xsd:string'>"+normalMdn+"</normalMdn></mdn><placeOfIssue xsi:type='soapenc:string' xmlns:soapenc='http://schemas.xmlsoap.org/soap/encoding/'>"+placeOfIssue+"</placeOfIssue><province xsi:type='soapenc:string' xmlns:soapenc='http://schemas.xmlsoap.org/soap/encoding/'>"+province+"</province><signature_Body xsi:type='soapenc:base64Binary' xmlns:soapenc='http://schemas.xmlsoap.org/soap/encoding/'>"+signature_Body+"</signature_Body><signature_Id xsi:type='soapenc:string' xmlns:soapenc='http://schemas.xmlsoap.org/soap/encoding/'>"+signature_Id+"</signature_Id><signature_Length xsi:type='xsd:int'>"+signature_Length+"</signature_Length><signature_Name xsi:type='soapenc:string' xmlns:soapenc='http://schemas.xmlsoap.org/soap/encoding/'>"+signature_Name+"</signature_Name><taxCode xsi:type='soapenc:string' xmlns:soapenc='http://schemas.xmlsoap.org/soap/encoding/'>"+taxCode+"</taxCode></req><in xsi:type='sms:BasicInput' xmlns:sms='http://SMSUtility.fss.com'><username xsi:type='soapenc:string' xmlns:soapenc='http://schemas.xmlsoap.org/soap/encoding/'>"+username+"</username><password xsi:type='soapenc:string' xmlns:soapenc='http://schemas.xmlsoap.org/soap/encoding/'>"+password+"</password><agentMsIsdn xsi:type='soapenc:string' xmlns:soapenc='http://schemas.xmlsoap.org/soap/encoding/'>"+agentMsIsdn+"</agentMsIsdn><mpin xsi:type='soapenc:string' xmlns:soapenc='http://schemas.xmlsoap.org/soap/encoding/'>"+mpin+"</mpin><tokenKey xsi:type='soapenc:string' xmlns:soapenc='http://schemas.xmlsoap.org/soap/encoding/'>"+tokenKey+"</tokenKey></in></ser:updateCustomerInfor></soapenv:Body></soapenv:Envelope>";
			method.setRequestBody(requestBody);
			int returncode = client.executeMethod(method);
			//System.out.println("requestBody UPDATE_CUST : " + requestBody);

			if (returncode == 200) {
				responseBody = method.getResponseBodyAsString();
				//System.out.println("responseBody UPDATE_CUST: " + responseBody);
				customerInforModelList = parseResponseBody(responseBody);
				String micMessage = customerInforModelList.get(0).getMessage();
				String micStatus = customerInforModelList.get(0).getStatus();
				String micTransId = customerInforModelList.get(0).getTransId();
				 //for production only
				if(micStatus.equalsIgnoreCase("0") || micMessage.contains("STK-906")){
					
					
					if(mode.equalsIgnoreCase("prod")){
						//for prod server
					updateMicStatusInitDB(mdn,1);
					updateLogForMicStatusEpos(mdn, micMessage,client_type);
					}
					else
					{
						//for dev server 
						//micInformationService.saveMicStatus(msisdn, msisdn, "1");
					}
					
				}
				else{
					if(mode.equalsIgnoreCase("prod")){
					updateLogForMicStatusEpos(mdn, micMessage,client_type);
					}
					 
				}
				//write the update status in both table
			} else {
				responseBody = "Something went wrong!";
			}

		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return customerInforModelList;
	}
	
	
	
	@SuppressWarnings("deprecation")
	public List<UpdateCustomerInforModel> updateMicInEposWithGender(String tokenKeystr,String firstName_cust, String lastName_cust, String dob_cust, String idCard_cust,
			String date_of_issue, String placeOfIssue_cust, String address, String province_cust, String districtt, String country,
			String msisdn, String firstSideIdcard, String secondSideIdcard, String customerPortrait,
			String customerSignature, String client_type, String gender) {
		
		
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
			
			method.addRequestHeader("Content-Type", "text/xml;charset=utf-8");

			String addres = address;//"HANAOI";
			String companyName = "oneclick";//"";//"oneclick";
			String contract_img1 = "";//msisdn+"_firstside_idcard"+".jpg";//"FirstSideID.jpg";
			String contract_img1_Body = "";//firstSideIdcard;//"";
			String contract_img1_Length = "0";
			String contract_img1_Name = msisdn+"_firstside_idcard"+".jpg";//"FirstSideID.jpg";
			
			String contract_img2 = "";// msisdn+"_secondside_idcard"+".jpg";//"SecondSideID.jpg";
			String contract_img2_Body = "";//secondSideIdcard;//"";
			String contract_img2_Length = "0";
			String contract_img2_Name = "";//msisdn+"_secondside_idcard"+".jpg";//"SecondSideID.jpg";
			
			String countryy = country;//"Vietnaam";
			String cust_img = msisdn+"_cust_portrait";//msisdn+"_portrait"+".jpg";//"cust_portrait.jpg";
			String cust_img_Body = customerPortrait;//"";
			String cust_img_Length = String.valueOf(customerPortrait.length());//"0";
			String cust_img_Name = msisdn.concat("3")+".jpg";//msisdn+"_portrait"+".jpg";//"cust_portrait.jpg";
			
			String customer_type = "1";
			String dateOfIssue = date_of_issue;//"12/12/2011";
			String district = districtt;//"sdsdsds";
			String dob = dob_cust;//"12/12/1990";
			String firstName = firstName_cust;//"Dhiraj";
			
			 gender = ""+gender;
			String idCard = idCard_cust;//"123456789";
			String imgBody = firstSideIdcard;//"";
			String imgID = msisdn+"_firstside_idcard";//"0";
			String imgID_2 = msisdn+"_secondside_idcard";//"";
			String imgID_2_Body = secondSideIdcard;//"";//customerSignature;//"";
			String imgID_2_Length =String.valueOf(secondSideIdcard.length());//"";// String.valueOf(customerSignature.length());//"0";
			String imgID_2_Name = msisdn.concat("2")+".jpg";//"";//msisdn+"_sign"+".jpg";//"cust_signature.jpg";
			String imgLength = String.valueOf(firstSideIdcard.length());//"0";
			String imgName = msisdn.concat("1")+".jpg";//"";//msisdn+"_sign"+".jpg";//"cust_signature.jpg";
			String lastName = lastName_cust;//"Kumar";
			String fullName = firstName+" "+lastName; //"Dhiraj Kumar";
			String compactMdn = "";
			String fullMdn = "";
			String mdn = msisdn;
			String normalMdn = "";

			String placeOfIssue = placeOfIssue_cust;//"Hanaoi";
			String province = province_cust;//"dsdsds";
			String taxCode = "";
	 
			String tokenKey = tokenKeystr;
			String signature_Id=msisdn+"_cust_signature";
            String signature_Body=customerSignature;
            String signature_Length=String.valueOf(customerSignature.length());
            String signature_Name=msisdn.concat("4")+".jpg";
            
          
    	//	String requestBody = "<soapenv:Envelope xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' xmlns:xsd='http://www.w3.org/2001/XMLSchema' xmlns:soapenv='http://schemas.xmlsoap.org/soap/envelope/' xmlns:ser='http://services.SMSUtility.fss.com'><soapenv:Header/><soapenv:Body><ser:updateCustomerInfor soapenv:encodingStyle='http://schemas.xmlsoap.org/soap/encoding/'><req xsi:type='ser:UpdateCustomerRequest' xmlns:ser='http://service.oom3.fss.com'><address xsi:type='soapenc:string' xmlns:soapenc='http://schemas.xmlsoap.org/soap/encoding/'>"+ addres+"</address><companyName xsi:type='soapenc:string' xmlns:soapenc='http://schemas.xmlsoap.org/soap/encoding/'>"+ companyName+"</companyName><contract_img1 xsi:type='soapenc:string' xmlns:soapenc='http://schemas.xmlsoap.org/soap/encoding/'>"+ contract_img1+"</contract_img1><contract_img1_Body xsi:type='soapenc:base64Binary' xmlns:soapenc='http://schemas.xmlsoap.org/soap/encoding/'>"+contract_img1_Body+"</contract_img1_Body><contract_img1_Length xsi:type='xsd:int'>"+contract_img1_Length+"</contract_img1_Length><contract_img1_Name xsi:type='soapenc:string' xmlns:soapenc='http://schemas.xmlsoap.org/soap/encoding/'>"+ contract_img1_Name+ "</contract_img1_Name><contract_img2 xsi:type='soapenc:string' xmlns:soapenc='http://schemas.xmlsoap.org/soap/encoding/'>"+contract_img2+ "</contract_img2><contract_img2_Body xsi:type='soapenc:base64Binary' xmlns:soapenc='http://schemas.xmlsoap.org/soap/encoding/'>"+ contract_img2_Body + "</contract_img2_Body><contract_img2_Length xsi:type='xsd:int'>"+ contract_img2_Length+ "</contract_img2_Length><contract_img2_Name xsi:type='soapenc:string' xmlns:soapenc='http://schemas.xmlsoap.org/soap/encoding/'>"+ contract_img2_Name+ "</contract_img2_Name><country xsi:type='soapenc:string' xmlns:soapenc='http://schemas.xmlsoap.org/soap/encoding/'>"+ countryy+ "</country><cust_img xsi:type='soapenc:string' xmlns:soapenc='http://schemas.xmlsoap.org/soap/encoding/'>"+cust_img+"</cust_img><cust_img_Body xsi:type='soapenc:base64Binary' xmlns:soapenc='http://schemas.xmlsoap.org/soap/encoding/'>"+cust_img_Body+"</cust_img_Body><cust_img_Length xsi:type='xsd:int'>"+cust_img_Length+"</cust_img_Length><cust_img_Name xsi:type='soapenc:string' xmlns:soapenc='http://schemas.xmlsoap.org/soap/encoding/'>"+cust_img_Name+"</cust_img_Name><customer_type xsi:type='soapenc:string' xmlns:soapenc='http://schemas.xmlsoap.org/soap/encoding/'>"+customer_type+"</customer_type><dateOfIssue xsi:type='soapenc:string' xmlns:soapenc='http://schemas.xmlsoap.org/soap/encoding/'>"+dateOfIssue+"</dateOfIssue><district xsi:type='soapenc:string' xmlns:soapenc='http://schemas.xmlsoap.org/soap/encoding/'>"+district+"</district><dob xsi:type='soapenc:string' xmlns:soapenc='http://schemas.xmlsoap.org/soap/encoding/'>"+dob+"</dob><firstName xsi:type='soapenc:string' xmlns:soapenc='http://schemas.xmlsoap.org/soap/encoding/'>"+firstName+"</firstName><fullName xsi:type='soapenc:string' xmlns:soapenc='http://schemas.xmlsoap.org/soap/encoding/'>"+fullName+"</fullName><gender xsi:type='soapenc:string' xmlns:soapenc='http://schemas.xmlsoap.org/soap/encoding/'>"+gender+"</gender><idCard xsi:type='soapenc:string' xmlns:soapenc='http://schemas.xmlsoap.org/soap/encoding/'>"+idCard+"</idCard><imgBody xsi:type='soapenc:base64Binary' xmlns:soapenc='http://schemas.xmlsoap.org/soap/encoding/'>"+imgBody+"</imgBody><imgID xsi:type='soapenc:string' xmlns:soapenc='http://schemas.xmlsoap.org/soap/encoding/'>"+imgID+"</imgID><imgID_2 xsi:type='soapenc:string' xmlns:soapenc='http://schemas.xmlsoap.org/soap/encoding/'>"+imgID_2+"</imgID_2><imgID_2_Body xsi:type='soapenc:base64Binary' xmlns:soapenc='http://schemas.xmlsoap.org/soap/encoding/'>"+imgID_2_Body+"</imgID_2_Body><imgID_2_Length xsi:type='xsd:int'>"+imgID_2_Length+"</imgID_2_Length><imgID_2_Name xsi:type='soapenc:string' xmlns:soapenc='http://schemas.xmlsoap.org/soap/encoding/'>"+imgID_2_Name+"</imgID_2_Name><imgLength xsi:type='xsd:int'>"+imgLength+"</imgLength><imgName xsi:type='soapenc:string' xmlns:soapenc='http://schemas.xmlsoap.org/soap/encoding/'>"+imgName+"</imgName><lastName xsi:type='soapenc:string' xmlns:soapenc='http://schemas.xmlsoap.org/soap/encoding/'>"+lastName+"</lastName><mdn xsi:type='ent:Mdn' xmlns:ent='http://entity.oom3.fss.com'><compactMdn xsi:type='xsd:string'>"+compactMdn+"</compactMdn><fullMdn xsi:type='xsd:string'>"+fullMdn+"</fullMdn><mdn xsi:type='xsd:string'>"+mdn+"</mdn><normalMdn xsi:type='xsd:string'>"+normalMdn+"</normalMdn></mdn><placeOfIssue xsi:type='soapenc:string' xmlns:soapenc='http://schemas.xmlsoap.org/soap/encoding/'>"+placeOfIssue+"</placeOfIssue><province xsi:type='soapenc:string' xmlns:soapenc='http://schemas.xmlsoap.org/soap/encoding/'>"+province+"</province><taxCode xsi:type='soapenc:string' xmlns:soapenc='http://schemas.xmlsoap.org/soap/encoding/'>"+taxCode+"</taxCode></req><in xsi:type='sms:BasicInput' xmlns:sms='http://SMSUtility.fss.com'><username xsi:type='soapenc:string' xmlns:soapenc='http://schemas.xmlsoap.org/soap/encoding/'>"+username+"</username><password xsi:type='soapenc:string' xmlns:soapenc='http://schemas.xmlsoap.org/soap/encoding/'>"+password+"</password><agentMsIsdn xsi:type='soapenc:string' xmlns:soapenc='http://schemas.xmlsoap.org/soap/encoding/'>"+agentMsIsdn+"</agentMsIsdn><mpin xsi:type='soapenc:string' xmlns:soapenc='http://schemas.xmlsoap.org/soap/encoding/'>"+mpin+"</mpin><tokenKey xsi:type='soapenc:string' xmlns:soapenc='http://schemas.xmlsoap.org/soap/encoding/'>"+tokenKey+"</tokenKey></in></ser:updateCustomerInfor></soapenv:Body></soapenv:Envelope>";
			
			//sign
			String requestBody = "<soapenv:Envelope xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' xmlns:xsd='http://www.w3.org/2001/XMLSchema' xmlns:soapenv='http://schemas.xmlsoap.org/soap/envelope/' xmlns:ser='http://services.SMSUtility.fss.com'><soapenv:Header/><soapenv:Body><ser:updateCustomerInfor soapenv:encodingStyle='http://schemas.xmlsoap.org/soap/encoding/'><req xsi:type='ser:UpdateCustomerRequest' xmlns:ser='http://service.oom3.fss.com'><address xsi:type='soapenc:string' xmlns:soapenc='http://schemas.xmlsoap.org/soap/encoding/'>"+ addres+"</address><companyName xsi:type='soapenc:string' xmlns:soapenc='http://schemas.xmlsoap.org/soap/encoding/'>"+ companyName+"</companyName><contract_img1 xsi:type='soapenc:string' xmlns:soapenc='http://schemas.xmlsoap.org/soap/encoding/'>"+ contract_img1+"</contract_img1><contract_img1_Body xsi:type='soapenc:base64Binary' xmlns:soapenc='http://schemas.xmlsoap.org/soap/encoding/'>"+contract_img1_Body+"</contract_img1_Body><contract_img1_Length xsi:type='xsd:int'>"+contract_img1_Length+"</contract_img1_Length><contract_img1_Name xsi:type='soapenc:string' xmlns:soapenc='http://schemas.xmlsoap.org/soap/encoding/'>"+ contract_img1_Name+ "</contract_img1_Name><contract_img2 xsi:type='soapenc:string' xmlns:soapenc='http://schemas.xmlsoap.org/soap/encoding/'>"+contract_img2+ "</contract_img2><contract_img2_Body xsi:type='soapenc:base64Binary' xmlns:soapenc='http://schemas.xmlsoap.org/soap/encoding/'>"+ contract_img2_Body + "</contract_img2_Body><contract_img2_Length xsi:type='xsd:int'>"+ contract_img2_Length+ "</contract_img2_Length><contract_img2_Name xsi:type='soapenc:string' xmlns:soapenc='http://schemas.xmlsoap.org/soap/encoding/'>"+ contract_img2_Name+ "</contract_img2_Name><country xsi:type='soapenc:string' xmlns:soapenc='http://schemas.xmlsoap.org/soap/encoding/'>"+ countryy+ "</country><cust_img xsi:type='soapenc:string' xmlns:soapenc='http://schemas.xmlsoap.org/soap/encoding/'>"+cust_img+"</cust_img><cust_img_Body xsi:type='soapenc:base64Binary' xmlns:soapenc='http://schemas.xmlsoap.org/soap/encoding/'>"+cust_img_Body+"</cust_img_Body><cust_img_Length xsi:type='xsd:int'>"+cust_img_Length+"</cust_img_Length><cust_img_Name xsi:type='soapenc:string' xmlns:soapenc='http://schemas.xmlsoap.org/soap/encoding/'>"+cust_img_Name+"</cust_img_Name><customer_type xsi:type='soapenc:string' xmlns:soapenc='http://schemas.xmlsoap.org/soap/encoding/'>"+customer_type+"</customer_type><dateOfIssue xsi:type='soapenc:string' xmlns:soapenc='http://schemas.xmlsoap.org/soap/encoding/'>"+dateOfIssue+"</dateOfIssue><district xsi:type='soapenc:string' xmlns:soapenc='http://schemas.xmlsoap.org/soap/encoding/'>"+district+"</district><dob xsi:type='soapenc:string' xmlns:soapenc='http://schemas.xmlsoap.org/soap/encoding/'>"+dob+"</dob><firstName xsi:type='soapenc:string' xmlns:soapenc='http://schemas.xmlsoap.org/soap/encoding/'>"+firstName+"</firstName><fullName xsi:type='soapenc:string' xmlns:soapenc='http://schemas.xmlsoap.org/soap/encoding/'>"+fullName+"</fullName><gender xsi:type='soapenc:string' xmlns:soapenc='http://schemas.xmlsoap.org/soap/encoding/'>"+gender+"</gender><idCard xsi:type='soapenc:string' xmlns:soapenc='http://schemas.xmlsoap.org/soap/encoding/'>"+idCard+"</idCard><imgBody xsi:type='soapenc:base64Binary' xmlns:soapenc='http://schemas.xmlsoap.org/soap/encoding/'>"+imgBody+"</imgBody><imgID xsi:type='soapenc:string' xmlns:soapenc='http://schemas.xmlsoap.org/soap/encoding/'>"+imgID+"</imgID><imgID_2 xsi:type='soapenc:string' xmlns:soapenc='http://schemas.xmlsoap.org/soap/encoding/'>"+imgID_2+"</imgID_2><imgID_2_Body xsi:type='soapenc:base64Binary' xmlns:soapenc='http://schemas.xmlsoap.org/soap/encoding/'>"+imgID_2_Body+"</imgID_2_Body><imgID_2_Length xsi:type='xsd:int'>"+imgID_2_Length+"</imgID_2_Length><imgID_2_Name xsi:type='soapenc:string' xmlns:soapenc='http://schemas.xmlsoap.org/soap/encoding/'>"+imgID_2_Name+"</imgID_2_Name><imgLength xsi:type='xsd:int'>"+imgLength+"</imgLength><imgName xsi:type='soapenc:string' xmlns:soapenc='http://schemas.xmlsoap.org/soap/encoding/'>"+imgName+"</imgName><lastName xsi:type='soapenc:string' xmlns:soapenc='http://schemas.xmlsoap.org/soap/encoding/'>"+lastName+"</lastName><mdn xsi:type='ent:Mdn' xmlns:ent='http://entity.oom3.fss.com'><compactMdn xsi:type='xsd:string'>"+compactMdn+"</compactMdn><fullMdn xsi:type='xsd:string'>"+fullMdn+"</fullMdn><mdn xsi:type='xsd:string'>"+mdn+"</mdn><normalMdn xsi:type='xsd:string'>"+normalMdn+"</normalMdn></mdn><placeOfIssue xsi:type='soapenc:string' xmlns:soapenc='http://schemas.xmlsoap.org/soap/encoding/'>"+placeOfIssue+"</placeOfIssue><province xsi:type='soapenc:string' xmlns:soapenc='http://schemas.xmlsoap.org/soap/encoding/'>"+province+"</province><signature_Body xsi:type='soapenc:base64Binary' xmlns:soapenc='http://schemas.xmlsoap.org/soap/encoding/'>"+signature_Body+"</signature_Body><signature_Id xsi:type='soapenc:string' xmlns:soapenc='http://schemas.xmlsoap.org/soap/encoding/'>"+signature_Id+"</signature_Id><signature_Length xsi:type='xsd:int'>"+signature_Length+"</signature_Length><signature_Name xsi:type='soapenc:string' xmlns:soapenc='http://schemas.xmlsoap.org/soap/encoding/'>"+signature_Name+"</signature_Name><taxCode xsi:type='soapenc:string' xmlns:soapenc='http://schemas.xmlsoap.org/soap/encoding/'>"+taxCode+"</taxCode></req><in xsi:type='sms:BasicInput' xmlns:sms='http://SMSUtility.fss.com'><username xsi:type='soapenc:string' xmlns:soapenc='http://schemas.xmlsoap.org/soap/encoding/'>"+username+"</username><password xsi:type='soapenc:string' xmlns:soapenc='http://schemas.xmlsoap.org/soap/encoding/'>"+password+"</password><agentMsIsdn xsi:type='soapenc:string' xmlns:soapenc='http://schemas.xmlsoap.org/soap/encoding/'>"+agentMsIsdn+"</agentMsIsdn><mpin xsi:type='soapenc:string' xmlns:soapenc='http://schemas.xmlsoap.org/soap/encoding/'>"+mpin+"</mpin><tokenKey xsi:type='soapenc:string' xmlns:soapenc='http://schemas.xmlsoap.org/soap/encoding/'>"+tokenKey+"</tokenKey></in></ser:updateCustomerInfor></soapenv:Body></soapenv:Envelope>";
			method.setRequestBody(requestBody);
			//System.out.println("requestBody UPDATE_CUST : " + requestBody);
			
			int returncode = client.executeMethod(method);
			 
			if (returncode == 200) {
				responseBody = method.getResponseBodyAsString();
				//System.out.println("responseBody UPDATE_CUST: " + responseBody);
				customerInforModelList = parseResponseBody(responseBody);
				String micMessage = customerInforModelList.get(0).getMessage();
				String micStatus = customerInforModelList.get(0).getStatus();
				String micTransId = customerInforModelList.get(0).getTransId();
				 //for production only
				if(micStatus.equalsIgnoreCase("0") || micMessage.contains("STK-906")){
				 
					if(mode.equalsIgnoreCase("prod")){
						//for prod server
					updateMicStatusInitDB(mdn,1);
					updateLogForMicStatusEpos(mdn, micMessage,client_type);
					}
					else
					{
						//for dev server 
						//micInformationService.saveMicStatus(msisdn, msisdn, "1");
					}
				}
				else{
					 
					if(mode.equalsIgnoreCase("prod")){
						//for prod server
						updateLogForMicStatusEpos(mdn, micMessage,client_type);
						}
					 
				}
				//write the update status in both table
			} else {
				responseBody = "Something went wrong!";
			}

		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return customerInforModelList;
	}

	public List<UpdateCustomerInforModel> parseResponseBody(String responseBody) {

		//System.out.println(responseBody);
		UpdateCustomerInforModel updateCustomerInforModel = new UpdateCustomerInforModel();
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		InputSource is;
		try {
			builder = factory.newDocumentBuilder();
			is = new InputSource(new StringReader(responseBody));
			Document doc = builder.parse(is);
			NodeList listTransId = doc.getElementsByTagName("transId");
			NodeList listStatus = doc.getElementsByTagName("status");
			NodeList listMsg = doc.getElementsByTagName("message");

			//System.out.println(listTransId.item(0).getTextContent());
			//System.out.println(listStatus.item(0).getTextContent());
			//System.out.println(listMsg.item(0).getTextContent());

			updateCustomerInforModel.setTransId(listTransId.item(0).getTextContent());
			updateCustomerInforModel.setStatus(listStatus.item(0).getTextContent());
			updateCustomerInforModel.setMessage(listMsg.item(0).getTextContent());

			customerInforModelList.add(updateCustomerInforModel);

		} catch (ParserConfigurationException e) {
		} catch (SAXException e) {
		} catch (IOException e) {
		}
		return customerInforModelList;
	}
	/**
	 *  MIC status Update
	 * @throws SQLException 
	 */
	public void updateMicStatusInitDB(String msisdn, int micStatus) throws SQLException{
		Connection connection=null;
		Statement statement=null;
		try{
			   
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url ="jdbc:oracle:thin:@(DESCRIPTION =(ADDRESS = (PROTOCOL = TCP)(HOST = "+host+")(PORT = 1526))(CONNECT_DATA = (SERVER = DEDICATED)(SERVICE_NAME = WSCDBP)))";
 
			  connection = DriverManager.getConnection(url,dbusername,dbpassword);
			 
			  statement= connection.createStatement();
		      String query = "Update app_ccw.TB_SUBS_UPDATE_INFO@INET11G b set b.status =1 where b.status =0 and b.msisdn ='"+msisdn+"'";
			  statement.executeUpdate(query);
		
				
		}
		
		catch(Exception exception){
			exception.printStackTrace();
		}
		finally {
			 
			connection.close();
			statement.close();
		 
	}
	}
	
	/*
	 *  MIC status LOG update
	 */
	
	public void updateLogForMicStatusEpos(String msisdn, String micMessage,String micClientType) throws SQLException{
		Connection connection=null;
		Statement statement=null;
		try{
			  
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//String url = "jdbc:oracle:thin:@10.6.16.32:1526:WSCDBP";
			String url ="jdbc:oracle:thin:@(DESCRIPTION =(ADDRESS = (PROTOCOL = TCP)(HOST = "+host+")(PORT = 1526))(CONNECT_DATA = (SERVER = DEDICATED)(SERVICE_NAME = WSCDBP)))";
			
			  connection = DriverManager.getConnection(url,dbusername,dbpassword);
			 
			  statement= connection.createStatement();
			String query ="INSERT INTO app_ccw.TB_SUBS_UPDATE_INFO_SC_LOG@INET11G (message, client_type,msisdn) VALUES ('"+micMessage +"', '"+micClientType+"','"+msisdn+"')";
		//	String query ="INSERT INTO app_ccw.TB_SUBS_UPDATE_INFO_SC_LOG@INET11G (message, client_type,msisdn, action_date) VALUES ("+micMessage +", "+micClientType+","+msisdn +","+ data_value+")";
	
			statement.executeUpdate(query);
			
				
		}
		
		catch(Exception exception){
			exception.printStackTrace();
		}
		finally {
			 
				connection.close();
				statement.close();
			 
		}
	}
	
}
