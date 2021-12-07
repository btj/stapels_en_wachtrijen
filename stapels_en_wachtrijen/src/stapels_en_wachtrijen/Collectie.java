package stapels_en_wachtrijen;

import java.util.Arrays;

/**
 * @invar | getElements() != null
 * @invar | isEmpty() == (getElements().length == 0)
 */
public abstract class Collectie {
	
	/**
	 * @invar | elements != null
	 * @invar | elements.length > 0
	 * @invar | 0 <= start
	 * @invar | start < elements.length
	 * @invar | 0 <= size
	 * @invar | size <= elements.length
	 * @representationObject
	 */
	private int[] elements;
	private int start;
	private int size;
	
	protected Collectie() {
		elements = new int[10];
	}
	
	public int[] getElements() {
		int[] result = new int[size];
		
		if (start + size > elements.length) {
			int size0 = elements.length - start;
			System.arraycopy(elements, start, result, 0, size0);
			System.arraycopy(elements, 0, result, size0, size - size0);
		} else
			System.arraycopy(elements, start, result, 0, size);
		return result;
	}
	
	public boolean isEmpty() { return size == 0; }
	
	/**
	 * @pre | !isEmpty()
	 * @mutates | this
	 * @post | getElements().length == old(getElements().length) - 1
	 * @post | Arrays.stream(old(getElements())).allMatch(e ->
	 *       |     Arrays.stream(getElements()).filter(e1 -> e1 == e).count() ==
	 *       |     Arrays.stream(old(getElements())).filter(e1 -> e1 == e).count() -
	 *       |     (e == result ? 1 : 0)
	 *       | )
	 */
	public abstract int remove();
	
	/**
	 * @pre | !isEmpty()
	 * @mutates | this
	 * @post | getElements().length == old(getElements()).length - 1
	 * @post | Arrays.equals(getElements(), 0, getElements().length, old(getElements()), 1, getElements().length + 1)
	 * @post | result == old(getElements()[0])
	 */
	public int removeFirst() {
		int result = elements[start];
		start = (start + 1) % elements.length;
		size--;
		return result;
	}
	
	/**
	 * @throws IllegalStateException | isEmpty()
	 * @mutates | this
	 * @post | getElements().length == old(getElements()).length - 1
	 * @post | Arrays.equals(getElements(), 0, getElements().length, old(getElements()), 0, getElements().length)
	 * @post | result == old(getElements()[getElements().length - 1])
	 */
	public int removeLast() {
		int result = elements[(start + size - 1) % elements.length];
		size--;
		return result;
	}
	
	/**
	 * @mutates | this
	 * @post | getElements().length == old(getElements().length) + 1
	 * @post | Arrays.equals(getElements(), 0, old(getElements().length), old(getElements()), 0, old(getElements().length))
	 * @post | getElements()[getElements().length - 1] == element
	 */
	public void add(int element) {
		if (size == elements.length) {
			int[] newElements = new int[elements.length * 2];
			if (start + size > elements.length) {
				int size0 = elements.length - start;
				System.arraycopy(elements, start, newElements, 0, size0);
				System.arraycopy(elements, 0, newElements, elements.length, size - size0);
			} else
				System.arraycopy(elements, 0, newElements, 0, size);
			elements = newElements;
		}
		elements[size++] = element;
	}
	
}
