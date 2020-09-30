package com.sm.schoolManagement;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sm.schoolManagement.service.facade.DevoirService;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SchoolManagementV1Application{
	 @Resource
	  DevoirService storageService;
	public static void main(String[] args) {
		SpringApplication.run(SchoolManagementV1Application.class, args);
	}
	
}
