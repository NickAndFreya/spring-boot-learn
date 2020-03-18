package com.freya.springboot.jpa.service;

import com.freya.springboot.jpa.dao.StudentRepository;
import com.freya.springboot.jpa.entity.StudentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author chengpiny
 * @version 1.0.0
 * @date 2020/3/18 14:31
 */
@Service
@Transactional
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentRepository dao;

	@Override
	public void addStudent(StudentEntity student) {
		dao.save(student);
	}

	/**
	 * 修改一个学生(jpa是根据id来修改的)
	 *
	 * @param student
	 */
	@Override
	public void updateStudent(StudentEntity student) {
		dao.save(student);
	}

	/**
	 * 根据id删除一条数据
	 *
	 * @param id
	 */
	@Override
	public void deleteStudentById(Long id) {
//		dao.deleteById(id);
		dao.deleteById1(id);
	}

	/**
	 * 查询所有
	 */
	@Override
	public List<StudentEntity> findAll() {
		return dao.findAll();
	}

	/**
	 * 根据id查询一条数据(2.0后不能使用findOne了)
	 *
	 * @param id
	 */
	@Override
	public StudentEntity findStudentById(Long id) {
		return dao.findById(id).get();
	}

	/**
	 * 根据学生姓名查询多条数据
	 *
	 * @param name
	 */
	@Override
	public List<StudentEntity> findStudentByName(String name) {
		return dao.findByName(name);
	}

	@Override
	public Page<StudentEntity> findByName(String name, Integer page, Integer size, String sort) {
		Sort s = new Sort(Sort.Direction.ASC, "id");
		if (sort.equalsIgnoreCase("desc")) {
			s = new Sort(Sort.Direction.DESC, "id");
		}

		Pageable pageable = PageRequest.of(page, size, s);
		Page<StudentEntity> pages = dao.findByName(name, pageable);
		return pages;
	}
}
