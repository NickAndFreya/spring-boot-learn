package com.freya.springboot.schedule.timer;

import lombok.extern.slf4j.Slf4j;

import java.time.Instant;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author chengpiny
 * @version 1.0.0
 * @date 2020/3/24 11:03
 */
@Slf4j
public class TimerTest {
	public static void main(String[] args) {
		test();
	}

	private static void test() {
		TimerTask timerTask = new TimerTask() {
			@Override
			public void run() {
				log.info("task run:【{}】", Instant.now());
			}
		};
		Timer timer = new Timer();
		/**
		 * 设置指定的任务在指定的时间开始进行重复的固定延迟执行。这里是每3秒执行一次
		 */
		timer.schedule(timerTask, 10, 3000);
	}
}
