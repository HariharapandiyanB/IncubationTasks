package com.incubationtasks.singleton;

import java.io.Serializable;

public class SingletonClass implements Cloneable,Serializable{
	
	private static volatile SingletonClass singletonInstance=null;
	private SingletonClass() throws IllegalAccessException{
		if (singletonInstance!=null) {
			throw new IllegalAccessException("Constructor can't be accessed");
		}singletonInstance = this;
		
	}
	public static SingletonClass getInstance() throws IllegalAccessException{
		if (singletonInstance==null) {
			synchronized (SingletonClass.class) {
				if (singletonInstance==null) {
						new SingletonClass();
			}}
		}
		return singletonInstance;
	}
	
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
	
	public Object readResolve() {
		return singletonInstance;
	}
	
	
	}
