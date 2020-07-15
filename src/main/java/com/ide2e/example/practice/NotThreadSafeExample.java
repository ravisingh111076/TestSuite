package com.ide2e.example.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.stream.IntStream;

public class NotThreadSafeExample {
	
	Map<String, String> map1 = new HashMap<>();
	
	List<String> sharedList = new ArrayList<>();
	
	boolean writeTaskDone = false;
	
	//final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
	
    public void iAmNotThreadSafe(String value) {
    	  // lock.readLock().unlock();
    	   sharedList.add(value);
    	   try {
			TimeUnit.MILLISECONDS.sleep(1000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
    	   
    	   //lock.readLock().unlock();
    	   //lock.writeLock().unlock();
    }
    public List<String> getSharedList() {
    	
    	 System.out.println(" current thread Reading: "+ Thread.currentThread().getId()
    + " size of array: " + sharedList.size());
    	 //  lock.readLock().lock();
    	   if(writeTaskDone) {
    		   while(!writeTaskDone) {
    			   System.out.println("waiting for data...");
    		   }	
    		  // lock.readLock().unlock();
    		   return sharedList;   
    	   }else {
    		   return null;
    	   }
    }
    
    public static void main(String [] ravi) {
    	
    	System.out.println(" Main thread "+ Thread.currentThread().getId());
    	ExecutorService service  = Executors.newSingleThreadExecutor();
    	NotThreadSafeExample example = new NotThreadSafeExample();
    	
    	Callable<List<String>> taskRead = () -> {
    			return example.getSharedList();
    	};
    	
    	Runnable taskWrite = () -> {
    		IntStream.range(0,10).forEach(f -> example.iAmNotThreadSafe("value: "+f));
    	};
    	
    
    	
    	service.submit(taskWrite);
    	
    	Future<List<String>> future = 
    			service.submit(taskRead);
    	
    	try {
			future.get().forEach(f->System.out.println("vlaue :" + f));
			if(future.isDone()) {
	    		service.shutdown();
	    	}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
    }
}
