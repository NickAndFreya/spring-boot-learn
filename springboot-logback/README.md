### 日志输出路径配置
通过在yml里面设置logging.path 的值来指定日志保存路径

### 题外话
#### Slf4j
    slf4j的全称是Simple Loging Facade For Java，即它仅仅是一个为Java程序提供日志输出的统一接口，并不是一个具体的日志实现方案，就比如JDBC一样，只是一种规则而已。所以单独的slf4j是不能工作的，必须搭配其他具体的日志实现方案，比如apache的org.apache.log4j.Logger，jdk自带的java.util.logging.Logger等。

#### Log4j
    Log4j是Apache的一个开源项目，通过使用Log4j，我们可以控制日志信息输送的目的地是控制台、文件、GUI组件，甚至是套接口服务器、NT的事件记录器、UNIX Syslog守护进程等；我们也可以控制每一条日志的输出格式；通过定义每一条日志信息的级别，我们能够更加细致地控制日志的生成过程。 Log4j由三个重要的组成构成：日志记录器(Loggers)，输出端(Appenders)和日志格式化器(Layout)。
    1.Logger：控制要启用或禁用哪些日志记录语句，并对日志信息进行级别限制
    2.Appenders : 指定了日志将打印到控制台还是文件中
    3.Layout : 控制日志信息的显示格式
    Log4j中将要输出的Log信息定义了5种级别，依次为DEBUG、INFO、WARN、ERROR和FATAL，当输出时，只有级别高过配置中规定的 级别的信息才能真正的输出，这样就很方便的来配置不同情况下要输出的内容，而不需要更改代码。
   
#### LogBack
    简单地说，Logback 是一个 Java 领域的日志框架。它被认为是 Log4J 的继承人。Logback 主要由三个模块组成：logback-core，logback-classic。logback-access logback-core 是其它模块的基础设施，其它模块基于它构建，显然，logback-core 提供了一些关键的通用机制。logback-classic 的地位和作用等同于 Log4J，它也被认为是 Log4J 的一个改进版，并且它实现了简单日志门面 SLF4J；logback-access 主要作为一个与 Servlet 容器交互的模块，比如说 tomcat 或者 jetty，提供一些与 HTTP 访问相关的功能。
    
#### Logback优点
同样的代码路径，Logback 执行更快
 更充分的测试
 原生实现了 SLF4J API（Log4J 还需要有一个中间转换层）
 内容更丰富的文档
 支持 XML 或者 Groovy 方式配置
 配置文件自动热加载
从 IO 错误中优雅恢复
 自动删除日志归档
 自动压缩日志成为归档文件
 支持 Prudent 模式，使多个 JVM 进程能记录同一个日志文件
 支持配置文件中加入条件判断来适应不同的环境
 更强大的过滤器
 支持 SiftingAppender（可筛选 Appender）
 异常栈信息带有包信息
