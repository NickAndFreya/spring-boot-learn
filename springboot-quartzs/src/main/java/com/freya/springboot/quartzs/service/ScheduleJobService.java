

package com.freya.springboot.quartzs.service;


import com.freya.springboot.quartzs.entity.ScheduleJobEntity;

import java.util.List;

/**
 * 定时任务
 */
public interface ScheduleJobService{
	/**
	 * 定时任务列表
	 * @return
	 */

	List<ScheduleJobEntity> list();

	/**
	 * 根据jobId查询
	 * @param id
	 * @return
	 */
	ScheduleJobEntity findById(Long id);
	/**
	 * 保存定时任务
	 */
	void save(ScheduleJobEntity scheduleJob);
	
	/**
	 * 更新定时任务
	 */
	void update(ScheduleJobEntity scheduleJob);
	
	/**
	 * 批量删除定时任务
	 */
	void deleteBatch(Long[] jobIds);
	
	/**
	 * 批量更新定时任务状态
	 */
	void updateBatch(List<ScheduleJobEntity> jobs, int status);
	
	/**
	 * 立即执行
	 */
	void run(Long[] jobs);
	
	/**
	 * 暂停运行
	 */
	void pause(Long[] jobIds);
	
	/**
	 * 恢复运行
	 */
	void resume(Long[] ids);
}
