package com.mumSched.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mumSched.model.Block;
import com.mumSched.model.BlockCourse;
import com.mumSched.model.BlockTable;
import com.mumSched.model.Course;
import com.mumSched.model.CourseTable;
import com.mumSched.model.Entry;
import com.mumSched.model.EntryBlock;
import com.mumSched.model.Student;
import com.mumSched.model.StudentEntry;
import com.mumSched.model.User;
import com.mumSched.services.BlockCourseServices;
import com.mumSched.services.BlockServices;
import com.mumSched.services.CourseServices;
import com.mumSched.services.EntryServices;
import com.mumSched.services.StudentServices;
import com.mumSched.services.UserServices;

@Controller
public class ApplicationController {
	
	@Autowired
	private UserServices userservice;
	
	@Autowired
	private EntryServices entryservice;
	
	@Autowired
	private BlockServices blockservice;
	
	@Autowired
	private CourseServices courseservice;
	
	@Autowired
	private StudentServices studentservice;
	
	@Autowired
	private BlockCourseServices blockcourseservice;
	
	@RequestMapping(value = {"/login", "/",""})
	public String Login() {
		return "login";
	}
	
	@RequestMapping("/login-user")
	public String LoginUser(@RequestParam String username, @RequestParam String password, HttpServletRequest request, HttpServletResponse response) {
		
		User user = userservice.LoginUser(username, password);
		if( user != null) {
			Student student = studentservice.findByUserProfile(user);
			Entry entry = student.getEntry();
			List<Block> blocks = entry.getBlocks();
			
			List<BlockTable> blocktables = new ArrayList<>();
			
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
			
			request.setAttribute("mode", "MODE_HOME");
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			request.setAttribute("blocktables", blocktables);
			return "welcomepage";
		}else {
			request.setAttribute("error", "Invalid Username or Password");
			return "login";
		}
	}
	
	@RequestMapping("/logout")
	public String Logout(HttpSession session) {
		session.removeAttribute("session");
		return "login";
	}
	
	@RequestMapping("/welcome")
	public String WelcomePage(HttpServletRequest request, HttpServletResponse response) {
		
		request.setAttribute("mode", "MODE_HOME");

		return "welcomepage";
	}
	
	@RequestMapping("/register")
	public String Registration(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_REGISTER");
		return "welcomepage";
	}
	
	@PostMapping("/save-user")
	public String SaveUser(@ModelAttribute User user, BindingResult bindingresult, HttpServletRequest request){
		userservice.saveMyUser(user);
		request.setAttribute("mode", "MODE_HOME");
		return "welcomepage";
	}
	
	@GetMapping("/show-users")
	public String ShowUsers(HttpServletRequest request) {
		request.setAttribute("users", userservice.showAllUser());
		request.setAttribute("mode", "MODE_USERS");
		return "welcomepage";
	}
	
	@RequestMapping("/delete-user")
	public String deleteUser(@RequestParam int id, HttpServletRequest request) {
		userservice.deleteuser(id);
		request.setAttribute("users", userservice.showAllUser());
		request.setAttribute("mode", "MODE_USERS");
		return "welcomepage";
	}
	
	@RequestMapping("/edit-user")
	public String EditUser(@RequestParam int id, HttpServletRequest request) {
		request.setAttribute("user", userservice.editUser(id));
		request.setAttribute("mode", "MODE_UPDATE");
		return "welcomepage";
	}
	
	@RequestMapping("/add-entry")
	public String AddEntry(HttpServletRequest request) {
		request.setAttribute("mode", "ADD_ENTRY");
		return "welcomepage";
	}
	
	@PostMapping("/save-entry")
	public String SaveEntry(@ModelAttribute Entry entry, BindingResult bindingresult, HttpServletRequest request){
		entryservice.saveMyEntry(entry);
		request.setAttribute("mode", "MODE_HOME");
		return "welcomepage";
	}
	
	@GetMapping("/view-entry")
	public String ViewEntry(HttpServletRequest request) {
		request.setAttribute("entries", entryservice.showAllEntry());
		request.setAttribute("mode", "VIEW_ENTRY");
		return "welcomepage";
	}
	//Blocks
	@RequestMapping("/add-block")
	public String AddBlock(HttpServletRequest request) {
		request.setAttribute("mode", "ADD_BLOCK");
		return "welcomepage";
	}
	
	@PostMapping("/save-block")
	public String SaveBlock(@ModelAttribute Block block, BindingResult bindingresult, HttpServletRequest request){
		blockservice.saveMyBlock(block);
		request.setAttribute("mode", "MODE_HOME");
		return "welcomepage";
	}
	
	@GetMapping("/view-block")
	public String ViewBlock(HttpServletRequest request) {
		request.setAttribute("blocks", blockservice.showAllBlock());
		request.setAttribute("mode", "VIEW_BLOCK");
		return "welcomepage";
	}
	//Course
	@RequestMapping("/add-course")
	public String AddCourse(HttpServletRequest request) {
		request.setAttribute("mode", "ADD_COURSE");
		return "welcomepage";
	}
	
	@PostMapping("/save-course")
	public String SaveCourse(@ModelAttribute Course course, BindingResult bindingresult, HttpServletRequest request){
		courseservice.saveMyCourse(course);
		request.setAttribute("mode", "MODE_HOME");
		return "welcomepage";
	}
	
	@GetMapping("/view-course")
	public String ViewCourse(HttpServletRequest request) {
		request.setAttribute("courses", courseservice.showAllCourse());
		request.setAttribute("mode", "VIEW_COURSE");
		return "welcomepage";
	}
	
	@RequestMapping("/add-schedule")
	public String AddSchedule(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("username", session.getAttribute("username"));
		List<Entry> entires = entryservice.showAllEntry();
		request.setAttribute("entries", entires);
		request.setAttribute("blocks", blockservice.showAllBlock());
		request.setAttribute("mode", "ADD_SCHEDULE");
		return "welcomepage";
	}
	
	@PostMapping("/save-schedule")
	public String SaveSchedule(@ModelAttribute EntryBlock entryBlock, BindingResult bindingresult, HttpServletRequest request){
		//entry.setBlocks(block)
		//courseservice.saveMyCourse(course);
		System.out.println(entryBlock);
		Entry entry = entryBlock.getEntry();
		List<Block> blocks = new ArrayList<>(Arrays.asList(entryBlock.getBlock1(),entryBlock.getBlock2(),entryBlock.getBlock3(),entryBlock.getBlock4()));
		entry.setBlocks(blocks);
		request.setAttribute("mode", "MODE_HOME");
		
		entryservice.saveMyEntry(entry);
		
		return "welcomepage";
	}
	
	@RequestMapping("/add-courseOnBlock")
	public String AddCourseOnBlocks(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("mode", "ADD_COURSE_ON_BLOCK");
		request.setAttribute("courses", courseservice.showAllCourse());
		request.setAttribute("blocks", blockservice.showAllBlock());
		return "welcomepage";
	}
	
	@PostMapping("/save-courseOnBlock")
	public String SaveCourseOnBlock(@ModelAttribute BlockCourse blockcourse, BindingResult bindingresult, HttpServletRequest request){
		//entry.setBlocks(block)
		//courseservice.saveMyCourse(course);
		blockcourseservice.saveMyBlockCourse(blockcourse);
		request.setAttribute("mode", "MODE_HOME");
		return "welcomepage";
	}
	
	@RequestMapping("/add-studentEntry")
	public String AddStudentEntry(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("users", userservice.usersRoleStudent());
		request.setAttribute("entries", entryservice.showAllEntry());
		request.setAttribute("mode", "ADD_STUDENT_ENTRY");
		return "welcomepage";
	}
	
	@PostMapping("/save-studentEntry")
	public String SaveStudentEntry(@ModelAttribute StudentEntry studentEntry, BindingResult bindingresult, HttpServletRequest request){
		Student student = new Student();
		Entry entry = studentEntry.getEntry();
		User user = studentEntry.getUser();
		System.out.println(user);
		student.setFirstName(user.getFirstname());
		student.setLastName(user.getLastname());
		student.setEntry(entry);
		student.setUserprofile(user);
		studentservice.saveMyStudent(student);
		request.setAttribute("mode", "MODE_HOME");

		return "welcomepage";
	}
	
}
