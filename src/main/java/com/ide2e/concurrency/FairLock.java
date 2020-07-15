package com.ide2e.concurrency;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;

public class FairLock {

     ReentrantLock lock = new ReentrantLock();
     
     AtomicReference<Thread> lastOwnerThead;
     
     long timeout;
     
     public FairLock(long timeout) {
    	    this.timeout = timeout;
     }
     
     public void lock() {
    	 
     }
}
