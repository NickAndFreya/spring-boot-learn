package com.freya.springboot.jpa.service;

import com.freya.springboot.jpa.entity.StudentEntity;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author chengpiny
 * @version 1.0.0
 * @date 2020/3/18 14:30
 */
public interface StudentService {
	void addStudent(StudentEntity student);

	/**
	 * 修改一个学生(jpa是根据id来修改的)
	 */

	void updateStudent(StudentEntity student);

	/**
	 * 根据id删除一条数据
	 */
	void deleteStudentById(Long id);

	/**
	 * 查询所有
	 */
	List<StudentEntity> findAll();

	/**
	 * 根据id查询一条数据(2.0后不能使用findOne了)
	 */
	StudentEntity findStudentById(Long id);

	/**
	 * 根据学生姓名查询多条数据
	 **/
	List<StudentEntity> findStudentByName(String name);


	/**
	 * 带条件分页查询
	 */

	Page<StudentEntity> findByName(String name, Integer page, Integer size, String sort);
}
