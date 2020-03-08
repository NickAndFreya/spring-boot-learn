package com.freya.websocket.chat;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author chengpiny
 * @version 1.0.0
 * @date 2020/3/6 10:28
 */
@Controller
@Slf4j
public class ChatController {
	@RequestMapping("/websocket/{name}")
	public String webSocket(@PathVariable String name, Model model) {
		try {
			log.info("跳转到websocket的页面上");
			model.addAttribute("username", name);
			return "websocket";
		} catch (Exception e) {
			log.info("跳转到websocket的页面上发生异常，异常信息是：" + e.getMessage());
			return "error";
		}
	}
}
