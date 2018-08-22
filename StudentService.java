package com.student.service;

import java.util.List;

import com.student.model.Student;

public interface StudentService {
	
	public List<Student> getAllStudents();
	public Student getStudent(int rollno);
	public void addStudent(Student student); 
	public void updateStudent(Student student);
	public void deleteStudent(int rollno);

}
