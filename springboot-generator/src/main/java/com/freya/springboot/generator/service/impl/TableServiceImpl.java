package com.freya.springboot.generator.service.impl;

import com.freya.springboot.generator.mapper.TableMapper;
import com.freya.springboot.generator.service.ITableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author yuanchengpin
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TableServiceImpl  implements ITableService {

    @Autowired
    private TableMapper tableMapper;

    @Override
    public List<String> listAllTableNames() {
        return tableMapper.listAllTableNames();
    }
}
