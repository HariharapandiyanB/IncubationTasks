package com.incubationtasks.threadtasks;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.Map;
import java.util.Set;

import utilities.InvalidInputException;
import utilities.UtilityTasks;

public class ThreadTasks {

		public String getName() {
			return Thread.currentThread().getName();
		}
		
		public int getPriority() {
			return Thread.currentThread().getPriority();
		}
		
		public Thread.State getState(){
			return Thread.currentThread().getState();
		}
		
		public void setName(Thread obj,String name) throws InvalidInputException {
			UtilityTasks.checkNull(name);
			obj.setName(name);
		}
		
		public void sleepThread(long milliSeconds) throws InterruptedException{
			Thread.sleep(milliSeconds);
		}
		public void dumpThread() {
			Thread.dumpStack();
		}
		
		public String threadDump() {
			ThreadMXBean threadMXBean=ManagementFactory.getThreadMXBean();
			StringBuilder threadDump = new StringBuilder();
			for (ThreadInfo threadInfo:threadMXBean.getThreadInfo(threadMXBean.getAllThreadIds())) {
				threadDump.append(threadInfo.getThreadName());
				for(StackTraceElement str: threadInfo.getStackTrace()) {
					threadDump.append(" "+str);
				}
			}
			return threadDump.toString();
		}
		
		public Map<Thread,StackTraceElement[]> getStackTraceOfAllThreads(){
			return Thread.getAllStackTraces();
		}
		
		public String sequencePrint(Map<Thread,StackTraceElement[]> maps) throws InvalidInputException{
			UtilityTasks.checkNull(maps);
			StringBuilder stackTrace=new StringBuilder();
			Set<Map.Entry<Thread,StackTraceElement[]>>set=maps.entrySet();
			for(Map.Entry<Thread,StackTraceElement[]> entry:set) {
				stackTrace.append("\n"+entry.getKey());
				StackTraceElement[] stackTraceElement=entry.getValue();
				for(StackTraceElement str:stackTraceElement) {
					stackTrace.append("\n "+str);
				}
			}
			return stackTrace.toString();
		}
}
