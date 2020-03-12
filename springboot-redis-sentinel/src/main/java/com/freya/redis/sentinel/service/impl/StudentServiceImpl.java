package com.freya.redis.sentinel.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.freya.redis.sentinel.entity.Student;
import com.freya.redis.sentinel.mapper.StudentMapper;
import com.freya.redis.sentinel.service.StudentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class StudentServiceImpl  extends ServiceImpl<StudentMapper, Student> implements StudentService {
}
