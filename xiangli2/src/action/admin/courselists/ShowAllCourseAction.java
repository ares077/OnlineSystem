package action.admin.courselists;

import java.util.List;

import dao.admin.CourseDAO;

import entity.admin.Course;

public class ShowAllCourseAction {
	private List<Course> courses;
	public String execute() {
		try {
			courses=new CourseDAO().findAll();
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
	
}
