package com.freya.springbean.way1;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

/**
 * @author chengpiny
 * @version 1.0.0
 * @date 2020/3/17 16:53
 */
@Data
@Builder
@Slf4j
@ToString
public class MessageService {
	private String message;

	public void init() throws Exception {
		log.info("Init method after properties are set【{}】 ", message);
	}

	public void destroy() throws Exception {
		log.info("Spring Container is destroy! Customer clean up");
	}
}
