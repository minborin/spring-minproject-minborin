package spring.min.project.language;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StudentController {
		@RequestMapping("student")
		public String studentUC(){
			return "student-cu";				
		}
}
