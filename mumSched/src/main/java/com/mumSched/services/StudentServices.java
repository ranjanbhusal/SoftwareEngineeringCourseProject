package com.mumSched.services;

import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import com.mumSched.model.Student;
import com.mumSched.model.User;
import com.mumSched.repository.StudentRepository;

@Service
@Transactional

public class StudentServices {
	
		
		private final StudentRepository studentRepository;
		
		public StudentServices(StudentRepository studentRepository) {
			this.studentRepository = studentRepository;
		}

		public void saveMyStudent(Student student) {
			studentRepository.save(student);
		}
		
		public List<Student>showAllStudent(){
			List <Student> students = new ArrayList<Student>();
			for (Student student: studentRepository.findAll()) {
				students.add(student);
			}
			return students;
		}
		
		public Student findByUserProfile (User user) {
			return studentRepository.findByStudentUserId(user.getId());
			
		}
		
		public void deleteEntry(long id) {
			studentRepository.deleteById(id);
		}
		
		public Student editUser(long id) {
			return studentRepository.findById(id).orElse(null);
		}
		


	}




