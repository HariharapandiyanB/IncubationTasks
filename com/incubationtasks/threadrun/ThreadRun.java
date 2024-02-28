package com.incubationtasks.threadrun;

import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.incubationtasks.threadtasks.ThreadTasks;
import utilities.InvalidInputException;
import com.incubationtasks.threadtasks.ExtendedThread;
import com.incubationtasks.threadtasks.RunnableThread;
public class ThreadRun {
	static Scanner scan = new Scanner(System.in);
	static ThreadTasks threadTasks=new ThreadTasks();
	public static void main(String... args) {
		Logger logger=Logger.getLogger(ThreadRun.class.getName());
		int x=1;
		do {
			logger.log(Level.INFO,"\n The Operation would you like to do is...(1-7)");
			int option=scan.nextInt();scan.nextLine();
			switch(option) {
				case 1:
					try {
					ExtendedThread extendedThread=new ExtendedThread();
					extendedThread.start();
					extendedThread.join();
					logger.log(Level.INFO,threadTasks.getName()+"\n");
					logger.log(Level.INFO,threadTasks.getState().toString()+"\n");
					logger.log(Level.INFO,threadTasks.getPriority()+"\n");
					}catch(InterruptedException e) {
						logger.log(Level.SEVERE,"\n"+e.getStackTrace());
					}break;
				
				case 2:
					try {
					RunnableThread runnableThread=new RunnableThread();
					Thread runThread=new Thread(runnableThread);
					runThread.start();
					runThread.join();
					logger.log(Level.INFO,threadTasks.getName()+"\n");
					logger.log(Level.INFO,threadTasks.getState().toString()+"\n");
					logger.log(Level.INFO,threadTasks.getPriority()+"\n");
					}catch(InterruptedException i){
						logger.log(Level.SEVERE,"\n"+i.getStackTrace());
					}break;
					
				case 3:
					try {
					ExtendedThread extendedThread=new ExtendedThread();
					logger.log(Level.INFO,threadTasks.getName()+"\n");
					logger.log(Level.INFO,threadTasks.getState().toString()+"\n");
					logger.log(Level.INFO,threadTasks.getPriority()+"\n");
					threadTasks.setName(extendedThread, "extendedThread");
					extendedThread.start();
					extendedThread.join();
					logger.log(Level.INFO,threadTasks.getName()+"\n");
					logger.log(Level.INFO,threadTasks.getState().toString()+"\n");
					logger.log(Level.INFO,threadTasks.getPriority()+"\n");
					
					RunnableThread runnableThread=new RunnableThread();
					Thread runThread=new Thread(runnableThread);
					logger.log(Level.INFO,threadTasks.getName()+"\n");
					logger.log(Level.INFO,threadTasks.getState().toString()+"\n");
					logger.log(Level.INFO,threadTasks.getPriority()+"\n");
					threadTasks.setName(runThread, "runThread");
					runThread.start();
					runThread.join();
					logger.log(Level.INFO,threadTasks.getName()+"\n");
					logger.log(Level.INFO,threadTasks.getState().toString()+"\n");
					logger.log(Level.INFO,threadTasks.getPriority()+"\n");
					}catch(InterruptedException i3) {
						logger.log(Level.SEVERE,"\n"+i3.getStackTrace());
					}catch(InvalidInputException ii3) {
						logger.log(Level.SEVERE,"\n"+ii3.getStackTrace());
					}
					break;
					
				case 4:
					try {
					ExtendedThread extendedThread1=new ExtendedThread();
					threadTasks.setName(extendedThread1, "extendedThread1");
					ExtendedThread extendedThread2=new ExtendedThread();
					threadTasks.setName(extendedThread2, "extendedThread2");
					extendedThread2.start();
					ExtendedThread extendedThread3=new ExtendedThread();
					threadTasks.setName(extendedThread3, "extendedThread3");
					extendedThread3.start();
					ExtendedThread extendedThread4=new ExtendedThread();
					threadTasks.setName(extendedThread4, "extendedThread4");
					extendedThread4.start();
					ExtendedThread extendedThread5=new ExtendedThread();
					threadTasks.setName(extendedThread5, "extendedThread5");
					extendedThread5.start();
					
					RunnableThread runnableThread=new RunnableThread();
					Thread runThread1=new Thread(runnableThread);
					threadTasks.setName(runThread1, "runThread1");
					runThread1.start();
					RunnableThread runnableThread2=new RunnableThread();
					Thread runThread2=new Thread(runnableThread2);
					threadTasks.setName(runThread2, "runThread2");
					runThread2.start();
					RunnableThread runnableThread3=new RunnableThread();
					Thread runThread3=new Thread(runnableThread3);
					threadTasks.setName(runThread3, "runThread3");
					runThread3.start();
					RunnableThread runnableThread4=new RunnableThread();
					Thread runThread4=new Thread(runnableThread4);
					threadTasks.setName(runThread4, "runThread4");
					runThread4.start();
					RunnableThread runnableThread5=new RunnableThread();
					Thread runThread5=new Thread(runnableThread5);
					threadTasks.setName(runThread5, "runThread5");
					runThread5.start();
					runThread5.join();
					}catch(InterruptedException ie) {
						logger.log(Level.SEVERE,"\n"+ie.getStackTrace());
					}
					catch(InvalidInputException i) {
						logger.log(Level.SEVERE,"\n"+i.getStackTrace());
					}break;
					
				case 5:
					try {
					ExtendedThread extendedThread1=new ExtendedThread(2000);
					threadTasks.setName(extendedThread1, "extendedThread1");
					ExtendedThread extendedThread2=new ExtendedThread(3000);
					threadTasks.setName(extendedThread2, "extendedThread2");
					extendedThread2.start();
					ExtendedThread extendedThread3=new ExtendedThread(4000);
					threadTasks.setName(extendedThread3, "extendedThread3");
					extendedThread3.start();
					ExtendedThread extendedThread4=new ExtendedThread(3500);
					threadTasks.setName(extendedThread4, "extendedThread4");
					extendedThread4.start();
					ExtendedThread extendedThread5=new ExtendedThread(4900);
					threadTasks.setName(extendedThread5, "extendedThread5");
					extendedThread5.start();
					extendedThread1.setTest(false);
					extendedThread2.setTest(false);
					extendedThread3.setTest(false);
					extendedThread4.setTest(false);
					extendedThread5.setTest(false);
					
					RunnableThread runnableThread=new RunnableThread(2800);
					Thread runThread1=new Thread(runnableThread);
					threadTasks.setName(runThread1, "runThread1");
					runThread1.start();
					RunnableThread runnableThread2=new RunnableThread(3896);
					Thread runThread2=new Thread(runnableThread2);
					threadTasks.setName(runThread2, "runThread2");
					runThread2.start();
					RunnableThread runnableThread3=new RunnableThread(4567);
					Thread runThread3=new Thread(runnableThread3);
					threadTasks.setName(runThread3, "runThread3");
					runThread3.start();
					RunnableThread runnableThread4=new RunnableThread(3282);
					Thread runThread4=new Thread(runnableThread4);
					threadTasks.setName(runThread4, "runThread4");
					runThread4.start();
					RunnableThread runnableThread5=new RunnableThread(2344);
					Thread runThread5=new Thread(runnableThread5);
					threadTasks.setName(runThread5, "runThread5");
					runThread5.start();
					runnableThread.setTest(false);
					runnableThread2.setTest(false);
					runnableThread3.setTest(false);
					runnableThread4.setTest(false);
					runnableThread5.setTest(false);
					Map<Thread,StackTraceElement[]>  threadMap=threadTasks.getStackTraceOfAllThreads();
					
					threadTasks.sequencePrint(threadMap);
					
					runThread5.join();
					}catch(InterruptedException ie) {
						logger.log(Level.SEVERE,"\n"+ie.getStackTrace());
					}
					catch(InvalidInputException i) {
						logger.log(Level.SEVERE,"\n"+i.getStackTrace());
					}break;
					
				case 6:
					try {
					ExtendedThread extendedThread=new ExtendedThread();
					threadTasks.setName(extendedThread, "extendedThread");
					extendedThread.start();
					threadTasks.sleepThread(5000);
					extendedThread.setTest(false);
						
					RunnableThread runnableThread=new RunnableThread(2800);
					Thread runThread1=new Thread(runnableThread);
					threadTasks.setName(runThread1, "runThread1");
					runThread1.start();
					threadTasks.sleepThread(5000);
					runnableThread.setTest(false);
					ExtendedThread.dumpStack();
					
					
					}catch(InterruptedException ie) {
						logger.log(Level.SEVERE,"\n"+ie.getStackTrace());
					}
					catch(InvalidInputException i) {
						logger.log(Level.SEVERE,"\n"+i.getStackTrace());
					}break;
					
				case 7:
					try {
						ExtendedThread extendedThread1=new ExtendedThread();
						threadTasks.setName(extendedThread1, "extendedThread1");
						ExtendedThread extendedThread2=new ExtendedThread();
						threadTasks.setName(extendedThread2, "extendedThread2");
						extendedThread2.start();
						ExtendedThread extendedThread3=new ExtendedThread();
						threadTasks.setName(extendedThread3, "extendedThread3");
						extendedThread3.start();
						ExtendedThread extendedThread4=new ExtendedThread();
						threadTasks.setName(extendedThread4, "extendedThread4");
						extendedThread4.start();
						ExtendedThread extendedThread5=new ExtendedThread();
						threadTasks.setName(extendedThread5, "extendedThread5");
						extendedThread5.start();
						extendedThread1.setTest(false);
						extendedThread2.setTest(false);
						extendedThread3.setTest(false);
						extendedThread4.setTest(false);
						extendedThread5.setTest(false);
						
						RunnableThread runnableThread=new RunnableThread();
						Thread runThread1=new Thread(runnableThread);
						threadTasks.setName(runThread1, "runThread1");
						runThread1.start();
						RunnableThread runnableThread2=new RunnableThread();
						Thread runThread2=new Thread(runnableThread2);
						threadTasks.setName(runThread2, "runThread2");
						runThread2.start();
						RunnableThread runnableThread3=new RunnableThread();
						Thread runThread3=new Thread(runnableThread3);
						threadTasks.setName(runThread3, "runThread3");
						runThread3.start();
						RunnableThread runnableThread4=new RunnableThread();
						Thread runThread4=new Thread(runnableThread4);
						threadTasks.setName(runThread4, "runThread4");
						runThread4.start();
						RunnableThread runnableThread5=new RunnableThread();
						Thread runThread5=new Thread(runnableThread5);
						threadTasks.setName(runThread5, "runThread5");
						runThread5.start();
						
						runnableThread.setTest(false);
						runnableThread2.setTest(false);
						runnableThread3.setTest(false);
						runnableThread4.setTest(false);
						runnableThread5.setTest(false);
						
						extendedThread1.join();
						extendedThread2.join();
						extendedThread3.join();
						extendedThread4.join();
						extendedThread5.join();
						
						runThread1.join();
						runThread2.join();
						runThread3.join();
						runThread4.join();
						runThread5.join();
						if (Thread.activeCount()==1) {
							logger.log(Level.INFO, "\n Task Accomplished");
						}else {
							logger.log(Level.INFO, "\n"
									+ " Task Unaccomplished");
						}
						Map<Thread,StackTraceElement[]>  threadMap=threadTasks.getStackTraceOfAllThreads();
						logger.log(Level.INFO,threadTasks.sequencePrint(threadMap));
						logger.log(Level.INFO,threadTasks.threadDump()); 
						threadTasks.dumpThread();
					}catch(InterruptedException ie) {
						logger.log(Level.SEVERE,"\n"+ie.getStackTrace());
					}
						catch(InvalidInputException i) {
							logger.log(Level.SEVERE,"\n"+i.getStackTrace());
						}break;
				default:
					logger.log(Level.INFO,"\n Kindly give the valid Input...");
			}
		}while(x==1);

	}

}
