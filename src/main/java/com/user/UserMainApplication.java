package com.user;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

import java.util.UUID;

@SpringBootApplication
@EnableScheduling
@EnableBatchProcessing
@EnableAuthorizationServer
@EnableResourceServer

public class UserMainApplication {//implements CommandLineRunner {


	@Autowired
	private JobLauncher jobLauncher;

	@Autowired
	private Job job;


	public static void main(String[] args) {
		SpringApplication.run(UserMainApplication.class, args);


	}

//	@Override
//	public void run(String... args) throws Exception {
//		JobParameters jobParameters = new JobParametersBuilder()
//				.addString("date", UUID.randomUUID().toString())
//				.addLong("JobId",System.currentTimeMillis())
//				.addLong("time",System.currentTimeMillis()).toJobParameters();
//
//		JobExecution execution = jobLauncher.run(job, jobParameters);
//		System.out.println("STATUS :: "+execution.getStatus());
//	}


}
