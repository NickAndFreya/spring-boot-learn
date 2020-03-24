package com.freya.botain.system.config.controller;

import com.freya.botain.system.config.conf.property.config.FreyaDesc;
import com.freya.botain.system.config.conf.property.listener.PropertiesListenerConfig;
import com.freya.botain.system.config.conf.property.source.OpenIdProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author chengpiny
 * @version 1.0.0
 * @date 2020/3/12 16:36
 */
@RestController
public class SystemConfigController {
	@Autowired
	private OpenIdProperties properties;


	@Autowired
	private FreyaDesc desc;

	@Value("${freya.birthday}")
	private String birthday;

	@Autowired
	private Properties serverProperties;


	private Map<String, String> map = new HashMap<String, String>();

	@PostConstruct
	private void postConstruct() {
		map.put("mother", serverProperties.getProperty("freya.name"));
		map.put("son", serverProperties.getProperty("freya.son"));
	}

	@GetMapping("/getOpenId")
	public String obtainSysConfig() {
		return properties.getOpenId();
	}

	@GetMapping("/getBirth")
	public String obtainSysValue() throws UnsupportedEncodingException {
		return new String(birthday.getBytes("utf8"));
	}

	@GetMapping("freyaDesc")
	public String obtainFreyaDesc() {
		return desc.getName();
	}

	@GetMapping("listener")
	public Map<String, Object> obtainFreyaDescs() {
		Map<String, Object> map = new ConcurrentHashMap<>();
		map.putAll(PropertiesListenerConfig.getAllProperty());
		return map;
	}

	@GetMapping("/listener/{key}")
	public String obtainFreyaDescs(@PathVariable(value = "key") String key) {
		return PropertiesListenerConfig.getProperty(key);
	}

	@GetMapping("/getMap")
	public Map<String, String> getMap() {
		return map;
	}
}
