package mySort;

import java.util.Arrays;

public class DualPivotQuick {
	
	public static void dualPivotQuickSort(int[] arr, int low, int high) {
		if (low >= high)
			return;
		
		int[] pivot = partition(arr, low, high);
		
		dualPivotQuickSort(arr, low, pivot[0]-1);
		dualPivotQuickSort(arr, pivot[0]+1, pivot[1]-1);
		dualPivotQuickSort(arr, pivot[1]+1, high);
	}
	
	
	private static int[] partition(int[] arr, int low, int high) {
		int l = low + 1; // left bound
		int g = high - 1; // right bound
		int k = low + 1; // current index

		// low, high를 pivot1, pivot2로(pivot1 < pivot2)
		if (arr[low] > arr[high])
			swap(arr, low, high);
		int pivot1 = arr[low];
		int pivot2 = arr[high];

		while (k <= g) {
			if (arr[k] < pivot1)
				swap(arr, l++, k);
			else if (pivot2 < arr[k]) {
				while (arr[g] >= pivot2 && k < g)
					g--;

				swap(arr, k, g--);

				if (arr[k] < pivot1)
					swap(arr, l++, k);
			}
			k++;
		}
		
		swap(arr, --l, low);
		swap(arr, ++g, high);
		
		return new int[] { l, g };
	}


	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static void main(String[] args) {
		int[] arr = { 40, 20, 50, 10, 30, 70 };
		System.out.println(Arrays.toString(arr));

		dualPivotQuickSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}

}
