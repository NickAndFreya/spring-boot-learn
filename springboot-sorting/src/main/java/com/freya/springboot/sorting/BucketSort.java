package com.freya.springboot.sorting;

import lombok.Builder;

import java.util.Arrays;

/**
 * @author chengpiny
 * @version 1.0.0
 * @date 2020/3/17 15:30
 */
@Builder
public class BucketSort implements ArraySort {
	private static final InsertSort insertSort = new InsertSort();

	@Override
	public int[] sort(int[] sourceArray) throws Exception {
		// 对 arr 进行拷贝，不改变参数内容
		int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

		return bucketSort(arr, 5);
	}

	private int[] bucketSort(int[] arr, int bucketSize) throws Exception {
		if (arr.length == 0) {
			return arr;
		}

		int minValue = arr[0];
		int maxValue = arr[0];
		for (int value : arr) {
			if (value < minValue) {
				minValue = value;
			} else if (value > maxValue) {
				maxValue = value;
			}
		}

		int bucketCount = (int) Math.floor((maxValue - minValue) / bucketSize) + 1;
		int[][] buckets = new int[bucketCount][0];

		// 利用映射函数将数据分配到各个桶中
		for (int i = 0; i < arr.length; i++) {
			int index = (int) Math.floor((arr[i] - minValue) / bucketSize);
			buckets[index] = arrAppend(buckets[index], arr[i]);
		}

		int arrIndex = 0;
		for (int[] bucket : buckets) {
			if (bucket.length <= 0) {
				continue;
			}
			// 对每个桶进行排序，这里使用了插入排序
			bucket = insertSort.sort(bucket);
			for (int value : bucket) {
				arr[arrIndex++] = value;
			}
		}

		return arr;
	}

	/**
	 * 自动扩容，并保存数据
	 *
	 * @param arr
	 * @param value
	 */
	private int[] arrAppend(int[] arr, int value) {
		arr = Arrays.copyOf(arr, arr.length + 1);
		arr[arr.length - 1] = value;
		return arr;
	}

	public static void main(String[] args) throws Exception {
		int[] source = new int[]{6, 12, 3, 2, 100, 90, 78, 65, 92, 900};
		System.out.println(Arrays.toString(CountingSort.builder().build().sort(source)));
	}

}
