package stapels_en_wachtrijen;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.Set;

class CollectieTest {

	static void testCollectie(Collectie collectie) {
		assertArrayEquals(new int[] {1, 2, 3}, collectie.getElements());
		HashSet<Integer> elements = new HashSet<>(Set.of(1, 2, 3));
		for (int i = 0; i < 3; i++) {
			assertFalse(collectie.isEmpty());
			int result = collectie.remove();
			assertTrue(elements.contains(result));
			elements.remove(result);
		}
		assertTrue(collectie.isEmpty());
	}

}
