package com.mumSched.services;
	import java.util.ArrayList;
	import java.util.List;
	import javax.transaction.Transactional;
	import org.springframework.stereotype.Service;
import com.mumSched.model.Course;
import com.mumSched.repository.CourseRepository;

	@Service
	@Transactional
	public class CourseServices {

		private final CourseRepository courseRepository;

			public CourseServices(CourseRepository courseRepository) {
			this.courseRepository = courseRepository;
		}

			public void saveMyCourse(Course course) {
				courseRepository.save(course);
			}
			
			public List<Course>showAllCourse(){
				List <Course> courses = new ArrayList<Course>();
				for (Course course: courseRepository.findAll()) {
					courses.add(course);
				}
				return courses;
			}
			
			public void deleteCourse(long id) {
				courseRepository.deleteById(id);
			}
			
			public Course editCourse(long id) {
				return courseRepository.findById(id).orElse(null);
			}

	}



