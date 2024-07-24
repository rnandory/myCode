package mySort;

import java.util.Arrays;

public class Quick {

	public static void main(String[] args) {
		int[] arr = { 40, 20, 50, 10, 30, 70 };
		System.out.println(Arrays.toString(arr));

		quickSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}

	public static void quickSort(int[] arr, int start, int end) {
		if (start == end)
			return;
		
		int pivot = (start + end)/2; // start~ pivot/~end
		
		pivot = partition(arr, start, pivot, end);
		
		
		quickSort(arr, start, pivot);
		quickSort(arr, pivot, end);		
	}

	private static int partition(int[] arr, int start, int pivot, int end) {
		int l = start;
		int r = end-1;
		
		// swap end, pivot
		int temp = arr[end];
		arr[end] = arr[pivot];
		arr[pivot] = temp;
		
		while (true) {
			while (arr[l] < arr[end]) {
				l++;
			}
			
			if (l>=r)
				break;
				
			while (arr[end] < arr[r]) {
				r--;
			}
			
			// swap
			temp = arr[l];
			arr[l] = arr[r];
			arr[r] = temp;
			l++; r--;			
		}
		
		// swap l, pivot
		temp = arr[end];
		arr[end] = arr[l];
		arr[l] = temp;
		
		return l;
	}

}
