package stapels_en_wachtrijen;

import java.util.Arrays;

public class Stapel extends Collectie {
	
	/**
	 * @post | getElements().length == 0
	 */
	public Stapel() {}

	/**
	 * @throws IllegalStateException | isEmpty()
	 * @mutates | this
	 * @post | getElements().length == old(getElements()).length - 1
	 * @post | Arrays.equals(getElements(), 0, getElements().length, old(getElements()), 0, getElements().length)
	 * @post | result == old(getElements()[getElements().length - 1])
	 */
	@Override
	public int remove() {
		return removeLast();
	}
	

}
