package com.revature;

import java.util.ArrayList;
import java.util.List;

public class Launcher {

	public static void main(String[] args) {
		try {
			heapError();			
		} catch (StackOverflowError | OutOfMemoryError e) {
			System.out.println("Caught");
		}
		
		System.out.println("Application survived");
	}
	
	public static void stackError() {
		stackError();
	}
	
	public static void heapError() {
		List list = new ArrayList();
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			sb.append("a");
			list.add(sb.toString());
		}
	}
}
