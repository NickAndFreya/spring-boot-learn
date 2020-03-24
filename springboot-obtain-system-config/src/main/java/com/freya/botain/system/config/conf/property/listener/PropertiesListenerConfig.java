package com.freya.botain.system.config.conf.property.listener;

import org.springframework.beans.BeansException;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author chengpiny
 * @version 1.0.0
 * @date 2020/3/12 17:17
 */
public class PropertiesListenerConfig {
	public static Map<String, String> propertiesMap = new ConcurrentHashMap<>();

	private static void processProperties(Properties props) throws BeansException {
		propertiesMap = new ConcurrentHashMap<>();
		for (Map.Entry<Object, Object> entry : props.entrySet()) {
			String keyStr = entry.getKey().toString();
			try {
				// PropertiesLoaderUtils的默认编码是ISO-8859-1,在这里转码一下
				propertiesMap.put(keyStr, new String(props.getProperty(keyStr).getBytes("ISO-8859-1"), "utf-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (java.lang.Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void loadAllProperties(String propertyFileName) {
		try {
			Properties properties = PropertiesLoaderUtils.loadAllProperties(propertyFileName);
			processProperties(properties);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getProperty(String name) {
		return propertiesMap.get(name).toString();
	}

	public static Map<String, String> getAllProperty() {
		return propertiesMap;
	}
}
