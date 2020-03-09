package com.freya.websocket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author chengpiny
 * @version 1.0.0
 * @date 2020/3/9 11:41
 */
@Configuration
@Import({WebSocketStompConfig.class})
public class MainConfig {

}
