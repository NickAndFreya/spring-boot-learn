package com.freya.springboot.generator.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author yuanchengpin
 * 数据表mapper文件
 */
@Component
@Mapper
public interface TableMapper extends BaseMapper {

    /**
     * 查询出所有的表名
     * @return
     */
    List<String> listAllTableNames();
}
