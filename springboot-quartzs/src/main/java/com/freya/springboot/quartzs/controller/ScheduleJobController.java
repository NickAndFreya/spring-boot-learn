

package com.freya.springboot.quartzs.controller;

import com.freya.springboot.quartzs.entity.ScheduleJobEntity;
import com.freya.springboot.quartzs.service.ScheduleJobService;
import com.freya.springboot.quartzs.utils.ReturnInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 定时任务
 */
@RestController
@RequestMapping("/schedule")
@CrossOrigin(origins = "*")
public class ScheduleJobController {
	@Autowired
	private ScheduleJobService scheduleJobService;

	/**
	 * 定时任务列表
	 */
	@PostMapping("/list")
	public List<ScheduleJobEntity> list() {
		List<ScheduleJobEntity> list = scheduleJobService.list();
		return list;
	}

	/**
	 * 定时任务信息
	 */
	@RequestMapping("/info/{jobId}")
	public ReturnInfo info(@PathVariable("jobId") Long jobId) {
		ScheduleJobEntity entity = scheduleJobService.findById(jobId);
		if (entity == null) {
			return ReturnInfo.ok().put("msg", "任务不存在!");
		}
		return ReturnInfo.ok().put("task", entity);
	}

	/**
	 * 保存定时任务
	 */
	@PostMapping("/save")
	public ReturnInfo save(@RequestBody ScheduleJobEntity scheduleJob) {
		scheduleJobService.save(scheduleJob);
		return ReturnInfo.ok();
	}

	/**
	 * 修改定时任务
	 */
	@PutMapping("/update")
	public ReturnInfo update(@RequestBody ScheduleJobEntity scheduleJob) {
		scheduleJobService.update(scheduleJob);
		return ReturnInfo.ok();
	}

	/**
	 * 删除定时任务
	 */
	@DeleteMapping("/delete")
	public ReturnInfo delete(@RequestBody Long[] jobIds) {
		scheduleJobService.deleteBatch(jobIds);
		return ReturnInfo.ok();
	}

	/**
	 * 立即执行任务
	 */
	@PostMapping("/run")
	public ReturnInfo run(@RequestBody Long[] jobIds) {
		scheduleJobService.run(jobIds);
		return ReturnInfo.ok();
	}

	/**
	 * 暂停定时任务
	 */
	@PutMapping("/pause")
	public ReturnInfo pause(@RequestBody Long[] ids) {
		scheduleJobService.pause(ids);
		return ReturnInfo.ok();
	}

	/**
	 * 恢复定时任务
	 */
	@PutMapping("/resume")
	public ReturnInfo resume(@RequestBody Long[] jobIds) {

		scheduleJobService.resume(jobIds);

		return ReturnInfo.ok();
	}

}
