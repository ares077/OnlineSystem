package xiu.controller.modifyinfo;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import xiu.dao.StudentDAO;
import xiu.entity.Student;

@Controller
@Scope("prototype")
@RequestMapping("/modify2")
public class PasswordController {
	@Resource
	private StudentDAO dao;
	@RequestMapping("/pw.xiu")
	public String execute(String studentid,String oldpw,String newpw,String newpw2,Model model){
		try {
			Student student=dao.findByKey(studentid);
			if (student.getStudentpw().equals(oldpw)) {
				Student student2=new Student(studentid, newpw2);
				dao.modify2(student2);
				model.addAttribute("modifypw_msg", "Succès");
				return "stu/modify/loadpw";
			}else {
				model.addAttribute("modifypw_msg", "code incorrect");
				return "stu/modify/loadpw";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "main/error";
		}
	}
	@RequestMapping("load.xiu")
	public String execute2(){
		return "stu/modify/loadpw";
	}
}
