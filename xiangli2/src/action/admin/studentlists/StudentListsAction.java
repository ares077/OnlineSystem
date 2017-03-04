package action.admin.studentlists;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import action.BaseAction;
import dao.InStudentDAO;
import entity.admin.Student;
@Controller
@Scope("prototype")
public class StudentListsAction extends BaseAction{
	private List<Student> students;
	private String nowPage;
	@Resource
	private InStudentDAO inStudentDAO;
	public String execute() {
		students=new ArrayList<Student>();
		int now=1;
		try {
			int maxPage=inStudentDAO.countPageBySize(7);		
			if (nowPage!=null){
				now=Integer.parseInt(nowPage);
			}else {
				if (session.get("nowPage")!=null){
					now=Integer.parseInt(session.get("nowPage").toString());
				}
			}
			now=now<1?1:now;
			now=now>maxPage?maxPage:now;
			students=inStudentDAO.findByPage(now, 7);
			session.put("nowPage", now);
			//session.put("students", students);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	public String getNowPage() {
		return nowPage;
	}
	public void setNowPage(String nowPage) {
		this.nowPage = nowPage;
	}

	
}
