package data;

import java.util.List;

public interface MaskProvider {
	Mask getMask();
	List<Mask> getMasks(int masksToGet);
}
