package com.ide2e.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LockUser {

	CustomLock lock = new CustomLock();

	int counter;

	public void doSynchronized() throws InterruptedException {
		this.lock.lock();
        for(int i = 0;i<10; i++) {
        	   System.out.println(" value "+ i);
        }
		// write code
		this.lock.unlock();
	}

	public static void main(String[] args) {
		LockUser user = new LockUser();
		
		ExecutorService service = Executors.newFixedThreadPool(2);
		
		Runnable task1 = () -> {
			try {
				user.doSynchronized();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		};

		Runnable task2 =()-> {
			try {
				user.doSynchronized();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		};
		
		service.submit(task1);
		service.submit(task2);
		
		service.shutdown();
	}
}
