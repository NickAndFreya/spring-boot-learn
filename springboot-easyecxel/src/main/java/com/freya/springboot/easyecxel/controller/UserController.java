package com.freya.springboot.easyecxel.controller;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.freya.springboot.easyecxel.pojo.dto.UserDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @GetMapping("export")
    public void userExport(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String userAgent = request.getHeader("user-agent").toLowerCase();
        String fileName = "用户信息表.xlsx";
        if (userAgent.contains("msie") || userAgent.contains("like gecko")) {
            fileName = URLEncoder.encode(fileName, "UTF-8");
        } else {
            fileName = new String(fileName.getBytes("UTF-8"), "iso-8859-1");
        }
        response.reset();
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
        OutputStream outputStream = response.getOutputStream();
        ExcelWriter writer = EasyExcelFactory.getWriter(outputStream);
        Sheet sheet = new Sheet(1, 0, UserDTO.class);
        List<UserDTO> list = new ArrayList<>();
        list.add(UserDTO.builder().id(1).name("freya").age(30).build());
        list.add(UserDTO.builder().id(2).name("eric").age(2).build());
        list.add(UserDTO.builder().id(3).name("nick").age(30).build());
        writer.write(list, sheet);
        writer.finish();
        outputStream.flush();
        outputStream.close();
    }
}
