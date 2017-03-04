package action.admin.courselists;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import action.BaseAction;
import dao.InCourseDAO;
import entity.admin.Course;
@Controller
@Scope("prototype")
public class AddCourseAction extends BaseAction{
	private String addcourse_msg;
	private String courseid;
	private String coursename;
	@Resource
	private InCourseDAO inCourseDAO;
	public String execute() {
		try {
			if (inCourseDAO.checkKey(courseid)) {
				addcourse_msg="课程名已经存在";
				return "fail";
			}else {
				if (inCourseDAO.add(new Course(courseid, coursename))) {
					session.put("addc", "添加成功");
					return "success";
				}else {
					addcourse_msg="添加失败，请稍后重试";
					return "fail";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	public String getAddcourse_msg() {
		return addcourse_msg;
	}
	public void setAddcourse_msg(String addcourseMsg) {
		addcourse_msg = addcourseMsg;
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
