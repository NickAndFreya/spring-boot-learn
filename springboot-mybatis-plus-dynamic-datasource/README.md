# spingboot 集成druid、mybatis-plus实现动态数据源
## 介绍
      springboot version 2.0.4
      druid version 1.1.13
      mybatis-plus version 3.1.2
      dynamic-datasource version 2.5.4
      可在Mapper上使用@DS注解实现数据源的绑定

## 集成mybatis-plus实现动态数据源时遇到的问题
    xml写在java下面的包内，报invalid bound 找不到sql语句，挪到resource下面后可以了
## 访问druid监控页面的方式
    http://ip:port/context-path/druid/index.html
