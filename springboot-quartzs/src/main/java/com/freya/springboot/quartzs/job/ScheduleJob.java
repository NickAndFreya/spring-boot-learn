
package com.freya.springboot.quartzs.job;

import com.freya.springboot.quartzs.entity.ScheduleJobEntity;
import com.freya.springboot.quartzs.utils.ScheduleRunnable;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


/**
 * 定时任务的核心方法
 */
@Slf4j
public class ScheduleJob extends QuartzJobBean {
	private ExecutorService service = Executors.newSingleThreadExecutor();

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		ScheduleJobEntity scheduleJob = (ScheduleJobEntity) context.getMergedJobDataMap()
				.get(ScheduleJobEntity.JOB_PARAM_KEY);

		//任务开始时间
		long startTime = System.currentTimeMillis();

		try {
			//执行任务
			log.info("任务准备执行,任务ID:【{}】", scheduleJob.getJobId());
			ScheduleRunnable task = new ScheduleRunnable(scheduleJob.getBeanName(),
					scheduleJob.getMethodName(), scheduleJob.getParams());
			Future<?> future = service.submit(task);
			future.get();
			//任务执行总时长
			long times = System.currentTimeMillis() - startTime;
			log.info("任务执行完毕,任务ID:【{}】,总耗时:【{}】毫秒", scheduleJob.getJobId(), times);
		} catch (Exception e) {
			log.error("任务执行失败,任务ID:【{}】,原因【{}】", scheduleJob.getJobId(), e);
			//任务执行总时长
			long times = System.currentTimeMillis() - startTime;
			log.info("任务执行失败,任务ID:【{}】,总耗时:【{}】毫秒", scheduleJob.getJobId(), times);

		}
	}
}
