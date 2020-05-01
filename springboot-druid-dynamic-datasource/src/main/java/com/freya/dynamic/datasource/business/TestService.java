package com.freya.dynamic.datasource.business;

import com.freya.dynamic.datasource.business.mapper.Test01;
import com.freya.dynamic.datasource.business.mapper.Test02;
import com.freya.dynamic.datasource.business.mapper.Test03;
import com.freya.dynamic.datasource.datasource.SourceName;
import com.freya.dynamic.datasource.datasource.annotation.DS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TestService {
    @Autowired
    private Test01 test01;
    @Autowired
    private Test02 test02;
    @Autowired
    private Test03 test03;

    @DS
    public List<Map<String, Object>> test01() {
        return test01.test01();
    }

    @DS(SourceName.SECOND)
    public List<Map<String, Object>> test02() {
        return test02.test02();
    }

    @DS(SourceName.THIRD)
    public List<Map<String, Object>> test03() {
        return test03.test03();
    }
}
