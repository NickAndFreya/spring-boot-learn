package com.freya.springboot.quartzs.task;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("task")
public class MyTask {
    public void say(String param){
        LoggerFactory.getLogger(getClass()).info("I love "+param);
    }
}
