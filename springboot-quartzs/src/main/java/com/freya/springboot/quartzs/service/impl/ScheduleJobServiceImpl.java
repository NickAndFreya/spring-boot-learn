
package com.freya.springboot.quartzs.service.impl;

import com.freya.springboot.quartzs.dao.ScheduleRepository;
import com.freya.springboot.quartzs.entity.ScheduleJobEntity;
import com.freya.springboot.quartzs.service.ScheduleJobService;
import com.freya.springboot.quartzs.utils.Constant;
import com.freya.springboot.quartzs.utils.ScheduleUtils;
import org.quartz.CronTrigger;
import org.quartz.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.List;

@Service
public class ScheduleJobServiceImpl implements ScheduleJobService {
	@Autowired
    private Scheduler scheduler;
	@Autowired
	private ScheduleRepository repository;
	
	/**
	 * 项目启动时，初始化定时器
	 */
	@PostConstruct
	public void init(){
		List<ScheduleJobEntity> scheduleJobList = repository.findAll();
		for(ScheduleJobEntity scheduleJob : scheduleJobList){
			CronTrigger cronTrigger = ScheduleUtils.getCronTrigger(scheduler, scheduleJob.getJobId());
            //如果不存在，则创建
            if(cronTrigger == null) {
                ScheduleUtils.createScheduleJob(scheduler, scheduleJob);
            }else {
                ScheduleUtils.updateScheduleJob(scheduler, scheduleJob);
            }
		}
	}

	@Override
	public List<ScheduleJobEntity> list() {
		return repository.findAll();
	}

	@Override
	public ScheduleJobEntity findById(Long id) {
		boolean flag = repository.existsById(id);
		if(flag){
			ScheduleJobEntity enti = repository.getOne(id);
			return enti;
		}else {
			return null;
		}
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void save(ScheduleJobEntity scheduleJob) {
		scheduleJob.setCreateTime(new Date());
		scheduleJob.setStatus(Constant.ScheduleStatus.NORMAL.getValue());
		repository.save(scheduleJob);
        ScheduleUtils.createScheduleJob(scheduler, scheduleJob);
    }
	
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void update(ScheduleJobEntity scheduleJob) {
        ScheduleUtils.updateScheduleJob(scheduler, scheduleJob);
		repository.update(scheduleJob.getParams(),scheduleJob.getCronExpression(),scheduleJob.getJobId());
    }

	@Override
	@Transactional(rollbackFor = Exception.class)
    public void deleteBatch(Long[] jobIds) {
    	for(Long id : jobIds){
    		ScheduleUtils.deleteScheduleJob(scheduler,id);
			//删除数据
			repository.deleteById(id);
    	}
	}

	@Override
    public void updateBatch(List<ScheduleJobEntity> jobs, int status){
		for(ScheduleJobEntity job:jobs){
			job.setCreateTime(new Date());
			job.setStatus(status);
			repository.save(job);
		}
    }
    
	@Override
	@Transactional(rollbackFor = Exception.class)
    public void run(Long[] jobs) {
    	for(Long id:jobs){
    		ScheduleJobEntity jobEntity = repository.getOne(id);
			jobEntity.setStatus(Constant.ScheduleStatus.NORMAL.getValue());
    		ScheduleUtils.run(scheduler,jobEntity);
			repository.save(jobEntity);
    	}
    }

	@Override
	@Transactional(rollbackFor = Exception.class)
    public void pause(Long[] jobIds) {
        for(Long id : jobIds){
    		ScheduleUtils.pauseJob(scheduler,id);
			repository.updateStatusById(Constant.ScheduleStatus.PAUSE.getValue(),id);
    	}
    }

	@Override
	@Transactional(rollbackFor = Exception.class)
    public void resume(Long[] ids) {
    	for(Long id:ids){
    		ScheduleUtils.resumeJob(scheduler,id);
    		repository.updateStatusById(Constant.ScheduleStatus.NORMAL.getValue(),id);
    	}
    }
    
}
