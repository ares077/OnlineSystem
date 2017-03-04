package xiu.controller.login;

import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import xiu.dao.LoginDAO;
import xiu.entity.Student;

@Controller
@Scope("prototype")
@RequestMapping("/login")
public class LoginController {
	@Resource
	private LoginDAO dao;

	@RequestMapping("/tologin.xiu")
	public String execute() {
		return "main/login";
	}

	@RequestMapping("/stuindex.xiu")
	public String execute2() {
		return "stu/stuindex";
	}

	@RequestMapping("/login.xiu")
	public String execute(String vcode, Model model, String statu,
			String adminpw, @ModelAttribute("adminid") String adminid,
			HttpSession session) {
		try {
			String imageCode = (String) session.getAttribute("imageCode");
			if (imageCode == null||!imageCode.toUpperCase().equals(vcode.toUpperCase())) {
				model.addAttribute("vcode_msg", "error code!");
				return "main/loginfr";
			} else {
				if (statu.equals("1")) {
					Student student = dao.studentMatched(new Student(adminid,
							adminpw));
					if (student != null) {
						session.setAttribute("studentid", adminid);
						session.setAttribute("stuname", student.getName());
						return "stu/stuindex";
					} else {
						model.addAttribute("login_msg", "error id ou mdp");
						return "main/loginfr";
					}
				} else {
					if (adminid.equals("")) {
						adminid="游客"+new Random().nextInt(19921105);
						session.setAttribute("studentid", adminid);
						session.setAttribute("stuname", adminid);
					}else {
						adminid="游客"+adminid;
						session.setAttribute("studentid", adminid);
						session.setAttribute("stuname", adminid);
					}
					return "stu/stuindex";
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			return "main/error";
		}
	}
}
