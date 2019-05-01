package data;

import java.awt.image.BufferedImage;
import java.util.List;

public interface Selector {
	List<BufferedImage> selectTwoFrom(List<BufferedImage> images);
}
