package com.freya.springboot.easyecxel.pojo.dto;


import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

@Builder
@Data
@Accessors(chain = true)
public class UserDTO extends BaseRowModel {
    @ExcelProperty(index = 0, value = "序号")
    private Integer id;
    @ExcelProperty(index = 1, value = "姓名")
    private String name;
    @ExcelProperty(index = 2, value = "年龄")
    private Integer age;
}
