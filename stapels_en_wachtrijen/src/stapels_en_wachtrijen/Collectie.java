package stapels_en_wachtrijen;

import java.util.Arrays;

/**
 * @invar | getElements() != null
 * @invar | isEmpty() == (getElements().length == 0)
 */
public interface Collectie {
	
	int[] getElements();
	
	default boolean isEmpty() { return getElements().length == 0; }
	
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
	int remove();

}
