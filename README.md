# springboot-learning
springboot学习
## 1、springboot项目多模块打包是遇到的问题及解决方式[parent为pom项目，moudles为jar]
### ① 在父级的pom中添加<packaging>pom</packaging> 标签
### ② 去掉或注释掉parent的<plugin><groupId>org.springframework.boot</groupId><artifactId>spring-boot-maven-plugin</artifactId></plugin>标签

