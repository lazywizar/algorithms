package com.thinklazy;

public class Test {
	private static Test t = null;
	
	private Test() {
		
	}
	
	public static Test getTestInstance() {
		if(t == null) {
			t = new Test();
		} 
		return t;
	}
}