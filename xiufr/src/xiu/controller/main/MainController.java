package xiu.controller.main;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Scope("prototype")
@RequestMapping("/main")
public class MainController {
	@RequestMapping("/intro.xiu")
	public String execute(){
		return "main/webintro";
	}
	@RequestMapping("/online.xiu")
	public String execute2(){
		return "stu/online/online";
	}
	@RequestMapping("cannot.xiu")
	public String execute3(){
		return "stu/cannot";
	}
}
