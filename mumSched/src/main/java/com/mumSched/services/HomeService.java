package com.mumSched.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mumSched.model.Block;
import com.mumSched.model.BlockCourse;
import com.mumSched.model.BlockTable;
import com.mumSched.model.CourseTable;
import com.mumSched.model.Entry;
import com.mumSched.model.Student;
import com.mumSched.model.User;

@Component
public class HomeService {
	
	@Autowired
	private UserServices userservice;
	
	@Autowired
	private StudentServices studentservice;
	


	public HomeService() {
		
	}

	public List<BlockTable> homeContent(User user) {
			List<BlockTable> blocktables = new ArrayList<>();
				Student student = studentservice.findByUserProfile(user);
				Entry entry = student.getEntry();
				List<Block> blocks = entry.getBlocks();
				
				for (Block block: blocks) {
					BlockTable blockTable = new BlockTable();
					blockTable.setBlockMonth(block.getBlockMonth());
					
					List<BlockCourse> blockCourses = block.getBlockCourses();
					
					List<CourseTable> courseTables = new ArrayList<>();
					for(BlockCourse blockCourse: blockCourses) {
						CourseTable courseTable = new CourseTable();
						courseTable.setCourseCode(blockCourse.getCourse().getCourseCode());
						courseTable.setCourseTitle(blockCourse.getCourse().getCourseName());
						courseTable.setProfessor(blockCourse.getProfessor());
						courseTable.setSeatCapacity(blockCourse.getSeatCapacity());
						courseTables.add(courseTable);
					}
					blockTable.setCourseTable(courseTables);
					blocktables.add(blockTable);
				}
			
			
		return blocktables;
	}
		
}
