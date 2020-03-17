package com.freya.springboot.sorting;

import lombok.Builder;

import java.util.Arrays;

/**
 * @author chengpiny
 * @version 1.0.0
 * @date 2020/3/17 15:27
 */
@Builder
public class CountingSort implements ArraySort {
	@Override
	public int[] sort(int[] source) throws Exception {
		// 对 arr 进行拷贝，不改变参数内容
		int[] arr = Arrays.copyOf(source, source.length);

		int maxValue = getMaxValue(arr);

		return countingSort(arr, maxValue);
	}

	private int[] countingSort(int[] arr, int maxValue) {
		int bucketLen = maxValue + 1;
		int[] bucket = new int[bucketLen];

		for (int value : arr) {
			bucket[value]++;
		}

		int sortedIndex = 0;
		for (int j = 0; j < bucketLen; j++) {
			while (bucket[j] > 0) {
				arr[sortedIndex++] = j;
				bucket[j]--;
			}
		}
		return arr;
	}

	private int getMaxValue(int[] arr) {
		int maxValue = arr[0];
		for (int value : arr) {
			if (maxValue < value) {
				maxValue = value;
			}
		}
		return maxValue;
	}

	public static void main(String[] args) throws Exception {
		int[] source = new int[]{6, 12, 3, 2, 100, 90, 78, 65, 92, 900};
		System.out.println(Arrays.toString(CountingSort.builder().build().sort(source)));
	}

}
