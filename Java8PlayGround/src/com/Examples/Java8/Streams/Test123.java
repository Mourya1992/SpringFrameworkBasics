package com.Examples.Java8.Streams;

import java.util.Arrays;
import java.util.List;

public class Test123 implements Runnable {

	@Override
	public void run() {
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		if(Thread.currentThread().isAlive())
		System.out.println("This is a thread with name-"+Thread.currentThread().getName());
	}

	

	

}
