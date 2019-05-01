package impl;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.List;

import data.Breeder;
import data.Mask;
import data.MaskProvider;
import data.Selector;
import gui.Display;

public class Runner {
	public static void main(String[] args) {
		foo(0L);
//		foo(1L);
//		foo(2L);
//		foo(10L);
		foo(-1L);
//		foo(-10L);
//		foo(-34354235L);
//		foo(Long.MAX_VALUE);
		
				
		
		Display p1d = new Display();
		Display p2d = new Display();
		MaskProvider mp = new OnePointCrossoverMaskProvider();
		Breeder breed = new Breeder(mp);
		BufferedImage par1 = getImage(Color.WHITE);
		BufferedImage par2 = getImage(Color.BLACK);
		List<BufferedImage> childs;
		Selector select = new VerticalLineSelector();
		for(int i = 0; i < 300; i++) {
			p1d.displayImage(par1);
			p2d.displayImage(par2);
			childs = breed.breedMultiple(par1, par2, 0);
			List<BufferedImage> newPars = select.selectTwoFrom(childs);
			par1 = newPars.get(0);
			par2 = newPars.get(1);
			System.out.println("Gen " + i);
		}
	}
	
	public static BufferedImage getImage(Color color) {
		BufferedImage bi = new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB);
		for(int w = 0; w < 64; w++) {
			for(int h = 0; h < 64; h++) {
				bi.setRGB(w, h, color.getRGB());
			}
		}
		return bi;
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


