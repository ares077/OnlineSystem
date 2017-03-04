package action.admin.courselists;

import dao.admin.CourseDAO;
import entity.admin.Course;
import action.BaseAction;

public class ModifyCourseAction extends BaseAction{
	private String mcname_msg;
	private String courseid;
	private String coursename;
	public String execute() {
		try {			
			if (new CourseDAO().modify(new Course(courseid, coursename))) {
				session.put("mcname", "修改成功");
				return "success";
			}
			session.put("mcname", "修改失败 请稍后重试");
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	public String getMcname_msg() {
		return mcname_msg;
	}
	public void setMcname_msg(String mcnameMsg) {
		mcname_msg = mcnameMsg;
	}
	public String getCourseid() {
		return courseid;
	}
	public void setCourseid(String courseid) {
		this.courseid = courseid;
	}
	public String getCoursename() {
		return coursename;
	}
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
	
}
