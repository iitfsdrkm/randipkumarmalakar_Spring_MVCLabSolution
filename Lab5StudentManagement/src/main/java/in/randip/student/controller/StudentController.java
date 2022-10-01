package in.randip.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.randip.student.entity.Student;
import in.randip.student.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {

	// inject student service
	@Autowired
	private StudentService studentService;

	@GetMapping("/list")
	public String listStudents(Model theModel) {

		// get customers from the service
		List<Student> theStudents = studentService.getStudents();

		// add the customers to the model
		theModel.addAttribute("students", theStudents);

		return "list-students";

	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		Student theStudent = new Student();

		theModel.addAttribute("student", theStudent);

		return "student-form";

	}

	@PostMapping("/saveStudent")
	public String saveStudent(@ModelAttribute("student") Student theStudent) {

		studentService.saveStudent(theStudent);

		return "redirect:/student/list";

	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("studentId") int theId, Model theModel) {

		// get the Student from the service
		Student theStudent = studentService.getStudent(theId);

		// set customer as a model attribute to fill the form
		theModel.addAttribute("student", theStudent);

		// send to form
		return "student-form";

	}

	@GetMapping("/delete")
	public String deleteStudent(@RequestParam("studentId") int theId) {

		studentService.deleteStudent(theId);

		return "redirect:/student/list";

	}

}
