# springboot-learning
## 介绍
    该项目总结记录了我学习springboot集成各组件的demo,旨在记录学习过程，Spring-boot 版本采用2.0.4.RELEASE;
    具体有哪些参考 标题【包含】的各个条目
## 包含

### druid-multi

### druid-single

### hikariCP

### logback

###  mybatis-plus-dynamic-datasource

### redis-sentinel

### swagger2

### websocket

### obtain-system-config

### knife4j

### quartz

### dubbo

### mybatis-dynamic-datasource

## 技巧经验总结
### 1、maven版本管理工具
        使用maven作为版本管理工具时，可以在parent module的pom中使用<dependencyManagement> 标签
        统一管理子module相关组件的版本,dependencyManagement中定义的只是依赖的声明，并不实现引入，
        所以子项目需要显式的声明需要用的依赖且不用指定<version>。
[参考博文](https://blog.csdn.net/wo541075754/article/details/51490711?depth_1-utm_source=distribute.pc_relevant.none-task&utm_source=distribute.pc_relevant.none-task)
        

## 遇到的问题

### springboot项目多模块打包是遇到的问题及解决方式[parent为pom项目，moudles为jar]
    ① 在父级的pom中添加<packaging>pom</packaging> 标签
    ② 去掉或注释掉parent的<plugin><groupId>org.springframework.boot</groupId><artifactId>spring-boot-maven-plugin</artifactId></plugin>标签
    ③参考https://www.jianshu.com/p/37c6688c4fcb 
