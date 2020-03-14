## springboot 集成dubbo 注册中心 zookeeper

### 介绍
       dubbo 版本为 apache的2.7.3
           <dependency>
              <groupId>org.apache.dubbo</groupId>
              <artifactId>dubbo-spring-boot-starter</artifactId>
              <version>2.7.3</version>
           </dependency>
       
       zookeeper 版本为 apache的 3.5.7
           <dependency>
               <groupId>org.apache.zookeeper</groupId>
               <artifactId>zookeeper</artifactId>
               <version>3.5.7</version>
           </dependency>
       zookeeper 服务为windows本地搭建的单体服务版本为3.5.7

### 过程中遇到的问题
    1、@Reference 属性 check 默认为true,启动服务时会检查zookeeper中是否有对应服务接口，如果服务接口还没注册到zookeeper中，启动报错，在服务提供方还没有将服务接口注册进zookeeper时，建议将check设为false；
    2、@Reference 属性 async 默认为false，如果设置为true，RPC调用时获取不到自定义的对象信息 【原因待查】