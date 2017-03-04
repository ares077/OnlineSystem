package action.admin.courselists;

import dao.admin.CourseDAO;

public class CheckCourseidAction {
	private String courseid;
	private String msg;
	public String execute() {
		try {
			if (new CourseDAO().checkKey(courseid)) {
				msg="已经存在的ID";
				return "success";
			}else {
				msg="V";
				return "success";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	public String getCourseid() {
		return courseid;
	}
	public void setCourseid(String courseid) {
		this.courseid = courseid;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
