package com.incubationtasks.threadtasks;

import java.util.logging.Level;
import java.util.logging.Logger;

public class RunnableThread implements Runnable{
	
	 Logger logger=Logger.getLogger(ExtendedThread.class.getName());
	 ThreadTasks threadTasks = new ThreadTasks();
	 long sleepTime;
	 private boolean test=true;
	 public RunnableThread(long sleepTime) {
			this.sleepTime=sleepTime;
		}
	 public RunnableThread() {
		
	}
	 public void run() {
		    String threadName=threadTasks.getName();
			logger.log(Level.INFO,threadName);
			logger.log(Level.INFO,"\n"+threadTasks.getState());
			logger.log(Level.INFO,"\n"+threadTasks.getPriority());
			logger.log(Level.INFO,"\n Going to sleep: "+threadName);
			while(test) {
				logger.log(Level.INFO,"\n"+threadName);
				try {
					if (sleepTime==0) {
						threadTasks.sleepThread(2000);
					}else {
						threadTasks.sleepThread(sleepTime);
					}
				} catch (InterruptedException e) {
					logger.log(Level.SEVERE,"\n"+e.getStackTrace());
				}
			}
			
			
			logger.log(Level.INFO,"\n After sleeping: "+threadName);
			
	 }
	 public void setTest(boolean test) {
		 this.test=test;
	 }
}
