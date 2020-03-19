package com.freya.springboot.generator.service;


import com.freya.springboot.generator.pojo.GeneratorInfo;

public interface IGeneratorService {

    /**
     * 生成代码的主方法
     * @param generatorInfo
     */
    void generate(GeneratorInfo generatorInfo);
}
