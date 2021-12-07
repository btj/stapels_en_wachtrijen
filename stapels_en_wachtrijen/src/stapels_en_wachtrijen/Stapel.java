package stapels_en_wachtrijen;

import java.util.Arrays;

public class Stapel implements Collectie {
	
	/**
	 * @invar | elements != null
	 * @representationObject
	 */
	private int[] elements;
	
	/**
	 * @post | getElements().length == 0
	 */
	public Stapel() {
		elements = new int[0];
	}

	@Override
	public int[] getElements() {
		return elements.clone();
	}
	
	/**
	 * @mutates | this
	 * @post | getElements().length == old(getElements().length) + 1
	 * @post | Arrays.equals(getElements(), 0, old(getElements().length), old(getElements()), 0, old(getElements().length))
	 * @post | getElements()[getElements().length - 1] == element
	 */
	public void add(int element) {
		elements = Arrays.copyOf(elements, elements.length + 1);
		elements[elements.length - 1] = element;
	}
	
	/**
	 * @throws IllegalStateException | isEmpty()
	 * @mutates | this
	 * @post | getElements().length == old(getElements()).length - 1
	 * @post | Arrays.equals(getElements(), 0, getElements().length, old(getElements()), 0, getElements().length)
	 * @post | result == old(getElements()[getElements().length - 1])
	 */
	@Override
	public int remove() {
		if (isEmpty())
			throw new IllegalStateException();
		int result = elements[elements.length - 1];
		elements = Arrays.copyOf(elements, elements.length - 1);
		return result;
	}
	

}
