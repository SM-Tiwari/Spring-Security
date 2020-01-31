package com.gnv.vnm.selfcare.core.test;

import java.io.File;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.text.NumberFormat;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.xml.namespace.QName;

public class DummyTest {
	public final static QName qname1 = new QName("http://comverse-in.com/prepaid/ccws", "Service");
	public final static QName qname2 = new javax.xml.namespace.QName("http://comverse-in.com/prepaid/ccws",
			"ServiceSoap");

//	static final String ipAddress = "10.200.37.109";
//	static final String imsi = "452050269482386";
//	static String searchFilter1 = "framed-ip-address=*";
//	static String searchFilter2 = "3gppimsi=*";
//	String host = "localhost";
//	int port = 4667;
//	static String userName = "cn=vmcp0003,o=radius", password = "Vnmcp3";
//
//	public static String USER_AGENT = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_7_3) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.151 Safari/535.19";
//	
//	static final String SEPARATOR = "\\|";
	
	static final String napasReq = "https://payment.napas.com.vn/gateway/vpcdps?vpc_Version=2.2&vpc_Command=queryDR&vpc_AccessCode=V1IE3TN5AM4OBI6L7E8"
			+ "&vpc_Merchant=VIETNAMOBILE&vpc_MerchTxnRef=100217598785581&vpc_User=querydr&vpc_Password=vietnamobile@123&vpc_SecureHash=4689A7905DFF10FE6951DBCE76C32357";
	
	static final String napasResp = "vpc_ExpiredDate=0517&vpc_Command=queryDR&vpc_OrderInfo=786829"
			+ "&vpc_AcqResponseCode=14&vpc_VerType=3DS&vpc_TransactionNo=846732430&vpc_Message=Transaction 100217598785581 is failed"
			+ "&vpc_CardType=Mastercard&vpc_3DSXID=/Ajv0/MuNBobjwR+Ri1p2/mbtO8=&vpc_BatchNo=20170927"
			+ "&vpc_AdditionalData=512345&vpc_Version=2.0&vpc_3DSECI=/Ajv0/MuNBobjwR+Ri1p2/mbtO8="
			+ "&vpc_CurrencyCode=VND&vpc_Locale=en&vpc_VerStatus=M&vpc_Merchant=VIETNAMOBILE&vpc_CardNumber=512345______2346"
			+ "&vpc_TxnResponseCode=29&vpc_Amount=1500000&vpc_SecureHash=E2E0D880B68125F3EC5A7D1C1BA25139"
			+ "&vpc_MerchTxnRef=100217598785581";
	
	public static void main(String[] args){
		
		
		File f = new File("/Users/nandipinto/Temp/Screen Shot 2018-04-12 at 10.49.05.png");//default_avatar.png //Screen Shot 2018-04-12 at 10.49.05.png
		try {
			System.out.println(f.getAbsolutePath());
			System.out.println(Files.probeContentType(f.toPath()));
			
			ImageInputStream iis = ImageIO.createImageInputStream(f);
			Iterator<ImageReader> iter = ImageIO.getImageReaders(iis);
			if (iter.hasNext()) {
				ImageReader ir = iter.next();
				int num = ir.getNumImages(true);
				System.out.println(ir.getFormatName());
			} else {
				System.out.println("not recognized!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.exit(0);
		
		String type = "voice";
		System.out.println(!type.equalsIgnoreCase("VOICE") && !type.equals("SMS"));
		
		System.exit(0);
		
		double d = 1234567890;
		System.out.println(NumberFormat.getInstance().format(d));
		System.out.println(String.format("%f", d));
		System.out.println(String.format("%.2f", d));
		
		System.exit(0);
		
		String[] arr = napasResp.split("&");
		for (String x : arr) {
			String[] nvp = x.split("=");
			if (nvp != null && nvp.length >= 2) {
				System.out.println(nvp[0] + ": " + nvp[1]);
			}
		}
		
		System.exit(0);
		
		String vpc_Version = "2.2";
		String vpc_Command = "queryDR";
		String vpc_AccessCode = "V1IE3TN5AM4OBI6L7E8"; //V1IE3TN5AM4OBI6L7E8
		String vpc_Merchant = "VIETNAMOBILE"; //VIETNAMOBILE
		String vpc_MerchTxnRef = "100217598785581";
		String vpc_User = "querydr"; // //usertest
		String vpc_Password = "vietnamobile@123"; //passtest
		String secretKey = "AF0EAFF75EA44DB0AAE472BE55177CC9";   //833887B940CE4AEF3B47E0B494460ADC
		
		//4689A7905DFF10FE6951DBCE76C32357
		
		String input = secretKey + vpc_AccessCode + vpc_Command + vpc_MerchTxnRef + vpc_Merchant + vpc_Password + vpc_User + vpc_Version ;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(input.getBytes());
			byte byteData[] = md.digest();
			
			StringBuffer sb = new StringBuffer();
	        for (int i = 0; i < byteData.length; i++) {
	         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
	        }

	        System.out.println("Digest(in hex format):: " + sb.toString().toUpperCase());
	        
	        
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	/*
	
	public static int getDays(double amount){
		int days = 0;
		if (amount > 10000){
			if (amount > 20000){
				if (amount > 50000){
					if (amount > 100000){
						if (amount > 200000){
							if (amount > 300000){
								days = 240;
							}else{
								days = 120;
							}
						}else{
							days = 60;
						}
					}else {
						days = 30;
					}
				}else {
					days = 15;
				}
			}else {
				days = 6;
			}
		}else{
			days = 3;
		}
		return days;
	}
	
	private static final CloseableHttpClient httpClient = HttpClients.custom()
            .setUserAgent(USER_AGENT)
            .setDefaultRequestConfig(RequestConfig.custom().setCookieSpec(CookieSpecs.DEFAULT).build())
            .setRedirectStrategy(new LaxRedirectStrategy())
            .build();
	
	
	public static void main(String[] args){
		
		//http://10.8.2.164:19091/VNPGUI/PaymentGateway?sessionToken=8e9e775e-8be4-46ba-aefb-0e040c2ec2b9&id=VigAdbBqFwVIgfo0/PN3yvSbVKOf8UmXJB/qqAdDoEQ=
		//http://10.8.2.164:19091/VNPGUI/PaymentGateway?sessionToken=fa352c7e-2d8d-4c76-bd06-d452cadca125&id=MFSFgt1YKeD9n8D2y5yfZrBVJJTVbd4oZ9D3k7GXXAQ=
		//9bf54def-0971-4244-ba5d-c33428ea5170&id=+YGLNw6BzmwC7YQaLluq5UERiLHnsgZWKGhHF+hon4k= HTTP/1.1[\r][\n]"

		String token = "9bf54def-0971-4244-ba5d-c33428ea5170&id=+YGLNw6BzmwC7YQaLluq5UERiLHnsgZWKGhHF+hon4k=";
		String url = "http://localhost:19091/VNPGUI/PaymentGateway?sessionToken=" + token;  //"http://bit.ly/1c1mBAI"
		
		List<URI> redirectLocations = null;
        CloseableHttpResponse response = null;
         
        try {
            HttpClientContext context = HttpClientContext.create();
            HttpPost http = new HttpPost(url);
            response = httpClient.execute(http, context);
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			response.getEntity().writeTo(out);

			System.out.println("------content-------");
			String s = new String(out.toByteArray());
			System.out.println(s);
           
            // get all redirection locations
            redirectLocations = context.getRedirectLocations();
        } catch(Exception e){ 
        	e.printStackTrace();
        } finally {
            if(response != null) {
                try {
					response.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
            }
        }
        
        if (redirectLocations == null){
        	System.out.println("No redirection links found!");
        	System.exit(0);
        }
        
        System.out.println("Redirection links found:");
        for (URI uri:redirectLocations){
        	System.out.println(uri.toString());
        }
	}
	*/
	
	/*
	public static void main(String[] args) {
		
//		System.out.println(stripCountryCode("84922526405"));
//		System.out.println(new SimplePasswordEncoder().encode("12345678"));
		
		try {
			String msisdn = "849299994545500";
			
			SelfcareInboundService service = new SelfcareInboundService();

			ObjectFactory factory = new ObjectFactory();
			
			System.out.println("------------- Bonus and Promotion -----------------");
			TibcoMessage bonusAndPromotionRequest = factory.createTibcoMessage();
			TibcoMessage.BonusEnquiry enq = factory.createTibcoMessageBonusEnquiry();
			enq.setMSISDN(msisdn);
			bonusAndPromotionRequest.getBonusEnquiry().add(enq);
			Holder<TibcoMessage> holder = new Holder<>(bonusAndPromotionRequest);
			service.getSelfcareInbound().bonusAndPromotion(holder);

			List<TibcoMessage.BonusEnquiry> bonus = holder.value.getBonusEnquiry(); // bonusAndPromotionRequest.getBonusEnquiry();
			for (TibcoMessage.BonusEnquiry be:bonus){
				System.out.println("response(code= " + be.getResponseCode() + ", desc=" + be.getResponseDescription() + ")");
				BONUSINFO bonusInfo = be.getBONUSINFO();
				if (bonusInfo != null){
					List<TibcoMessage.BonusEnquiry.BONUSINFO.Attribute> attrList = be.getBONUSINFO().getAttribute();
					for (TibcoMessage.BonusEnquiry.BONUSINFO.Attribute attr:attrList){
						System.out.println(attr.getAttribDtl().getName()  + "= " + attr.getAttribDtl().getValue());
					}
				}
			}

			System.out.println("\n\n------------- Voucher Top Up -----------------");
			Holder<String> transactionID = new Holder<String>("" + System.currentTimeMillis());
			Holder<String> messageType = new Holder<String>("1");
			Holder<String> stan = new Holder<String>("STAN");
			Holder<String> localTxnDtTime = new Holder<String>("" + System.currentTimeMillis()); //AppUtils.dateToString(new Date(), "dd-MM-yyyy HH:mm:ss.SSS")
			Holder<String> mobNum = new Holder<String>(msisdn);
			Holder<String> voucherNum = new Holder<String>("123456789012");
			Holder<String> actCode = new Holder<String>("123456789012");
			Holder<String> curr = new Holder<String>("VND");
			
			Holder<String> procCode = new Holder<>("");
			Holder<String> voucherBal = new Holder<>("");
			Holder<String> validityDate = new Holder<>("");
			Holder<String> graceDate = new Holder<>("");
			Holder<String> gracePeriod = new Holder<>("");
			Holder<String> addonBalance = new Holder<>("");
			Holder<String> bonusBal = new Holder<>("");
			Holder<String> voucherDenom = new Holder<>("");
			Holder<String> domainID = new Holder<String>("");
			Holder<String> deliveryChannelCtrlID = new Holder<String>("");
			
			List<String> list = new ArrayList<>();
			
			Holder<List<String>> messageID = new Holder<List<String>>(list);
			Holder<List<String>> languageID = new Holder<List<String>>(list);
			Holder<List<String>> priority = new Holder<List<String>>(list);
			Holder<List<String>> businessHourIndicator = new Holder<List<String>>(list);
			Holder<String> vlrId = new Holder<>("");
			Holder<String> cellId = new Holder<>("");
			
			service.getSelfcareInbound().voucherTopUp(transactionID, messageType, procCode, stan, localTxnDtTime,
					mobNum, voucherNum, domainID, deliveryChannelCtrlID, actCode, curr, voucherBal, validityDate,
					graceDate, gracePeriod, addonBalance, bonusBal, voucherDenom, messageID, languageID, priority,
					businessHourIndicator, vlrId, cellId);
			
			System.out.println("transactionID= " + transactionID.value);
			System.out.println("messageType= " + messageType.value);
			System.out.println("stan= " + stan.value);
			System.out.println("localTxnDtTime= " + localTxnDtTime.value);
			System.out.println("mobNum= " + mobNum.value);
			System.out.println("voucherNum= " + voucherNum.value);
			System.out.println("voucherBal= " + voucherBal.value);
			System.out.println("validityDate= " + validityDate.value);
			System.out.println("graceDate= " + graceDate.value);
			System.out.println("gracePeriod= " + gracePeriod.value);
			System.out.println("addonBalance= " + addonBalance.value);
			System.out.println("bonusBal= " + bonusBal.value);
			System.out.println("voucherDenom= " + voucherDenom.value);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static String stripCountryCode(String msisdn){
		if (msisdn.startsWith(AppDefaultValues.COUNTRY_CODE)){
			return "0" + msisdn.substring(msisdn.indexOf(AppDefaultValues.COUNTRY_CODE) + AppDefaultValues.COUNTRY_CODE.length());
		}
		return msisdn.startsWith("0") ? msisdn : "0" + msisdn;
	}
	
	private static Map<String, String> metaDataToMap(Set<?> metadata) {

		Map<String, String> map = new HashMap<>();
		if (metadata != null && metadata.iterator().hasNext()) {
			Iterator<?> it = metadata.iterator();
			while (it.hasNext()) {
				MetaDataEntity mde = (MetaDataEntity) it.next();
				map.put(mde.getName(), mde.getValue());
			}
		}
		return map;
	}
	*/
	
}
