package xiu.controller.modifyinfo;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import xiu.dao.StudentDAO;
import xiu.entity.Student;

@Controller
@Scope("prototype")
@RequestMapping("/modify")
@SessionAttributes("modify_msg")
public class ModifyInfoController {
	@Resource
	private StudentDAO dao;
	@RequestMapping("/loadstu.xiu")
	public String execute(HttpSession session,Model model){
		try {
			String stuid=session.getAttribute("studentid").toString();
			Student student=dao.findByKey(stuid);
//			student.setNotice(student.getNotice().trim());
//			student.setAnswer(student.getAnswer().trim());
			model.addAttribute("student", student);
			return "stu/modify/loadstu";
		} catch (Exception e) {
			e.printStackTrace();
			return "main/error";
		}
	}
	@RequestMapping("/modify.xiu")
	public String execute2(@ModelAttribute("student")Student student,Model model){
		try {
			dao.modify(student);
			model.addAttribute("modify_msg", "succès");
			return "redirect:/modify/loadstu.xiu";
		} catch (Exception e) {
			e.printStackTrace();
			return "main/error";
		}
	}
}
