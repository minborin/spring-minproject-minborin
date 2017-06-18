package spring.min.project.language;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StudentController {
		@GetMapping("student")
		public String studentUC(ModelMap mp){
			mp.addAttribute("STUDENT",new Student());
			return "student-cu";				
		}
		@PostMapping("student")
		@ResponseBody
		public Student result(@ModelAttribute Student stu){
			return stu	;
		}
}
