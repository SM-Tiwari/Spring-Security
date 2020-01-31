package com.gnv.vnm.selfcare.core.test;

import java.util.Date;
import java.util.List;

import com.gnv.vnm.selfcare.core.adapter.sv.ws.CommonService;
import com.gnv.vnm.selfcare.core.adapter.tibco.SelfcareInboundService;
import com.gnv.vnm.selfcare.core.model.TopUpHistory;

public class TibcoTest {

	static final String msisdn = "841888044003";
	private static final String SOURCE_NAME = "selfcare";
	private static final String REQ_ID_PATTERN = "yyyyMMddHHmmssS";
	private static final String TIBCO_SHORT_DATE_PATTERN = "dd/MM/yyyy";
	private static final String TIBCO_LONG_DATE_PATTERN = "dd/MM/yyyy HH:mm:ss";
	private static final String STATUS_CODE_SUCCESS = "00000";
	private static final String STATUS_TEXT_SUCCESS = "SUCCESS";

//	private static final ObjectFactory factory = new ObjectFactory();
	private static SelfcareInboundService inboundService = new SelfcareInboundService();
	private static CommonService commonService = new CommonService();
	static String endpointURL = "http://localhost:45011/Business_Process/Selfcare";

	public static void main(String[] args) {
		
//		String result = commonService.getCommonPortType().migratedServiceRequest(msisdn);
//		System.out.println(result);
//		System.exit(0);
		
//		List<TopUpHistory> list = topUpHistory("0929292010", AppUtils.stringToDate("01/01/2017", "dd/MM/yyyy"), 
//				AppUtils.stringToDate("11/07/2017", "dd/MM/yyyy"));
//		System.out.println(list);
		
		querySubscriber();
	}
	
	public static void querySubscriber(){
		/*
		Request request = factory.createRequest();
		request.setMSISDN(AppUtils.prependCountryCodeToMsisdn(msisdn, AppDefaultValues.COUNTRY_CODE));
		
		SelfcareInbound port = inboundService.getSelfcareInbound();
		BindingProvider bp = (BindingProvider)port;
		bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpointURL);
		
		Response response = port.subscriberQuery(request);
		System.out.println("resp= " + response);
		System.out.println("COS= " + response.getCALLPLAN() );
		System.out.println("Core balance= " + response.getMAINACCOUNTBALANCE() );
		
		List<Balance> balances = new ArrayList<Balance>();
		List<MsgParam.Attribute> attrs = response.getMsgParam().getAttribute();
		for (MsgParam.Attribute attr : attrs){
			Map<String, String> maps = new HashMap<>();
			List<MsgParam.Attribute.AttribDtl> attrDetails = attr.getAttribDtl();
			for (MsgParam.Attribute.AttribDtl dtl : attrDetails){
				maps.put(dtl.getName(), dtl.getValue());
			}
			Balance b = new Balance();
			b.setName(maps.get("BONUS_NAME"));
			if (maps.get("REMAINING_AMOUNT") != null){
				b.setAvailableValue(Integer.parseInt(maps.get("REMAINING_AMOUNT")));
			}
			if (maps.get("ALLOCATED_AMOUNT") != null){
				b.setTotalValue(Integer.parseInt(maps.get("ALLOCATED_AMOUNT")));
			}
			
			Date expDate = AppUtils.stringToDate(maps.get("END_DATE"), "dd/MM/yyyy HH:mm:ss");
			if (expDate != null){
				long validityPeriod = (expDate.getTime() - new Date().getTime())/86400000;
				b.setValidityPeriod((int)validityPeriod);
				b.setExpiryDate(expDate);
				b.setExpiryDateAsString(AppUtils.dateToString(expDate, TIBCO_SHORT_DATE_PATTERN));
			}
			
			String uom = maps.get("BONUS_UOM");
			if (uom != null && uom.equals("Charge")){
				b.setType(BalanceType.PROMOTION);
				b.setUnitName(BalanceUnitName.VND.name());
				
			}else if (uom != null && uom.equals("Seconds")){
				b.setType(BalanceType.VOICE);
				b.setUnitName(BalanceUnitName.SECOND.name());
				
			}else if (uom != null && uom.equals("SMS")){
				b.setType(BalanceType.SMS);
				b.setUnitName(BalanceUnitName.SMS.name());
			}
			
			if (b.getType() != null) balances.add(b);
		}
		
		for (Balance b : balances) System.out.println(b);
		*/
	}

	public static void usageHistory(){

	}
	
	public static List<TopUpHistory> topUpHistory(String subscriberId, Date startDate, Date endDate) {

		/*
		List<TopUpHistory> history = new ArrayList<>();
		
		try {
			VoucherHistory request = factory.createVoucherHistory();
			request.setEndDate(AppUtils.dateToString(endDate, TIBCO_SHORT_DATE_PATTERN));
			request.setMobNum(AppUtils.prependCountryCodeToMsisdn(subscriberId, AppDefaultValues.COUNTRY_CODE));
			request.setStartDate(AppUtils.dateToString(startDate, TIBCO_SHORT_DATE_PATTERN));
			request.setTransactionID(AppUtils.dateToString(new Date(), "yyyyMMddHHmmssSSS"));
			
			VoucherHistory result = inboundService.getSelfcareInbound().topupHistory(request);
			if (result != null && result.getStatusText().equalsIgnoreCase(STATUS_TEXT_SUCCESS)){
				if (result.getVoucherList() != null){
					List<VoucherHistory.VoucherList.VoucherItems> list = result.getVoucherList().getVoucherItems();
					for (VoucherItems item : list){
						TopUpHistory tuh = new TopUpHistory();
						tuh.setAmount(Double.parseDouble(item.getVoucherMoney()));
						tuh.setMsisdn(subscriberId);
						tuh.setStatus(TransactionStatus.SUCCESS);
						tuh.setTimeStamp(AppUtils.stringToDate(item.getTopUpDate(), TIBCO_LONG_DATE_PATTERN));
						tuh.setTimeStampAsString(AppUtils.dateToString(tuh.getTimeStamp(), AppDefaultValues.DATE_TIME_FORMAT));
						tuh.setVoucherCode(item.getPaymentRefNumber());
						
						String originator = item.getSourceRequest();
						tuh.setTypeNameEN(originator);
						tuh.setTypeNameVN(originator);
						
						history.add(tuh);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();;
		}
		return history;
		*/
		return null;
	}
}
