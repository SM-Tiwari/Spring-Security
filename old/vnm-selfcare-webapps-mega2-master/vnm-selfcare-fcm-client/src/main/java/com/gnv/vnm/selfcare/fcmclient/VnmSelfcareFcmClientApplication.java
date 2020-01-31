package com.gnv.vnm.selfcare.fcmclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class VnmSelfcareFcmClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(VnmSelfcareFcmClientApplication.class, args);
	}
}
