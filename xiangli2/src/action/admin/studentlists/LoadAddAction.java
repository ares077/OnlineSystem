package action.admin.studentlists;

import java.util.List;

import dao.admin.DepartmentDAO;

import entity.admin.Departments;

public class LoadAddAction {
	private List<Departments> departments;
	public String execute() {
		try {
			departments=new DepartmentDAO().getDepartments();
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	public List<Departments> getDepartments() {
		return departments;
	}
	public void setDepartments(List<Departments> departments) {
		this.departments = departments;
	}
	
}
