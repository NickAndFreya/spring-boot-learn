package com.freya.springboot.sorting;

import lombok.Builder;

import java.util.Arrays;

/**
 * @author chengpiny
 * @version 1.0.0
 * @date 2020/3/17 15:25
 */
@Builder
public class HeapSort implements ArraySort {
	@Override
	public int[] sort(int[] source) throws Exception {
		// 对 arr 进行拷贝，不改变参数内容
		int[] arr = Arrays.copyOf(source, source.length);
		int len = arr.length;

		buildMaxHeap(arr, len);

		for (int i = len - 1; i > 0; i--) {
			swap(arr, 0, i);
			len--;
			heapify(arr, 0, len);
		}
		return arr;
	}

	private void buildMaxHeap(int[] arr, int len) {
		for (int i = (int) Math.floor(len / 2); i >= 0; i--) {
			heapify(arr, i, len);
		}
	}

	private void heapify(int[] arr, int i, int len) {
		int left = 2 * i + 1;
		int right = 2 * i + 2;
		int largest = i;

		if (left < len && arr[left] > arr[largest]) {
			largest = left;
		}

		if (right < len && arr[right] > arr[largest]) {
			largest = right;
		}

		if (largest != i) {
			swap(arr, i, largest);
			heapify(arr, largest, len);
		}
	}

	private void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) throws Exception {
		int[] source = new int[]{6, 12, 3, 2, 100, 90, 78, 65, 92, 900};
		System.out.println(Arrays.toString(HeapSort.builder().build().sort(source)));
	}
}
