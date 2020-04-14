
package com.freya.nc.common.ncutil;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * @author yuanchengpin
 */
@Slf4j
public class DateUtil {
	/**
	 * 获取世界时间
	 *
	 * @return
	 */
	public static String getUTCtime(Date date) throws Exception {

		//设置返回日期格式
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHH0000");

		//获取当前时间
		Calendar calendar = Calendar.getInstance();

		log.info("当前整点时间为:{} ", sdf.format(calendar.getTime()));

		if (null != date) {
			calendar.setTime(date);
			//将时间转换为UTC时间
			calendar.set(Calendar.HOUR, calendar.get(Calendar.HOUR) - 8);
		} else {
			calendar.setTime(Calendar.getInstance().getTime());
			//将时间转换为UTC时间
			calendar.set(Calendar.HOUR, calendar.get(Calendar.HOUR) - 8);
		}

		log.info("当前整点时间的UTC(世界)时间: {}", sdf.format(calendar.getTime()));

		String UTCtime = sdf.format(calendar.getTime());

		return UTCtime;
	}

}
