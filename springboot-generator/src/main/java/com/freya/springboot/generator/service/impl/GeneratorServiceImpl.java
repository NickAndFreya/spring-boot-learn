package com.freya.springboot.generator.service.impl;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.freya.springboot.generator.pojo.GeneratorInfo;
import com.freya.springboot.generator.service.IGeneratorService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;




@Service
@Transactional(rollbackFor = Exception.class)
public class GeneratorServiceImpl implements IGeneratorService {

    @Value(value = "${spring.datasource.druid.driver-class-name}")
    private String driverClassName;

    @Value(value = "${spring.datasource.druid.username}")
    private String username;

    @Value(value = "${spring.datasource.druid.password}")
    private String password;

    @Value(value = "${spring.datasource.druid.url}")
    private String url;

    @Override
    public void generate(GeneratorInfo generatorInfo) {


        AutoGenerator mpg = new AutoGenerator();
        // 选择 freemarker 引擎，默认 Veloctiy
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(generatorInfo.getCodePath());
        gc.setFileOverride(true);
        // 不需要ActiveRecord特性的请改为false
        gc.setActiveRecord(true);
        // XML 二级缓存
        gc.setEnableCache(false);
        // XML ResultMap
        gc.setBaseResultMap(true);
        // XML columList
        gc.setBaseColumnList(false);
        gc.setAuthor("yourself");

        // 自定义文件命名，注意 %s 会自动填充表实体属性！
        gc.setControllerName(generatorInfo.getControllerName().split("\\.")[0]);
        gc.setServiceName(generatorInfo.getServiceName().split("\\.")[0]);
        gc.setServiceImplName(generatorInfo.getImplName().split("\\.")[0]);
        gc.setMapperName(generatorInfo.getMapperName().split("\\.")[0]);
        gc.setXmlName(generatorInfo.getMapperXmlName().split("\\.")[0]);
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setDriverName(driverClassName);
        dsc.setUsername(username);
        dsc.setPassword(password);
        dsc.setUrl(url);
        mpg.setDataSource(dsc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        // strategy.setTablePrefix(new String[] { "sys_" });// 此处可以修改为您的表前缀
        // 表名生成策略
        strategy.setNaming(NamingStrategy.underline_to_camel);

        // 需要生成的表
        strategy.setInclude(new String[] { generatorInfo.getTableName() });

        //设置一下需要基础的基础类
        strategy.setSuperServiceClass("com.baomidou.mybatisplus.extension.service.IService");
        strategy.setSuperServiceImplClass("om.baomidou.mybatisplus.extension.service.impl.ServiceImpl");
        strategy.setSuperMapperClass("com.baomidou.mybatisplus.core.mapper.BaseMapper");

        mpg.setStrategy(strategy);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent(generatorInfo.getPackageParentPath()+"."+generatorInfo.getPackagePath());
        pc.setController("controller");
        pc.setService("service");
        pc.setServiceImpl("service.impl");
        pc.setMapper("mapper");
        pc.setEntity("entity");
        pc.setXml("xml");
        mpg.setPackageInfo(pc);
        // 执行生成
        mpg.execute();
    }
}
