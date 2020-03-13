package com.freya.springboot.quartzs.utils;

/**
 * 常量
 */
public class Constant {
	/**
	 * 定时任务状态
	 */
	public enum ScheduleStatus {
		/*** 正常*/
		NORMAL(0),
		/*** 暂停*/
		PAUSE(1);
		private int value;

		private ScheduleStatus(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}
	}


}
