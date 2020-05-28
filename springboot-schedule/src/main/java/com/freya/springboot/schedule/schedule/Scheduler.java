package com.freya.springboot.schedule.schedule;

import com.freya.springboot.schedule.utils.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author chengpiny
 * @version 1.0.0
 * @date 2020/3/24 10:40
 */
@Component
@Slf4j
public class Scheduler {
    private static LocalDateTime dateTime = LocalDateTime.now();

    private static Instant instant = Instant.now();

    /***
     * 每隔10秒执行一次
     */
    @Scheduled(fixedRate = 10000)
    public void testTasks() {
		String day = DateUtil.getInstance().getDayOfMonth(LocalDate.now());

        log.info("固定频率定时任务执行时间:[{}],Day Of Month is[{}]", instant,day);
    }

    /**
     * 每天10点50执行
     */
    @Scheduled(cron = "0 50 10 ? * *")
    public void testTask() {
        log.info("CRON定时任务执行时间:【{}】", dateTime);
    }
}
