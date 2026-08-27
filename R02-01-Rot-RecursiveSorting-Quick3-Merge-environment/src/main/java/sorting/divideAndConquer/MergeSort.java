package sorting.divideAndConquer;

import sorting.AbstractSorting;

/**
 * Merge sort is based on the divide-and-conquer paradigm. The algorithm
 * consists of recursively dividing the unsorted list in the middle, sorting
 * each sublist, and then merging them into one single sorted list. Notice that
 * if the list has length == 1, it is already sorted.
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if(leftIndex < rightIndex) {
			int meio = (leftIndex + rightIndex) / 2;
			sort(array, leftIndex, meio);
			sort(array, meio + 1, rightIndex);
			merge(array, leftIndex, meio, rightIndex);
		}
	}

	public void merge(T[] array, int leftIndex, int meio, int rightIndex) {
		int n1 = meio - leftIndex + 1;
		int n2 = rightIndex - meio;

		T[] leftArray = (T[]) new Comparable[n1];
		T[] rightArray = (T[]) new Comparable[n2];

		for (int i = 0; i < n1; i++) {
			leftArray[i] = array[leftIndex + i];
		}
		for (int j = 0; j < n2; j++) {
			rightArray[j] = array[meio + 1 + j];
		}

		int i = 0;
		int j = 0;
		int k = leftIndex;
		while (i < n1 && j < n2) {
			if (leftArray[i].compareTo(rightArray[j]) <= 0) {
				array[k++] = leftArray[i++];
			} else {
				array[k++] = rightArray[j++];
			}
		}

		while (i < n1) {
			array[k++] = leftArray[i++];
		}
		while (j < n2) {
			array[k++] = rightArray[j++];
		}
	}

}
