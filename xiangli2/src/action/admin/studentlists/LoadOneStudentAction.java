package action.admin.studentlists;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import util.Regex;
import action.BaseAction;
import dao.InStudentDAO;
import dao.admin.DepartmentDAO;
import entity.admin.Departments;
import entity.admin.Student;
@Controller
@Scope("prototype")
public class LoadOneStudentAction extends BaseAction{
	private Student student;
	private String studentid;
	private String states;
	private String nowPage;
	List<Departments> departments;
	@Resource
	private InStudentDAO inStudentDAO;
	public String execute() {
		try {
			if (nowPage==null) {
				nowPage="1";
			}
			if (studentid.equals("")||!(new Regex().stuidisvalid(studentid))) {
				return "fail";
			}
			if (!inStudentDAO.checkKey(studentid)) {
				return "fail";
			}else {
				student=inStudentDAO.findByKey(studentid);
				boolean isdelete=inStudentDAO.states(studentid);
				if (isdelete) {
					states="已删除或已毕业";
				}else {
					states="正常用户";
				}
				//session.put("student", student);
				departments=new DepartmentDAO().getDepartments();
				return "success";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public String getStudentid() {
		return studentid;
	}
	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}
	public String getStates() {
		return states;
	}
	public void setStates(String states) {
		this.states = states;
	}
	public String getNowPage() {
		return nowPage;
	}
	public void setNowPage(String nowPage) {
		this.nowPage = nowPage;
	}
	public List<Departments> getDepartments() {
		return departments;
	}
	public void setDepartments(List<Departments> departments) {
		this.departments = departments;
	}
	
}
