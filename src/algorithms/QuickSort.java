package algorithms;

import java.util.Arrays;

public class QuickSort {
	public static int[] medianPivot(int[] arr, int low, int high) {
		int mid = (high + low) / 2;
		int[] sortingArr = { arr[low], arr[mid], arr[high] };
		Arrays.sort(sortingArr);
		int middleValue = sortingArr[1];
		int temp = arr[high];
		arr[high] = middleValue;
		arr[mid] = temp;
		return arr;
	}

	public static int partition(int[] arr, int low, int high) {
		arr = medianPivot(arr, low, high);
		int pivot = arr[high];
		int i = (low - 1);
		for (int j = low; j < high; j++) {
			if (arr[j] <= pivot) {
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		int temp = arr[i + 1];
		arr[i + 1] = arr[high];
		arr[high] = temp;
		return i + 1;
	}

	public static void quickSort(int[] arr, int low, int high) {

		if (low < high) {
			int pi = partition(arr, low, high);
			quickSort(arr, low, pi - 1);
			quickSort(arr, pi + 1, high);
		}
	}
}
