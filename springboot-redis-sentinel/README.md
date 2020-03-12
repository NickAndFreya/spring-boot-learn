## springboot 配置redis哨兵模式
#### 介绍

springboot-cache-redis  使用redis作为数据缓存

    使用springboot内置的缓存框架

    项目当中使用了mybatis-plus操作数据库进行单标的增删改查(因为快速)
	
	配置了在控制台打印sql语句来验证缓存是否生效(看sql是否多次打印)
	
	使用hikari作为数据库连接池
	
	配置了redis服务器作为缓存服务器
	
	在RedisConfig当中配置缓存60s过期，所以假如你运行此项目无效请检查过期时间
	
	
### 几大注解

主要使用如下五个注解

     @Cacheable:标注该方法或者类是支持缓存的
	 
     @Cacheable可以标记在一个方法上，也可以标记在一个类上。
 	当标记在一个方法上时表示该方法是支持缓存的，当标记在一个类上时则表示该类所有的方法都是支持缓存的。如果一个方法上添加了@Cacheable标记，Spring会在其被调用后将其返回值缓存起来，以保证下次利用同样的参数来执行该方法时可以直接从缓存中获取结果，而不需要再次执行该方法。
	@Cacheable可以指定三个属性:
		value：cacheNames，可以指定多个，用逗号隔开
		key：缓存的key，支持SpringEL表达式，#id或者#student.id
		condition:判定条件，符合条件的才会假如缓存
		例如：@Cacheable(value={"users"}, key="#user.id", condition="#user.id%2==0")
		  
    @CacheEvict:注解用来清除缓存
	 
	    有以下五个属性：value，key，condition，allentries，beforeInvocation 
		value，key，condition：同上
		allentries：默认为false，假如设置为true，就删除value下面的所有的缓存
		beforeInvocation：默认为fasle，是在方法执行之前还是之后删除缓存。假如设置为true，那么就算方法执行出错，也会执行删除缓存。
	 
     @CachePut:每次都会执行该方法，并将执行结果以键值对的形式存入指定的缓存中
	 
	     @CachePut标注的方法在执行前不会去检查缓存中是否存在之前执行过的结果，
		 而是每次都会执行该方法，并将执行结果以键值对的形式存入指定的缓存中。
	 
     @CacheConfig:类级别的注解
	 
	     这是一个类级别的注解，比如一个类里所有的缓存都是放在cachename为mycache的缓存中，那么每个@Cacheable中都要写value=”mycache”。
		 现在可以直接在类上面加上这个注解@CacheConfig(value="mycache")，那么下面的每个方法就都相当于在mycache缓存下面
	 
     @Caching:组合多个Cache注解使用
	 
	     在一个方法上面假如同时需要执行多个操作可以用这个进行注解组合。比如下面的一个例子：保存一个用户，之后可能查询的时候会根据id，username，email查询出对应的用户数据。那么就需要把这三个属性分别对应缓存数据保存起来。
	     @Caching(put = {
                @CachePut(value = "user", key = "#user.id"),
                @CachePut(value = "user", key = "#user.username"),
                @CachePut(value = "user", key = "#user.email")
               })

