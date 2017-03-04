package action.admin.studentlists;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import util.Regex;
import action.BaseAction;
import dao.InStudentDAO;
@Controller
@Scope("prototype")
public class CheckStudentidAction extends BaseAction{
	private String studentid;
	private Map<String, Object> infoStudentid = new HashMap<String, Object>();
	@Resource
	private InStudentDAO inStudentDAO;
	public String execute() {
		try {
			if (inStudentDAO.checkKey(studentid)) {
				infoStudentid.put("message", "学号已经存在");
				return "success";
			}else if (!(new Regex().stuidisvalid(studentid))) {
				infoStudentid.put("message", "学号不合法");
				return "success";
			}else {
				infoStudentid.put("message", "V");
				return "success";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	public String getStudentid() {
		return studentid;
	}

	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}

	public Map<String, Object> getInfoStudentid() {
		return infoStudentid;
	}
	public void setInfoStudentid(Map<String, Object> infoStudentid) {
		this.infoStudentid = infoStudentid;
	}

	
}
