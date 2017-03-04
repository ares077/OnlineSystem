package entity.admin;


public class Majors {
	private String majors;

	public String getMajors() {
		return majors;
	}

	public void setMajors(String majors) {
		this.majors = majors;
	}

	@Override
	public String toString() {
		return "Majors [majors=" + majors + "]";
	}

	public Majors(String majors) {
		super();
		this.majors = majors;
	}
	
}
