package com.mumSched.services;

import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import com.mumSched.model.BlockCourse;
import com.mumSched.repository.BlockCourseRepository;

@Service
@Transactional
public class BlockCourseServices {
		
	private final BlockCourseRepository blockCourseRepository;

			public BlockCourseServices(BlockCourseRepository blockCourseRepository) {
				this.blockCourseRepository = blockCourseRepository;
			}

			public void saveMyBlockCourse(BlockCourse blockcourse) {
				blockCourseRepository.save(blockcourse);
			}
			
			public List<BlockCourse>showAllBlockCourseCourse(){
				List <BlockCourse> blockcourses = new ArrayList<BlockCourse>();
				for (BlockCourse blockCourse: blockCourseRepository.findAll()) {
					blockcourses.add(blockCourse);
				}
				return blockcourses;
			}
			
			public void deleteBlockCourse(long id) {
				blockCourseRepository.deleteById(id);
			}
			
			public BlockCourse editBlockCourse(long id) {
				return blockCourseRepository.findById(id).orElse(null);
			}


}
