package com.ide2e.concurrency;

public class CustomLock {
	
	private boolean isLocked = false;
	
	private Thread lockingThread;
	
    public synchronized void lock() throws InterruptedException {
    	     while(isLocked) {
    	    	    wait();
    	     }
    	     isLocked = true;
    	     lockingThread = Thread.currentThread();
    }
    
    public synchronized void unlock()  {
    	    
    	    if(Thread.currentThread()!= lockingThread) {
    	    	   throw new IllegalMonitorStateException("Calling thread is not allowed to unlock"); 
    	    }
    	    
    	    isLocked = false;
    	    lockingThread = null;
    	    notify();
    }
}
