package action.admin.studentlists;

import java.util.List;

import dao.admin.MajorDAO;

import entity.admin.Majors;

public class LoadMajorAction {
	private String department;
	private List<Majors> majors;
	public String execute() {
		try {
			majors=new MajorDAO().getMajors(department);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public List<Majors> getMajors() {
		return majors;
	}
	public void setMajors(List<Majors> majors) {
		this.majors = majors;
	}
	
}
