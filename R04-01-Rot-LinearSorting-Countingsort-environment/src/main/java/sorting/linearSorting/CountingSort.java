package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala.
 *
 * Procure evitar desperdício de memória: AO INVÉS de alocar o array de contadores
 * com um tamanho arbitrariamente grande (por exemplo, com o maior valor de entrada possível),
 * aloque este array com o tamanho sendo o máximo inteiro presente no array a ser ordenado.
 *
 * Seu algoritmo deve assumir que o array de entrada nao possui numeros negativos,
 * ou seja, possui apenas numeros inteiros positivos e o zero.
 *
 */
public class CountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		int max = 0;
		for(int i = 0; i < array.length; i++){
			if (array[i] > max){
				max = array[i];
			}
		}

		int[] C = new int[max];

		for (int i = 0; i < array.length; i++) {
            C[array[i] - 1] += 1;
        }
		for (int i = 1; i < C.length; i++) {
            C[i] += C[i-1];
        }
		int[] B = new int[array.length];

        for (int i = array.length - 1; i >= 0; i--) {
            B[C[array[i] - 1] -1] = array[i];
            C[array[i] - 1] -= 1;
        }

	}

}
