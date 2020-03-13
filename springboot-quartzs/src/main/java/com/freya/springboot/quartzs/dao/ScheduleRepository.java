package com.freya.springboot.quartzs.dao;

import com.freya.springboot.quartzs.entity.ScheduleJobEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;


/**
 * 定时任务
 *
 */
public interface ScheduleRepository extends JpaRepository<ScheduleJobEntity,Long> {
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update schedule_job_entity sje set sje.status =?1 where sje.job_id = ?2",nativeQuery = true)
    int updateStatusById(Integer status, Long id);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value="UPDATE ScheduleJobEntity e SET e.cronExpression=:cron,e.params=:params WHERE e.jobId=:id")
    int update(@Param("params") String params, @Param("cron") String cron, @Param("id") Long id);

}
