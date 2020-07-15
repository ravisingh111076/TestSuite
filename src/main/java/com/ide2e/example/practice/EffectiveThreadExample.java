package com.ide2e.example.practice;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class EffectiveThreadExample {

	public static void main(String [] ravi) {
		
		new MyTask();
		new MyTask();
	}
}

class MyTask extends Thread {
	public MyTask() {
		this.start();
	}
	public void run() {
		IntStream.range(0, 10).forEach(f->
		{
			System.out.println(" Thread "+ Thread.currentThread().getId());
			System.out.println(f);
			try {
				TimeUnit.MILLISECONDS.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}
}
