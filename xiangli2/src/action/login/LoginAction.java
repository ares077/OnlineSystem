package action.login;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import action.BaseAction;
import dao.InAdminMatchedDAO;
@Scope("prototype")
@Controller
public class LoginAction extends BaseAction {
	private String adminid;
	private String adminpw;
	private String login_msg;
	private String vcode;
	@Resource
	private InAdminMatchedDAO inAdminMatchedDAO;
	public String execute() {
//		System.out.println("执行了");
//		System.out.println(session.get("adminid"));
//		if (session.get("adminid")!=null) {
//			return "success2";
//		}
		String imageCode = (String) session.get("imageCode");
		try {
		if (imageCode==null||!imageCode.toUpperCase().equals(vcode.toUpperCase())) {
				login_msg = "验证码有误";
				return "fail";
		}else {
			if (inAdminMatchedDAO.matched(adminid, adminpw)) {
				session.put("adminid", adminid);
				return "success2";
			} else {
				login_msg = "帐号密码有误";
				return "fail";
			}	
		}
		}catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		
	}

	public String getAdminid() {
		return adminid;
	}

	public void setAdminid(String adminid) {
		this.adminid = adminid;
	}

	public String getAdminpw() {
		return adminpw;
	}

	public void setAdminpw(String adminpw) {
		this.adminpw = adminpw;
	}

	public String getLogin_msg() {
		return login_msg;
	}

	public void setLogin_msg(String loginMsg) {
		login_msg = loginMsg;
	}

	public String getVcode() {
		return vcode;
	}

	public void setVcode(String vcode) {
		this.vcode = vcode;
	}
}
