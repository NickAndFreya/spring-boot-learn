package com.freya.springboot.distributed.lock.config;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.CuratorEvent;
import org.apache.curator.framework.api.CuratorEventType;
import org.apache.curator.framework.api.CuratorListener;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.WatchedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * @author Cheng Pin.Y & Nick
 * @Version 0.0.1
 * @Description CuratorFrameworkConfig
 * @Date 2021-01-05 12:20
 */
@Configuration
public class CuratorFrameworkConfig {

    @Autowired
    private Environment env;

    @Bean
    public CuratorFramework curatorFramework() {
        // ExponentialBackoffRetry是种重连策略，每次重连的间隔会越来越长,1000毫秒是初始化的间隔时间,3代表尝试重连次数。
        ExponentialBackoffRetry retry = new ExponentialBackoffRetry(1000, 3);
        // 创建client
        CuratorFramework curatorFramework = CuratorFrameworkFactory.newClient(env.getProperty("zooClientIp"), retry);
        // 添加watched 监听器
        curatorFramework.getCuratorListenable().addListener(new ZookeeperCuratorListener() {

        });
        curatorFramework.start();
        return curatorFramework;
    }


    public class ZookeeperCuratorListener implements CuratorListener {
        @Override
        public void eventReceived(CuratorFramework client, CuratorEvent event) throws Exception {
            CuratorEventType type = event.getType();
            if (type == CuratorEventType.WATCHED) {
                WatchedEvent watchedEvent = event.getWatchedEvent();
                String path = watchedEvent.getPath();
                System.out.println(watchedEvent.getType() + " -- " + path);
                // 重新设置改节点监听
                if (null != path) {
                    client.checkExists().watched().forPath(path);
                }
            }
        }
    }


}
