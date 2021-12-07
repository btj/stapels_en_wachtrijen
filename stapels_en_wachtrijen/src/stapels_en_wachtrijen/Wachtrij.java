package stapels_en_wachtrijen;

import java.util.Arrays;

public class Wachtrij extends Collectie {
	
	/**
	 * @post | getElements().length == 0
	 */
	public Wachtrij() {}
	
	/**
	 * @pre | !isEmpty()
	 * @mutates | this
	 * @post | getElements().length == old(getElements()).length - 1
	 * @post | Arrays.equals(getElements(), 0, getElements().length, old(getElements()), 1, getElements().length + 1)
	 * @post | result == old(getElements()[0])
	 */
	@Override
	public int remove() {
		return removeFirst();
	}
	

}
