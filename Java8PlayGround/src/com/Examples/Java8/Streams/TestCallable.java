package com.Examples.Java8.Streams;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class TestCallable implements Callable<String> {

	@Override
	public String call() throws Exception {
		
		Thread.sleep(3000);
		
		return "Hi this is "+Thread.currentThread().getName();
	}

}
