package com.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.student.model.Student;
import com.student.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	//Test
	@RequestMapping("/")
	public String test() {
		return "test";
	}

	String jsonObject = null;
	ObjectMapper objectMapper = new ObjectMapper();
	
	//All Students
	@RequestMapping(value = "/students", method = RequestMethod.GET, produces = "application/json")
	public String students() {
		objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
		List<Student> listOfStudents = studentService.getAllStudents();
		try {
			jsonObject = objectMapper.writeValueAsString(listOfStudents);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		System.out.println(jsonObject);
		return jsonObject;

	}
	
	//Get Student
	@RequestMapping(value = "/student/{rollno}", method = RequestMethod.GET, produces = "application/json")
	public String getStudent(@PathVariable("rollno") int rollno) {
		Student student = studentService.getStudent(rollno);
		objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
		try {
			jsonObject = objectMapper.writeValueAsString(student);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		System.out.println(jsonObject);
		return jsonObject;
	}
	
	//Add Student
	@RequestMapping(value = "/student", method = RequestMethod.POST)
	public void createStudent(@RequestBody Student student) {
		studentService.addStudent(student);
		System.out.println(student);
	}
	
	//Update Student
	@RequestMapping(value = "/student/{rollno}", method = RequestMethod.PUT, produces = "application/json")
	public void updateEmployee(@PathVariable("rollno") int rollno, @RequestBody Student student) {
		studentService.updateStudent(student);
	}
	
	//Delete Student
	@RequestMapping(value = "/student/{rollno}", method = RequestMethod.DELETE)
	 public void deleteEmployee(@PathVariable("rollno") int rollno) {
		studentService.deleteStudent(rollno);
	}
}
