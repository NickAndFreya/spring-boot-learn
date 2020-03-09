package com.freya.druid.multi.config;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author chengpiny
 * @version 1.0.0
 * @date 2020/3/9 21:07
 */
public class DruidConfig {
	//下面的1和2是配置Druid的监控
	//1、配置一个管理后台的Servlet
	@Bean
	public ServletRegistrationBean statViewServlet() {
		ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
		Map<String, String> initParams = new HashMap<>();
		initParams.put("loginUsername", "admin");
		initParams.put("loginPassword", "admin");
		initParams.put("allow", "");//默认就是允许所有访问
		initParams.put("deny", "192.168.15.21");//黑名单的IP

		bean.setInitParameters(initParams);
		return bean;
	}

	//2、配置一个web监控的filter
	@Bean
	public FilterRegistrationBean webStatFilter() {
		FilterRegistrationBean bean = new FilterRegistrationBean();
		bean.setFilter(new WebStatFilter());

		Map<String, String> initParams = new HashMap<>();
		initParams.put("exclusions", "*.js,*.css,/druid/*");

		bean.setInitParameters(initParams);

		bean.setUrlPatterns(Arrays.asList("/*"));

		return bean;
	}
}
