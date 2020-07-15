package com.ide2e.example.practice;

public class SingletonPattern {
	
	private volatile static SingletonPattern instance;
	
	private SingletonPattern() {}
	
    public static SingletonPattern getInstance() {
    	     if(SingletonPattern.instance == null) {
    	    	   synchronized(SingletonPattern.class) {
    	    		   if(SingletonPattern.instance==null)
    	    		   {
    	    			   SingletonPattern.instance = new SingletonPattern();
    	    			   return SingletonPattern.instance;
    	    		   }
    	    	   }
    	    	 
    	     } 	    
    	     return SingletonPattern.instance;
    }
}
