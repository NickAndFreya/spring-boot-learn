package com.freya.springboot.sorting;

import lombok.Builder;

import java.util.Arrays;

/**
 * @author chengpiny
 * @version 1.0.0
 * @date 2020/3/17 15:12
 */
@Builder
public class ShellSort implements ArraySort {
	@Override
	public int[] sort(int[] source) throws Exception {
		// 对 arr 进行拷贝，不改变参数内容
		int[] arr = Arrays.copyOf(source, source.length);

		int gap = 1;
		while (gap < arr.length) {
			gap = gap * 3 + 1;
		}

		while (gap > 0) {
			for (int i = gap; i < arr.length; i++) {
				int tmp = arr[i];
				int j = i - gap;
				while (j >= 0 && arr[j] > tmp) {//默认升序，若想降序改为 arr[j] < tmp
					arr[j + gap] = arr[j];
					j -= gap;
				}
				arr[j + gap] = tmp;
			}
			gap = (int) Math.floor(gap / 3);
		}

		return arr;
	}

	public static void main(String[] args) throws Exception {
		int[] source = new int[]{6, 12, 3, 2, 100, 90, 78, 65, 92, 900};
		System.out.println(Arrays.toString(ShellSort.builder().build().sort(source)));
	}
}
