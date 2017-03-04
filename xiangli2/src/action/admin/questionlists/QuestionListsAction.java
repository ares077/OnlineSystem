package action.admin.questionlists;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import action.BaseAction;
import dao.InQuestionDAO;
import dao.admin.CourseDAO;
import entity.admin.Course;
import entity.admin.Question;
@Controller
@Scope("prototype")
public class QuestionListsAction extends BaseAction{
	private List<Question> questions;
	private String nowPageQ;
	private List<Course> courses;
	@Resource
	private InQuestionDAO inQuestionDAO;
	public String execute() {
		questions=new ArrayList<Question>();
		int now=1;
		try {
			int maxPage=inQuestionDAO.countPageBySize(7);		
			if (nowPageQ!=null){
				now=Integer.parseInt(nowPageQ);
			}else {
				if (session.get("nowPageQ")!=null){
					now=Integer.parseInt(session.get("nowPageQ").toString());
				}
			}
			now=now<1?1:now;
			now=now>maxPage?maxPage:now;
			courses=new CourseDAO().findAll();
			questions=inQuestionDAO.findByPage(now, 7);
			session.put("nowPageQ", now);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	public List<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	public String getNowPageQ() {
		return nowPageQ;
	}
	public void setNowPageQ(String nowPageQ) {
		this.nowPageQ = nowPageQ;
	}
	public List<Course> getCourses() {
		return courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
}
