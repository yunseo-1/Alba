package com.example.demo.jobSeeking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class JobSeekingApplication {
	public static void main(String[] args) {
		SpringApplication.run(JobSeekingApplication.class, args);
	}
}
