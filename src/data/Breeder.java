package data;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Breeder {
	private MaskProvider maskProvider;
	
	public Breeder(MaskProvider mp) {
		maskProvider = mp;
	}
	
	public List<BufferedImage> breed(BufferedImage parentA, BufferedImage parentB){
		return breedHelper(parentA, parentB, maskProvider.getMask());
	}
	
	public List<BufferedImage> breedMultiple(BufferedImage parentA, BufferedImage parentB, int numMasks){
		ArrayList<BufferedImage> children = new ArrayList<BufferedImage>();
		List<Mask> masks = maskProvider.getMasks(numMasks);
		for(Mask m: masks) {
			children.addAll(breedHelper(parentA, parentB, m));
		}
		return children;
	}
	
	private List<BufferedImage> breedHelper(BufferedImage parentA, BufferedImage parentB, Mask m){
		if(parentA.getWidth() != parentB.getWidth() || parentA.getHeight() != parentB.getHeight()) {
			throw new RuntimeException("Images must be the same dimensions.");
		}
		if(m.size() != parentA.getWidth() * parentB.getHeight()) {
			throw new RuntimeException("Mask length must match the number of pixels in the images.");
		}
		BufferedImage childA = new BufferedImage(parentA.getWidth(), parentA.getHeight(), BufferedImage.TYPE_INT_ARGB);
		BufferedImage childB = new BufferedImage(parentA.getWidth(), parentA.getHeight(), BufferedImage.TYPE_INT_ARGB);
		for(int h = 0; h < parentA.getHeight(); h++) {
			for(int w = 0; w < parentA.getWidth(); w++) {
				if(m.get((h * parentA.getHeight()) + w)) { //Child A gets a bit from parent b if mask is 1
					childA.setRGB(w, h, parentB.getRGB(w, h));
					childB.setRGB(w, h, parentA.getRGB(w, h));
				} else {
					childA.setRGB(w, h, parentA.getRGB(w, h));
					childB.setRGB(w, h, parentB.getRGB(w, h));
				}
			}
		}
		ArrayList<BufferedImage> children = new ArrayList<BufferedImage>();
		children.add(childA);
		children.add(childB);
		return children;
	}
}
