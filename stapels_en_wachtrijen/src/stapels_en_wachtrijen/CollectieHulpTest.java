package stapels_en_wachtrijen;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CollectieHulpTest {

	static void testMaakLeegEnGeefSom(Collectie collectie) {
		assertArrayEquals(new int[] {10, 20, 30}, collectie.getElements());
		assertEquals(60, CollectieHulp.maakLeegEnGeefSom(collectie));
		assertTrue(collectie.isEmpty());
	}
	
	static void testMaakLeegEnGeefAantal(Collectie collectie) {
		assertArrayEquals(new int[] {10, 20, 30}, collectie.getElements());
		assertEquals(3, CollectieHulp.maakLeegEnGeefAantal(collectie));
		assertTrue(collectie.isEmpty());
	}

}
