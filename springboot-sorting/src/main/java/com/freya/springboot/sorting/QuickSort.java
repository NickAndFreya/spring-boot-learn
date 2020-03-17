package com.freya.springboot.sorting;

import lombok.Builder;

import java.util.Arrays;

/**
 * @author chengpiny
 * @version 1.0.0
 * @date 2020/3/17 15:21
 */
@Builder
public class QuickSort implements ArraySort {
	@Override
	public int[] sort(int[] sourceArray) throws Exception {
		// 对 arr 进行拷贝，不改变参数内容
		int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

		return quickSort(arr, 0, arr.length - 1);
	}

	private int[] quickSort(int[] arr, int left, int right) {
		if (left < right) {
			int partitionIndex = partition(arr, left, right);
			quickSort(arr, left, partitionIndex - 1);
			quickSort(arr, partitionIndex + 1, right);
		}
		return arr;
	}

	private int partition(int[] arr, int left, int right) {
		// 设定基准值（pivot）
		int pivot = left;
		int index = pivot + 1;
		for (int i = index; i <= right; i++) {
			if (arr[i] < arr[pivot]) {
				swap(arr, i, index);
				index++;
			}
		}
		swap(arr, pivot, index - 1);
		return index - 1;
	}

	private void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) throws Exception {
		int[] source = new int[]{6, 12, 3, 2, 100, 90, 78, 65, 92, 900};
		System.out.println(Arrays.toString(QuickSort.builder().build().sort(source)));
	}
}
