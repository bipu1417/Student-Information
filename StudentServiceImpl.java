package com.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.student.dao.StudentDAO;
import com.student.model.Student;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDAO studentDao;

	@Override
	@Transactional
	public List<Student> getAllStudents() {
		List<Student> listOfStudents = studentDao.studentList();
		return listOfStudents;
	}

	@Override
	public Student getStudent(int rollno) {
		return studentDao.getStudent(rollno);
	}

	@Override
	public void updateStudent(Student student) {
		studentDao.updateStudent(student);
	}

	@Override
	@Transactional
	public void addStudent(Student student) {
		studentDao.addStudent(student);
	}

	@Override
	public void deleteStudent(int rollno) {
		studentDao.deleteStudent(rollno);
		
	}

}
