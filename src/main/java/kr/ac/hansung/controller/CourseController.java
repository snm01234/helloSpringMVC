package kr.ac.hansung.controller;



import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.hansung.model.Course;
import kr.ac.hansung.service.CourseService;

@Controller
public class CourseController {

	@Autowired
	private CourseService courseService;

	@RequestMapping("/gradeInquiry")
	public String gradeInquiry(Model model) {
		
		List<Course> courses = courseService.getCurrent();
		model.addAttribute("courses", courses);
		return "gradeInquiry";
	}

	@RequestMapping("/courseRegistrationInquiry")
	public String courseRegistrationInquiry(Model model) {
		
		List<Course> courses = courseService.getCurrent();
		model.addAttribute("courses", courses);
		
		return "courseRegistrationInquiry";
	}
	
	@RequestMapping("/201902Course")
	public String Course201902(Model model) {
		
		List<Course> courses = courseService.getCurrent();
		model.addAttribute("courses", courses);
		
		return "201902Course";
	}
	
	@RequestMapping("/201901Course")
	public String Course201901(Model model) {
		
		List<Course> courses = courseService.getCurrent();
		model.addAttribute("courses", courses);
		
		return "201901Course";
	}
	
	@RequestMapping("/createcourse")
	public String createOffer(Model model) {

		model.addAttribute("course", new Course());

		return "createcourse";
	}
	
	@RequestMapping("/docreate")
	public String docreate(Model model, @Valid Course course, BindingResult result) {
		
		if(result.hasErrors()) {
			System.out.println("=== Web Form data does not validated ===");
			List<ObjectError> errors = result.getAllErrors();
			
			for(ObjectError error: errors) {
				System.out.println(error.getDefaultMessage());
			}
			return "createcourse";
		}
		
		courseService.insert(course); //controller -> service-> dao
		
		return "coursecreated";
	}
}
