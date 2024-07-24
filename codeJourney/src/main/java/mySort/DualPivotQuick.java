package mySort;

import java.util.Arrays;

public class DualPivotQuick {
	
	public static void dualPivotQuickSort(int[] arr, int low, int high) {
		if (low > high)
			return;
		
		int[] pivot = partition(arr, low, high);
		
		dualPivotQuickSort(arr, low, pivot[0]-1);
		dualPivotQuickSort(arr, pivot[0]+1, pivot[1]-1);
		dualPivotQuickSort(arr, pivot[1]+1, high);
	}
	
	
	private static int[] partition(int[] arr, int low, int high) {
		
		return null;
	}


	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static void main(String[] args) {
		int[] arr = { 2, 1};
		System.out.println(Arrays.toString(arr));

		dualPivotQuickSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}

}
