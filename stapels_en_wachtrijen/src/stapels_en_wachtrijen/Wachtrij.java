package stapels_en_wachtrijen;

import java.util.Arrays;

public class Wachtrij implements Collectie {
	
	/**
	 * @invar | elements != null
	 * @representationObject
	 */
	private int[] elements;
	
	/**
	 * @post | getElements().length == 0
	 */
	public Wachtrij() {
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
	 * @pre | !isEmpty()
	 * @mutates | this
	 * @post | getElements().length == old(getElements()).length - 1
	 * @post | Arrays.equals(getElements(), 0, getElements().length, old(getElements()), 1, getElements().length + 1)
	 * @post | result == old(getElements()[0])
	 */
	@Override
	public int remove() {
		int result = elements[0];
		elements = Arrays.copyOfRange(elements, 1, elements.length);
		return result;
	}
	

}
