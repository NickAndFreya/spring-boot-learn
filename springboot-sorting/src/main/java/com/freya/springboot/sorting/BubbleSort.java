package com.freya.springboot.sorting;

import lombok.Builder;

import java.util.Arrays;

/**
 * @author chengpiny
 * @version 1.0.0
 * @date 2020/3/17 14:26
 */
@Builder
public class BubbleSort implements ArraySort {

	@Override
	public int[] sort(int[] source) throws Exception {
		//对arr进行拷贝，不改变参数内容
		int[] arr = Arrays.copyOf(source, source.length);
		for (int i = 1; i < arr.length; i++) {
			//设定一个标记，若为true,则表示此次循环没有进行交换,意味着待排序列已经有序，排序已经完成。
			boolean flag = true;
			for (int j = 0; j < arr.length - i; j++) {
				if (arr[j] > arr[j + 1]) {//默认升序排列，若为降序，条件改为 <
					arr[j] = arr[j] ^ arr[j + 1];
					arr[j + 1] = arr[j + 1] ^ arr[j];
					arr[j] = arr[j] ^ arr[j + 1];
					flag = false;
				}
			}
			if (flag) {
				break;
			}
		}
		return arr;
	}

	public static void main(String[] args) throws Exception {
		int[] source = new int[]{6, 12, 3, 2};
		System.out.println(Arrays.toString(BubbleSort.builder().build().sort(source)));
	}
}

