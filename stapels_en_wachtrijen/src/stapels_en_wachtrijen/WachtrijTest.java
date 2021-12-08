package stapels_en_wachtrijen;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class WachtrijTest {

	@Test
	void test() {
		Wachtrij wachtrij = new Wachtrij();
		assertTrue(wachtrij.isEmpty());
		assertArrayEquals(new int[0], wachtrij.getElements());
		wachtrij.add(10);
		assertFalse(wachtrij.isEmpty());
		assertArrayEquals(new int[] {10}, wachtrij.getElements());
		wachtrij.add(20);
		assertFalse(wachtrij.isEmpty());
		assertArrayEquals(new int[] {10, 20}, wachtrij.getElements());
		
		assertEquals(10, wachtrij.remove());
		assertFalse(wachtrij.isEmpty());
		assertArrayEquals(new int[] {20}, wachtrij.getElements());
		assertEquals(20, wachtrij.remove());
		assertTrue(wachtrij.isEmpty());
		assertArrayEquals(new int[] {}, wachtrij.getElements());
		
		wachtrij.add(1);
		wachtrij.add(2);
		wachtrij.add(3);
		CollectieTest.testCollectie(wachtrij);
		
		wachtrij.add(10);
		wachtrij.add(20);
		wachtrij.add(30);
		CollectieHulpTest.testMaakLeegEnGeefSom(wachtrij);
		
		wachtrij.add(10);
		wachtrij.add(20);
		wachtrij.add(30);
		CollectieHulpTest.testMaakLeegEnGeefAantal(wachtrij);

	}

}
