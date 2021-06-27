package com.myspring.springbatch;

import org.springframework.batch.item.ItemProcessor;

public class Processor implements ItemProcessor<String, String> {

	@Override
	public String process(String item) throws Exception {
		System.out.println("Enter process..");
		return "Processed [" + item + "]";
	}

}
