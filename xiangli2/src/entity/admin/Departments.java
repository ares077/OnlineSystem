package entity.admin;

public class Departments {
	private String department;

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Departments [department=" + department + "]";
	}

	public Departments(String department) {
		super();
		this.department = department;
	}
	
}
