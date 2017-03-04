package action.admin.courselists;

import action.BaseAction;
import dao.admin.CourseDAO;

public class DeleteCourseAction extends BaseAction{
	private String mcname_msg;
	private String courseid;
	public String execute() {
		try {			
			if (new CourseDAO().delete(courseid)) {
				session.put("mcname", "删除成功");
				return "success";
			}
			mcname_msg="删除失败 请稍后重试";
			return "fail";
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
}
