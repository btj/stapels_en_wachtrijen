package stapels_en_wachtrijen;

import java.util.Arrays;

public class CollectieHulp {
	
	/**
	 * @pre | collectie != null
	 * @mutates | collectie
	 * @post | result == Arrays.stream(old(collectie.getElements())).sum()
	 * @post | collectie.isEmpty()
	 */
	public static int maakLeegEnGeefSom(Collectie collectie) {
		int result = 0;
		while (!collectie.isEmpty())
			result += collectie.remove();
		return result;
	}
	
	/**
	 * @pre | collectie != null
	 * @mutates | collectie
	 * @post | result == Arrays.stream(old(collectie.getElements())).count()
	 * @post | collectie.isEmpty()
	 */
	public static int maakLeegEnGeefAantal(Collectie collectie) {
		int result = 0;
		while (!collectie.isEmpty()) {
			collectie.remove();
			result++;
		}
		return result;
	}
	
	

}
