package com.freya.springboot.sorting;

import lombok.Builder;

import java.util.Arrays;

/**
 * @author chengpiny
 * @version 1.0.0
 * @date 2020/3/17 15:00
 */
@Builder
public class InsertSort implements ArraySort {

	@Override
	public int[] sort(int[] source) throws Exception {
		int[] arr = Arrays.copyOf(source, source.length);
		//从下标为1的元素开始选择合适的位置插入，因为下标为0的只有一个元素，默认是有序的
		for (int i = 1; i < arr.length; i++) {
			//记录要插入的数据
			int tmp = arr[i];
			// 从已经排序的序列最右边的开始比较，找到比其小的数
			int j = i;
			while (j > 0 && tmp < arr[j - 1]) {//默认升序，想要降序tmp > arr[j - 1]
				arr[j] = arr[j - 1];
				j--;
			}
			// 存在比其小的数，插入
			if (j != i) {
				arr[j] = tmp;
			}
		}
		return arr;
	}

	public static void main(String[] args) throws Exception {
		int[] source = new int[]{6, 12, 3, 2, 100, 90, 78, 65, 92, 900};
		System.out.println(Arrays.toString(InsertSort.builder().build().sort(source)));
	}
}
