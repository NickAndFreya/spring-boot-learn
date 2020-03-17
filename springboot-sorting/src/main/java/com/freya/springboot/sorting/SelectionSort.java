package com.freya.springboot.sorting;

import lombok.Builder;

import java.util.Arrays;

/**
 * @author chengpiny
 * @version 1.0.0
 * @date 2020/3/17 14:50
 */
@Builder
public class SelectionSort implements ArraySort {

	@Override
	public int[] sort(int[] source) throws Exception {
		int[] arr = Arrays.copyOf(source, source.length);
		// 总共要经过 N-1 轮比较
		for (int i = 0; i < arr.length - 1; i++) {
			int min = i;
			// 每轮需要比较的次数 N-i
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[min]) {//默认升序，想要改变为降序改为 >
					// 记录目前能找到的最小值元素的下标
					min = j;
				}
			}
			// 将找到的最小值和i位置所在的值进行交换
			if (i != min) {
				arr[i] = arr[i] ^ arr[min];
				arr[min] = arr[min] ^ arr[i];
				arr[i] = arr[i] ^ arr[min];
			}
		}
		return arr;
	}

	public static void main(String[] args) throws Exception {
		int[] source = new int[]{6, 12, 3, 2};
		System.out.println(Arrays.toString(SelectionSort.builder().build().sort(source)));
	}
}
