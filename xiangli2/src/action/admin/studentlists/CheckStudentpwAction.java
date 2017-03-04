package action.admin.studentlists;

import java.util.HashMap;
import java.util.Map;

import util.Regex;

import action.BaseAction;

public class CheckStudentpwAction extends BaseAction{
	private String studentpw;
	private Map<String, Object> infoStudentpw = new HashMap<String, Object>();
	public String execute() {
		try {
		    if (!(new Regex().pwisvalid(studentpw))) {
		    	infoStudentpw.put("message", "密码不合法");
				return "success";
			}else {
				infoStudentpw.put("message", "V");
				return "success";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	public String getStudentpw() {
		return studentpw;
	}
	public void setStudentpw(String studentpw) {
		this.studentpw = studentpw;
	}
	public Map<String, Object> getInfoStudentpw() {
		return infoStudentpw;
	}
	public void setInfoStudentpw(Map<String, Object> infoStudentpw) {
		this.infoStudentpw = infoStudentpw;
	}
	
}
