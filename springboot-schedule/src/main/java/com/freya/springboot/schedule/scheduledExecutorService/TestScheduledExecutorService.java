package com.freya.springboot.schedule.scheduledExecutorService;

import lombok.extern.slf4j.Slf4j;

import java.time.Instant;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author chengpiny
 * @version 1.0.0
 * @date 2020/3/24 11:10
 */
@Slf4j
public class TestScheduledExecutorService {
	private static final ScheduledExecutorService SERVICE = Executors.newSingleThreadScheduledExecutor();

	public static void main(String[] args) {
		test();
	}

	private static void test() {
		/**
		 * 参数：1、任务体 2、首次执行的延时时间
		 * 		 3、任务执行间隔 4、间隔时间单位
		 */

		SERVICE.scheduleAtFixedRate(() -> System.out.println("task ScheduledExecutorService " + Instant.now()), 0, 3, TimeUnit.SECONDS);
	}
}
