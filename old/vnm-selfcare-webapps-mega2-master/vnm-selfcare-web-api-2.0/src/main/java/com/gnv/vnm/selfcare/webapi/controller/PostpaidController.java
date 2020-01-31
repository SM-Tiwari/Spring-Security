/**
 * Jan 22, 2018 1:43:50 PM
 */
package com.gnv.vnm.selfcare.webapi.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.client.LaxRedirectStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gnv.vnm.selfcare.core.AppDefaultValues;
import com.gnv.vnm.selfcare.core.adapter.BackEndAdapterResponse;
import com.gnv.vnm.selfcare.core.enums.ClientAppId;
import com.gnv.vnm.selfcare.core.enums.SubscriptionStatus;
import com.gnv.vnm.selfcare.core.model.PackageSubscription;
import com.gnv.vnm.selfcare.core.model.UnbilledBalance;
import com.gnv.vnm.selfcare.core.service.impl.XprintFileProcessor;
import com.gnv.vnm.selfcare.core.utils.AppUtils;
import com.gnv.vnm.selfcare.core.utils.LoggingUtil;
import com.gnv.vnm.selfcare.webapi.DefaultApiResponse;
import com.gnv.vnm.selfcare.webapi.model.ApiResponse;
import com.gnv.vnm.selfcare.webapi.model.GetBillingSummaryDetailsResponse;
import com.gnv.vnm.selfcare.webapi.model.GetBillingSummaryResponse;
import com.gnv.vnm.selfcare.webapi.model.GetDeposityBalanceResponse;
import com.gnv.vnm.selfcare.webapi.model.GetOutstandingBalanceResponse;
import com.gnv.vnm.selfcare.webapi.model.GetPostpaidConfigResponse;
import com.gnv.vnm.selfcare.webapi.model.GetRoamingStatusResponse;
import com.gnv.vnm.selfcare.webapi.model.GetUnbilledBalanceResponse;
import com.gnv.vnm.selfcare.webapi.model.VerifyPostpaidResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;

/**
 * @author nandipinto
 *
 */

@Controller
@RequestMapping(value = "/postpaid")
public class PostpaidController extends BaseRestController{
	
	static final String VOICE_ROAMING = "voice";
	static final String SMS_ROAMING = "sms";

	@Autowired
	private XprintFileProcessor xprintFileProcessor;
	
	@GetMapping(value = "/verify/{msisdn}")
	public ResponseEntity<?> isPostPaidSubscriber(@PathVariable String msisdn){
		
		if (!msisdn.equals(getCurrentUserName())) {
			return new ResponseEntity<>(new ApiResponse(false, DefaultApiResponse.UNAUTHORIZED.code(),
				    DefaultApiResponse.UNAUTHORIZED.message()), HttpStatus.UNAUTHORIZED);
		}

		boolean postpaid = tibcoServiceProvider.isPostpaidSubscriber(msisdn);
		VerifyPostpaidResponse response = new VerifyPostpaidResponse(postpaid, 
				DefaultApiResponse.SUCCESS.code(), DefaultApiResponse.SUCCESS.message(), postpaid);
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	/**Comments on 17-12-2018 method name getLastBilling*/
	/*@GetMapping(value = "/unbilled/{msisdn}")
	public ResponseEntity<?> getLastBilling(@PathVariable String msisdn){
		
		if (!msisdn.equals(getCurrentUserName())) {
			return new ResponseEntity<>(new ApiResponse(false, DefaultApiResponse.UNAUTHORIZED.code(),
				    DefaultApiResponse.UNAUTHORIZED.message()), HttpStatus.UNAUTHORIZED);
		}

		UnbilledBalance billSummary = tibcoServiceProvider.getUnbilledBalanceSummary(msisdn);
		if (billSummary != null) {
			
			return new ResponseEntity<>(new GetUnbilledBalanceResponse(true, DefaultApiResponse.SUCCESS.code(),
					DefaultApiResponse.SUCCESS.message(), billSummary), HttpStatus.OK);
		} else {
			
			return new ResponseEntity<>(new GetUnbilledBalanceResponse(false, DefaultApiResponse.SUCCESS.code(),
					DefaultApiResponse.SUCCESS.message()), HttpStatus.OK);
		}
	}*/
	
	@GetMapping(value = "/unbilled/{msisdn}")
	public ResponseEntity<?> getLastBilling(@PathVariable String msisdn){
		
		if (!isCurrentUserNameValid(msisdn)) {
			return new ResponseEntity<>(new ApiResponse(false, DefaultApiResponse.UNAUTHORIZED.code(),
				    DefaultApiResponse.UNAUTHORIZED.message()), HttpStatus.UNAUTHORIZED);
		}

		UnbilledBalance billSummary = tibcoServiceProvider.getUnbilledBalanceSummary(msisdn);
		if (billSummary != null) {
			
			return new ResponseEntity<>(new GetUnbilledBalanceResponse(true, DefaultApiResponse.SUCCESS.code(),
					DefaultApiResponse.SUCCESS.message(), billSummary), HttpStatus.OK);
		} else {
			
			return new ResponseEntity<>(new GetUnbilledBalanceResponse(false, DefaultApiResponse.SUCCESS.code(),
					DefaultApiResponse.SUCCESS.message()), HttpStatus.OK);
		}
	}
	/**Comments on 17-12-2018 method name getBillingHistory*/
	/*@GetMapping(value = "/billinghistory/{msisdn}")
	public ResponseEntity<?> getBillingHistory(@PathVariable String msisdn, 
			@RequestParam(defaultValue = "") String startDate,
			@RequestParam(defaultValue = "") String endDate){
		
		if (!msisdn.equals(getCurrentUserName())) {
			return new ResponseEntity<>(new ApiResponse(false, DefaultApiResponse.UNAUTHORIZED.code(),
				    DefaultApiResponse.UNAUTHORIZED.message()), HttpStatus.UNAUTHORIZED);
		}

		if (!subscriberManagementService.isVnmNumber(msisdn)){
			return new ResponseEntity<>(
					new GetBillingSummaryResponse(false, DefaultApiResponse.NUMBER_NOT_RECOGNIZED.code(),
							String.format(DefaultApiResponse.NUMBER_NOT_RECOGNIZED.message(), msisdn)),
					HttpStatus.OK);
		}
		if (!subscriberManagementService.isActiveSubscriber(msisdn)) {
			return new ResponseEntity<>(
					new GetBillingSummaryResponse(false, DefaultApiResponse.SUBSCRIBER_NOT_FOUND.code(),
							String.format(DefaultApiResponse.SUBSCRIBER_NOT_FOUND.message(), msisdn)),
					HttpStatus.OK);
		}		

		Date from = AppUtils.stringToDate(startDate, "ddMMyyyy");
		Date to = AppUtils.stringToDate(endDate, "ddMMyyyy");;
		
		if (from == null) {
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.MONTH, -3);
			from = cal.getTime();
		}

		if (to == null) {
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.MONTH, -1);
			to = cal.getTime();
		}
		
		GetBillingSummaryResponse response = new GetBillingSummaryResponse(true, DefaultApiResponse.SUCCESS.code(),
				DefaultApiResponse.SUCCESS.message(), tibcoServiceProvider.getBillingHistory(msisdn, from, to));
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}*/
	@GetMapping(value = "/billinghistory/{msisdn}")
	public ResponseEntity<?> getBillingHistory(@PathVariable String msisdn, 
			@RequestParam(defaultValue = "") String startDate,
			@RequestParam(defaultValue = "") String endDate){
		
		if (!isCurrentUserNameValid(msisdn)) {
			return new ResponseEntity<>(new ApiResponse(false, DefaultApiResponse.UNAUTHORIZED.code(),
				    DefaultApiResponse.UNAUTHORIZED.message()), HttpStatus.UNAUTHORIZED);
		}

		if (!subscriberManagementService.isVnmNumber(msisdn)){
			return new ResponseEntity<>(
					new GetBillingSummaryResponse(false, DefaultApiResponse.NUMBER_NOT_RECOGNIZED.code(),
							String.format(DefaultApiResponse.NUMBER_NOT_RECOGNIZED.message(), msisdn)),
					HttpStatus.OK);
		}
		if (!subscriberManagementService.isActiveSubscriber(msisdn)) {
			return new ResponseEntity<>(
					new GetBillingSummaryResponse(false, DefaultApiResponse.SUBSCRIBER_NOT_FOUND.code(),
							String.format(DefaultApiResponse.SUBSCRIBER_NOT_FOUND.message(), msisdn)),
					HttpStatus.OK);
		}		

		Date from = AppUtils.stringToDate(startDate, "ddMMyyyy");
		Date to = AppUtils.stringToDate(endDate, "ddMMyyyy");;
		
		if (from == null) {
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.MONTH, -4);
			from = cal.getTime();
		}

		if (to == null) {
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.MONTH, -1);
			to = cal.getTime();
		}
		
		GetBillingSummaryResponse response = new GetBillingSummaryResponse(true, DefaultApiResponse.SUCCESS.code(),
				DefaultApiResponse.SUCCESS.message(), tibcoServiceProvider.getBillingHistory(msisdn, from, to));
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	@GetMapping(value = "/config")
	public ResponseEntity<?> getMinDepositAmount(){
		
		double depositAmount = Double.parseDouble(applicationConfigurationService.get("postpaid.depositamount.min", "" + AppDefaultValues.MIN_DEPOSIT_AMOUNT).toString());
		GetPostpaidConfigResponse response = new GetPostpaidConfigResponse(true, DefaultApiResponse.SUCCESS.code(), DefaultApiResponse.SUCCESS.message(), depositAmount);
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	/**Comments on 17-12-2018 method name getOutstandingBalance*/
/*	@GetMapping(value = "/outstandingbalance/{msisdn}")
	public ResponseEntity<?> getOutstandingBalance(@PathVariable String msisdn){
		
		if (!msisdn.equals(getCurrentUserName())) {
			return new ResponseEntity<>(new ApiResponse(false, DefaultApiResponse.UNAUTHORIZED.code(),
				    DefaultApiResponse.UNAUTHORIZED.message()), HttpStatus.UNAUTHORIZED);
		}

		if (!subscriberManagementService.isVnmNumber(msisdn)){
			return new ResponseEntity<>(
					new GetBillingSummaryResponse(false, DefaultApiResponse.NUMBER_NOT_RECOGNIZED.code(),
							String.format(DefaultApiResponse.NUMBER_NOT_RECOGNIZED.message(), msisdn)),
					HttpStatus.OK);
		}
		if (!subscriberManagementService.isActiveSubscriber(msisdn)) {
			return new ResponseEntity<>(
					new GetBillingSummaryResponse(false, DefaultApiResponse.SUBSCRIBER_NOT_FOUND.code(),
							String.format(DefaultApiResponse.SUBSCRIBER_NOT_FOUND.message(), msisdn)),
					HttpStatus.OK);
		}		

		GetOutstandingBalanceResponse response = new GetOutstandingBalanceResponse(true,
				DefaultApiResponse.SUCCESS.code(), DefaultApiResponse.SUCCESS.message(),
				tibcoServiceProvider.getOutstandingBalances(msisdn));
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}*/
	@GetMapping(value = "/outstandingbalance/{msisdn}")
	public ResponseEntity<?> getOutstandingBalance(@PathVariable String msisdn){
		
		if (!isCurrentUserNameValid(msisdn)) {
			return new ResponseEntity<>(new ApiResponse(false, DefaultApiResponse.UNAUTHORIZED.code(),
				    DefaultApiResponse.UNAUTHORIZED.message()), HttpStatus.UNAUTHORIZED);
		}

		if (!subscriberManagementService.isVnmNumber(msisdn)){
			return new ResponseEntity<>(
					new GetOutstandingBalanceResponse(false, DefaultApiResponse.NUMBER_NOT_RECOGNIZED.code(),
							String.format(DefaultApiResponse.NUMBER_NOT_RECOGNIZED.message(), msisdn)),
					HttpStatus.OK);
		}
		if (!subscriberManagementService.isActiveSubscriber(msisdn)) {
			return new ResponseEntity<>(
					new GetOutstandingBalanceResponse(false, DefaultApiResponse.SUBSCRIBER_NOT_FOUND.code(),
							String.format(DefaultApiResponse.SUBSCRIBER_NOT_FOUND.message(), msisdn)),
					HttpStatus.OK);
		}		

		GetOutstandingBalanceResponse response = new GetOutstandingBalanceResponse(true,
				DefaultApiResponse.SUCCESS.code(), DefaultApiResponse.SUCCESS.message(),
				tibcoServiceProvider.getOutstandingBalances(msisdn));
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	/**Comments on 17-12-2018 method name getDepositBalance*/
	/*@GetMapping(value = "/depositbalance/{msisdn}")
	public ResponseEntity<?> getDepositBalance(@PathVariable String msisdn){
		
		if (!msisdn.equals(getCurrentUserName())) {
			return new ResponseEntity<>(new ApiResponse(false, DefaultApiResponse.UNAUTHORIZED.code(),
				    DefaultApiResponse.UNAUTHORIZED.message()), HttpStatus.UNAUTHORIZED);
		}

		if (!subscriberManagementService.isVnmNumber(msisdn)){
			return new ResponseEntity<>(
					new GetBillingSummaryResponse(false, DefaultApiResponse.NUMBER_NOT_RECOGNIZED.code(),
							String.format(DefaultApiResponse.NUMBER_NOT_RECOGNIZED.message(), msisdn)),
					HttpStatus.OK);
		}
		if (!subscriberManagementService.isActiveSubscriber(msisdn)) {
			return new ResponseEntity<>(
					new GetBillingSummaryResponse(false, DefaultApiResponse.SUBSCRIBER_NOT_FOUND.code(),
							String.format(DefaultApiResponse.SUBSCRIBER_NOT_FOUND.message(), msisdn)),
					HttpStatus.OK);
		}		

		GetDeposityBalanceResponse response = new GetDeposityBalanceResponse(true,
				DefaultApiResponse.SUCCESS.code(), DefaultApiResponse.SUCCESS.message(),
				tibcoServiceProvider.getDepositBalance(msisdn));
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}*/
	@GetMapping(value = "/depositbalance/{msisdn}")
	public ResponseEntity<?> getDepositBalance(@PathVariable String msisdn){
		
		if (!isCurrentUserNameValid(msisdn)) {
			return new ResponseEntity<>(new ApiResponse(false, DefaultApiResponse.UNAUTHORIZED.code(),
				    DefaultApiResponse.UNAUTHORIZED.message()), HttpStatus.UNAUTHORIZED);
		}

		if (!subscriberManagementService.isVnmNumber(msisdn)){
			return new ResponseEntity<>(
					new GetBillingSummaryResponse(false, DefaultApiResponse.NUMBER_NOT_RECOGNIZED.code(),
							String.format(DefaultApiResponse.NUMBER_NOT_RECOGNIZED.message(), msisdn)),
					HttpStatus.OK);
		}
		if (!subscriberManagementService.isActiveSubscriber(msisdn)) {
			return new ResponseEntity<>(
					new GetBillingSummaryResponse(false, DefaultApiResponse.SUBSCRIBER_NOT_FOUND.code(),
							String.format(DefaultApiResponse.SUBSCRIBER_NOT_FOUND.message(), msisdn)),
					HttpStatus.OK);
		}		

		GetDeposityBalanceResponse response = new GetDeposityBalanceResponse(true,
				DefaultApiResponse.SUCCESS.code(), DefaultApiResponse.SUCCESS.message(),
				tibcoServiceProvider.getDepositBalance(msisdn));
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	/**Comments on 17-12-2018 method name getBillingSummaryDetails*/
	/*
	@GetMapping(value = "/billingdetails/{id}")
	public ResponseEntity<?> getBillingSummaryDetails(@PathVariable int id){
		
		GetBillingSummaryDetailsResponse response = new GetBillingSummaryDetailsResponse(true,
				DefaultApiResponse.SUCCESS.code(), DefaultApiResponse.SUCCESS.message(),
				tibcoServiceProvider.getBillingSummaryDetails(id));
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}*/
	@GetMapping(value = "/billingdetails/{id}")
	public ResponseEntity<?> getBillingSummaryDetails(@PathVariable int id){
		
		GetBillingSummaryDetailsResponse response = new GetBillingSummaryDetailsResponse(true,
				DefaultApiResponse.SUCCESS.code(), DefaultApiResponse.SUCCESS.message(),
				tibcoServiceProvider.getBillingSummaryDetails(id));
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	@PostMapping(value = "/enableroaming/{msisdn}/{type}")
	public ResponseEntity<?> enableRoaming(@PathVariable String msisdn, @PathVariable String type){
		if (!msisdn.equals(getCurrentUserName())) {
			return new ResponseEntity<>(new ApiResponse(false, DefaultApiResponse.UNAUTHORIZED.code(),
				    DefaultApiResponse.UNAUTHORIZED.message()), HttpStatus.UNAUTHORIZED);
		}

		if (!subscriberManagementService.isActiveSubscriber(msisdn)) {
			return new ResponseEntity<>(new ApiResponse(false, DefaultApiResponse.SUBSCRIBER_NOT_FOUND.code(),
					String.format(DefaultApiResponse.SUBSCRIBER_NOT_FOUND.message(), msisdn)), HttpStatus.OK);
		}

		if (!type.equalsIgnoreCase(VOICE_ROAMING) && !type.equalsIgnoreCase(SMS_ROAMING)) {
			return new ResponseEntity<>(new ApiResponse(false, DefaultApiResponse.INVALID_PARAMETER_VALUE.code(),
					String.format(DefaultApiResponse.INVALID_PARAMETER_VALUE.message(), "type")), HttpStatus.OK);
		}
		
		String smsRoamingPkgId = applicationConfigurationService.get("postpaid.packageid.irsms", "1000006").toString();
		String voiceRoamingPkgId = applicationConfigurationService.get("postpaid.packageid.irvoice", "20000100").toString();;
		
		BackEndAdapterResponse result = backEndRequestProcessor.activatePackageSubscription(msisdn,
				type.equalsIgnoreCase(VOICE_ROAMING) ? voiceRoamingPkgId : smsRoamingPkgId, ClientAppId.MOBILE_APP);
		
		return new ResponseEntity<>(new ApiResponse(result.isSuccessful(), result.getResponseCode(), result.getResponseDescription()), HttpStatus.OK);
	}
	
	@PostMapping(value = "/enableroaming/{msisdn}")
	public ResponseEntity<?> enableRoaming(@PathVariable String msisdn /*, @PathVariable String type*/){
		if (!isCurrentUserNameValid(msisdn)) {
			return new ResponseEntity<>(new ApiResponse(false, DefaultApiResponse.UNAUTHORIZED.code(),
				    DefaultApiResponse.UNAUTHORIZED.message()), HttpStatus.UNAUTHORIZED);
		}

		if (!subscriberManagementService.isActiveSubscriber(msisdn)) {
			return new ResponseEntity<>(new ApiResponse(false, DefaultApiResponse.SUBSCRIBER_NOT_FOUND.code(),
					String.format(DefaultApiResponse.SUBSCRIBER_NOT_FOUND.message(), msisdn)), HttpStatus.OK);
		}
		/*
		if (!type.equalsIgnoreCase(VOICE_ROAMING) && !type.equalsIgnoreCase(SMS_ROAMING)) {
			return new ResponseEntity<>(new ApiResponse(false, DefaultApiResponse.INVALID_PARAMETER_VALUE.code(),
					String.format(DefaultApiResponse.INVALID_PARAMETER_VALUE.message(), "type")), HttpStatus.OK);
		}
		String smsRoamingPkgId = applicationConfigurationService.get("postpaid.packageid.irsms", "1000006").toString();
		String voiceRoamingPkgId = applicationConfigurationService.get("postpaid.packageid.irvoice", "20000100").toString();;
		
		BackEndAdapterResponse result = backEndRequestProcessor.activatePackageSubscription(msisdn,
				type.equalsIgnoreCase(VOICE_ROAMING) ? voiceRoamingPkgId : smsRoamingPkgId, ClientAppId.MOBILE_APP);
		*/
		
		String intlRoamingPkgId = applicationConfigurationService.get("postpaid.packageid.intlroaming", "1000006", false).toString();
		BackEndAdapterResponse result = backEndRequestProcessor.activatePackageSubscription(msisdn, intlRoamingPkgId, ClientAppId.MOBILE_APP);
		
		return new ResponseEntity<>(new ApiResponse(result.isSuccessful(), result.getResponseCode(), result.getResponseDescription()), HttpStatus.OK);
	}
	
	@PostMapping(value = "/disableroaming/{msisdn}/{type}")
	public ResponseEntity<?> disableRoaming(@PathVariable String msisdn, @PathVariable String type){
		
		if (!msisdn.equals(getCurrentUserName())) {
			return new ResponseEntity<>(new ApiResponse(false, DefaultApiResponse.UNAUTHORIZED.code(),
				    DefaultApiResponse.UNAUTHORIZED.message()), HttpStatus.UNAUTHORIZED);
		}

		if (!subscriberManagementService.isActiveSubscriber(msisdn)) {
			return new ResponseEntity<>(new ApiResponse(false, DefaultApiResponse.SUBSCRIBER_NOT_FOUND.code(),
					String.format(DefaultApiResponse.SUBSCRIBER_NOT_FOUND.message(), msisdn)), HttpStatus.OK);
		}
		
		if (!type.equalsIgnoreCase(VOICE_ROAMING) && !type.equalsIgnoreCase(SMS_ROAMING)) {
			return new ResponseEntity<>(new ApiResponse(false, DefaultApiResponse.INVALID_PARAMETER_VALUE.code(),
					String.format(DefaultApiResponse.INVALID_PARAMETER_VALUE.message(), "type")), HttpStatus.OK);
		}
		
		String smsRoamingPkgId = applicationConfigurationService.get("postpaid.packageid.irsms", "1000006").toString();
		String voiceRoamingPkgId = applicationConfigurationService.get("postpaid.packageid.irvoice", "20000100").toString();;

		boolean result = backEndRequestProcessor.cancelPackageSubscription(msisdn,
				type.equalsIgnoreCase(VOICE_ROAMING) ? voiceRoamingPkgId : smsRoamingPkgId);
		
		return new ResponseEntity<>(new ApiResponse(result,
				result ? DefaultApiResponse.SUCCESS.code() : DefaultApiResponse.INTERNAL_APP_ERROR.code(), 
						result ? DefaultApiResponse.SUCCESS.message() : DefaultApiResponse.INTERNAL_APP_ERROR.message()), HttpStatus.OK);
	}
	/**Comments on 17-12-2018 method name getRoamingStatus*/
	/*@GetMapping(value = "/roamingstatus/{msisdn}")
	public ResponseEntity<?> getRoamingStatus(@PathVariable String msisdn){
		
		if (!msisdn.equals(getCurrentUserName())) {
			return new ResponseEntity<>(new ApiResponse(false, DefaultApiResponse.UNAUTHORIZED.code(),
					DefaultApiResponse.UNAUTHORIZED.message()), HttpStatus.UNAUTHORIZED);
		}

		if (!subscriberManagementService.isActiveSubscriber(msisdn)) {
			return new ResponseEntity<>(new ApiResponse(false, DefaultApiResponse.SUBSCRIBER_NOT_FOUND.code(),
					String.format(DefaultApiResponse.SUBSCRIBER_NOT_FOUND.message(), msisdn)), HttpStatus.OK);
		}
		
		String smsRoamingPkgId = applicationConfigurationService.get("postpaid.packageid.irsms", "1000006").toString();
		String voiceRoamingPkgId = applicationConfigurationService.get("postpaid.packageid.irvoice", "20000100").toString();;

		GetRoamingStatusResponse response = new GetRoamingStatusResponse(true, DefaultApiResponse.SUCCESS.code(), DefaultApiResponse.SUCCESS.message());
		List<PackageSubscription> list = backEndRequestProcessor.getSubscribedPackages(msisdn, null, null);
		if (list != null) {
			for (PackageSubscription pkg : list) {
				if (pkg.getProduct() != null && pkg.getProduct().getCode() != null) {
					if (pkg.getProduct().getCode().equals(voiceRoamingPkgId)) {
						response.setVoiceRoamingStatus(SubscriptionStatus.ACTIVE);
						
					} else if (pkg.getProduct().getCode().equals(smsRoamingPkgId)) {
						response.setSmsRoamingStatus(SubscriptionStatus.ACTIVE);
					}
				} 
			}
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}*/
	@GetMapping(value = "/roamingstatus/{msisdn}")
	public ResponseEntity<?> getRoamingStatus(@PathVariable String msisdn){
		
		if (!isCurrentUserNameValid(msisdn)) {
			return new ResponseEntity<>(new ApiResponse(false, DefaultApiResponse.UNAUTHORIZED.code(),
					DefaultApiResponse.UNAUTHORIZED.message()), HttpStatus.UNAUTHORIZED);
		}

		if (!subscriberManagementService.isActiveSubscriber(msisdn)) {
			return new ResponseEntity<>(new ApiResponse(false, DefaultApiResponse.SUBSCRIBER_NOT_FOUND.code(),
					String.format(DefaultApiResponse.SUBSCRIBER_NOT_FOUND.message(), msisdn)), HttpStatus.OK);
		}
		
		GetRoamingStatusResponse response = new GetRoamingStatusResponse(true, DefaultApiResponse.SUCCESS.code(), DefaultApiResponse.SUCCESS.message());
		response.setRoamingStatus(subscriberManagementService.getIntlRoamingStatus(msisdn));
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping(value = "/importxprint")
	public ResponseEntity<?> processXprintFiles(){
		
		xprintFileProcessor.processXprintFiles();
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping(value = "/streampdf/{invoiceNo}")
	public ResponseEntity<?> streamPDF(@PathVariable String invoiceNo, HttpServletRequest request, HttpServletResponse response){
	
		//http://10.8.8.171:19599/6dbillingApp/InvoiceDownload?invoice_seq_id=448&file_type=CRM
		String url = applicationConfigurationService.get("invoiceapp.pdfdownload.url", "", true).toString();
		File tempFile = new File(System.getProperty("java.io.tmpdir"), invoiceNo + ".pdf");
		
	//	LoggingUtil.debug(logger, "#downloadPDF --- invoice_no " + invoiceNo + ", URL= " + url);
		if (StringUtils.hasText(invoiceNo) && StringUtils.hasText(url)) {
			
			if (!url.endsWith("?")) url = url + "?";
			url = url + "invoice_seq_id=" + invoiceNo + "&file_type=CRM";
			CloseableHttpClient httpclient = HttpClients.custom().setRedirectStrategy(new LaxRedirectStrategy()).build();
			HttpGet httpGet = new HttpGet(url);
			
			try {
				File downloaded = httpclient.execute(httpGet, new FileDownloadResponseHandler(tempFile));
				
			//	LoggingUtil.debug(logger, "#downloadPDF --- invoice_no " + invoiceNo + ", downloaded file= " + downloaded.getName() + ", " + downloaded.length());
				if (downloaded.exists() && downloaded.length() > 0) {
					
					/*
					response.setContentType("application/x-pdf");
					response.setHeader("Content-disposition", "inline; filename=" + invoiceNo + ".pdf");
					final OutputStream outStream = response.getOutputStream();
					
					FileUtils.copyFile(destFile, outStream);
					*/
					
					HttpHeaders headers = new HttpHeaders();
					headers.setContentType(MediaType.parseMediaType("application/pdf"));
					headers.add("Access-Control-Allow-Headers", "Content-Type");
					headers.add("Content-Disposition", "filename=" + tempFile.getName());
					headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
					headers.add("Pragma", "no-cache");
					headers.add("Expires", "0");
					headers.setContentLength(downloaded.length());

					return new ResponseEntity<InputStreamResource>(new InputStreamResource(new FileInputStream(downloaded)), headers, HttpStatus.OK);
				}
				
			} catch (Exception e) {
				//logger.error("#downloadPDF -- error when downloading PDF file for invoice_no " + invoiceNo, e);
				
			} finally {
				try {
					httpclient.close();
				} catch (IOException e) {
				}
			}
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	static class FileDownloadResponseHandler implements ResponseHandler<File> {

		private final File target;

		public FileDownloadResponseHandler(File target) {
			this.target = target;
		}

		@Override
		public File handleResponse(HttpResponse response) throws ClientProtocolException, IOException {
			InputStream source = response.getEntity().getContent();
			FileUtils.copyInputStreamToFile(source, this.target);
			return this.target;
		}

	}
}
