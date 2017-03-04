package action.admin.questionlists;

import java.util.List;

import dao.admin.CourseDAO;
import entity.admin.Course;


public class LoadAddAction {
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
