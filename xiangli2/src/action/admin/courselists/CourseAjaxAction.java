package action.admin.courselists;

import java.util.List;

import dao.admin.CourseDAO;
import entity.admin.Course;

public class CourseAjaxAction {
	private List<Course> courses;
	private String cid;
	private String cname;
	public String execute() {
		try {
			String sql="";
			if (cid==null||cid=="")sql="select courseid,coursename from course where states=1 and coursename='"+cname+"'";
			else if (cname==null||cname=="") sql="select courseid,coursename from course where states=1 and courseid='"+cid+"'";
			else return "fail";
			courses=new CourseDAO().findByCondition(sql);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	public List<Course> getCourses() {
		return courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	
}
