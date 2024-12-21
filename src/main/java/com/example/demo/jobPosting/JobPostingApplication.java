package com.example.demo.jobPosting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class JobPostingApplication {
	public static void main(String[] args) {
		SpringApplication.run(JobPostingApplication.class, args);
	}
}
