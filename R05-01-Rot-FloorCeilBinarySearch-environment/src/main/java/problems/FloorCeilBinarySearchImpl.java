package problems;

/**
 * Calcula o floor e ceil de um numero em um array usando a estrategia de busca
 * binaria.
 * 
 * Restricoes: 
 * - Algoritmo in-place (nao pode usar memoria extra a nao ser variaveis locais) 
 * - O tempo de seu algoritmo deve ser O(log n).
 * 
 * @author Adalberto
 *
 */
public class FloorCeilBinarySearchImpl implements FloorCeil {

	@Override
	public Integer floor(Integer[] array, Integer x) {
		return floor(array, x, 0, array.length - 1);
	}

	private Integer floor(Integer[] array, Integer x, Integer l, Integer r){
		Integer res = null;

		if (l <= r) {
			int meio = l + (r-l)/2;
		
			if ( array[meio] == x){
				res = array[meio];
			}
			else if (array[meio] > x){
				res = floor(array, x, l, meio - 1);
			}
			else {
				res = floor(array, x, meio + 1, r);
				if (res == null) {
					res = array[meio];
				}
			}
		}

		return res;
	}

	@Override
	public Integer ceil(Integer[] array, Integer x) {
		return ceil(array, x, 0, array.length - 1);
	}

	private Integer ceil(Integer[] array, Integer x, Integer l, Integer r){
		Integer res = null;
		if (l <= r){
			int meio = l + (r-l)/2;
			if (array[meio] == x){
				res = array[meio];
			}
			else if (array[meio] > x){
				res = ceil(array, x, l, meio - 1);
				if (res == null) {
					res = array[meio];
				}
			}
			else {
				res = ceil(array, x, meio + 1, r);
			}
		}
		
		return res;
	}

}

