package com.student.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import com.student.model.Student;

public class StudentDAOImpl implements StudentDAO {

	private SessionFactory sessionFactory;

	public StudentDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	@SuppressWarnings("unchecked")
	public List<Student> studentList() {
		List<Student> listStudent = sessionFactory.getCurrentSession().createQuery("from Student").list();
		return listStudent;
	}

	@Override
	public Student getStudent(int rollno) {
		return (Student) sessionFactory.getCurrentSession().get(Student.class, rollno);
	}

	@Override
	public void updateStudent(Student student) {
		sessionFactory.getCurrentSession().update(student);
	}
	
	@Override
	@Transactional
	public void addStudent(Student student) {
		System.out.println("Executing add statement");
		System.out.println(student.getRollno());
		sessionFactory.getCurrentSession().save(student);
		System.out.println("operation successs");
	}

	@Override
	@Transactional
	public void deleteStudent(int rollno) {
		System.out.println("Executing add statement");
		Student student= getStudent(rollno);
		sessionFactory.getCurrentSession().delete(student);
		System.out.println("operation successs");
	}

}
