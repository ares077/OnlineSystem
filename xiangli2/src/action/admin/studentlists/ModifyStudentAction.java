package action.admin.studentlists;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import util.Regex;
import action.BaseAction;
import dao.InStudentDAO;
import entity.admin.Student;
@Controller
@Scope("prototype")
public class ModifyStudentAction extends BaseAction{
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
	private String modify_msg;
	//private String nowPage;
	private Student student;
	private String states;
	@Resource
	private InStudentDAO inStudentDAO;
	public String execute() {
		try {
			student=new Student(studentid, studentpw, name, sex, idnumber, phonum, email, department, major, classinfo, notice, answer);
			Regex regex=new Regex();			
			if (!regex.pwisvalid(studentpw)) {
				modify_msg="密码不合法";
				return "fail";
			}else if (!regex.classinfoisvalud(classinfo)) {
				modify_msg="班级名不合法";
				return "fail";
			}
			if (inStudentDAO.modify(student)) {
				modify_msg="修改成功";
				return "success";
			}else {
				modify_msg="修改失败，请稍后尝试";
				return "fail";
			}	
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
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
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
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
	public String getModify_msg() {
		return modify_msg;
	}
	public void setModify_msg(String modifyMsg) {
		modify_msg = modifyMsg;
	}
//	public String getNowPage() {
//		return nowPage;
//	}
//	public void setNowPage(String nowPage) {
//		this.nowPage = nowPage;
//	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public String getStates() {
		return states;
	}
	public void setStates(String states) {
		this.states = states;
	}
	
}
