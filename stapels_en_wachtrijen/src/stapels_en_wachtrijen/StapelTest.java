package stapels_en_wachtrijen;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StapelTest {

	@Test
	void test() {
		Stapel stapel = new Stapel();
		assertTrue(stapel.isEmpty());
		assertArrayEquals(new int[0], stapel.getElements());
		stapel.add(10);
		assertFalse(stapel.isEmpty());
		assertArrayEquals(new int[] {10}, stapel.getElements());
		stapel.add(20);
		assertFalse(stapel.isEmpty());
		assertArrayEquals(new int[] {10, 20}, stapel.getElements());
		
		assertEquals(20, stapel.remove());
		assertFalse(stapel.isEmpty());
		assertArrayEquals(new int[] {10}, stapel.getElements());
		assertEquals(10, stapel.remove());
		assertTrue(stapel.isEmpty());
		assertArrayEquals(new int[] {}, stapel.getElements());
		
		stapel.add(1);
		stapel.add(2);
		stapel.add(3);
		CollectieTest.testCollectie(stapel);
	}

}
