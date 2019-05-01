package impl;

import java.util.ArrayList;
import java.util.List;

import data.Mask;
import data.MaskProvider;

public class OnePointCrossoverMaskProvider implements MaskProvider {

	@Override
	public Mask getMask() {
		Mask m = new Mask();
		for(int i = 0; i < 64; i++) {
			m.addBools((((long)Math.pow(2, 33)) - 1) << 32);
		}
		return m;
	}

	@Override
	public List<Mask> getMasks(int masksToGet) {
		ArrayList<Mask> masks = new ArrayList<Mask>();
		for(int i = 1; i < (64 * 64) - 2; i++) {
			masks.add(new Mask());
			for(int a = 0; a < i; a++) {
				masks.get(i - 1).add(true);
			}
			for(int a = i; a < (64 * 64); a++) {
				masks.get(i - 1).add(false);
			}
		}
		return masks;
	}

}
