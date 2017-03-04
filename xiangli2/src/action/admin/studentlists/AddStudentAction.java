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
public class AddStudentAction extends BaseAction{
	private String studentid;
	private String studentpw;
	private String name;
	private String department;
	private String major;
	private String classinfo;
	private String add_msg;
	@Resource
	private InStudentDAO inStudentDAO;
	public String execute() {
		try {
			Regex regex=new Regex();
			if (!regex.stuidisvalid(studentid)||inStudentDAO.checkKey(studentid)) {
				add_msg="学号已存在或不合法";
				return "fail";
			}
			if (!regex.pwisvalid(studentpw)) {
				add_msg="密码不合法";
				return "fail";
			}
			if (department.equals("默认")) {
				add_msg="请选择院系";
				return "fail";
			}
			if (name.equals("")) {
				add_msg="请输入姓名";
				return "fail";
			}
			if (major.equals("默认")) {
				add_msg="请选择专业";
				return "fail";
			}
			if (!regex.classinfoisvalud(classinfo)||classinfo.equals("默认")) {
				add_msg="班级名不合法";
				return "fail";
			}
			Student student=new Student();
			student.setStudentid(studentid);
			student.setStudentpw(studentpw);
			student.setName(name);
			student.setDepartment(department);
			student.setMajor(major);
			student.setClassinfo(classinfo);
			if (inStudentDAO.add(student)) {
				add_msg="添加成功";
				session.put("add_msg", add_msg);
				return "success";
			}else {
				add_msg="出现错误，请稍后重试";
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
	public String getAdd_msg() {
		return add_msg;
	}
	public void setAdd_msg(String addMsg) {
		add_msg = addMsg;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	
}
