# springboot-learning
## 介绍
    Spring-boot version:2.0.4.RELEASE
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

### aop

### jpa

## 遇到的问题

### springboot项目多模块打包是遇到的问题及解决方式[parent为pom项目，moudles为jar]
    ① 在父级的pom中添加<packaging>pom</packaging> 标签
    ② 去掉或注释掉parent的<plugin><groupId>org.springframework.boot</groupId><artifactId>spring-boot-maven-plugin</artifactId></plugin>标签
    ③参考https://www.jianshu.com/p/37c6688c4fcb 
