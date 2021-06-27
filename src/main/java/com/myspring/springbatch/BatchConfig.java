package com.myspring.springbatch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BatchConfig {

	@Autowired
	private StepBuilderFactory stepFactry;

	@Autowired
	private JobBuilderFactory jobFactry;

	@Bean
	public Step getStep() {
		return stepFactry.get("step1").<String, String>chunk(1).reader(getReader()).writer(getWriter())
				.processor(getProcessor()).build();
	}

	@Bean
	public Job getJob() {
		return jobFactry.get("job1").incrementer(new RunIdIncrementer()).listener(getListener()).start(getStep())
				.build();
	}

	@Bean
	public Reader getReader() {
		return new Reader();
	}

	@Bean
	public Writer getWriter() {
		return new Writer();
	}

	@Bean
	public Processor getProcessor() {
		return new Processor();
	}

	@Bean
	public JobListener getListener() {
		return new JobListener();
	}

}
