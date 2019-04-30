package impl;

import data.Mask;
import gui.Display;

public class Runner {
	public static void main(String[] args) {
//		foo(0L);
//		foo(1L);
//		foo(2L);
//		foo(10L);
//		foo(-1L);
//		foo(-10L);
//		foo(-34354235L);
//		foo(Long.MAX_VALUE);
		Display disp = new Display();
		
	}
	
	public static void printBooleans(Mask m) {
		for(int i = m.size() - 1; i >= 0; i--) {
			System.out.print(m.get(i) ? "1" : "0");
		}
		System.out.println("");
	}
	
	public static void foo(Long num) {
		Mask m = new Mask(num);
		System.out.println(num);
		printBooleans(m);
	}
}


