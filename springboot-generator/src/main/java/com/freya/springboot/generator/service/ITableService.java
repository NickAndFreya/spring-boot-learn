package com.freya.springboot.generator.service;

import java.util.List;

/**
 * @author yuanchengpin
 */
public interface ITableService {

    /**
     * 查询出所有的表名
     * @return
     */
    List<String> listAllTableNames();
}
