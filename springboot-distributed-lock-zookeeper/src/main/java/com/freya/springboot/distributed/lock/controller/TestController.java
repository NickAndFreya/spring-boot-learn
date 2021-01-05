package com.freya.springboot.distributed.lock.controller;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.locks.InterProcessSemaphoreMutex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author Cheng Pin.Y & Nick
 * @Version 0.0.1
 * @Description TestController
 * @Date 2021-01-05 12:25
 */
@RestController
@RequestMapping("zookeeper")
public class TestController {
    private static Logger log = LoggerFactory.getLogger(TestController.class);
    private final CuratorFramework curatorFramework;

    private String lockPath = "/lock/test/";

    public TestController(CuratorFramework curatorFramework) {
        this.curatorFramework = curatorFramework;
    }


    @GetMapping(value = "/zookpTest", produces = "application/json; charset=utf-8")
    public ResponseEntity zookpTest() {
        String lockName = lockPath + UUID.randomUUID();
        log.info("============={} 线程访问开始=========lockName:{}", Thread.currentThread().getName(), lockName);
        InterProcessSemaphoreMutex lock = new InterProcessSemaphoreMutex(curatorFramework, lockName);
        try {
            //获取锁资源
            boolean flag = lock.acquire(10, TimeUnit.SECONDS);
            if (flag) {
                log.info("线程:{}，获取到了锁", Thread.currentThread().getName());
                Thread.sleep(500);
                log.info("======获得锁后进行相应的操作======" + Thread.currentThread().getName());
            }
        } catch (Exception e) {
            log.info("错误信息：{}", e.getMessage());
        } finally {
            try {
                lock.release();
                log.info("=========lockName:{}==============={}释放了锁", lockName, Thread.currentThread().getName());
            } catch (Exception e) {
                log.info("错误信息：{}", e.getMessage());
            }
        }
        return ResponseEntity.ok().build();
    }

}
