package com.jaav.sys.miniencuesta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.jaav.sys"})
//@EnableConfigurationProperties
public class BusinessMiniEncuestaApi {

	public static void main(String[] args) {
		SpringApplication.run(BusinessMiniEncuestaApi.class, args);
	}

}
