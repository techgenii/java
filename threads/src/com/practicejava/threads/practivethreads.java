package com.practicejava.threads;

public class practivethreads {
	
	public static class Portfolio extends Thread {
	    public Portfolio (String threadName) {
	        super(threadName);
	    }

	    public void run() {
	       System.out.println( "Thread: You have 500 shares of IBM ");
	    }
	}
	
	public static class Portfolio2 implements Runnable {
	    public void run() {
	       System.out.println( "Runnable: You have 500 shares of IBM ");
	     }
	}
	
	public static class Portfolio3 extends Thread {
		   public Portfolio3 (String str) {
		        super(str);
		   }

		   public void run() {
		     try {
		      for (int i=0; i<10;i++) {
		        sleep (700);    // Sleep for 700 milliseconds
		        System.out.println( "Sleep: You have " +  (500 + i) + " shares of IBM");
		       }
		     } catch(InterruptedException e ){
		      System.out.println(Thread.currentThread().getName() + e.toString());
		     }
		  }
	}

	public static class MarketNews extends Thread {
		public MarketNews (String threadName) {
			super(threadName);  // name your thread
		}

		public void run() {
			System.out.println( "Thread: The stock market is improving!");
		}
	}
	
	public static class MarketNews2 implements Runnable {
	     public void run() {
	        System.out.println( "Runnable: The stock market is improving!");
	     }
	}
	
	public static class MarketNews3 extends Thread {
		  public MarketNews3 (String str) {
		    super(str);
		  }

		  public void run() {
		    try{
		      for (int i=0; i<10;i++){
		    	  sleep (1000);  // sleep for 1 second
		    	  System.out.println( "Sleep: The market is improving " + i);
		      }
		    } catch(InterruptedException e ){
		       System.out.println(Thread.currentThread().getName() + e.toString());
		    }
		 }
	}
	
    public static void main(String args[]) {
    	
        MarketNews mn = new MarketNews("Market News Thread");
        Portfolio p = new Portfolio("Portfolio Data Thread");
                
        mn.start();
        p.start();

        System.out.println( "Main Thread is finished");
    	
        MarketNews2 mn2 = new MarketNews2();
        Thread mnA = new Thread(mn2,"Market News Runnable");

        Runnable port2 = new Portfolio2();
        Thread pA = new Thread(port2, "Portfolio Data Rubbable");

        mnA.start();
        pA.start();

        System.out.println( "Main Runnable is finished");
             
        MarketNews3 mn3 = new MarketNews3("Market News Sleep");
        Portfolio3 p3 = new Portfolio3("Portfolio Data Sleep");
        p3.setPriority(Thread.NORM_PRIORITY + 1);

        mn3.start();
        p3.start();
        try{
        	mn3.join();
        	p3.join();
        }catch (InterruptedException e){
        	e.printStackTrace();
        }
        System.out.println( "Sleep Thread is finished");
    }
    
}
