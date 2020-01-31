/**
* HomeController.java
*/
package com.gnv.vnm.selfcare.webapi.controller;

import static org.bitbucket.dollar.Dollar.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.gnv.vnm.selfcare.dao.entity.MsisdnTokenEntity;
import com.gnv.vnm.selfcare.dao.entity.QMsisdnTokenEntity;
import com.gnv.vnm.selfcare.dao.repo.MsisdnTokenRepo;
import com.gnv.vnm.selfcare.webapi.DefaultApiResponse;
import com.gnv.vnm.selfcare.webapi.model.GenerateToken;
import com.gnv.vnm.selfcare.webapi.model.TokenResponse;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.StringUtils;
/**
 * @author nandipinto
 *
 */
@Controller
public class HomeController extends BaseRestController {
	String validCharacters = $('0', '9').join() + $('A', 'Z').join();

	@Autowired
	MsisdnTokenRepo msisdnRepo;

	@GetMapping("/")
	public String index() {
		return "Index";
	}

	@GetMapping("/home")
	public String home() {
		return "Index";
	}

	String randomString(int length) {
		return $(validCharacters).shuffle().slice(length).toString();
	}

	@GetMapping(value = "/autologin")
	public ResponseEntity<?> Autologin(HttpServletRequest request) {
		ArrayList<String> list = null;
		String ipaddress = "";
		String msisdn = null;
		String token = null;
		String[] ipAdress = null;
		;
		Map<String, String> map = new HashMap<String, String>();
		Enumeration headerNames = request.getHeaderNames();

		while (headerNames.hasMoreElements()) {
			String key = (String) headerNames.nextElement();
			String value = request.getHeader(key);
			if (key.equalsIgnoreCase("autherzietoken")) {
				String tokenvalue = value;
				token = StringUtils.newStringUtf8(Base64.decodeBase64(tokenvalue));
			}
			if (key.equalsIgnoreCase("x-forwarded-for")) {// x-forwarded-for
				if (value != null) {
					ipAdress = value.trim().split(",");
					ipaddress = ipAdress[0];
				}

			}
			if (key.equalsIgnoreCase("msisdn")) {
				list = new ArrayList<>();
				list.add(value);
				// break;
			}
			System.out.println("list size >>>key   " + key + "   >>> value...." + value);
		}

		TokenResponse response = new TokenResponse();
		if (list.size() != 1) {
			response.setMessage(DefaultApiResponse.INVALID_PARAMETER_VALUE.message());
			response.setCode(DefaultApiResponse.INVALID_PARAMETER_VALUE.code());
			response.setSuccessful(false);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		System.out.println("list " + list);
		msisdn = list.isEmpty() ? null : list.get(0).toString();
		String[] ipAllDig = ipaddress.split("\\.");

		// if (ipAllDig[0] != null && (Integer.parseInt(ipAllDig[0])) == 10) {
		if (Validip(ipAdress) == true) {
			boolean result = saveMsisdnbehalfToken(token, ipaddress, msisdn);
			if (!result) {

				response.setMessage(DefaultApiResponse.INVALID_TOKEN.message());
				response.setCode(DefaultApiResponse.INVALID_TOKEN.code());
				response.setSuccessful(false);

			} else {
				response.setMessage(DefaultApiResponse.SUCCESS.message());
				response.setCode(DefaultApiResponse.SUCCESS.code());
				response.setSuccessful(true);

			}

			return new ResponseEntity<>(response, HttpStatus.OK);

		} else {
			response.setMessage(DefaultApiResponse.INVALID_IP_ADDRESS.message());
			response.setCode(DefaultApiResponse.INVALID_IP_ADDRESS.code());
			response.setSuccessful(true);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}

	}

	/*
	 * private boolean saveMsisdnbehalfToken(String token, String ipaddress,
	 * String msisdn) { try { MsisdnTokenEntity msisdnTokenEntity = msisdnRepo
	 * .findOne(QMsisdnTokenEntity.msisdnTokenEntity.token.eq(token));
	 * System.out.println(">>>>>>token........." + token + "............." +
	 * msisdnTokenEntity.getIpAddress()); if (msisdnTokenEntity != null) {
	 * msisdnRepo.delete(msisdnTokenEntity.getId()); msisdnTokenEntity = new
	 * MsisdnTokenEntity(); msisdnTokenEntity.setMsisdn(msisdn);
	 * msisdnTokenEntity.setToken(token);
	 * msisdnTokenEntity.setIpAddress(ipaddress);
	 * msisdnTokenEntity.setLastModifiedTime(new Date());
	 * msisdnRepo.save(msisdnTokenEntity); return true; } else {
	 * 
	 * return false; }
	 * 
	 * } catch (Exception e) { e.printStackTrace(); return false; }
	 * 
	 * }
	 */

	private boolean saveMsisdnbehalfToken(String token, String ipaddress, String msisdn) {
		try {
			MsisdnTokenEntity msisdnTokenEntity = msisdnRepo
					.findOne(QMsisdnTokenEntity.msisdnTokenEntity.token.eq(token));

			if (msisdnTokenEntity != null) {
				System.out.println(">>>>>>token........." + token + "............." + msisdnTokenEntity.getIpAddress());
				if (msisdnTokenEntity != null) {
					Date tokenDate = msisdnTokenEntity.getCreateTimestamp();
					Date current = new Date();
					if ((current.getTime() - tokenDate.getTime()) > 300000) {
						msisdnRepo.delete(msisdnTokenEntity.getId());
						return false;
					}
				}

				msisdnRepo.delete(msisdnTokenEntity.getId());
				msisdnTokenEntity = new MsisdnTokenEntity();
				msisdnTokenEntity.setMsisdn(msisdn);
				msisdnTokenEntity.setToken(token);
				msisdnTokenEntity.setIpAddress(ipaddress);
				msisdnTokenEntity.setLastModifiedTime(new Date());
				msisdnRepo.save(msisdnTokenEntity);
				return true;
			} else {

				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}
	@GetMapping(value = "/generateTokenBasedOnIp")
	public ResponseEntity<?> generateTokenBasedOnIp(HttpServletRequest request) {
		String[] ipAdress = null;
		String[] ipAdressvalue = null;
		GenerateToken generateToken = new GenerateToken();
		
		Map<String, String> map = new HashMap<String, String>();
		Enumeration headerNames = request.getHeaderNames();

		while (headerNames.hasMoreElements()) {
			String key = (String) headerNames.nextElement();
			String value = request.getHeader(key);
			 
			if (key.equalsIgnoreCase("x-forwarded-for")) {// x-forwarded-for
				if (value != null) {
					ipAdress = value.trim().split(",");;
					 
				}

			}
			 
			System.out.println("list size >>>key   " + key + "   >>> value...." + value);
		}

		
		 
		TokenResponse response = new TokenResponse();

		//String[] ipAllDig = generateToken.getIpaddress().split("\\.");
		
		if (Validip(ipAdress) == true) {
			response.setMessage("SUCCESS");
			response.setCode("0");
			response.setSuccessful(true);
			String random_token = randomString(50);
			response.setRandom_token(random_token);
			response.setIpAddress(ipAdress[0]);
			saveToken(ipAdress[0], random_token, "");
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			response.setMessage(DefaultApiResponse.INVALID_IP_ADDRESS.message());
			response.setCode(DefaultApiResponse.INVALID_IP_ADDRESS.code());
			response.setSuccessful(true);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}

	}

	public void saveToken(String ipAddress, String token, String msisdn) {

		try {
			MsisdnTokenEntity msisdnTokenEntity = new MsisdnTokenEntity();
			msisdnTokenEntity.setIpAddress((ipAddress));
			msisdnTokenEntity.setToken(token);
			msisdnTokenEntity.setMsisdn("");
			msisdnTokenEntity.setLastModifiedTime(new Date());
			msisdnRepo.save(msisdnTokenEntity);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * This Method used validate ip address
	 * 
	 * @param ipAddress
	 * @return {@link Boolean}}
	 * 
	 */
	/*
	 * 
	 * public static boolean checkValidIp(String ip) { boolean status=false;
	 * String[] ipAllDig =ip.split("\\."); System.out.println(ipAllDig[0]);
	 * String ipList[]={"103","45","203","10"};
	 * 
	 * int secoundIndexValueIp103=7; Integer[]
	 * thirdIndexValueIp103={36,37,38,39}; Integer[]
	 * fourthIndexValueIp103={0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,
	 * 20,21,22,23,24};
	 * 
	 * int secoundIndexValueIp203=170; Integer[] thirdIndexValueIp203={26,27};
	 * Integer[]
	 * fourthIndexValueIp203={0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,
	 * 20,21,22,23,24};
	 * 
	 * int secoundIndexValueIp45=126; Integer[]
	 * thirdIndexValueIp45={96,97,98,99}; Integer[]
	 * fourthIndexValueIp45={0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,
	 * 20,21,22,23,24};
	 * 
	 * if((ipAllDig.length!=4)) { return status; } if(ipAllDig[0] !=
	 * null&&Arrays.asList(ipList).contains(ipAllDig[0].trim())){
	 * 
	 * if(ipAllDig[0].equalsIgnoreCase(ipList[0]))
	 *//** check ip 103 series **/
	/*
	 * { if(Integer.parseInt(ipAllDig[1])==secoundIndexValueIp103 &&
	 * (Arrays.asList(thirdIndexValueIp103).contains(Integer.parseInt(ipAllDig[2
	 * ]))) &&
	 * ((Arrays.asList(fourthIndexValueIp103).contains(Integer.parseInt(ipAllDig
	 * [3]))))) { status=true; return status; } }
	 * 
	 * if(ipAllDig[0].equalsIgnoreCase(ipList[1]))
	 *//** check ip 45 series **/
	/*
	 * { if(Integer.parseInt(ipAllDig[1])==secoundIndexValueIp45 &&
	 * (Arrays.asList(thirdIndexValueIp45).contains(Integer.parseInt(ipAllDig[2]
	 * ))) &&
	 * ((Arrays.asList(fourthIndexValueIp45).contains(Integer.parseInt(ipAllDig[
	 * 3]))))) { status=true; return status; } }
	 * 
	 * if(ipAllDig[0].equalsIgnoreCase(ipList[2]))
	 *//** check ip203eries **/

	/*
	 * { if(Integer.parseInt(ipAllDig[1])==secoundIndexValueIp203 &&
	 * (Arrays.asList(thirdIndexValueIp203).contains(Integer.parseInt(ipAllDig[2
	 * ]))) &&
	 * ((Arrays.asList(fourthIndexValueIp203).contains(Integer.parseInt(ipAllDig
	 * [3]))))) { status=true; return status; } }
	 * 
	 * if(ipAllDig[0].equalsIgnoreCase(ipList[3]))
	 *//** check ip 10 series **//*
								 * { status=true; return status; }
								 * 
								 * } return status; }
								 * 
								 */

	 public boolean Validip(String[] iplist) {
		
		boolean vlaidip = false;
		if (iplist != null) {
			try{
			for (int i = 0; i < iplist.length; i++) {
				String[] ipAllDig = iplist[i].split("\\.");
				if (ipAllDig[0] == "") {
					continue;
				}
				if (ipAllDig[0] != null && (Integer.parseInt(ipAllDig[0].trim())) == 10) {
					vlaidip = true;

				} else {
					vlaidip = false;
					break;
				}
			}
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>problem with ip");
				return vlaidip;
			}
			return vlaidip;

		} else {
			return vlaidip;
		}

	} 
	
	
	/*public boolean Validip(String[] iplist) {
		boolean vlaidip = false;
		if (iplist != null) {
		for (int i = 0; i < iplist.length; i++) {
		String[] ipAllDig = iplist[i].split("\\.");
		if (ipAllDig[0] == "") {
		continue;
		}
		if (ipAllDig[0] != null && (Integer.parseInt(ipAllDig[0])) == 10) {
		vlaidip = true;

		} else {
		vlaidip = false;
		break;
		}
		}
		return vlaidip;

		} else {
		return vlaidip;
		}

		}*/
}