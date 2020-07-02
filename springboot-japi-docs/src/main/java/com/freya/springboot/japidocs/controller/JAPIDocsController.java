package com.freya.springboot.japidocs.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户接口
 */
@RestController
public class JAPIDocsController {
    /**
     * 用户列表
     * @param 
     * @return
     */
    @GetMapping("list")
    public JSONObject listUser() {
        JSONObject object = new JSONObject();
        object.put("freya", new JSONObject().put("age", "30"));
        object.put("nick", new JSONObject().put("age", "32"));
        object.put("eric", new JSONObject().put("age", "2"));
        return object;
    }
}
