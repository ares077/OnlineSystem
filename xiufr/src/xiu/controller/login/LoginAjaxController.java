package xiu.controller.login;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Scope("prototype")
@RequestMapping("/login")
public class LoginAjaxController {
	@RequestMapping("/checkcode.xiu")
	@ResponseBody
	public Map<String, String> execute(HttpSession session,String vcode){
		String imageCode=session.getAttribute("imageCode").toString().toUpperCase();
		String code=vcode.toUpperCase();
		Map<String, String> map=new HashMap<String, String>();
		if (imageCode.equals(code)) {
			map.put("info", "V");
			return map;
		}else {
			map.put("info", "X");
			return map;
		}
	}
}
