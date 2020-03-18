package com.freya.springboot.jpa.controller;

import com.freya.springboot.jpa.entity.StudentEntity;
import com.freya.springboot.jpa.result.Result;
import com.freya.springboot.jpa.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author chengpiny
 * @version 1.0.0
 * @date 2020/3/18 14:38
 */
@RestController
public class StudentController {

	@Autowired
	private StudentService service;

	@PostMapping("/save")
	public Result<StudentEntity> add(StudentEntity student) {
		Result<StudentEntity> result = new Result<>();
		try {
			service.addStudent(student);
			return result;
		} catch (Exception e) {
			result.setCode(500);
			result.setMessage(e.getMessage());
			return result;
		}
	}

	@PutMapping("/updata")
	public Result<String> update(StudentEntity student) {
		Result<String> result = new Result<>();
		try {
			service.updateStudent(student);
			return result;
		} catch (Exception e) {
			result.setCode(500);
			result.setMessage(e.getMessage());
			return result;
		}
	}


	@DeleteMapping("/delete/{id}")
	public Result<String> deleteOne(@PathVariable(name = "id") Long id) {
		Result<String> result = new Result<>();
		try {
			service.deleteStudentById(id);
			return result;
		} catch (Exception e) {
			result.setCode(500);
			result.setMessage(e.getMessage());
			return result;
		}
	}

	@GetMapping("/findAll")
	public Result findAll() {
		Result<List<StudentEntity>> result = new Result<>();
		try {
			List<StudentEntity> list = service.findAll();
			result.setData(list);
			return result;
		} catch (Exception e) {
			result.setCode(500);
			result.setMessage(e.getMessage());
			return result;
		}
	}

	@GetMapping("/getById/{id}")
	public Result findById(@PathVariable(name = "id") Long id) {
		Result<StudentEntity> result = new Result<>();
		try {
			StudentEntity studentEntity = service.findStudentById(id);
			result.setData(studentEntity);
			return result;
		} catch (Exception e) {
			result.setCode(500);
			result.setMessage(e.getMessage());
			return result;
		}
	}

	@GetMapping("/getByName/{name}")
	public Result findByName(@PathVariable(name = "name") String name) {
		Result<List<StudentEntity>> result = new Result<>();
		try {
			List<StudentEntity> studentEntity = service.findStudentByName(name);
			result.setData(studentEntity);
			return result;
		} catch (Exception e) {
			result.setCode(500);
			result.setMessage(e.getMessage());
			return result;
		}
	}


	@GetMapping("/getByNameSort")
	public Result findByNameSort(@RequestParam(value = "name", defaultValue = "freya") String name,
								 @RequestParam(value = "page", defaultValue = "0") Integer page,
								 @RequestParam(value = "size", defaultValue = "10") Integer size,
								 @RequestParam(value = "sort", defaultValue = "asc") String sort) {
		Result<Page<StudentEntity>> result = new Result<>();
		try {
			Page<StudentEntity> studentEntity = service.findByName(name, page, size, sort);
			result.setData(studentEntity);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			result.setCode(500);
			result.setMessage(e.getMessage());
			return result;
		}
	}
}
