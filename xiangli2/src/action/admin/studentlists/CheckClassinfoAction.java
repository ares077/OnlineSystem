package action.admin.studentlists;

import java.util.HashMap;
import java.util.Map;

import util.Regex;
import action.BaseAction;

public class CheckClassinfoAction extends BaseAction{
	private String classinfo;
	private Map<String, Object> infoclassinfo = new HashMap<String, Object>();
	public String execute() {
		try {
		    if (!(new Regex().classinfoisvalud(classinfo))) {
		    	infoclassinfo.put("message", "班级不合法");
				return "success";
			}else {
				infoclassinfo.put("message", "V");
				return "success";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	public String getClassinfo() {
		return classinfo;
	}
	public void setClassinfo(String classinfo) {
		this.classinfo = classinfo;
	}
	public Map<String, Object> getInfoclassinfo() {
		return infoclassinfo;
	}
	public void setInfoclassinfo(Map<String, Object> infoclassinfo) {
		this.infoclassinfo = infoclassinfo;
	}
	
}
