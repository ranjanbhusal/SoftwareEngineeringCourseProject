package com.mumSched.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mumSched.model.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {
	
	@Query("SELECT s FROM Student s WHERE s.userprofile.id = ?1")
	Student findByStudentUserId(long id);

}
