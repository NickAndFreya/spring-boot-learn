package com.freya.springboot.jpa.dao;

import com.freya.springboot.jpa.entity.StudentEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author chengpiny
 * @version 1.0.0
 * @date 2020/3/18 14:26
 */
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {


	List<StudentEntity> findByName(String name);

	/**
	 * 自定义删除操作
	 */
	@Query(value = "delete from student where id=?1", nativeQuery = true)
	@Modifying
	void deleteById1(Long id);


	/**
	 * 本地sql实现分页查询
	 */
	@Query(value = "select id,age,name from student where name like %?1%"
			, countQuery = "select count(1) from student where name like %?1% "
			, nativeQuery = true)
	Page<StudentEntity> findByName(String name, Pageable pageable);
}
