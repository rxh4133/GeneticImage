package data;

import java.util.ArrayList;

public class Mask extends ArrayList<Boolean>{
	private static final long serialVersionUID = 1L;

	public Mask() {
		super();
	}
	
	/**
	 * Initializes this mask to 64 booleans, with index 0 being bit 0 through index 63 as bit 63.
	 * @param mask The long to take booleans from.
	 */
	public Mask(long mask ) {
		super();
		setBools(mask);
	}
	
	/**
	 * Sets this mask to 64 booleans, with index 0 being bit 0 through index 63 as bit 63.
	 * @param mask The long to take booleans from.
	 */
	public void setBools(long mask) {
		this.clear();
		for(int i = 0; i < 64; i++) {
			this.add((mask & (1L << i)) != 0);
		}
	}
	
	public void addBools(long mask) {
		for(int i = 0; i < 64; i++) {
			this.add((mask & (1L << i)) != 0);
		}
	}
}
