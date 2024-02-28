package com.incubationtasks.threadtasks;

 

import java.util.logging.*;


public class ExtendedThread extends Thread {
	
	static Logger logger=Logger.getLogger(ExtendedThread.class.getName());
	static ThreadTasks threadTasks = new ThreadTasks();
	private boolean test=true;
	long sleepTime;
	public ExtendedThread() {
		
	}
	
	public ExtendedThread(long sleepTime) {
		this.sleepTime=sleepTime;
	}
	
	public  void run() {
		
		String threadName=threadTasks.getName();
		logger.log(Level.INFO,threadName);
		logger.log(Level.INFO,threadTasks.getState()+"\n");
		logger.log(Level.INFO,threadTasks.getPriority()+"\n");
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
