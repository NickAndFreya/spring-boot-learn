package com.freya.springboot.tree.utils;

/**
 * @author chengpiny
 * @version 1.0.0
 * @date 2020/4/11 20:06
 * @Description
 */
public class SnowFlateWorkerUtil {
	public static String uuid() {
		return String.valueOf(new SnowFlateWorker(1, 2, 3).nextId());
	}
}
