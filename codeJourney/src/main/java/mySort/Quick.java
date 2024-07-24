package mySort;

import java.util.Arrays;

public class Quick {

	public static void main(String[] args) {
		int[] arr = { 2, 1};
		System.out.println(Arrays.toString(arr));

		quickSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}

	public static void quickSort(int[] arr, int start, int end) {
		if (start == end)
			return;
		
		int pivot = partition(arr, start, end);
		
		if (start < pivot-1)
			quickSort(arr, start, pivot-1);
		if (pivot+1 < end)
			quickSort(arr, pivot+1, end);		
	}

	private static int partition(int[] arr, int start, int end) {
		int l = start;
		int r = end;
		int pivot = arr[(start + end)/2];
		
		while (l<=r) {
			while (arr[l] < pivot)
				l++;
				
			while (pivot < arr[r])
				r--;

			if (l <= r)
				swap(arr, l++, r--);			
		}
		
		return l;
	}
	
	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
