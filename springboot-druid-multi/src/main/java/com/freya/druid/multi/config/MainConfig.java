package com.freya.druid.multi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author chengpiny
 * @version 1.0.0
 * @date 2020/3/9 21:07
 */
@Configuration
@Import({MasterDatasourceConfig.class, DB1DatasourceConfig.class, DruidConfig.class})
public class MainConfig {

}
