package xiu.entity;

public class Student {
	private String studentid;
	private String studentpw;
	private String name;
	private String sex;
	private String idnumber;
	private String phonum;
	private String email;
	private String department;
	private String major;
	private String classinfo;
	private String notice;
	private String answer;
	public String getStudentid() {
		return studentid;
	}
	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}
	public String getStudentpw() {
		return studentpw;
	}
	public void setStudentpw(String studentpw) {
		this.studentpw = studentpw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getIdnumber() {
		return idnumber;
	}
	public void setIdnumber(String idnumber) {
		this.idnumber = idnumber;
	}
	public String getPhonum() {
		return phonum;
	}
	public void setPhonum(String phonum) {
		this.phonum = phonum;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getClassinfo() {
		return classinfo;
	}
	public void setClassinfo(String classinfo) {
		this.classinfo = classinfo;
	}
	public String getNotice() {
		return notice;
	}
	public void setNotice(String notice) {
		this.notice = notice;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	
	public Student(String studentid, String studentpw, String name, String sex,
			String idnumber, String phonum, String email, String department,
			String major, String classinfo, String notice, String answer) {
		super();
		this.studentid = studentid;
		this.studentpw = studentpw;
		this.name = name;
		this.sex = sex;
		this.idnumber = idnumber;
		this.phonum = phonum;
		this.email = email;
		this.department = department;
		this.major = major;
		this.classinfo = classinfo;
		this.notice = notice;
		this.answer = answer;
	}
	public Student() {
		super();
	}
	@Override
	public String toString() {
		return "Student [answer=" + answer + ", classinfo=" + classinfo
				+ ", department=" + department + ", email=" + email
				+ ", idnumber=" + idnumber + ", major=" + major + ", name="
				+ name + ", notice=" + notice + ", phonum=" + phonum + ", sex="
				+ sex + ", studentid=" + studentid + ", studentpw=" + studentpw
				+ "]";
	}
	public Student(String studentid, String studentpw) {
		super();
		this.studentid = studentid;
		this.studentpw = studentpw;
	}
	
}
