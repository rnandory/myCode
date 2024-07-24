package mySort;

import java.util.Arrays;

public class Merge {

	public static void main(String[] args) {
		int[] arr = { 40, 20, 50, 10, 30, 70 };
		System.out.println(Arrays.toString(arr));

		mergeSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}

//	public static void mergeSort(int[] arr, int p, int r) {
//		if (p == r)
//			return;
//
//		// 1. arr크기가 2이상이면 둘로 나눈다
//		int mid = (p + r) / 2;
//		mergeSort(arr, p, mid);
//		mergeSort(arr, mid + 1, r);
//
//		// 2. 합친다
//		int[] copy = arr.clone();
//		int L = p; // p~mid
//		int R = mid + 1; // mid+1~r
//
//		int index = p;
//		while (index <= r) {
//			// L, R둘다 범위 내
//			if (L <= mid && R <= r) {
//				if (copy[L] < copy[R])
//					arr[index] = copy[L++];
//				else
//					arr[index] = copy[R++];
//			}
//
//			// L이 범위 밖
//			else if (mid < L)
//				arr[index] = copy[R++];
//
//			else if (r < R)
//				arr[index] = copy[L++];
//
//			index++;
//		}
//	}

	public static void mergeSort(int[] arr, int p, int r) {
		if (p < r) {
			// 1. arr크기가 2이상이면 둘로 나눈다
			int mid = (p + r) / 2;
			mergeSort(arr, p, mid);
			mergeSort(arr, mid + 1, r);
			
			// 2. 합친다
			merge(arr, p, mid, r);			
		}
	}

	private static void merge(int[] arr, int p, int mid, int r) {
		int[] left = Arrays.copyOfRange(arr, p, mid+1);
		int[] right = Arrays.copyOfRange(arr, mid+1, r+1);
		
		int i = 0;
		int j = 0;
		int index = p;
		
		// i, j 둘다 범위 내
		while (i<left.length && j<right.length) {
				if (left[i] < right[j])
					arr[index] = left[i++];
				else
					arr[index] = right[j++];
				index++;
		}

		// i만 범위 내
		while (i < left.length) {
			arr[index] = left[i++];
			index++;
		}
		
		// j만 범위 내
		while (j < right.length) {
			arr[index] = right[j++];
			index++;
		}

	}

}
