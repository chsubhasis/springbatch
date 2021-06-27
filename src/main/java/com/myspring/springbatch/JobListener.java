package com.myspring.springbatch;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

public class JobListener implements JobExecutionListener {

	@Override
	public void beforeJob(JobExecution jobExecution) {
		System.out.println("Listener beforeJob..");

	}

	@Override
	public void afterJob(JobExecution jobExecution) {
		System.out.println("Listener afterJob..");

	}

}
