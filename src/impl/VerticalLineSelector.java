package impl;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import data.Selector;

public class VerticalLineSelector implements Selector{

	@Override
	public List<BufferedImage> selectTwoFrom(List<BufferedImage> images) {
		ArrayList<ImageListItem> scored = new ArrayList<ImageListItem>();
		for(BufferedImage image: images) {
			int points = 0;
			for(int h = 1; h < 63; h++) {
				for(int w = 1; w < 63; w++) {
					double leftAvg = 0;
					leftAvg += colorScore(image.getRGB(w - 1, h - 1));
					leftAvg += colorScore(image.getRGB(w - 1, h));
					leftAvg += colorScore(image.getRGB(w - 1, h + 1));
					leftAvg /= 3;
					double centAvg = 0;
					centAvg += colorScore(image.getRGB(w, h - 1));
					centAvg += colorScore(image.getRGB(w, h));
					centAvg += colorScore(image.getRGB(w, h + 1));
					centAvg /= 3;
					double rghtAvg = 0;
					rghtAvg += colorScore(image.getRGB(w + 1, h - 1));
					rghtAvg += colorScore(image.getRGB(w + 1, h));
					rghtAvg += colorScore(image.getRGB(w + 1, h + 1));
					rghtAvg /= 3;
					points += Math.abs((2 * centAvg) - (leftAvg + rghtAvg));
				}
			}
			scored.add(new ImageListItem(image, points));
		}
		Collections.shuffle(scored);
		Collections.sort(scored);
		ArrayList<BufferedImage> top2 = new ArrayList<BufferedImage>();
		top2.add(scored.get(scored.size() - 1).image);
		top2.add(scored.get(scored.size() - 2).image);
		return top2;
	}

	private static int colorScore(int color) {
		int score = 0;
		score += color & 255;
		score += color & (255 << 8);
		score += color & (255 << 16);
		return score;
	}
	
	private class ImageListItem implements Comparable<ImageListItem>{
		public BufferedImage image;
		public int score;
		
		public ImageListItem(BufferedImage image, int score) {
			this.image = image;
			this.score = score;
		}
		
		@Override
		public int compareTo(ImageListItem other) {
			return score - other.score;
		}
	}
	
}
