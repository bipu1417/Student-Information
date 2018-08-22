package com.student.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.student.model.Student;
@Service
public interface StudentDAO {
	public List<Student> studentList();
	
	public void addStudent(Student student);
	
	public Student getStudent(int rollno);
	
	public void updateStudent(Student student);
	
	public void deleteStudent(int rollno);
}

