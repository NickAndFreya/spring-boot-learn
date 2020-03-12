package com.freya.redis.sentinel.controller.baseAnno;

import com.alibaba.fastjson.JSON;
import com.freya.redis.sentinel.entity.Student;
import com.freya.redis.sentinel.service.StudentService;
import com.freya.redis.sentinel.util.ServiceResult;
import com.freya.redis.sentinel.util.SnowFlakeWorker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author chengpiny
 * @version 1.0.0
 * @date 2020/3/12 11:18
 */
@RestController
@Slf4j
@Cacheable
public class StudentController {
	/**
	 * 注意：这些方法或者注解最好使用的service层
	 * 由于我在这里使用的mybatis-plus自带的单表增删改查，所以写在controller层
	 * <p>
	 * 主要使用如下五个注解
	 * Cacheable:标注该方法或者类是支持缓存的
	 * CacheEvict:注解用来清除缓存
	 * CachePut:每次都会执行该方法，并将执行结果以键值对的形式存入指定的缓存中
	 * CacheConfig:类级别的注解
	 * Caching:组合多个Cache注解使用
	 */

	@Autowired
	private StudentService studentService;

	@Autowired
	private SnowFlakeWorker snowFlakeWorker;

	/**
	 * 查询方法使用@Cacheable注解，根据id去缓存当中获取数据
	 *
	 * @param id
	 * @return
	 */
	@GetMapping("/listStudentById/{id}")
	@Cacheable(value = "students", key = "#id")
	public ServiceResult listStudentById(@PathVariable Long id) {
		Student student = studentService.selectById(id);
		return ServiceResult.success(student);
	}

	/**
	 * 添加用户，把数据放入到缓存当中
	 * {
	 * "name": "nick",
	 * "age": 30,
	 * "email": "510325796@qq.com",
	 * "address": "河南南阳"
	 * }
	 *
	 * @param student
	 * @return
	 */
	@PostMapping("/createStudent")
	@CachePut(value = "students", key = "#student.id")
	public ServiceResult createStudent(@RequestBody Student student) {
		student.setId(snowFlakeWorker.nextId());
		log.info("创建Student传输过来的参数是：{}", JSON.toJSONString(student));
		studentService.insert(student);
		return ServiceResult.success(student);
	}
	/**
	 * 修改的时候，缓存的时候和新增的时候一样就可以了。
	 * 因为@CachePut执行的原理是往redis当中根据可以插入对应的数据，重复的会覆盖
	 *
	 * @param student
	 * @return
	 */
	@PutMapping("/updateStudent")
	@CachePut(value = "students", key = "#student.id")
	public ServiceResult updateStudent(@RequestBody Student student) {
		studentService.updateById(student);
		return ServiceResult.success(student);
	}

	/**
	 * 删除的时候，把缓存当中的数据同步进行删除就可以了
	 *
	 * @param id
	 * @return
	 */
	@DeleteMapping("/deleteStudent/{id}")
	@CacheEvict(value = "students", key = "#id")
	public ServiceResult deleteStudent(@PathVariable Long id) {
		studentService.deleteById(id);
		return ServiceResult.success("");
	}

}
